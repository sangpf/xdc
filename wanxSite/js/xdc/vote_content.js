"use strict";

+ function() {

    // mui初始化
    mui.init({
        swipeBack: true, //启用右滑关闭功能
        beforeback: function() {
            MtaH5.clickStat('2402'); //浏览器返回统计
        }
    });

    // h5统计
    MtaH5.clickStat('2400');

    var qnType = 3;
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();

    // 加载投放信息
    getDeliveryInfo(qnType, deliveryId, 'content', function() {
       loadVqn();
       loadDeliveryAd();
    });

    // 监听提交按钮
    document.getElementById('submit').addEventListener('tap', function() {
        // 点击提交答案统计
        MtaH5.clickStat('2401');
        addLog({
            logType: 'qnAction',
            action: 'submitAnswer',
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType,
            actResult: 'vote_result'
        });

        // 提交答案
        var submitAnswer = getSubmitAnswer(qnType);
        if (submitAnswer.success) {
            saveAnswer(qnType, submitAnswer.data[0].qAnswer);
        }
    });
}()

/**
 * 加载问卷
 */
function loadVqn() {
    mui.ajax(baseUrl+'/wanx/loadVqn', {
        data: {
            userId: 1,
            vqnId: getIdFromQueryString(),
            deliveryId: getDeliveryIdFromQueryString()
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
            
            var titleTemplate = [
                '<div class=\"mui-content-padded-18px\">',
                '   <h4 id=\"title\">【{{questionQty}}题】{{vqnName}}</h4>',
                '   <p class=\"title-desc\"><span>出题人：{{publisherName}}</span>类型：{{vqnClassName}}</p>',
                '   <img class=\"title-pic\" src=\"' + baseUrl + '{{picPath}}\"  alt=\"title-Picture\">',
                '   <p class=\"title-summary\">{{{vqnSummary}}}</p>',
                '</div>'
            ].join('');

            var textTemplateSingle = [
                '<div>',
                '   <h5>',
                '      {{vqTitle}}',
                '      <font color=\"red\">(单选)</font>',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{vqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '   <form class=\"mui-input-group\" id=\"q1\" name=\"xdc-single-choice\" data-id=\"0\" data-isRequired=\"1\">',
                '     {{#options}}',
                '           <div class=\"mui-input-row mui-radio mui-left\">',
                '              <label>{{optionDes}}</label>',
                '              <input name=\"q1\" value=\"{{optionOrder}}\" type=\"radio\"></input>',
                '           </div>',
                '     {{/options}}',
                '   </form>',
                '</div>'
            ].join('');

            var textTemplateMuti = [
                '<div>',
                '   <h5>',
                '      {{vqTitle}}',
                '      <font color=\"red\">(多选{{chioceDesc}})</font>',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{aqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '   <form class=\"mui-input-group\" id=\"q1\" name=\"xdc-multiple-choice\" data-id=\"0\" data-isRequired=\"1\" data-optMaxNum=\"{{optMaxNum}}\" data-optMinNum=\"{{optMinNum}}\">',
                '     {{#options}}',
                '           <div class=\"mui-input-row mui-checkbox mui-left\">',
                '              <label>{{optionDes}}</label>',
                '              <input name=\"q1\" value=\"{{optionOrder}}\" type=\"checkbox\"></input>',
                '           </div>',
                '     {{/options}}',
                '   </form>',
                '</div>'
            ].join('');

            var imgChioceTemplateSingle = [
                '<div>',
                '   <h5>',
                '      {{vqTitle}}',
                '      <font color=\"red\">(单选)</font>',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{aqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '   <form class=\"mui-input-group\" id=\"q1\" name=\"xdc-single-choice\" data-id=\"0\" data-isRequired=\"1\">',
                '      <ul class=\"mui-table-view mui-grid-view img-chioce\">',
                '          {{#options}}',
                '              <li class=\"mui-table-view-cell mui-media mui-col-xs-12\">',
                '                  <div class=\"mui-radio mui-left\">',
                '                      <label>',
                '                          <div class=\"mui-media-body\">{{optionDes}}</div>',
                '                          <img class=\"mui-media-object\" src=\"' + baseUrl + '{{optionPic}}\" alt=\"{{optionDes}}\">',
                '                      </label>',
                '                      <input name=\"q1\" value=\"{{optionOrder}}\" type=\"radio\"></input>',
                '                  </div>',
                '              </li>',
                '          {{/options}}',
                '      </ul>',
                '   </form>',
                '</div>'
            ].join('');

            var imgChioceTemplateMuti = [
                '<div>',
                '   <h5>',
                '      {{vqTitle}}',
                '      <font color=\"red\">(多选{{chioceDesc}})</font>',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{aqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '   <form class=\"mui-input-group\" id=\"q1\" name=\"xdc-multiple-choice\" data-id=\"0\" data-isRequired=\"1\" data-optMaxNum=\"{{optMaxNum}}\" data-optMinNum=\"{{optMinNum}}\">',
                '      <ul class=\"mui-table-view mui-grid-view img-chioce\">',
                '          {{#options}}',
                '              <li class=\"mui-table-view-cell mui-media mui-col-xs-12\">',
                '                  <div class=\"mui-checkbox mui-left\">',
                '                      <label>',
                '                          <div class=\"mui-media-body\">{{optionDes}}</div>',
                '                          <img class=\"mui-media-object\" src=\"' + baseUrl + '{{optionPic}}\" alt=\"{{optionDes}}\">',
                '                      </label>',
                '                      <input name=\"q1\" value=\"{{optionOrder}}\" type=\"checkbox\"></input>',
                '                  </div>',
                '              </li>',
                '          {{/options}}',
                '      </ul>',
                '   </form>',
                '</div>'
            ].join('');

            var titleFragment = Mustache.render(titleTemplate, data);
            var listFragment = '';       

            // 判断选项是文字还是图片。
            // 由于接口中没有字段指明是文字还是图片，所以判断方法是：检查第一个选项的optionPic是否有值
            var isImageChioce = function() {
                if (isStrValid(data.options[0].optionPic)) {
                    // 图片选项
                    return true;
                } else {
                    // 文字选项
                    return false;
                }
            }

            // 判断是单选、多选
            if (data.questionType == 1) {
                // 判断选项是文字还是图片
                if (isImageChioce()) {
                    listFragment += Mustache.render(imgChioceTemplateSingle, data);
                } else {
                    listFragment += Mustache.render(textTemplateSingle, data);
                }
            } else if (data.questionType == 2) {
                // optMinNum或optMaxNum为0时，表示不限制选项最少或最多的个数
                data.optMinNum = data.optMinNum || 0;
                data.optMaxNum = data.optMaxNum || 999;
                data.chioceDesc = getMultiChioceDesc(data.optMinNum, data.optMaxNum, data.optionNum);

                // 判断选项是文字还是图片
                if (isImageChioce()) {
                    listFragment += Mustache.render(imgChioceTemplateMuti, data);
                } else {
                    listFragment += Mustache.render(textTemplateMuti, data);
                }
            }
            var title = document.getElementById("title");
            var list = document.getElementById("list");
            title.innerHTML = titleFragment;
            list.innerHTML = listFragment;
        }
    });
}
