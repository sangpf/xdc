(function() {

    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });

    // 显示头部
    initialPersonPreview();

    // 加载列表
    myReport();

    // 存入后退按钮的跳转地址
    localStorage.setItem('fromPos', 'my_report.html?version=' + xdcVersion);

    // 初始化悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_report',
            targetPage: 'person_index'
        });
        jumpTo('person_index');
    });
    
    // 监听跳转按钮
    document.getElementById('start-tour').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_report',
            targetPage: 'report_list'
        });
        jumpTo('report_list');
    });
    
})();

/**
 * 加载列表
 */
function myReport() {

    mui.ajax(baseUrl+'/wanx/myReport', {
        data: {
            userId: 1
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {

            if (!isDataSuccess(data)) {
                jumpTo('404');
            }

            var template = [
                "<li class=\"mui-table-view-cell\">",
                "   <a id=\"report-{{reportId}}\" data-reportId=\"{{reportId}}\" data-reportUrl=\"{{reportUrl}}\" data-thumbUp=\"{{thumbUp}}\" data-reportTitle=\"{{reportTitle}}\" data-isFavorite=\"1\" data-reportvisible=\"{{reportVisible}}\">",
                "      {{#reportVisible}}<h4 class=\"card-name mui-ellipsis\">{{reportTitle}}</h4>{{/reportVisible}}",
                "      {{^reportVisible}}<h4 class=\"card-name mui-ellipsis gray\">{{reportTitle}}</h4>{{/reportVisible}}",
                "      <span class=\"card-time\">{{favoriteTime}}</span>",
                "      {{#tags}}",
                "         <span class=\"card-tag card-tag-yellow\">{{.}}</span>",
                "      {{/tags}}",
                "      <i class=\"card-trash icon-trash mui-pull-right\" onclick=\"handleTrashClick(event,'{{reportId}}')\"></i>",
                "   </a>",
                "</li>"
            ].join("");

            // 如果列表为空
            handleListEmpty(data.myReportList, 'my-report-list-empty');

            // 显示每个条目
            var list = document.getElementById('my-report-list');
            var record = data.myReportList;
            var fragment = '';
            var qnTypeArray = {
                "1": "调查",
                "2": "测评",
                "3": "投票"
            }
            for (var i = 0, length = record.length; i < length; i++) {
                record[i].tags = [record[i].reportClassName, qnTypeArray[record[i].qnType]];
                record[i].reportVisible = getVisibleByStatus(record[i].reportStatus);
                fragment += Mustache.render(template, record[i]);
            }
            list.innerHTML = fragment;

            // 监听列表点击
            initialMyReportListener();

            // 隐藏loading动画
            hideLoading();
        },
        error: function() {
            jumpTo('404');
        }
    });
}

/**
 * 我收藏的报告页：每个条目的跳转函数
 */
function initialMyReportListener() {
    document.getElementById('my-report-list').addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.className.indexOf('qn-trash') > -1) {
                return;
            }
            if (target.tagName.toLowerCase() == 'a') {
                break;
            }
            target = target.parentNode;
        }

        // 如果问卷关闭
        var reportVisible = target.getAttribute('data-reportVisible');
        if (parseInt(reportVisible) == 0) {
            mui.toast('该报告已经关闭了...');
            return;
        }

        var reportId = target.getAttribute('data-reportid');
        jumpToReport(reportId, 'my_report'); 
    });
}

/**
 * 删除报告按钮的点击函数
 */
function handleTrashClick(e, reportId) {
    mui.confirm("确认删除此报告？", "提示", ["删除", "取消"], function(confirmEvent) {
        if (confirmEvent.index == 0) {
            mui.ajax(baseUrl+'/wanx/deleteReportFavorite', {
                data: {
                    userId: 1,
                    reportId: reportId
                },
                dataType: 'json',
                type: 'get',
                timeout: 10000,
                success: function(data) {
                    if (isDataSuccess(data)) {
                        // 删除DOM节点
                        var liElement = e.target.parentNode.parentNode;
                        var ulElement = liElement.parentNode;
                        ulElement.removeChild(liElement);
                        // 判断列表是否为空
                        handleListEmpty(ulElement.childNodes, 'my-report-list-empty');
                        // 更新收藏的报告数
                        updateMyFavoriteReportNum('del');
                        initialPersonPreview();
                        // 删除收藏统计
                        addLog({
                            logType: 'reportAction',
                            action: 'deleteFavoriteReport',
                            reportId: reportId,
                            actResult: 'success'
                        });
                    } else {
                        mui.toast("网络错误，请稍后再试~");
                    }
                },
                error: function() {
                    mui.toast("网络错误，请稍后再试~");
                }
            });
        }
    });
    // 阻止事件冒泡，防止父标签的跳转
    e.stopPropagation();
}
