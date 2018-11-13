"use strict";

(function() {

    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });

    var qnType = 1;
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();
    localStorage.setItem('isReport', 0);

    // 加载投放信息
    getDeliveryInfo(qnType, deliveryId, 'result', function() {
        // 调查：加载获奖区域，显示知识型题目或核心题
        loadAwardArea();
        var sqnCategory = localStorage.getItem('sqnCategory');
        if ( sqnCategory === '1') {
            getSurveyAnswerResult();
        } else if (sqnCategory === '2') {
            getSurveyKeyQuestionResult();
        }
    });

    // 监听"首页、查看报告、打赏"按钮
    initialResultButtonListener(qnType);
    
    // 监听查看答案
    document.getElementById('jump-to-answer').addEventListener('tap', function() {
        addLog({
            logType: 'qnAction',
            action: 'viewQuestionAnswer',
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType,
            actResult: 'answer'
        });
        jumpTo('answer');
    });

})()

/**
 * 得到核心题的结果
 */
function getSurveyKeyQuestionResult() {
    mui.ajax(baseUrl+'/wanx/getSurveyKeyQuestionResult', {
        data: {
            keyQuestionNum: localStorage.getItem('keyQuestionNum'),
            sqnId: getIdFromQueryString(),
            deliveryId: getDeliveryIdFromQueryString()
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            var template = [
                '<div class=\"graph-title-h\">',
                '  {{sqTitle}}',
                '  {{#qImgUrl}}',
                '      <div class=\"qimg\">',
                '         <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{sqTitle}}\">',
                '      </div>',
                '  {{/qImgUrl}}',
                '</div>'
            ].join("");
            var title = document.getElementById("title");
            var list = document.getElementById("list");

            // 当前有核心题时，才显示核心题结果
            if (isDataSuccess(data)) {
                var fragment = Mustache.render(template, data)
                title.innerHTML = fragment;
                title.style.display = 'block';
                list.style.display = 'block';
                drawResult(list, data);
            }
        }
    });
}

/**
 * 得到知识题型的得分
 */
function getSurveyAnswerResult() {
    mui.ajax(baseUrl+'/wanx/getSurveyAnswerResult', {
        data: {
            userId: "1",
            sqnId: getIdFromQueryString(),
            sqnCategory: "1"
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {

            // 击败人数的计算规则
            function score2percent(score) {
                var percent = 0;
                if (score == 0) {
                    percent = 0;
                } else if (score == 100) {
                    percent = 100;
                } else {
                    //总分上下五个百分点范围取随机数（保留一位小数，例如12.7）
                    var socreRandom = Number((Math.random() * 10 - 5).toFixed(1));
                    percent = score + socreRandom;
                    percent = percent > 0 ? percent : 0; //保证数字为正
                    percent = percent >= 100 ? 99 : percent; //保证小于100
                }
                return percent;
            }

            // 显示分数
            document.getElementById('scoreContainer').style.display = 'block';
            document.getElementById("totalScore").innerHTML = data.totalScore;
            document.getElementById("correctAnswerNum").innerHTML = data.correctAnswerNum;
            document.getElementById("questionQty").innerHTML = data.questionQty;

            // 击败的人数递增
            var percent = score2percent(data.totalScore);
            var times = 0;
            var tt = 0;
            var timer = window.setInterval(function() {
                times++;
                tt += percent / 100;
                document.getElementById("scorePercent").innerHTML = Number(tt.toFixed(1));
                if (times === 100) {
                    window.clearInterval(timer);
                }
            }, 20);
        }
    });
}

/**
 * 加载获奖区域
 */
function loadAwardArea() {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);
    var awardArea = document.getElementById('awardArea');

    if (award.awardMethod == 0) { //无奖
        awardArea.style.display = 'none';
    } else if (award.awardMethod == 1) { //定奖
        awardArea.style.display = 'block';
        var fragment = [
            "恭喜您！获得" + award.awardName,
            "<div class=\"awardButton\" id=\"awardButton\">",
            "领取红包",
            "</div>",
            "<i class=\"bg-placeholder\"></i>"
        ].join("");
        awardArea.innerHTML = fragment;
        document.getElementById('awardButton').addEventListener('tap', function() {
            handleGetStaticAwardButtonClick();
        });
    } else if (award.awardMethod == 2 || award.awardMethod == 3) { //抽奖
        awardArea.style.display = 'block';
        var fragment = [
            "恭喜您！获得抽奖机会",
            "<div class=\"awardButton\" id=\"awardButton\">",
            "开始抽奖",
            "</div>",
            "<i class=\"bg-placeholder\"></i>"
        ].join("");
        awardArea.innerHTML = fragment;
        document.getElementById('awardButton').addEventListener('tap', function() {
            handleGetRandomAwardButtonClick();
        });
    }
}

/**
 * 固定奖励，结果页领奖按钮的点击函数
 * 
 * 查询奖励的领取状态，如果领取状态为1，未领取，则进入领取环节
 */
function handleGetStaticAwardButtonClick() {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);
    
    // 点击领奖统计
    addLog({
        logType: 'awardAction',
        action: 'getFixedAward',
        actResult: award.awardId
    });

    // 检查领取状态
    mui.ajax(baseUrl+'/wanx/checkAwardGetStatus', {
        data: {
            userId: 1,
            sqnId: localStorage.getItem('qnId')
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                // 如果领取状态为1，未领取，则进入领取环节
                if (data.awardGetStatus == 1) {
                    getAward();
                } else {
                    mui.toast('您已经领取过奖励了呦，快去回答更多问卷领取丰厚奖励！');
                }
            } else {
                mui.toast('网络错误...');
            }
        },
        error: function() {
            mui.toast('网络错误...');
        }
    });
};

/**
 * 抽奖（随机型、倾向型），结果页领奖按钮的点击函数
 *
 * 跳转到抽奖页
 */
function handleGetRandomAwardButtonClick() {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);

    // 点击领奖统计
    MtaH5.clickStat('2501');
    if (award.awardMethod == 2) {
        // 随机抽奖
        var actResult = 'lotteryId_' + localStorage.getItem('lotteryId');
    } else if (award.awardMethod == 3){
        // 倾向抽奖
        var actResult = 'evaluateId_' + localStorage.getItem('evaluateId');
    }
    addLog({
        logType: 'awardAction',
        action: 'toLotteryPgae',
        actResult: actResult
    });
    addLog({
        logType: 'awardPageSkip',
        sourcePage: 'survey_result',
        targetPage: 'lottery',
        deliveryId: localStorage.getItem('deliveryId'),
        qnId: localStorage.getItem('qnId'),
        qnType: localStorage.getItem('qnType')
    });

    // 跳转页面
    jumpTo('lottery',location.search);
}
