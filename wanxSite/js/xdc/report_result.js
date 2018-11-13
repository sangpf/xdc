"use strict";
var images = "[{\"url\":\"" + baseUrl + "/data/res/static/img/misc/shareIcon/shareIcon_180_180.png\"},{\"url\":\"" + baseUrl + "/data/res/static/img/misc/shareIcon/shareIcon_320_320.png\"}]";
// var images = "[{\"url\":\"http://www.17wanxiao.com:80/campus/~/userPic/164\"},{\"url\":\"http://www.17wanxiao.com:80/campus/~/userPic/167\"}]";
var imagejson = eval('(' + images + ')');
(function() {

    // mui初始化
    mui.init({
        subpages: [{
            url: localStorage.getItem('url_adress'),
            styles: {
                top: '0px', //mui标题栏默认高度为45px；
                bottom: '0px' //默认为0px，可不定义；
            }
        }]
    });
    localStorage.setItem('isReport', 1);
	
    // 加载底部操作栏
    loadFootBar();
    
////点击关闭按钮让其隐藏
	document.getElementById('close-img').addEventListener('tap',function(){
		document.getElementById('sheet1').style.display='none';
	})
	//点击分享显示遮罩层
	document.getElementById('share').addEventListener('tap',function(){
		document.getElementById('sheet1').style.display='block';
	})
//	//加载分享操作函数
	shartFun();
})()
/**
 * 点击分享
 */
function clickShare(){
	var sharebtn=doucument.getElementById('share');
	//点击分享按钮弹出分享框
}

/**
 * 添加收藏报告
 */
function addFavoriteReport(favoriteElem) {
    // 收藏业务
    var reportId = localStorage.getItem('reportId');
    mui.ajax(baseUrl+'/wanx/favoriteReport', {
        data: {
            userId: 1,
            reportId: reportId
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                mui.toast("收藏成功！");
                favoriteElem.classList.add('active');
                localStorage.setItem('isFavorite','1');
                updateMyFavoriteReportNum('add');
            } else {
                mui.toast("网络错误，请稍后再试~");
            }
        },
        error: function() {
            mui.toast("网络错误，请稍后再试~");
        }
    });

    // 收藏统计
    addLog({
        logType: 'reportAction',
        action: 'favoriteReport',
        reportId: reportId,
        actResult: 'success'
    });
}

/**
 * 删除收藏报告
 */
function deleteReportFavorite(favoriteElem) {
    // 取消收藏业务
    var reportId = localStorage.getItem('reportId');
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
                mui.toast("已取消收藏！");
                localStorage.setItem('isFavorite','0');
                favoriteElem.classList.remove('active');
                updateMyFavoriteReportNum('del');
            } else {
                mui.toast("网络错误，请稍后再试~");
            }
        },
        error: function() {
            mui.toast("网络错误，请稍后再试~");
        }
    });

    // 取消收藏统计
    addLog({
        logType: 'reportAction',
        action: 'deleteFavoriteReport',
        reportId: reportId,
        actResult: 'success'
    });
}



/**
 *分享事件 
 */
function shartFun(){
	//点击微信好友分享
	document.getElementById('share-wxhy').addEventListener('tap',function(){
		//调用微信好友分享事件
		shareWeixin();
	});
	//点击微信朋友圈分享
	document.getElementById('share-wxpyq').addEventListener('tap',function(){
		//调用朋友圈分享事件
		shareWeixinCircle();
	});
	//点击微博分享
	document.getElementById('share-weibo').addEventListener('tap',function(){
		//调用微博分享事件
		shareWeibo();
	});
	//点击QQ好友分享
	document.getElementById('share-qqhy').addEventListener('tap',function(){
		//调用QQ好友分享事件
		shareQQ();
	});
	//点击QQ空间分享
	document.getElementById('share-qqkj').addEventListener('tap',function(){
		//调用QQ空间分享事件
		shareQzone();
	});
	//点击完校同学圈分享
	document.getElementById('share-wanxiao').addEventListener('tap',function(){
		//调用完校同学圈分享事件
		shareWanxiaoCircle();
	});
}
/**
 * 分享相关
 */

function shareToWanxiao() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'wanxiao'
    });
    wanxiao.shareTo("-1", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress'), localStorage.getItem('reportTitle'));
}

function shareWanxiaoCircle() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'wanxiaoCircle'
    });
    wanxiao.shareTo("0", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress') + '?position=wanx', localStorage.getItem('reportTitle'));
}

function shareWeixin() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'weixin'
    });
    wanxiao.shareTo("1", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress') + '?position=weix', localStorage.getItem('reportTitle'));
}

function shareWeixinCircle() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'weixinCircle'
    });
    wanxiao.shareTo("2", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress') + '?position=weix', localStorage.getItem('reportTitle'));
}

function shareWeibo() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'weibo'
    });
    wanxiao.shareTo("3", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress'), localStorage.getItem('reportTitle'));
}

function shareQQ() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'qq'
    });
    wanxiao.shareTo("4", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress'), localStorage.getItem('reportTitle'));
}

function shareQzone() {
    addLog({
        logType: 'reportAction',
        action: 'repost',
        reportId: localStorage.getItem('reportId'),
        actResult: 'qzone'
    });
    wanxiao.shareTo("5", "超级调查来喽，乃们有各种好玩有料的报告，让你在欢乐中了解大学生的世界！", imagejson, 'http://www.xindongcha.net:8080' + localStorage.getItem('url_adress'), localStorage.getItem('reportTitle'));
}