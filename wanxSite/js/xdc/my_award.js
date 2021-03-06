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
    myAward();

    // 初始化悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_award',
            targetPage: 'person_index'
        });
        jumpTo('person_index');
    });
    
    // 监听跳转按钮
    document.getElementById('start-tour').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'my_award',
            targetPage: 'awardQnList'
        });
        jumpToQnList(2,'awardQnList');
    });
    
})();

/**
 * 加载列表
 */
function myAward() {

    mui.ajax(baseUrl+'/wanx/myAward', {
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
                "   <a>",
                "      <div class=\"card-name\">",
                "         <span class=\"card-tag card-tag-yellow\">{{awardTypeText}}</span>",
                "         <span>{{awardMethodText}}</span>",
                "      </div>",
                "      <span class=\"card-time\">{{time}}</span>",
                "      {{#redeemCode}}",
                "          </br><span class=\"card-time\">兑换码：{{redeemCode}}</span>",
                "      {{/redeemCode}}",
                "      <span class=\"card-award-des\">{{awardNameAndNum}}</span>",
                "   </a>",
                "</li>"
            ].join("");

            // 上拉刷新部分
            initialPullRefresh.call(window, data.totalPage, myAward);

            // 如果列表为空
            handleListEmpty(data.myAwardList, 'my-award-list-empty');
            
            // 显示每个条目
            var list = document.getElementById('my-award-list');
            var record = data.myAwardList;
            var fragment = '';
            var awardTypeArray = {
                "1": "实物",
                "2": "虚拟",
                "3": "粮票",
                "4": "卡券"
            }
            var awardMethodArray = {
                "1": "参加有奖问卷",
                "2": "参加抽奖问卷",
                "3": "参加抽奖问卷",
                "4": "完善个人信息"
            }
            for (var i = 0, length = record.length; i < length; i++) {
                record[i].awardTypeText = awardTypeArray[record[i].awardType];
                record[i].awardMethodText = awardMethodArray[record[i].awardMethod];
                record[i].time = record[i].awardGetTime.split(" ")[0];
                // 若为粮票，显示粮票数；若不为粮票，显示奖品名
                if (record[i].awardType == 3) {
                    record[i].awardNameAndNum = "+ " + record[i].awardNum;
                } else {
                    record[i].awardNameAndNum = record[i].awardName;
                }
                fragment += Mustache.render(template, record[i]);
            }
            list.innerHTML += fragment;

            // 隐藏loading动画
            hideLoading();
        },
        error: function() {
            jumpTo('404');
        }
    });
}