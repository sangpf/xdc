"use strict";

(function() {
	
    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });
    localStorage.setItem('isReport', 0);
    //获取本地存储的data_survey
    var deliveryId=localStorage.getItem('data_survey');
    //获取url的menu参数用来判断用户答题情况
    var isSuccess=splitFromQueryString(2);
    //保存用户答题信息
    saveKuRunSurvey();
    //如果用户答题成功就显示奖励区域
    if(isSuccess=='C'){
    		//进入这里表示正常完成答题
    		//加载获奖区域
	 	loadAwardArea();
	 	//显示结果标语
		document.getElementById("resultMsg").innerHTML='答题完成，感谢您的参与！可以进行抽奖哟~'
    }else{
    		//进入这里表示答题中途因为条件不符导致答题结束
    		//显示结果标语
		document.getElementById("resultMsg").innerHTML='非常抱歉，答题未完成，但是为您准备了5个粮票哟~已经发到了您的账号上了！'
		//调用发粮票接口
		 addWanxScore(5, function() {
            		//调用领奖统计接口
            		mui.ajax(baseUrl+'/wanx/addAwardStatistics', {
				        data: {
				            userId: 1,
				            awardId:10042,
				            awardMethod:2,
				            awardCause: 1,
				            deliveryId:deliveryId,
				            qnType:1,
				            lotteryRank:0,
				            redeemCodeId:0
				        },
				        dataType: 'json',
				        type: 'get',
				        timeout: 10000,
				        success: function(data) {},
				        error: function() {
				            mui.toast('网络错误...');
				        }
				    });
            })
		 	
    }
    
	
    // 监听首页按钮
    document.getElementById('jump-to-index').addEventListener('tap', function() {
        jumpTo('index');
    });
	 // 监听看报告按钮
    document.getElementById('jump-to-report').addEventListener('tap', function() {
        mui.toast("本问卷不支持此功能");
    });
    // 监听打赏
    document.getElementById('donate-show').addEventListener('tap', function() {
         mui.toast("本问卷不支持此功能");
    });
    //监听评论
    document.getElementById("writeComment").addEventListener('tap',function(){
    		mui.toast("本问卷不支持此功能");
    });
    hideLoading();
})()



/**
 * 加载获奖区域
 */
function loadAwardArea(tag) {
    var awardArea = document.getElementById('awardArea');
    //给予抽奖奖励
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
};

/**
 * 抽奖（随机型），结果页领奖按钮的点击函数
 *
 * 跳转到抽奖页
 */
function handleGetRandomAwardButtonClick() {
    // 随机抽奖-- 固定组合3，积分
    var actResult = 'lotteryId_' + 3;

    // 跳转页面
    jumpTo('kurun_lottery',location.search);
}
/**
 *保存库润答题结果 
 */
function saveKuRunSurvey(){
	//从本地中获取存储的问卷Id
	var surveyId=localStorage.getItem('data_survey');
	//从url中截取需要的参数
	var state=splitFromQueryString(2);
	var userId=splitFromQueryString(1);
	mui.ajax(baseUrl+'/wanx/saveKuRunSurvey', {
		data: {
			state:state,
			surveyId:surveyId
		},
		dataType: 'json',
		type: 'get',
		timeout: 10000,
		success: function(data) {},
		error: function() {
				mui.toast('网络错误...');
		}
	});
}
