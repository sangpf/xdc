"use strict";

+ function() {

    // mui初始化
    mui.init({
        swipeBack: true, //启用右滑关闭功能
        beforeback: function() {
            MtaH5.clickStat('3302')
        }
    });

    var qnType = 2;
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();

    // 加载投放信息
    getDeliveryInfo(qnType, deliveryId, 'content', function() {
       loadAqn();
    });

    // 监听提交按钮
    document.getElementById('submit').addEventListener('tap', function() {
        // 点击提交答案统计
        MtaH5.clickStat('3301');
        addLog({
            logType: 'qnAction',
            action: 'submitAnswer',
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType,
            actResult: 'assess_result'
        });

        // 提交答案
        var submitAnswer = getSubmitAnswer(qnType);
        if (submitAnswer.success) {
            saveAnswer(qnType, submitAnswer.data);
        }
    });
}()

/**
 * 加载问卷
 */
function loadAqn() {
    MtaH5.clickStat('3300');
    mui.ajax(baseUrl+'/wanx/loadAqn', {
        data: {
            userId: 1,
            aqnId: getIdFromQueryString(),
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {

            if (!isDataSuccess(data)) {
                mui.toast(data.errInfo);
                setTimeout(function() {
                    history.back();
                }, 1000);
                return;
            }
            var newPicUrl=baseUrl+data.picPath;
            var oldPicUrl=data.picPath;
            //提取
            var substr=data.picPath.substring(0,1)
            //判断data中的头图字段第一个字符是否为/
            if(substr=='/'){
            		//进入这里表示包含，让其拼接上当前服务器地址
            		data.picPath=newPicUrl
            }else{
            		//进入这里表示不包含，无需操作
            }
            var titleTemplate = [
                '<div class=\"mui-content-padded-18px\">',
                '   <h4 id=\"title\">【{{questionQty}}题】{{aqnName}}</h4>',
                '   <p class=\"title-desc\"><span>出题人：{{publisherName}}</span> 类型：{{aqnClassName}}</p>',
                '   <img class=\"title-pic\" src=\"{{picPath}}\" alt=\"title-Picture\">',
                '   <p class=\"title-summary\">{{{aqnSummary}}}</p>',
                '</div>'
            ].join('');

            var template = [
                '<div>',
                '   <h5>',
                '      {{questionNum}}.{{aqTitle}}',
                '      <font color=\"red\">(单选)</font>',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{aqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '   <form class=\"mui-input-group\" id=\"q{{questionNum}}\" name=\"xdc-single-choice\"  data-id=\"{{aqId}}\" data-isRequired=\"1\">',
                '       {{#options}}',
                '           <div class=\"mui-input-row mui-radio mui-left\">',
                '               <label>{{optionDes}}</label>',
                '               <input name=\"q{{questionNum}}\" value=\"{{optionOrder}}\" type=\"radio\"></input>',
                '           </div>',
                '       {{/options}}',
                '   </form>',
                '</div>'
            ].join('');
			//将问卷名称和问卷的地址保存到本地，分享问卷的时候需要用到
			localStorage.setItem('aqnName',data.aqnName);
			localStorage.setItem('aqnAdder',window.location.href);
			console.log('aqnName是:'+localStorage.getItem('aqnName'))
			console.log('aqnAdder:'+localStorage.getItem('aqnAdder'))
            var title = document.getElementById("title");
            var list = document.getElementById("list");
            var titleFragment = Mustache.render(titleTemplate, data);
            var listFragment = '';
            for (var i = 0, length = data.questions.length; i < length; i++) {
                listFragment += Mustache.render(template, data.questions[i]);
            }
            title.innerHTML = titleFragment;
            list.innerHTML = listFragment;
        }
    })
}
