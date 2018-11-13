(function() {

    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });

    // h5统计
    MtaH5.clickStat('3000');

    // 加载列表
    loadReportList();

    // 加载广告
    loadBannerAd(4, 'wanx_reportList_b1');

    // 存入后退按钮的跳转地址
    localStorage.setItem('fromPos', 'report_list.html?version=' + xdcVersion);

    // 监听悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'listSkip',
            sourcePage: 'report-list',
            targetPage: 'index'
        });
        jumpTo('index');
    });

})();

/**
 * 加载报告List
 */
function loadReportList() {
    mui.ajax(baseUrl+'/wanx/reportList', {
        data: {
            userId: 1
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            var template = [
                "<li class=\"mui-table-view-cell mui-media\">",
                "   <a id=\"report-{{reportId}}\" data-reportId=\"{{reportId}}\" data-reportUrl=\"{{reportUrl}}\" data-thumbUp=\"{{thumbUp}}\" data-reportTitle=\"{{reportTitle}}\" data-isFavorite=\"{{isFavorite}}\">",
                "       <img class=\"report-img\" src=\"{{reportImg}}\">",
                "       <h4 class=\"report-title\">{{reportTitle}}</h4>",
                "       <p class=\"report-detail\">",
                "          <span class=\"iconfont icon-user\"></span>{{publisher}}",
                "          <span class=\"iconfont icon-clock\"></span>{{pTime}}",
                "       </p>",
                "       <p class=\"report-detail mui-pull-right\">",
                "          <span class=\"iconfont icon-7\"></span>{{collectedNum}}",
                "          <span class=\"iconfont icon-eye\"></span>{{viewNum}}",
                "       </p>",
                "   </a>",
                "</li>"
            ].join("");

            // 显示每个条目
            var list = document.getElementById("report-list");
            var record = data;
            var fragment = '';
            for (var i = 0, length = record.length; i < length; i++) {                
                record[i].pTime = record[i].pTime ? record[i].pTime.split(' ')[0] : '';
                fragment += Mustache.render(template, record[i]);
            }
            list.innerHTML = fragment;

            // 监听列表点击
            initialReportListListener();

            // 隐藏loading动画
            hideLoading();
        }
    });
}

/**
 * 报告列表页：每个条目的跳转函数
 */
function initialReportListListener() {
    document.getElementById('report-list').addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.tagName.toLowerCase() == 'a') {
                break;
            }
            target = target.parentNode;
        }
        
        var reportId = target.getAttribute('data-reportid');
        jumpToReport(reportId, 'report_list'); 
    });
}
