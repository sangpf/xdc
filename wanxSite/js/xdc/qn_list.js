(function() {

    // mui初始化
    mui.init({
        swipeBack: true //启用右滑关闭功能
    });

    // 初始化配置
    var pageConfig = {
        currentPage: 0,
        hasMore: false,
        pullToRefreshSelector: '.xdc-scroll',
        listId: 'qn-list',
        listType: parseInt(splitFromQueryString(1)),
        listCategory: splitFromQueryString(2),
        headTagType: 'qnClassName',
        loadFunction: function() {
            loadQnList(this, function() {
                hideLoading();
            });
        }
    };

    // 根据list页面类型，初始化一些变量
    // 1: daily3Update-list
    // 2: super-list
    // 3: assess-list
    // 4: activity-list
    switch (pageConfig.listType) {
        case 1:
        case 2:
            var MtaH5Code = '200';
            var adPos = 2;
            break;
        case 3:
            var MtaH5Code = '300';
            var adPos = 3;
            break;
        case 4:
            var MtaH5Code = '700';
            var adPos = 5;
        default:
            // statements_def
            break;
    }

    // h5统计
    MtaH5.clickStat(MtaH5Code);

    // 加载列表
    pageConfig.loadFunction();

    // 加载广告
    loadBannerAd(adPos, 'wanx_' + pageConfig.listCategory + '_b1');

    // 存入后退按钮的跳转地址
    var fromPos = 'qn_list.html?version=' + xdcVersion + '&listType=' + pageConfig.listType + '&listCategory=' + pageConfig.listCategory;
    localStorage.setItem('fromPos', fromPos);

    // 监听悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'listSkip',
            sourcePage: pageConfig.listCategory,
            targetPage: 'index'
        });
        jumpTo('index');
    });

    // 监听查看已答问卷
    document.getElementById('jump-to-person').addEventListener('tap', function() {
        addLog({
            logType: 'listSkip',
            sourcePage: pageConfig.listCategory,
            targetPage: 'person_index'
        });
        jumpTo('person_index');
    });

})();
