/*
 * 产品包栏目里测试的标签如果是空的就隐藏
 */
function deshtml(c_name){
	for(var y=0; y<$(c_name).length; y++){
		if($(c_name).eq(y).html()==""){
			$(c_name).eq(y).css("display","none")
		}
	}
}
//======================================================
//                       点赞相关
//=====================================================
/**
 * 改变点赞图形的颜色、点赞数目
 */
function toggleThumbUp(thumbElem, thumbNum) {
    if (thumbElem.getAttribute('tapped') == 'false') {
        thumbElem.setAttribute('tapped', 'true');
        thumbElem.classList.add('active');
        thumbNum.innerHTML = parseInt(thumbNum.innerHTML) + 1;
    } else {
        thumbElem.setAttribute('tapped', 'false');
        thumbElem.classList.remove('active');
        thumbNum.innerHTML = parseInt(thumbNum.innerHTML) - 1;
    }
}

/**
 * 评论点赞数
 */
function thumbsUp(commentId, type) {
    var thumbElem = document.getElementById(type + 'thumbs-up' + commentId);
    var thumbNum = document.getElementById(type + 'thumbsUpNum' + commentId);

    // 改变点赞图形的颜色、点赞数目
    toggleThumbUp(thumbElem, thumbNum);

    // 点赞业务
    mui.ajax(baseUrl+'/wanx/praiseComment', {
        data: {
            commentId: commentId,
            likeNum: thumbNum.innerHTML
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });

    // 点赞统计
    var isReport = localStorage.getItem('isReport');
    if (isReport == '1') {
        addLog({
            logType: 'reportAction',
            action: 'thumbUpComment',
            reportId: localStorage.getItem('reportId'),
            actResult: commentId
        });
    } else {
        addLog({
            logType: 'qnAction',
            action: 'thumbUpComment',
            deliveryId: localStorage.getItem('deliveryId'),
            qnId: localStorage.getItem('qnId'),
            qnType: localStorage.getItem('qnType'),
            actResult: commentId
        });
    }
}

/*
 * 底部操作栏点赞数
 */
function thumbsChange(type) {
    var thumbElem = document.getElementById('footThumb' + type);
    var thumbNum = document.getElementById('footThumbNum' + type);
    var deliveryId = localStorage.getItem('deliveryId');
    var qnId = localStorage.getItem('qnId');
    var qnType = localStorage.getItem('qnType');

    // 改变点赞图形的颜色、点赞数目
    toggleThumbUp(thumbElem, thumbNum);

    // 点赞业务
    mui.ajax(baseUrl+'/wanx/updateThumbUpAndDown', {
        data: {
            deliveryId: deliveryId,
            qnType: qnType,
            thumbUp: document.getElementById('footThumbNumUp').innerHTML,
            thumbDown: document.getElementById('footThumbNumDown').innerHTML
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });

    // 点赞统计
    addLog({
        logType: 'qnAction',
        action: 'thumb' + type,
        deliveryId: deliveryId,
        qnId: qnId,
        qnType: qnType,
        actResult: 'success'
    });
}

/**
 * 报告底部操作栏点赞数
 */
function reportThumbsUp(type) {
    var thumbElem = document.getElementById('footThumb' + type);
    var thumbNum = document.getElementById('footThumbNum' + type);
    var reportId = localStorage.getItem('reportId');

    // 改变点赞图形的颜色、点赞数目
    toggleThumbUp(thumbElem, thumbNum);

    // 点赞业务
    mui.ajax(baseUrl+'/wanx/reportThumbUpAndDown', {
        data: {
            reportId: reportId,
            thumbUp: thumbNum.innerHTML,
            thumbDown: '0'
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });

    // 点赞统计
    addLog({
        logType: 'reportAction',
        action: 'thumb' + type,
        reportId: reportId,
        actResult: 'success'
    });
}
/*
 * 测评点赞,踩业务
 */
function assessThumbsUp(activeEl,type){
	var deliveryId = localStorage.getItem('deliveryId');
	var qnId = localStorage.getItem('qnId');
    var qnType = localStorage.getItem('qnType');
    var up_tapped=document.getElementById('operation-box').getAttribute('up-tapped');
    var down_tapped=document.getElementById('operation-box').getAttribute('down-tapped');
    //判断点击的是准还是不准，并改变其数量与样式
	if(activeEl=='thumbup'){
		//进入这里表示是增加准的数量
		if(up_tapped=='false'){
			//增加准的数量
			document.getElementById('operation-true-datanumber').innerHTML = parseInt(document.getElementById('operation-true-datanumber').innerHTML) + 1;
			//点击准改变按钮的样式
			document.getElementById('operation-true-datanumber').classList.add('assess-up-active');
			//将tapped设置为true，表示当前用户已经点击过‘准’按钮了
			document.getElementById('operation-box').setAttribute('up-tapped','true');
		}else{
			//进入这里表示是取消准
			document.getElementById('operation-true-datanumber').innerHTML = parseInt(document.getElementById('operation-true-datanumber').innerHTML) - 1;
			//移除样式
			document.getElementById('operation-true-datanumber').classList.remove('assess-up-active');
			//将tapped设置为false，表示当前用户已经取消点击‘准’按钮了
			document.getElementById('operation-box').setAttribute('up-tapped','false');
		}
		
	}else if(activeEl=='thumbdown'){
		//进入这里表示是增加不准的数量
		if(down_tapped=='false'){
			document.getElementById('operation-false-datanumber').innerHTML = parseInt(document.getElementById('operation-false-datanumber').innerHTML) + 1;
			//改变不准按钮的样式
			document.getElementById('operation-false-datanumber').classList.add('assess-up-active');
			//将tapped设置为true，表示当前用户已经点击‘不准’按钮了
			document.getElementById('operation-box').setAttribute('down-tapped','true')
		}else{
			//进入这里表示是取消不准
			document.getElementById('operation-false-datanumber').innerHTML = parseInt(document.getElementById('operation-false-datanumber').innerHTML) - 1;
			//移除
			document.getElementById('operation-false-datanumber').classList.remove('assess-up-active');
			//将tapped设置为false，表示当前用户已经取消点击‘不准’按钮了
			document.getElementById('operation-box').setAttribute('down-tapped','false')
		}
		
	}
	 mui.ajax(baseUrl+'/wanx/updateThumbUpAndDown', {
        data: {
            deliveryId: deliveryId,
            qnType: qnType,
            thumbUp: document.getElementById('operation-true-datanumber').innerHTML,
            thumbDown: document.getElementById('operation-false-datanumber').innerHTML
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });

    // 点赞统计
    addLog({
        logType: 'qnAction',
        action: 'thumb' + type,
        deliveryId: deliveryId,
        qnId: qnId,
        qnType: qnType,
        actResult: 'success'
    });
}

//======================================================
//                       评论相关
//======================================================

/**
 * 加载评论列表
 */
function loadCommentList() {
    // 判断是否是报告页面评论
    var commentObjId, commentObjType;
    if (localStorage.getItem('isReport') == '1') {
        commentObjId = localStorage.getItem('reportId');
        commentObjType = '4';
    } else {
        commentObjId = localStorage.getItem('deliveryId');
        commentObjType = localStorage.getItem('qnType');
    }

    mui.ajax(baseUrl+'/wanx/getCommentList', {
        data: {
            commentObjId: commentObjId,
            commentObjType: commentObjType
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
        		
            //无评论头部标题模板
            var noCommentTitleTemplate = "\n <div class=\"commetTittle\">全部评论<span class=\"commentCircle\" id=\"commentNum\">0</span></div>\n ";
            //无评论内容模板
            var noCommentListTemplate = "\n <p class=\"commentNullText\">快来抢沙发吧～～～</p>\n ";
            //精彩评论头部标题模板
            var goodCommentTitleTemplate = "\n <div class=\"commetTittle\">精彩评论</div>\n ";
            //精彩评论内容模板
            var goodCommentListTemplate = "\n <div class=\"comment-item\">\n <img class=\"portrait\" src=\"{{wanxHeadImg}}\" />\n <div class=\"comment-txt\">\n <div class=\"comment-left\">\n <p class=\"comment-info\">{{wanxNickname}} | {{schoolName}}</p>\n <p class=\"comment-info\">{{showTime}}</p>\n <div class=\"comment-detail\">{{content}}</div>\n </div>\n <div class=\"comment-mid\"><img src=\"images/hot.png\"></div>\n <div class=\"comment-right\">\n  <span class=\"thumbs\" id=\"goodthumbsUpNum{{commentId}}\">{{likeNum}}</span><a class=\"icon-thumbs-up thumbsUp\" onclick=\"thumbsUp({{commentId}},'good')\" id=\"goodthumbs-up{{commentId}}\" tapped=\"false\"></a>\n </div>\n </div>\n </div>\n";
           	//全部评论头部标题模板
            var allCommentTitleTemplate = "\n <div class=\"commetTittle\">全部评论<span class=\"commentCircle\" id=\"commentNum\">{{commentNum}}</span></div>\n ";
            //全部评论内容模板
			var allCommentListTemplate = "\n <div class=\"comment-item\">\n <img class=\"portrait\" src=\"{{wanxHeadImg}}\" />\n <div class=\"comment-txt\">\n <div class=\"comment-left\">\n <p class=\"comment-info\">{{wanxNickname}} | {{schoolName}} </p>\n <p class=\"comment-info\">{{showTime}}</p>\n <div class=\"comment-detail\">{{content}}</div>\n </div>\n <div id=\"comment-reply\"><img class=\"reply-img\" onclick=\"replyUser(this)\" data-nickName=\"{{wanxNickname}}\"  data-content=\"{{content}}\" data-user=\"{{userId}}\"  src=\"\\wanxSite\\images\\reply-after.png\"/></div>\n <div class=\"comment-right\">\n  <span class=\"thumbs\" id=\"thumbsUpNum{{commentId}}\">{{likeNum}}</span><a class=\"icon-thumbs-up thumbsUp\" onclick=\"thumbsUp({{commentId}},'')\" id=\"thumbs-up{{commentId}}\" tapped=\"false\"></a>\n </div>\n  </div>\n </div>\n";
			//获得评论外层边框操作对象
            var allCommentArea = document.getElementById("commentArea");
            //获得精彩评论外边框操作对象
            var goodCommentArea = document.getElementById("goodcommentArea");

            // 解码从后台读取到的评论的表情
            var decodeFace = function(str) {
                var newStr = str
                    .replace(/&lt;img/g, '<img')
                    .replace(/&#x2F;&gt;/g, '/>')
                    .replace(/&#x3D;/g, '=')
                    .replace(/&quot;/g, '\'')
                    .replace(/&#39;/g, '\'');
                return newStr;
            }

            // 渲染评论的函数
            var renderCommentList = function(commentArea, commentList, titleTemplate, listTemplate) {
            			//判断有无评论
                if (commentList.length > 0) { 
                		//进入这里表示有评论
                		//使用Mustache.js的render渲染头部模板和数据
                    commentArea.innerHTML = Mustache.render(titleTemplate, data)
                    var fragment = '';
                    //循环操作数据
                    for (var i = 0, length = commentList.length; i < length; i++) {
                    		//使用三目运算判断
                    		//如果头像数据是否是有效的字符串，如果是就表示此用户设置了头像
                    		//如果不是有效的字符串就表示当前用户没有设置头像
                    		//将显示的头像赋值为项目目录下images文件下的固定默认头像的路径
                        commentList[i].wanxHeadImg = isStrValid(commentList[i].wanxHeadImg) ? commentList[i].wanxHeadImg : "./images/good.png";
                        //将渲染后的评论模板和数据在原有的基础上进行叠加
                        fragment += Mustache.render(listTemplate, commentList[i]);
                    }
                    //将数据库获取到的表情解码成可视标签
                    fragment = decodeFace(fragment); 
                    
                    //将渲染好的模板添加到评论板块中
                    commentArea.innerHTML += fragment;
                }
            }

            // 渲染评论
            if (data.errorCode == "001") {
            		//进入这里表示无评论
                //将评论外边框填充无评论模板
                allCommentArea.innerHTML = (noCommentTitleTemplate + noCommentListTemplate);
            } else {
            		//进入这里表示有评论内容
                //渲染全部评论
                renderCommentList(allCommentArea, data.commentList, allCommentTitleTemplate, allCommentListTemplate);
                //渲染精彩评论
                renderCommentList(goodcommentArea, data.goodCommentList, goodCommentTitleTemplate, goodCommentListTemplate);
            }

            // 隐藏Loading动画
            hideLoading();
        }
    });
}

/**
 * 监听插入表情
 */
function inputFac(){
	//给表情ul监听点击时间
	document.getElementById('emoji').addEventListener('tap',function(e){
		//获取点击的目标
		var target=e.target
		//判断是否点击的是li
		while (target!=this){
		if(target.tagName.toLowerCase()=='li'){
			break;
		}
		//获得节点
		target=target.parentNode;
		}
		//转换表情显示代码
		facText=target.innerHTML;
		//把点击的表情拼接上用户输入的内容
		document.getElementById('commentInput').value += facText;
	});
}

//======================================================
//                       loading相关
//======================================================

/**
 * 显示loading动画
 */
function hideLoading() {
    document.getElementById("over").style.display = "none";
    document.getElementById("layout").style.display = "none";
}

/**
 * 隐藏loading动画
 */
function showLoading() {
    document.getElementById("over").style.display = "block";
    document.getElementById("layout").style.display = "none";
}
/**
 * 根据当前时间切换不同Loading动画
 * 如果1:当前是白天则显示白色背景没有篝火的Loading动画
 * 如果2：当前是晚上则显示黑色背景有篝火的Loading动画
 * nowTime:当前的时间的时和分
 */
function currenttimechange(nowTime){
	//声明白天时间变量--需要转成date时间类型
	var am=new Date('18:00');
	//判断nowTime是否大于18:00分
	if(nowTime>=am){
		//进入这里表示是晚上，显示如果2的动画
	}
}
/**
 * 获取当前时间
 * year:年份--取值:true则返回的当前时间保留年份,false则不保留年份
 * month:月份--取值:true返回的当前时间保留月份，false则不保留月份
 * day:日期--取值:true返回的当前时间保留日期，false则不保留日期
 * hours:小时--取值:true返回的当前时间保留小时，false则不保留小时
 * min:分钟--取值:true返回的当前时间保留分钟，false则不保留
 * seconds:秒--取值:true返回的当前时间保留秒，false则不保留
 * seperator:年份和月份的分隔符--取值:String，例如:"-"则返回日期为2017-5-19
 */
//function getNowFormatDate(year,month,day,hours,min,seconds,seperator) {
//  var date = new Date();
//  var seperator1 = seperator;
//  var seperator2 = ":";
//  var month = date.getMonth() + 1;
//  var strDate = date.getDate();
//  if (month >= 1 && month <= 9) {
//      month = "0" + month;
//  }
//  if (strDate >= 0 && strDate <= 9) {
//      strDate = "0" + strDate;
//  }
//  //判断需要返回的时间格式
//  if(year==true&&month==true&&day==true&&hours==true&&min==true&&seconds==true){
//  		//进入这里表示全部返回
//  		var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
//          + " " + date.getHours() + seperator2 + date.getMinutes()
//          + seperator2 + date.getSeconds();
//          return currentdate;
//  }else if(year==true&&month==true&&day==true){
//  		//进入这里表示只返回年月日
//  		var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate;
//      return currentdate;
//  }else if(hours==true&&min==true&&seconds==true){
//  		//进入这里表示只返回时分秒
//  		var currentdate =date.getHours() + seperator2 + date.getMinutes()
//          + seperator2 + date.getSeconds();
//          return currentdate;
//  }else if(hours==true&&min==true){
//  		//进入这里表示只返回时分
//  		var currentdate =date.getHours() + seperator2 + date.getMinutes();
//          return currentdate;
//  }
//  
//} 
//======================================================
//                       上拉刷新相关
//======================================================

/**
 * 初始化上拉刷新
 * 输入：
 *   totalPage: 总页数
 *   handlePullRefresh: 每次下拉刷新的业务操作（如ajax）
 */
function initialPullRefresh(totalPage, handlePullRefresh) {
    // 如果总共只有一页，则不必启用上拉刷新
    totalPage = parseInt(totalPage);
    if (totalPage <= 1) {
        return;
    }

    // 如果总页数大于1，则启用上拉刷新
    var _self = this;
    mui.ready(function() {
        mui.each(document.querySelectorAll(_self.pullToRefreshSelector), function(index, pullRefreshEl) {
            mui(pullRefreshEl).pullToRefresh({
                up: {
                    // 上拉加载具体业务实现
                    callback: function() {
                        setTimeout(function() {
                            if (_self.hasMore) {
                                updatePullRefreshTips('上拉显示更多');
                                handlePullRefresh.apply(_self, arguments);
                            } else {
                                updatePullRefreshTips('没有更多数据了');
                            }
                            this.endPullUpToRefresh(false); //参数为true代表没有更多数据了。
                        }.bind(this), 1000);
                    }
                }
            });
        });
    });

    // 刷新了下一页后，需更新hasMore
    if (_self.currentPage < totalPage) {
        _self.hasMore = true;
    } else {
        _self.hasMore = false;
    }
}

/**
 * 更新上拉加载的底部提示文字
 *
 * 输入：
 *     str：要显示的文字
 */
function updatePullRefreshTips(str) {
    mui.each(document.getElementsByClassName('mui-pull-loading'), function(i, item) {
        var noMoreDiv = document.createElement('div');
        noMoreDiv.setAttribute('class', 'mui-pull-loading');
        noMoreDiv.innerHTML = str;
        item.parentNode.replaceChild(noMoreDiv, item);
    });
}

//======================================================
//                       广告相关
//======================================================

/**
 * 加载banner广告
 * 输入：
 *   adPos: 广告位id
 *   adPosCode:广告位编码，用于广告浏览统计
 */
function loadBannerAd(adPos, adPosCode) {
    mui.ajax(baseUrl+'/wanx/bannerAd', {
        data: {
            adPos: adPos
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            // 显示广告
            var bannerAd = document.getElementById('ad-banner');
            bannerAd.src = baseUrl + data.adImg;
            bannerAd.style.display = 'block';

            // 浏览广告统计
            onloadAdStatistics(adPosCode, data.adId);
            addLog({
                logType: 'advertise',
                action: 'view',
                adPosCode: adPosCode,
                adId: data.adId,
                adTitle: data.adTitle,
                adLink: data.adLink
            });

            // 点击广告统计
            bannerAd.addEventListener('tap', function() {
                var MtaH5Code = {
                    '1': '1700', // index
                    '2': '2100', // super_list
                    '3': '3100', // assess_list
                    '4': '4100', // report_list
                }
                MtaH5.clickStat(MtaH5Code[adPos]);
                clickAdStatistics(adPosCode, data.adId);
                addLog({
                    logType: 'advertise',
                    action: 'click',
                    adPosCode: adPosCode,
                    adId: data.adId,
                    adTitle: data.adTitle,
                    adLink: data.adLink
                });
                jumpToUrl('http://' + data.adLink);
            });
        }
    });
}

/**
 * 加载投放信息中的广告
 */
function loadDeliveryAd() {
    // 显示广告  
    var completeAd = document.getElementById('ad-delivery');
    completeAd.src = baseUrl + localStorage.getItem('adImg');
    completeAd.style.display = 'block';

    // 浏览广告统计
    var adPosCode = 'wanx_delivery_b1';
    var adId = localStorage.getItem('adId');
    var adLink = localStorage.getItem('adLink');
    onloadAdStatistics(adPosCode, adId);
    addLog({
        logType: 'advertise',
        action: 'view',
        adPosCode: adPosCode,
        adId: adId,
        adTitle: '浏览投放信息中的广告',
        adLink: adLink
    });

    // 点击广告统计
    completeAd.addEventListener('tap', function() {
        clickAdStatistics(adPosCode, adId);
        addLog({
            logType: 'advertise',
            action: 'click',
            adPosCode: adPosCode,
            adId: adId,
            adTitle: '点击投放信息中的广告',
            adLink: adLink
        });
        jumpToUrl('http://' + adLink);
    });
}

//======================================================
//                       URL相关
//======================================================

/*
 * 从url的查询字符串中，提取第i个[key=value]对的value值.
 * i从0开始
 * 
 *   如：http://101.200.166.221:8080/wanxSite/example.html?version=1.3&id=212235640&deliveryId=149
 *
 *    var id = splitFromQueryString(1)  // 212235640
 *    var deliveryId = splitFromQueryString(2)  // 149
 */
function splitFromQueryString(i) {
    return window.location.search.split('&')[i].split('=')[1];
}

function getVersion() {
    return splitFromQueryString(0);
}

function getIdFromQueryString() {
    return splitFromQueryString(1);
}

function getDeliveryIdFromQueryString() {
    return splitFromQueryString(2);
}

//======================================================
//                       jumpTo 相关
//======================================================

/**
 * 跳转到指定的URL
 *
 * 封装了mui的openWindow()方法
 *
 * 输入：
 *     url：跳转目标地址的url
 */
function jumpToUrl(url) {
    mui.openWindow({
        url: url,
        show: {
            aniShow: "pop-in"
        },
        waiting: {
            autoShow: false
        }
    });
}

/*
 * 只用于对站点内部html的跳转链接。
 *
 * 输入：
 *     html：必选。站点内部html的文件名。不包括后缀。
 *     queryString：可选。查询字符串，格式形如  ?key1=value1&key2=value2
 *
 *     如果只有html参数，则自动追加 ?version=X.X
 *     如果有queryString，则输入的queryString中应已经拼接好version
 */
function jumpTo(html, queryString) {
    if (arguments.length == 1) { // 只有参数html
        var url = html + '.html?version=' + xdcVersion;
    } else if (arguments.length == 2) {
        var url = html + '.html' + queryString;
    }
    jumpToUrl(url);
}


/*
 * 只用于对站点内部qn_list页的跳转链接。
 *
 * 输入：
 *     listType: list页面类型。
 *     listCategory: 查询条件
 */
function jumpToQnList(listType, listCategory) {
    var url = 'qn_list.html?version=' + xdcVersion + '&listType=' + listType + '&listCategory=' + listCategory;
    jumpToUrl(url);
}

/**
 * 跳转到问卷（调查、投票、测评）
 *
 * 输入：
 *     reportId
 * 备注：需满足特定的DOM结构
 */
//TODO 加入付费测评
function jumpToQn(qnType, answered, qnId, deliveryId, sourcePage) {
    var contentType = {
        '1': 'assess_content.html',
        '2': 'paid_guide.html',
        '3': 'vote_content.html'
    }
    var resultType = {
        '1': 'survey_result.html',
        '2': 'assess_result.html',
        '3': 'vote_result.html'
    }
    var queryString = '?version=' + xdcVersion + '&id=' + qnId + '&deliveryId=' + deliveryId;
    var href = '404.html?version=' + xdcVersion;
    var targetPage = '';

    if (answered == 0) {
        href = contentType[qnType] + queryString;
        targetPage = contentType[qnType];
    } else if (answered == 1) {
        href = resultType[qnType] + queryString;
        targetPage = resultType[qnType];
    }

    // 列表点击统计
    if (typeof sourcePage !== 'undefined') {
        addLog({
            logType: 'qnPageSkip',
            sourcePage: sourcePage,
            targetPage: targetPage,
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType
        });
    }
    
    // 跳转页面
    jumpToUrl(href);
}

/**
 * 跳转到报告页report_result
 *
 * 备注：需满足特定的DOM结构
 */
function jumpToReport(reportId, sourcePage) {

    // 增加报告阅读量
    var addReportViewNum = function (reportId) {
        mui.ajax(baseUrl+'/wanx/addReportViewNum', {
            data: {
                reportId: reportId
            },
            dataType: 'json',
            type: 'post',
            timeout: 10000,
            success: function() {}
        });
    }

    var element = document.getElementById('report-' + reportId);
    localStorage.setItem('url_adress', element.getAttribute('data-reportUrl'));
    localStorage.setItem('reportId', element.getAttribute('data-reportId'));
    localStorage.setItem('thumbUp', element.getAttribute('data-thumbUp'));
    localStorage.setItem('thumbDown', '0');  // 取消了报告的踩
    localStorage.setItem('reportTitle', element.getAttribute('data-reportTitle'));
    localStorage.setItem('isFavorite', element.getAttribute('data-isFavorite'));

    // 列表点击统计
    addLog({
        logType: 'reportPageSkip',
        sourcePage: sourcePage,
        targetPage: 'report_result',
        reportId: reportId
    });

    // 增加报告阅读量
    addReportViewNum(reportId);

    // 跳转页面
    jumpTo('report_result');
}

//======================================================
//                       统计相关
//======================================================

/**
 * 列表点击流水统计
 * 三更，超级，测一发，活动页均调用该函数
 *
 * 输入：
 *   qnType: 问卷类型。1:调查   2: 测评    3:投票
 *   deliveryId: 投放ID。作为入参传给后台
 *   listType: list页面类型。作为入参传给后台
 */
function qnClickStatistics(qnType, deliveryId, listType) {
    var flowInterface = {
        '1': '/wanx/addSurveyDeliveryWanxFlowRecord',
        '2': '/wanx/addAssessDeliveryWanxFlowRecord',
        '3': '/wanx/addVoteWanxFlowRecord'
    }

    mui.ajax(baseUrl+flowInterface[qnType], {
        data: {
            deliveryId: deliveryId,
            tapSource: listType
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });
}

/*
 * 点击广告统计
 */
function clickAdStatistics(adPosCode, adId) {
    mui.ajax(baseUrl+'/wanx/adClickRecord', {
        data: {
            userId: 1,
            adId: adId,
            adPosCode: adPosCode
        },
        dataType: 'json',
        type: 'post',
        timeout: 10000,
        success: function() {}
    });
}

/**
 * 加载广告统计
 */
function onloadAdStatistics(adPosCode, adId) {
    mui.ajax(baseUrl+'/wanx/adOnloadRecord', {
        data: {
            userId: 1,
            adId: adId,
            adPosCode: adPosCode
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function() {}
    });
}

/**
 * 添加日志
 */
function addLog(data) {
    data.version = xdcVersion;
    data.channel = 1;

    mui.ajax(baseUrl+'/wanx/addLog', {
        data: data,
        dataType: 'json',
        type: 'post',
        timeout: 10000,
        success: function() {}
    });
}

//======================================================
//                       投放相关
//======================================================

/**
 * 加载投放信息
 *
 * 输入：
 *   qnType: 问卷类型。1:调查   2: 测评    3:投票
 *   deliveryId: 投放ID。作为入参传给后台
 *   where: 触发getDeliveryInfo的位置。对于答题页和结果页，有不同的公共行为
 *   successCallback: 回调函数
 */
function getDeliveryInfo(qnType, deliveryId, where, successCallback) {

    // 得到加载投放信息中，调查、测评、投票各自的后台接口。
    var deliveryInterfaceArray = {
        '1': '/wanx/surveyDeliveryInfo',
        '2': '/wanx/assessDeliveryInfo',
        '3': '/wanx/voteDeliveryInfo'
    }

    // 将加载的投放信息存入到localStorage中
    var saveDeliveryToLocal = function(data, qnType, deliveryId) {
        var award = {
            awardMethod: data.awardMethod,
            awardName: data.awardName,
            awardId: data.awardId,
            awardType: data.awardType,
            awardLink: data.awardLink,
            awardNum: data.awardNum,
        };

        localStorage.setItem('award', JSON.stringify(award));
        localStorage.setItem('answered', data.answered);
        localStorage.setItem('qnId', data.qnId);
        localStorage.setItem('adImg', data.adImg);
        localStorage.setItem('adLink', data.adLink);
        localStorage.setItem('adId', data.adId);
        localStorage.setItem('aqnCategory', data.aqnCategory);
        localStorage.setItem('sqnCategory', data.sqnCategory);
        localStorage.setItem('keyQuestionNum', data.keyQuestionNum);
        localStorage.setItem('thumbUp', data.thumbUp);
        localStorage.setItem('thumbDown', data.thumbDown);
        localStorage.setItem('lotteryId', data.lotteryId);
        localStorage.setItem('evaluateId', data.evaluateId);        
        localStorage.setItem('resultMsg', data.resultMsg);
        localStorage.setItem('titleTag', data.titleTag);
        localStorage.setItem('donatePerson', data.donatePerson);
        localStorage.setItem('donateScore', data.donateScore);
        
        localStorage.setItem('headResultDetail', data.headResultDetail);
        localStorage.setItem('tailResultDetail', data.tailResultDetail);

        localStorage.setItem('qnType', qnType);
        localStorage.setItem('deliveryId', deliveryId);
        
        
    }
	//
    mui.ajax(baseUrl+deliveryInterfaceArray[qnType], {
        data: {
            userId: 1,
            deliveryId: deliveryId
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {	
            saveDeliveryToLocal(data, qnType, deliveryId);
            //如果qnType是2就表示加载的测评投放信息
			if(qnType==2||qnType=='2'){
				//将投放信息的问卷名称保存起来
				localStorage.setItem('qnName',data.qnName)
			}
            if (where === 'content') {
                // 答题页行为：判断：如果答过就跳到结果页
                if (data.answered == 1) {
                    jumpToQn(qnType, data.answered, data.qnId, deliveryId);
                }
            }else if(where === 'result'&&qnType==2){
            		//加载当前投放的广告信息
            		loadDeliveryAd();
            		//加载底部操作栏
            		loadAssessFoot();
            		 //加载当前投放评论信息
            		loadCommentList();
            } else if (where === 'result') {
                // 结果页行为：调查、投票、测评都要做的公共部分
                loadResultMsg();
                loadVSDonateShow();
                loadRecommend(data.relatedList);
                loadFootBar();
                loadDeliveryAd();
                loadCommentList();
            }
            successCallback(data);
        }
    });
}

//======================================================
//                       result页相关
//======================================================







/**
 * 答题结果提示语
 */
function loadResultMsg() {
    var resultMsg = localStorage.getItem('resultMsg');
    var resultMsgElem = document.getElementById('resultMsg');
    if (!isStrValid(resultMsg)) {
        resultMsgElem.innerHTML = "答案已提交，感谢参与！";
    } else {
        resultMsgElem.innerHTML = resultMsg;
    }
}

/**
 * 调查，投票打赏区域
 */
function loadVSDonateShow() {
    var donateShowElem = document.getElementById('donate-show');
    var donatePerson = localStorage.getItem('donatePerson');
    var donateScore = localStorage.getItem('donateScore');
    // var html = "有" + donatePerson +"人打赏了" + donateScore + "粮票";
    var html = "已有" + donatePerson + "人打赏了";
    donateShowElem.getElementsByTagName('p')[0].innerHTML = html;
}

/**
 * 测评打赏区域
 */
function loadAssessDonateShow() {
    var donateShowElem = document.getElementById('operation-data-num');
    var donatePerson = localStorage.getItem('donatePerson');
    var donateScore = localStorage.getItem('donateScore');
    donateShowElem.innerHTML = donatePerson;
}

/**
 * 加载精彩推荐
 * 输入：
 *     relatedList: getDeliveryInfo中，ajax返回的精彩推荐列表
 */
function loadRecommend(relatedList) {
    if (relatedList.length > 0) {
        // 模板
        var templateTitle = [
            "<h5>精彩推荐</h5>",
            "<ul id=\"recommend-list\"></ul>"
        ].join("");
        var templateRelated = [
            "<li>",
            "   <a data-href=\"{{relatedUrl}}\">{{relatedStr}}</a>",
            "</li>"
        ].join("");

        // 渲染精彩推荐的标题
        var recommend = document.getElementById("recommend");
        recommend.innerHTML = templateTitle;

        // 渲染精彩推荐的每一个条目
        var list = document.getElementById("recommend-list");
        var fragment = '';
        for (var i = 0, length = relatedList.length; i < length; i++) {
            fragment += Mustache.render(templateRelated, relatedList[i]);
        }
        list.innerHTML = fragment;

        // 监听点击事件
        var qnType = localStorage.getItem('qnType');
        var qnId = localStorage.getItem('qnId');
        var deliveryId = localStorage.getItem('deliveryId');
        list.addEventListener('tap', function(e) {
            var target = e.target;
            if (target.tagName.toLowerCase() == 'a') {
                addLog({
                    logType: 'qnAction',
                    action: 'clickRelatedContent',
                    deliveryId: deliveryId,
                    qnId: qnId,
                    qnType: qnType,
                    actResult: 'success'
                });
                jumpToUrl(target.getAttribute('data-href'));
            }
        });
    }
}

/**
 * 加载底部操作栏
 */
function loadFootBar() {
    var isReport = localStorage.getItem('isReport');

    // 点赞
    if (document.getElementById('footThumbNumUp')) {
        var footThumbNumUp = document.getElementById('footThumbNumUp');
        var footThumbUp = document.getElementById('footThumbUp');
        // 初始化点赞数
        footThumbNumUp.innerHTML = localStorage.getItem('thumbUp');
        // 监控按键点击
        footThumbUp.addEventListener('tap', function() {
            if (isReport == '1') {
                reportThumbsUp('Up');
            } else {
                thumbsChange('Up');
            }
        });
    }

    // 踩
    if (document.getElementById('footThumbNumDown')) {
        var footThumbNumDown = document.getElementById('footThumbNumDown');
        var footThumbDown = document.getElementById('footThumbDown');
        // 初始化踩数
        footThumbNumDown.innerHTML = localStorage.getItem('thumbDown');
        // 监控按键点击
        footThumbDown.addEventListener('tap', function() {
            if (isReport == '1') {
                reportThumbsUp('Down');
            } else {
                thumbsChange('Down');
            }
        });
    }

    // 收藏
    if (document.getElementById('footFavorite')) {
        // 初始化收藏状态
        var favoriteElem = document.getElementById('footFavorite');
        var isFavorite = localStorage.getItem('isFavorite');
        if (isFavorite == '1') {
            favoriteElem.classList.add('active');
        } else if (isFavorite == '0') {
            favoriteElem.classList.remove('active');
        }
        // 监控按键点击
        favoriteElem.addEventListener('tap', function(e) {
            var isFavorite = localStorage.getItem('isFavorite');
            if (isFavorite == '0') {
                // 还未被收藏过，则点击按钮应该添加收藏
                addFavoriteReport(this);
            } else {
                // 已经被收藏过，则点击按钮应该删除收藏
                deleteReportFavorite(this); 
            }
        });
    }

    // 返回
    if (document.getElementById('backBtn')) {
        document.getElementById('backBtn').addEventListener('tap', function() {
            var fromPos = localStorage.getItem('fromPos');
            if(fromPos==null){
            		fromPos='index.html';
            }
            jumpToUrl(fromPos);
        });
    }

    // 评论
    if (document.getElementById('writeComment')) {
        var writeComment = document.getElementById('writeComment');
        writeComment.addEventListener('tap', function() {
            if (isReport == '1') {
                jumpTo('report_comment');
            } else {
                jumpTo('comment');
            }
        });
    }
}
/**
 * 
 * @param {Object} isTemporary：表示用户是否为临时用户
 */
function loadAssessFoot(isTemporary){
	var isReport = localStorage.getItem('isReport');
	// 判断是否是报告页面评论
    var commentObjId, commentObjType;
    if (localStorage.getItem('isReport') == '1') {
        commentObjId = localStorage.getItem('reportId');
        commentObjType = '4';
    } else {
        commentObjId = localStorage.getItem('deliveryId');
        commentObjType = localStorage.getItem('qnType');
    }
	//评论数
    mui.ajax(baseUrl+'/wanx/getCommentList', {
        data: {
            commentObjId: commentObjId,
            commentObjType: commentObjType
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
        		// 加载底部操作栏的评论数
        		if(data.errorCode == "001"){
        			//进入这里表示无评论
        			//localStorage.setItem('assessCommentNum',0);
				document.getElementById('footer-commentnum').innerText=0;
        		}else{
        			//进入这里表示有评论
        			//localStorage.setItem('assessCommentNum',data.commentNum);
				document.getElementById('footer-commentnum').innerText=data.commentNum;
        		}
        		
        }
     });
	
    // 返回
	if (document.getElementById('backBtn')) {
			document.getElementById('backBtn').addEventListener('tap', function() {
			var fromPos = localStorage.getItem('fromPos');
			if(fromPos==null){
			    fromPos='index.html';
			}
			    jumpToUrl(fromPos);
			});
	}
			
	// 评论
	if (document.getElementById('writeComment')) {
			var writeComment = document.getElementById('writeComment');
			writeComment.addEventListener('tap', function() {
				if (isReport == '1') {
				    		jumpTo('report_comment');
				} else {
				       	jumpTo('comment');
				}
			});
	}
	//返回首页
	if(document.getElementById('assess-tohome')){
		//点击首页返回首页
		document.getElementById('assess-tohome').addEventListener('tap',function(){
			   jumpTo('index');
		});
	}
}


/**
 *  画出调查结果、投票结果中的选项分布图
 *  
 *  适用于如下HTML
 *   (1)vote_result.html
 *   (2)survey_result.html
 *
 * 输入：
 *   elem：用于展示绘图区域的div
 *   data：Ajax读到的数据
 */
function drawResult(elem, data) {
    var resultTemplate = [
        '<div class=\"graph-area\">',
        '  {{#optionData}}',
        '     <div class=\"mui-card\">',
        '        <div class=\"graph graph-gray\">',
        '           <div class=\"subrect trans\"></div>',
        '           <div class=\"graph-text\">',
        '               <p class=\"graph-text-des mui-ellipsis-2\">{{des}}</p>',
        '               <p class=\"graph-text-percent\">{{optionPercent}}%</p>',
        '           </div>',
        '        </div>',
        '     </div>',
        '  {{/optionData}}',
        '</div>',
        '<p class=\"graph-parti\">',
        '   共<span id=\"num\">{{participant}}</span>人参与',
        '</p>'
    ].join('');

    data.optionData = data.voteOptionData || data.optionData || data.surveyKeyQuestionOptionData;
    for (var i = 0, length = data.optionData.length; i < length; i++) {
        data.optionData[i].des = data.optionDes[i];
        data.optionData[i].optionPercent = parseInt(data.optionData[i].optionPercent * 100);
    }
    var fragment = Mustache.render(resultTemplate, data);
    elem.innerHTML = fragment;

    // 加载用户的答案，为用户选择的矩形条赋予类graph-user
    var userAnswer = (data.userAnswer || "").toLowerCase();
    var aCharCode = 'a'.charCodeAt();
    var graph = elem.getElementsByClassName('graph');
    for (var i = 0, length = userAnswer.length; i < length; i++) {
        var userAnswerIndex = userAnswer.charCodeAt(i) - aCharCode;
        graph[userAnswerIndex].classList.remove('graph-gray');
        graph[userAnswerIndex].classList.add('graph-green');
    }

    setTimeout(function() {
        var trans = elem.querySelectorAll('.trans')
        for (var i = 0, length = trans.length; i < length; i++) {
            trans[i].style.width = data.optionData[i].optionPercent + '%'
        }
    }, 500)
}

//======================================================
//                       获奖相关
//======================================================

/**
 * 更新奖励领取状态
 *
 * 输入：
 *     awardGetStatus: 奖品领取状态：1未领取；2已领取；3放弃
 *     awardPayStatus: 奖品发放：1未发放；2已发放
 */
function updateAwardGetStatus(awardGetStatus, awardPayStatus) {
    mui.ajax(baseUrl+'/wanx/updateAwardGetStatus', {
        data: {
            userId: 1,
            qnId: localStorage.getItem('qnId'),
            qnType: localStorage.getItem('qnType'),
            awardGetStatus: awardGetStatus,
            awardPayStatus: awardPayStatus
        },
        dataType: 'json',
        type: 'post',
        timeout: 10000,
        success: function(data) {
            console.log('更新奖励领取状态：awardGetStatus=' + awardGetStatus + '  awardPayStatus=' + awardPayStatus);
        },
        error: function() {
            mui.toast('网络错误...');
        }
    });
}

/**
 * 添加获奖统计
 */
function addAwardStatistics() {
    var award = JSON.parse(localStorage.getItem('award'));
    var redeemCodeInfo = JSON.parse(localStorage.getItem('redeemCodeInfo')) || {redeemCodeId:'0'};

    mui.ajax(baseUrl+'/wanx/addAwardStatistics', {
        data: {
            userId: 1,
            awardId: award.awardId,
            awardMethod: award.awardMethod,
            awardCause: 1,
            deliveryId: localStorage.getItem('deliveryId'),
            qnType: localStorage.getItem('qnType'),
            lotteryRank: 0,
            redeemCodeId: redeemCodeInfo.redeemCodeId
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

/*
 * 调查问卷领取奖励函数。
 *
 * 对于固定奖励：在checkAwardGetStatus()中查询，如果未领取则调用getAward()领奖
 * 对于抽奖：在lottery.js中，点击抽奖轮盘指针后，如果中奖且未领取，调用getAward()领奖
 */
function getAward() {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);

    switch (parseInt(award.awardType)) {
        case 1:
            // 实物奖励: 跳转到邮寄信息页
            if (award.awardMethod == 1) {
                var sourcePage = 'survey_result';
            } else if (award.awardMethod == 2 || award.awardMethod == 3) {
                var sourcePage = 'lottery';
            }
            addLog({
                logType: 'awardPageSkip',
                sourcePage: sourcePage,
                targetPage: 'postal_info',
                deliveryId: localStorage.getItem('deliveryId'),
                qnId: localStorage.getItem('qnId'),
                qnType: localStorage.getItem('qnType')
            });
            jumpTo('postal_info');
            break;
        case 2:
            // 外链url: 跳转到外链url，状态：2已领取  2已发放
            updateAwardGetStatus(2, 2);
            addAwardStatistics();
            jumpToUrl(award.awardLink);
            break;
        case 3:
            // 玩校积分: 添加粮票积分，状态：2已领取  2已发放
            addWanxScore(award.awardNum, function() {
                mui.toast('领取成功...');
                updateAwardGetStatus(2, 2);
                addAwardStatistics();
            })
            break;
        case 4:
            // 兑换码: 输入手机号，弹出悬浮窗，状态：2已领取  2已发放
            mui.prompt('', '', '输入手机号领取奖品', ['取消', '确定'], function(e) {
                if (e.index == 1) {
                    var phoneNum = e.value;
                    // 验证手机号
                    if (phoneNum.trim() == '' || !checkIsPhone(phoneNum)) {
                        mui.toast('请输入正确手机号码...');
                        return false;
                    }
                    // 发放兑换码
                    giveRedeemCode(award.awardId, phoneNum, function() {
                        showRedeemWindow();
                        updateAwardGetStatus(2, 2);
                        addAwardStatistics();
                    })
                }
            });
            break;
        default:
            mui.toast("网络错误...");
            break;
    }
}

/**
 * 添加粮票积分
 * 输入：
 *     wanxScoreNum：添加的积分数
 *     successCallback：添加成功的回调函数
 */
function addWanxScore(wanxScoreNum, successCallback) {
    mui.ajax(baseUrl+'/wanx/addWanxScore', {
        data: {
            userId: 1,
            score: wanxScoreNum
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                successCallback();
            } else {
                mui.toast('领取失败了...');
            }
        },
        error: function() {
            mui.toast('网络错误...');
        }
    });
}

/**
 * 发放兑换券
 */
function giveRedeemCode(awardId, phoneNum, successCallback) {
    mui.ajax(baseUrl+'/wanx/giveRedeemCode', {
        data: {
            awardId: awardId,
            phoneNum: phoneNum
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                localStorage.setItem('redeemCodeInfo', JSON.stringify(data.redeemCodeInfo));
                successCallback();
            } else {
                if (data.errCode == '001') {
                    mui.toast('抱歉来晚了，兑换码已经发完了...');
                } else {
                    mui.toast('领取失败了...');
                }
            }
        },
        error: function() {
            mui.toast('网络错误...');
        }
    });
}

/**
 * 显示兑换码悬浮窗
 */
function showRedeemWindow() {
    var template = [
        '<div class="mui-popup-backdrop mui-active">',
        '    <div class="mui-popup mui-popup-in redeemCode">',
        '        <div class="mui-popup-inner">',
        '            <h4>欢迎您领取奖品</h4>',
        '            <p>奖品：{{awardName}}</p>',
        '            <p>兑换码：{{redeemCode}}</p>',
        '            <p>兑换规则：</p>',
        '            <ul>',
        '                <li>1.已填写手机号领取奖励的用户，请在苹果应用商店和各大安卓市场下载“口粮”客户端</li>',
        '                <li>2.用填写的手机号码在“口粮”客户端内进行注册，完成注册后在帐户内查询兑换券</li>',
        '                <li>3.流量兑换券将在您填写手机号后24小时之内发放到您的“口粮”账户</li>',
        '                <li>4.本次活动客户服务由“口粮”提供</li>',
        '            </ul>',
        '            <p style="text-align: center;">本次活动奖励由“口粮”提供</p>',
        '            <img src="images/kouliang.png">',
        '            <i class="icon-remove-circle" onclick="hideRedeemCodeWindow();"></i>',
        '        </div>',
        '    </div>',
        '</div>'
    ].join('');
    
    var redeemCodeInfo = JSON.parse(localStorage.getItem('redeemCodeInfo'));
    var fragment = Mustache.render(template, redeemCodeInfo);
    var div = document.createElement('div');
    div.id = 'redeemCode';
    div.innerHTML = fragment;
    document.body.appendChild(div);
}

/**
 * 隐藏兑换码悬浮窗
 */
function hideRedeemCodeWindow() {
    var redeemCode = document.getElementById('redeemCode');
    if (redeemCode) {
        redeemCode.parentNode.removeChild(redeemCode);
    }
}

//======================================================
//                       我的XX页面
//======================================================

/**
 * 初始化头部
 */
function initialPersonPreview() {
    var myValue = document.getElementById('my-value');
    var myType = myValue.getAttribute('data-myType');
    myValue.innerHTML = localStorage.getItem(myType);
}

/**
 * 查看报告按钮的点击函数
 */
function handleReadReportClick(e) {
    var reportId = e.target.getAttribute('data-reportId');
    var sourcePage = e.target.getAttribute('data-source');
    jumpToReport(reportId, sourcePage);
    
    // 阻止事件冒泡，防止父标签的跳转
    e.stopPropagation();
}

/**
 * 根据状态（问卷投放状态、报告状态）和报告url，判断是否有效
 *
 * 输入：
 *     status: 问卷投放状态或报告状态。只有状态为2，才有效
 *     reportUrl：报告url。
 * 返回：
 *     是否有效。boolean型
 * 备注：
 *     问卷：输入参数为1个（投放状态）
 *     报告：输入参数为2个（报告状态、报告url)
 */
function getVisibleByStatus(status, reportUrl) {
    if (arguments.length == 1) {
        if (parseInt(status) == 2) {
            return 1;
        } else {
            return 0;
        }
    } else if (arguments.length == 2) {
        if (parseInt(status) == 2 && isStrValid(reportUrl)) {
            return 1;
        } else {
            return 0;
        }
    }
}

/**
 * 更新我收藏的报告数
 * 
 * 输入：
 *    type：
 *        add：收藏报告数+1
 *        del：收藏报告数-1
 */
function updateMyFavoriteReportNum(type) {
    var myFavoriteReportNum = parseInt(localStorage.getItem('myFavoriteReport'));
    myFavoriteReportNum = (myFavoriteReportNum ? myFavoriteReportNum : 0);
    if (type == 'add') {
        localStorage.setItem('myFavoriteReport', myFavoriteReportNum + 1);
    } else if (type == 'del') {
        localStorage.setItem('myFavoriteReport', myFavoriteReportNum - 1);
    }
}

//======================================================
//                list页面：渲染列表
//======================================================

/* 加载问卷的List。包括：qn-list页、首页侧滑tab
 * 
 * 输入：
 *     obj: 包含有listType、listCategory、listId等配置的对象
 *     successCallback：ajax请求成功的回调函数
 */
function loadQnList(obj, successCallback) {
    var ajaxSettings = {
        interface: "",
        data:{
            userId: 1,
            page: ++obj.currentPage
        }
    }

    switch (obj.listType) {
        case 1:
            ajaxSettings.interface = '/wanx/daily3UpdateList';
            ajaxSettings.data.qnListCategory = obj.listCategory;
            break;
        case 2:
            ajaxSettings.interface = '/wanx/superList';
            ajaxSettings.data.superListCategory = obj.listCategory;
            break;
        case 3:
            ajaxSettings.interface = '/wanx/assessList';
            ajaxSettings.data.assessListCategory = obj.listCategory;
            break;
        case 4:
            ajaxSettings.interface = '/wanx/activityList';
            ajaxSettings.data.activityType = obj.listCategory;
            break;
        default:
            break;
    }

    var qnTemplate = [
        "<li class=\"mui-table-view-cell mui-media\">",
        "   <a data-itemtype=\"{{itemType}}\" data-source=\"" + obj.listCategory + "\" data-answered=\"{{answered}}\" data-qntype=\"{{qnType}}\" data-deliveryid=\"{{deliveryId}}\" data-qnid=\"{{qnId}}\" data-listtype=\"" + obj.listType + "\">",
        "      <div class=\"card-intro\">",
        "         <img class=\"mui-media-object mui-pull-left card-img\" src=\"{{img}}\">",
        "         <div class=\"mui-media-body\">",
        "            <h4 class=\"mui-ellipsis-2 card-title\"><span class=\"card-tag card-head-tag card-tag-yellow\">{{headTag}}</span>{{showTitle}}</h4>",
        "            {{#timeShow}}",
        "               <p class=\"card-detail card-time\">{{bTime}}</p>",
        "            {{/timeShow}}",
        "            <p class=\"card-detail card-publisher\">{{publisher}}</p>",
        "            <p class=\"card-detail card-collect\">{{collectedNum}}</p>",
        "            <p class=\"card-detail card-award\">{{winnerNum}}</p>",
        "         </div>",
        "      </div>",
        "      <div class=\"mui-media-body card-tags\">",
        "         {{#tags}}",
        "            <span class=\"card-tag card-foot-tag card-tag-gray\">{{.}}</span>",
        "         {{/tags}}",
        "      </div>",
        "      <p class=\"mui-ellipsis-2 card-summary\">{{showDes}}</p>",
        "   </a>",
        "</li>"
    ].join("");

    var reportTemplate = [
        "<li class=\"mui-table-view-cell mui-media\">",
        "   <a id=\"report-{{reportId}}\" class=\"card-intro\" data-itemtype=\"{{itemType}}\" data-source=\"" + obj.listCategory + "\" data-reportId=\"{{reportId}}\" data-reportUrl=\"{{reportUrl}}\" data-thumbUp=\"{{thumbUp}}\" data-reportTitle=\"{{reportTitle}}\" data-isFavorite=\"{{isFavorite}}\">",
        "      <img class=\"mui-media-object mui-pull-left card-img\" src=\"{{reportImg}}\">",
        "      <div class=\"mui-media-body\">",
        "         <h4 class=\"mui-ellipsis-2 card-title\"><span class=\"card-tag card-head-tag card-tag-green\">报告</span>{{reportTitle}}</h4>",
        "         <p class=\"card-detail card-time2\">{{pTime}}</p>",
        "         <p class=\"card-detail card-publisher2\">{{publisher}}</p>",
        "      </div>",
        "   </a>",
        "</li>"
    ].join("");

    var tweetTemplate = [
        "<li class=\"mui-table-view-cell mui-media\">",
        "   <a href=\"{{tweetUrl}}\" class=\"card-intro\" data-itemtype=\"{{itemType}}\">",
        "      <img class=\"mui-media-object mui-pull-left card-img\" src=\"{{picUrl}}\">",
        "      <div class=\"mui-media-body\">",
        "         <h4 class=\"mui-ellipsis-2 card-title\"><span class=\"card-tag card-head-tag card-tag-green\">文章</span>{{tweetTitle}}</h4>",
        "         <p class=\"card-detail card-time2\">{{pTime}}</p>",
        "         <p class=\"card-detail card-publisher2\">{{author}}</p>",
        "      </div>",
        "   </a>",
        "</li>"
    ].join("");

    mui.ajax(baseUrl+ajaxSettings.interface, {
        data: ajaxSettings.data,
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            
            // 上拉刷新部分
            initialPullRefresh.call(obj, data.totalPage, obj.loadFunction);

            // 如果列表为空
            var record = data.record || data.records;
            handleListEmpty(record, obj.listId + '-empty');

            // 显示每个条目
            var list = document.getElementById(obj.listId);
            var fragment = '';
            for (var i = 0, length = record.length; i < length; i++) {
                record[i].itemType = record[i].itemType || 'qn';
                switch (record[i].itemType) {
                    case 'qn':
                        record[i].qnType = record[i].qnType || 2;
                        record[i].qnId = record[i].qnId || record[i].aqnId;
                        record[i].qnClassName = record[i].qnClassName || record[i].aqnClassName;
                        record[i].timeShow = !record[i].bTime && !record[i].eTime ? false : true;
                        record[i].bTime = record[i].bTime ? record[i].bTime.split(' ')[0] : '';
                        record[i].eTime = record[i].eTime ? record[i].eTime.split(' ')[0] : '';
                        record[i].collectNum = record[i].collectNum - record[i].collectedNum;
                        
                        if (obj.headTagType === 'titleTag') {
                            record[i].headTag = record[i].titleTag || '标题标签';
                        } else if (obj.headTagType === 'qnClassName') {
                            record[i].headTag = record[i].qnClassName || '问卷类别';
                        }
                        if(record[i].collectedNum<100){
                        	record[i].collectedNum+=Math.round(Math.random()*500+500);
                        }else if(record[i].collectedNum>100&&record[i].collectedNum<1000){
                        	record[i].collectedNum=record[i].collectedNum*5
                        }
                        
                        fragment += Mustache.render(qnTemplate, record[i]);
                        break;
                    case 'report':
                        record[i].pTime = record[i].pTime ? record[i].pTime.split(' ')[0] : '';
                        fragment += Mustache.render(reportTemplate, record[i]);
                        break;
                    case 'tweet':
                        fragment += Mustache.render(tweetTemplate, record[i]);
                        break;
                    default:
                        break;
                }
            }
            list.innerHTML += fragment;

            // 监听列表点击
            initialQnListListener(obj.listId);

            if (typeof successCallback === 'function') {
                successCallback();
            }
        }.bind(obj)
    });
}

//======================================================
//                list页面：列表为空
//======================================================

/**
 * 当列表为空时的处理函数。包括：首页列表、每个十宫格的列表、我的XX页的列表
 *
 * 输入：
 *     record：ajax获取的数组
 *     qnEmptyElemId：DOM元素的id
 */
function handleListEmpty(record, qnEmptyElemId) {
    if (record.length == 0) {
        var qnEmptyElem = document.getElementById(qnEmptyElemId);
        qnEmptyElem.style.display = 'block';

        // 如果需要显示用户，则显示用户名
        if (qnEmptyElem.getElementsByTagName('h3').length > 0) {
            var wanxNickNameElem = qnEmptyElem.getElementsByTagName('h3')[0];
            // 如果本地存储里有，则直接显示；如果没有，则调取接口获取用户名
            if (localStorage.getItem('wanxNickName')) {
                wanxNickNameElem.innerHTML = localStorage.getItem('wanxNickName') + "同学";
            } else {
                mui.ajax(baseUrl+'/wanx/myCognitionIndex', {
                    data: {
                        userId: 1
                    },
                    dataType: 'json',
                    type: 'get',
                    timeout: 10000,
                    success: function(data) {
                        wanxNickNameElem.innerHTML = data.wanxNickName + "同学";
                    }
                })
            }
        }
    }
}

//======================================================
//                list页面：条目跳转相关
//======================================================

/**
 * 三更列表、qn_list：每个条目的跳转函数
 *
 * 输入：
 *     listId：DOM元素的id
 */
function initialQnListListener(listId) {
    document.getElementById(listId).addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.tagName.toLowerCase() == 'a') {
                break;
            }
            target = target.parentNode;
        }

        var itemType = target.getAttribute('data-itemtype');
        switch (itemType) {
            case 'qn':
                // 提取属性
                var qnType = target.getAttribute('data-qntype');
                var deliveryId = target.getAttribute('data-deliveryId');
                var qnId = target.getAttribute('data-qnid');
                var listType = target.getAttribute('data-listtype');
                var answered = target.getAttribute('data-answered');
                var sourcePage = target.getAttribute('data-source');

                // 列表点击统计
                qnClickStatistics(qnType, deliveryId, listType);
                
                // 跳转页面
                localStorage.setItem("listType","list")
                jumpToQn(qnType, answered, qnId, deliveryId, sourcePage);
                break;
            case 'report':
                var reportId = target.getAttribute('data-reportid');
                var sourcePage = target.getAttribute('data-source');
                jumpToReport(reportId, sourcePage); 
                break;
            case 'tweet':

                break;
            default:
                break;
        }
        
    });
}

/**
 * 我的xx页：每个条目的跳转函数
 *
 * 输入：
 *     listId：DOM元素的id
 */
function initialMyListListener(listId) {
    document.getElementById(listId).addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.className.indexOf('qn-report') > -1) {
                return;
            }
            if (target.tagName.toLowerCase() == 'a') {
                break;
            }
            target = target.parentNode;
        }

        // 如果问卷关闭
        var qnVisible = target.getAttribute('data-qnvisible');
        if (parseInt(qnVisible) == 0) {
            mui.toast('该问卷已经关闭了...');
            return;
        }

        // 提取属性
        var qnType = target.getAttribute('data-qntype');
        var deliveryId = target.getAttribute('data-deliveryId');
        var qnId = target.getAttribute('data-qnid');
        var sourcePage = target.getAttribute('data-source');
        
        // 跳转页面
        jumpToQn(qnType, 1, qnId, deliveryId, sourcePage);
    });
}

//======================================================
//                Ajax 相关
//======================================================
/*
 * Ajax请求成功后，判断返回数据data的success状态
 * 通常，success可能为字符串型的'ture'，也可能为Boolean型的true。
 * 本函数旨在屏蔽这种差异。
 * 
 * 返回：Boolean型
 */
function isDataSuccess(data) {
    if (data.success === true || data.success === 'true' || data.success === 'success') {
        return true;
    } else if (data.success === false || data.success === 'false') {
        return false;
    }
}

/*
 * Ajax请求成功后，返回的字段如果为字符串，需判断该字符串是否有效
 * 通常，字符串若无效，则可能为空字符串''，也可能为null，也可能为字符串型的'null'
 * 本函数旨在屏蔽这种差异。
 * 
 * 返回：Boolean型
 */
function isStrValid(str) {
    if (typeof str != 'string') {
        return false;
    }
    if (str.trim() === '' || str.trim() === 'null') {
        return false;
    } else {
        return true;
    }
}

//======================================================
//                结果页：首页、查看报告、打赏相关、分享相关
//======================================================

function initialResultButtonListener(qnType) {
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();

    // 监听首页按钮
    document.getElementById('jump-to-index').addEventListener('tap', function() {
        addLog({
            logType: 'qnPageSkip',
            sourcePage: 'survey_result',
            targetPage: 'index',
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType
        });
        jumpTo('index');
    });

    // 监听看报告按钮
    document.getElementById('jump-to-report').addEventListener('tap', function() {
        addLog({
            logType: 'qnPageSkip',
            sourcePage: 'survey_result',
            targetPage: 'report_list',
            deliveryId: deliveryId,
            qnId: qnId,
            qnType: qnType
        });
        jumpTo('report_list');
    });

    // 监听打赏
    document.getElementById('donate-show').addEventListener('tap', function() {
        document.getElementById('donate').style.display = 'block';
    });
    document.getElementById('donate-hide').addEventListener('tap', function() {
        document.getElementById('donate').style.display = 'none';
    });
    document.getElementById('donate-panel').addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.classList.contains('donate-box')) {
                break;
            }
            target = target.parentNode;
        }

        var score = target.getAttribute('data-score');
        donateWanxScore(score, qnType);
    });
}


function AssessResultButtonListener(qnType) {
    var qnId = getIdFromQueryString();
    var deliveryId = getDeliveryIdFromQueryString();
    // 监听打赏
    document.getElementById('donate-show').addEventListener('tap', function() {
        //判断是否是临时用户
        if(localStorage.getItem('isTemporary')!='true'){
        		//进入这里表示不是临时用户，允许打赏
        		document.getElementById('donate').style.display = 'block';
        }
    });
    document.getElementById('donate-hide').addEventListener('tap', function() {
        document.getElementById('donate').style.display = 'none';
    });
    document.getElementById('donate-panel').addEventListener('tap', function(e) {
        // 找到目标节点
        var target = e.target;
        while (target !== this ) {
            if (target.classList.contains('donate-box')) {
                break;
            }
            target = target.parentNode;
        }

        var score = target.getAttribute('data-score');
        donateWanxScore(score, qnType);
    });
}

/*
 * 打赏玩校积分
 *
 * 输入：
 *     wanxScoreNum：要打赏的积分数
 */
function donateWanxScore(wanxScoreNum, qnType) {
    wanxScoreNum = parseInt(wanxScoreNum);
    var deliveryId = getDeliveryIdFromQueryString();
    var qnId = getIdFromQueryString();

    mui.ajax(baseUrl+'/wanx/donateWanxScore', {
        data: {
            score: -wanxScoreNum,
            deliveryId: deliveryId,
            qnType: qnType
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                mui.toast('打赏' + wanxScoreNum + '粮票成功！');
                document.getElementById('donate').style.display = 'none';
                
                // 如果当前用户第一次打赏，则更新打赏总人数
                if (data.isFirstdonate === 0) {
                    var donatePerson = parseInt(localStorage.getItem('donatePerson'));
                    var donateScore = parseInt(localStorage.getItem('donateScore'));
                    localStorage.setItem('donatePerson', donatePerson + 1);
                    localStorage.setItem('donateScore', donateScore + wanxScoreNum);
                    //因为测评和调查与投票的显示位置不一样，所以要要调用不同的方法
                    if(qnType==2){
                    		//进入这里表示是评测
                    		loadAssessDonateShow();
                    }else{
                    		//进入这里表示调查和投票
                    		loadVSDonateShow();
                    }
                }

                // 打赏统计
                addLog({
                    logType: 'qnAction',
                    action: 'donateWanxScore',
                    deliveryId: deliveryId,
                    qnId: qnId,
                    qnType: qnType,
                    actResult: wanxScoreNum
                });
            } else {
                if (data.errCode === '003') {
                    mui.toast('余额已不足' + wanxScoreNum + '粮票...');
                } else {
                    mui.toast('网络错误...');
                }
            }
        },
        error: function() {
            mui.toast('网络错误...');
        }
    });
}


//======================================================
//              			回复相关
//======================================================

/**
 * 回复用户
 * 
 */
function replyUser(event){
		var nickName=event.getAttribute('data-nickName')
		var content=event.getAttribute('data-content')
		//将data-nikename保存到本地
		localStorage.setItem('data_nikename',nickName);
		//将data-content保存到本地
		localStorage.setItem('data_content',content);
		//跳转到回复界面
		jumpTo('reply');
}