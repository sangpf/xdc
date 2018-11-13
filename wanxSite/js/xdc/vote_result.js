+ function() {

    // mui初始化
    mui.init({
        swipeBack: true, //启用右滑关闭功能
    });

    var qnType = 3;
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();    
    localStorage.setItem('isReport', 0);

    // 加载投放信息
    getDeliveryInfo(qnType, deliveryId, 'result', function() {
        loadVqn();
        getVoteResult();
    });

    // 监听"首页、查看报告、打赏"按钮
    initialResultButtonListener(qnType);

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
            var template = [
                '<div class="mui-content-padded-18px">',
                '   <h4 id=\"title\">【{{questionQty}}题】{{vqnName}}</h4>',
                '   <p class=\"title-desc\"><span>出题人：{{publisherName}}</span>类型：{{vqnClassName}}</p>',
                '   <img class=\"title-pic\"  src=\"' + baseUrl + '{{picPath}}\"  alt=\"title-Picture\">',
                '   <p class=\"title-summary\">{{{vqnSummary}}}</p>',
                '   <h5>',
                '      {{vqTitle}}',
                '      {{#qImgUrl}}',
                '          <div class=\"qimg\">',
                '               <img src=\"' + baseUrl + '{{qImgUrl}}\" alt=\"{{vqTitle}}\">',
                '          </div>',
                '      {{/qImgUrl}}',
                '   </h5>',
                '</div>'
            ].join('');

            var title = document.getElementById("title");
            var fragment = Mustache.render(template, data);
            title.innerHTML = fragment;
            title.style.display = 'block';
        }
    });
}

/**
 * 加载投票结果
 */
function getVoteResult() {
    mui.ajax(baseUrl+'/wanx/getVoteResult', {
        data: {
            vqnId: getIdFromQueryString(),
            deliveryId: getDeliveryIdFromQueryString()
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                var list = document.getElementById("list");
                drawResult(list, data);
            } else {
                mui.toast('网络似乎很繁忙啊,好像出错了额...');
            }
        },
        error: function() {
            mui.toast('网络似乎很繁忙啊,好像出错了额...');
        }
    })
}