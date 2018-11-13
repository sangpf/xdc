var hasMore = false;
var currentPage = 0;
var pullToRefreshSelector = '.xdc-scroll';

(function() {

    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });

    // 显示头部
    initialPersonPreview();

    // 加载列表
    mySuperSurvey();

    // 存入后退按钮的跳转地址
    localStorage.setItem('fromPos', 'my_survey.html?version=' + xdcVersion);

    // 初始化悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_survey',
            targetPage: 'person_index'
        });
        jumpTo('person_index');
    });
    
    // 监听跳转按钮
    document.getElementById('start-tour').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_survey',
            targetPage: 'schoolQnList'
        });
        jumpToQnList(1,'schoolQnList');
    });
    
})();

/**
 * 加载列表
 */
function mySuperSurvey() {

    mui.ajax(baseUrl+'/wanx/mySuperSurvey', {
        data: {
            userId: 1,
            page: ++currentPage
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
                "   <a data-source=\"my_survey\" data-qntype=\"{{qnType}}\" data-deliveryid=\"{{deliveryId}}\" data-qnid=\"{{qnId}}\" data-qnvisible=\"{{qnVisible}}\">",
                "      {{#qnVisible}}<h4 class=\"card-name mui-ellipsis\">{{qnName}}</h4>{{/qnVisible}}",
                "      {{^qnVisible}}<h4 class=\"card-name mui-ellipsis gray\">{{qnName}}</h4>{{/qnVisible}}",
                "      <span class=\"card-time\">{{answerETime}}</span>",
                "      {{#tags}}",
                "         <span class=\"card-tag card-tag-yellow\">{{.}}</span>",
                "      {{/tags}}",
                "      {{#reportVisible}}",
                "         <span class=\"card-report\" id=\"report-{{reportId}}\" data-source=\"my_survey\" data-reportId=\"{{reportId}}\" data-reportUrl=\"{{reportUrl}}\" data-thumbUp=\"{{thumbUp}}\" data-reportTitle=\"{{reportTitle}}\" data-isFavorite=\"{{isFavorite}}\" onclick=\"handleReadReportClick(event);\">查看报告 ></span>",
                "      {{/reportVisible}}",
                "   </a>",
                "</li>"
            ].join("");

            // 上拉刷新部分
            initialPullRefresh.call(window, data.totalPage, mySuperSurvey);

            // 如果列表为空
            handleListEmpty(data.mySuperList, 'my-survey-list-empty');
            
            // 显示每个条目
            var list = document.getElementById('my-survey-list');
            var record = data.mySuperList;
            var fragment = '';
            var qnTypeArray = {
		        "1": "调查",
		        "2": "测评",
		        "3": "投票"
		    }
            for (var i = 0, length = record.length; i < length; i++) {
                record[i].tags = [record[i].qnClassName, qnTypeArray[record[i].qnType]];
                record[i].qnVisible = getVisibleByStatus(record[i].deliveryStatus);
                record[i].reportVisible = getVisibleByStatus(record[i].reportStatus, record[i].reportUrl);
                fragment += Mustache.render(template, record[i]);
            }
            list.innerHTML += fragment;

            // 监听列表点击
            initialMyListListener('my-survey-list');
            
            // 隐藏loading动画
            hideLoading();
        },
        error: function() {
            jumpTo('404');
        }
    });
}