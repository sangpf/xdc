/***********************************************************************
 *
 * v1.1.8
 * 2016-07-07 增加 显示和隐藏 menu
 * 2016-06-30 增加 setMenu1 方法
 *
 * v1.1.7
 * 2016-05-21 openCamera方法，参数增加字段 action：0（默认，弹窗选择），1直接打开系统相册，2直接打开拍照
 * 2016-05-21 增加selectImage1方法,比selectImage方法增加裁剪功能
 *
 * v1.1.6
 * 2016-04-25 增加scheme回调
 * 2016-04-28 修改shareTo方法接口，增加分享到同学圈（link card）
 *
 * v1.1.5
 * 2016-03-23 增加打开图片浏览
 * 2016-03-23 增加获取网络状态
 * 2016-03-23 增加选择图片（每次只能选择一张图片）
 * 2016-03-23 增加设置title
 *
 * v1.1.4
 * 2015-12-31 分享js增加分享标题title
 *
 * v1.1.3
 * 2015-12-11 增加setMenu方法
 * 2015-12-14 增加scanBarcode方法
 * 2015-12-29 增加shake摇一摇方法
 *
 * v1.1.2
 * 2015-11-02 分享方法增加点击跳转url参数
 *
 * v1.1.1
 * 2015-08-22 增加Wanxiao.readycallback
 *
 * v1.1
 * 2015-07-31 创建
 *
 * V1.0
 * 2015-07-22 增加获取用户头像 李润冬
 * 2015-07-29 将get_jsname，add_js_name方法，放外边
 ***********************************************************************/

function Wanxiao() {
    // // 获得随机名字
    // function get_jsname() {
    // d = new Date();
    // return "wanxiao_" + d.getTime();
    // }
    // ;
    // // json参数中加上方法名参数
    // function add_js_name(jsonString, jsname) {
    // var obj = JSON.parse(jsonString);
    // obj.wx_jsname = jsname;
    // return JSON.stringify(obj);
    // }
    // ;
}

// 获得随机名字
Wanxiao.prototype.get_jsname = function () {
    var d = new Date();
    return "wanxiao_" + d.getTime();
};

// json参数中加上方法名参数
Wanxiao.prototype.add_js_name = function (jsonString, jsname) {
    var obj = JSON.parse(jsonString);
    obj.wx_jsname = jsname;
    return JSON.stringify(obj);
};

/**
 * 测试IOS异步动态绑定js回调方法
 */
Wanxiao.prototype.test = function (jsondata, callback) {
    if (!isIphone()) {
        window.wanxiao_camera.executeBindMethod("getCameraPhoto", jsondata);
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('iosAppMethod', jsonString, function (response) {
                               });
        }
    }
};

Wanxiao.prototype.ready = function (callback) {
    this.readycallback = callback;
    if (!isIphone()) {
        callback();
    }
}

/**
 * 获得用户token
 * </p>
 * 第三方调用时，通过回调方式获得结果，如下：<br>
 * var result = wanxiao.getToken(function(response){ alert("获得结果: " + response);
 * });
 */
Wanxiao.prototype.getToken = function (callback) {
    if (!isIphone()) {
        callback(window.wanxiao_authen.executeBindMethod("getToken", null));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('getToken', jsonString, callback);
        }
    }
};

/**
 * 获得用户信息
 */
Wanxiao.prototype.getUserJsonValue = function (callback) {
    if (!isIphone()) {
        callback(window.wanxiao_authen.executeBindMethod("getUserJsonValue",
                                                         null));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('getUserJsonValue', jsonString, callback);
        }
    }
};

/**
 * 发起推送 jsondata {token:用户token, flag:插件标记, sign:除sign本身的全部传入参数的签名
 * toUserId:接收人id appcode:应用编号 versionname:版本名称 versioncode:版本代码
 * param:插件参数(json格式) title:通知标题 message:通知内容} *具体可参考接口0087:插件推送通知
 */
Wanxiao.prototype.sendRemoteNotification = function (jsondata, callback) {
    if (!isIphone()) {
        callback(window.wanxiao_push.executeBindMethod(
                                                       "sendRemoteNotification", jsondata));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('sendRemoteNotification', jsonString, callback);
        }
    }
}

/**
 * 打开相机
 * </p>
 * isCrop 是否裁剪: 0、不剪切, 1、剪切 ratio 缩放的高宽比例值，浮点类型(仅支持小数点内2位)；如：2 = 高2，宽1
 *
 * @param jsondata =
 *            {"isCrop":"0、不剪切, 1、剪切",
 *             "ratio":"缩放的高宽比例值，浮点类型；如：2 = 高2，宽1",
 *             "action":"动作：0（默认，弹窗选择），1直接打开系统相册，2直接打开拍照" }
 */
Wanxiao.prototype.openCamera = function (jsondata) {
    if (!isIphone()) {
        window.wanxiao_camera.executeBindMethod("getCameraPhoto", jsondata);
    } else {
        if (window.bridge) {
            bridge.registerHandler("cameraPhotoCallBack",
                                   this.cameraPhotoCallBack);
            bridge.callHandler('openCamera', jsondata, function (response) {
                               });
        }
    }
};

// APP回调该方法，并传入图片字节字符串的base64编码数据
// 该方法由第三方调用者覆盖。
Wanxiao.prototype.cameraPhotoCallBack = function (photoBase64Str) {
    
};


/**
 * 分享到...
 *
 * @param type
 *            分享类型：0 同学圈，1 微信， 2 微信朋友圈，3新浪微博，4 QQ，5 QQ空间
 * @param text
 *            分享的文本
 * @imagesJson 分享的照片URL数据，json格式，[{"url":"http://..."}, {"url":"http://..."}]
 *
 * @url 点击跳转url 包括LinkCardUrl
 * @title 分享的标题
 * @bbscontent linkCard分享默认传递帖子内容
 * @shareTo 分享范围：0:公开；-1：仅同校可见；(注意，int型)
 * @linkType 0 Http跳转 1 Schema跳转
 */
Wanxiao.prototype.shareTo = function (type, text, imagesJson, url, title, bbscontent, shareTo, linkType) {
    var JsonObject = {
        "type": type,
        "text": text,
        "images": imagesJson,
        "url": url,
        "title": title,
        "bbsContent": bbscontent,
        "linkUrl": url,
        "shareTo": shareTo,
        "linkType": linkType
    };
    var params = JSON.stringify(JsonObject);
    if (!isIphone()) {
        window.wanxiao_share.executeBindMethod("shareTo", params);
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, function () {
                                   });
            bridge.callHandler('shareTo', jsonString, function (response) {
                               });
        }
        
    }
};

/**
 * 返回积分信息
 *
 * @param jsondata
 *            输入参数
 * @param callback
 *            通过回调函数，获得结果，如：callback = function(data){alert(data);}
 */
Wanxiao.prototype.getCredits = function (jsondata, callback) {
    if (!isIphone()) {
        callback(window.wanxiao_credits.executeBindMethod("getCredits",
                                                          jsondata));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('getCredits', jsonString, callback);
        }
        
    }
};

/**
 * 添加积分
 *
 * @param jsondata
 *            输入参数 sign签名针对所有参数
 *            {"sign":"5183BC22","desc":"娱乐系统消费积分","flag":"entertainmentSys","token":"3a459a5b-3dae-40a2-a942-ab27eb7758a3","grade":"5"}
 *            desc 积分描述最多25个字
 */
Wanxiao.prototype.addCredits = function (jsondata, callback) {
    if (!isIphone()) {
        callback(window.wanxiao_credits.executeBindMethod("addCredits",
                                                          jsondata));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('addCredits', jsonString, callback);
        }
        
    }
};

/**
 * 扣减积分
 *
 * @param jsondata
 *            输入参数
 */
Wanxiao.prototype.reduceCredits = function (jsondata, callback) {
    if (!isIphone()) {
        callback(window.wanxiao_credits.executeBindMethod("reduceCredits",
                                                          jsondata));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('reduceCredits', jsonString, callback);
        }
    }
};

/**
 * 打开聊天
 *
 * @param 聊天好友信息
 * @param toId
 *            对方Id（StuId）
 * @param fromId
 *            登录人userId
 * @sign 迎新插件调用玩校聊天功能合法性校验 接口需要(签名只针对flag)
 * @flag 插件唯一编号，玩校中对应subApp实体SN
 */
Wanxiao.prototype.openChat = function (toId, fromId, sign, flag, callback) {
    var JsonObject = {
        "toId": toId,
        "fromId": fromId,
        "sign": sign,
        "flag": flag
    };
    var params = JSON.stringify(JsonObject);
    if (!isIphone()) {
        callback(window.wanxiao_chat.executeBindMethod("getChat", params));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('openChat', jsonString, callback);
        }
    }
};
/**
 * 打开支付收银台
 *
 * @param 订单json字符串
 *
 */
Wanxiao.prototype.openPayWay = function (order_param, callback) {
    
    var JsonObject = {
        "order_param": order_param
    };
    var params = JSON.stringify(JsonObject);
    if (!isIphone()) {
        callback(window.wanxiao_payway.executeBindMethod("getPayWay", params));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('openPayWay', jsonString, callback);
        }
    }
};

/**
 * 关闭当前打开的APP网页界面
 */
Wanxiao.prototype.closeAppWeb = function () {
    if (!isIphone()) {
        window.wanxiao_default.executeBindMethod("closeActivity", null);
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, function () {
                                   });
            bridge.callHandler('closeAppWeb', jsonString, function (response) {
                               });
        }
    }
};

/**
 * 设置menu
 *  @param jsonStr 菜单列表json字符串
 *    例如： [{"title":"百度","icon":"http://192.168.156.90/img/face.png","url":"http://www.baidu.com"},
 *        {"title":"网易","icon":"http://192.168.156.90/img/face.png","url":"http://www.163.com"},
 *            {"title":"IT之家","icon":"http://192.168.156.90/img/face.png","url":"http://www.ithome.com"},……]
 */
Wanxiao.prototype.setMenu = function (jsonStr, callback) {
    if (!isIphone()) {
        callback(window.wanxiao_menu.executeBindMethod("setMenu", jsonStr));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsonStr, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('setMenu', jsonString, callback);
        }
    }
};

/**
 * 扫描条码
 * @param callback 结果回调函数
 */
Wanxiao.prototype.scanBarcode = function (callback) {
    if (!isIphone()) {
        Wanxiao.prototype._scanBarcodeCallback = callback;
        window.wanxiao_scanBarcode.executeBindMethod("scanBarcode",
                                                     "wanxiao._scanBarcodeCallback");
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('scanBarcode', jsonString, callback);
        }
    }
};

/**
 * 摇一摇
 * @param callback 结果回调函数
 */
Wanxiao.prototype.shake = function (callback) {
    if (!isIphone()) {
        Wanxiao.prototype._shakeCallback = callback;
        window.wanxiao_shake.executeBindMethod("shake", "wanxiao._shakeCallback");
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('shake', jsonString, callback);
        }
    }
};

/**
 * 获得坐标数据，经纬度信息
 *
 */
Wanxiao.prototype.getLocation = function (callback) {
    if (!isIphone()) {
        console.log("-----getLocaltionPosition----");
        Wanxiao.prototype._locationCallback = callback;
        window.wanxiao_Location.executeBindMethod("getLocaltionPosition",
                                                  "wanxiao._locationCallback");
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('getLocation', jsonString, callback);
        }
    }
};

/**
 * 第三方插件调用Command方法
 *
 */
Wanxiao.prototype.appChannel = function (method, jsonData, callback) {
    if (!isIphone()) {
        var JsonObject = {
            "command": method,
            "data": jsonData
        };
        var params = JSON.stringify(JsonObject);
        callback(window.wanxiao_command.executeBindMethod("appchannel", params));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('appChannel', jsonString, callback);
        }
    }
};

/**
 * 获取用户头像 返回值：成功返回头像url,失败返回空字符串
 */
Wanxiao.prototype.getUserGravatar = function (callback) {
    
    wanxiao.getUserJsonValue(function (result) {
                             if (result == null || result == undefined || result == '') {
                             callback("");
                             } else {
                             var d = eval('(' + result + ')');
                             var url = "http://server.17wanxiao.com/campus/~/userPic/" + d.id;
                             callback(url);
                             }
                             });
    
}

/*
 * 打开图片浏览
 * @param imageUrls 图片地址json字符串
 * @param index 默认显示的图片索引
 * @param callback 回调函数，调用成功返回空字符串，否则返回错误信息
 */
Wanxiao.prototype.openImageView = function (imageUrls, index, callback) {
    var JsonObject = {
        "urls": imageUrls,
        "index": index
    };
    var params = JSON.stringify(JsonObject);
    
    if (!isIphone()) {
        callback(window.wanxiao_imageView.executeBindMethod("imageView", params));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('imageView', jsonString, callback);
        }
    }
}

/*
 * 获取网络状态
 * @param callback 回调函数，返回网络类型（大写）,未知网络返回空字符串
 */
Wanxiao.prototype.getNetworkStatus = function (callback) {
    if (!isIphone()) {
        callback(window.wanxiao_network.executeBindMethod("getNetwrokStatus", null));
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('getNetwrokStatus', jsonString, callback);
        }
    }
}

/*
 * 选择图片（每次只能选择一张图片）
 * @param callback 回调函数，返回选择图片的base64位编码
 *
 */
Wanxiao.prototype.selectImage = function (callback) {
    if (!isIphone()) {
        Wanxiao.prototype._selectImageCallback = callback;
        window.wanxiao_selectImage.executeBindMethod("selectImage", "wanxiao._selectImageCallback");
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('selectImage', jsonString, callback);
        }
    }
}

/*
 * 选择图片（每次只能选择一张图片）（是否启用裁剪）
 *
 * @param jsondata =
 *            {"isCrop":"0、不剪切, 1、剪切",
 *             "ratio":"缩放的高宽比例值，浮点类型；如：2 = 高2，宽1" }
 *
 * @param callback 回调函数，返回选择图片的base64位编码
 *
 */
Wanxiao.prototype.selectImage1 = function (jsondata, callback) {
    if (!isIphone()) {
        Wanxiao.prototype._selectImage1Callback = callback;
        window.wanxiao_selectImage1.executeBindMethod("selectImage1", jsondata);
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(jsondata, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('selectImage1', jsonString, callback);
        }
    }
}

/*
 * 设置title
 * @param title 标题
 *
 */
Wanxiao.prototype.setTitle = function (title, callback) {
    
    var JsonObject = {
        "title": title
    };
    var params = JSON.stringify(JsonObject);
    
    if (!isIphone()) {
        window.wanxiao_title.executeBindMethod("setTitle", title);
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('setTitle', jsonString, callback);
        }
    }
}

/*
 * scheme通用回调接口
 * @param callback 回调函数，回调函数的参数格式为json
 * 回调函数数据格式   int code ：0成功,其他失败
 * 					string type：scheme地址中page参数内容
 * 					string message：消息
 *					string data：扩展字段内容为json字符串
 *
 */
Wanxiao.prototype.commonCallback = function (callback) {
    if (!isIphone()) {
        Wanxiao.prototype._commonCallback = callback;
        window.wanxiao_callback.executeBindMethod("commonCallback", "wanxiao._commonCallback");
    } else {
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('commonCallback', jsonString, callback);
        }
    }
}

/**
 * 设置menu
 * @param jsonData
 *  例如： {"data": [{"id":"1","title":"百度","icon":"http://www.baidu.com/favicon.ico"},
 *         {"id":"2","title":"网易","icon":"http://www.163.com/favicon.ico"},
 *         {"id":"3","title":"IT之家","icon":"http://www.ithome.com/favicon.ico"},……]}
 * @param callback  回调    function(id)  //点击项的id
 */
Wanxiao.prototype.setMenu1 = function(jsonData,callback){
    var params = JSON.stringify(jsonData);
    if (!isIphone()) {
        Wanxiao.prototype._setMenu1 = callback;
        window.wanxiao_menu1.executeBindMethod("setMenu1", params);
    }else{
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name(params, jsname);
            bridge.registerHandler(jsname, callback);
            bridge.callHandler('setMenu1', jsonString, callback);
        }
    }
}

/**
 * 显示menu
 */
Wanxiao.prototype.showMenu = function(){
    if (!isIphone()) {
        window.wanxiao_menu.executeBindMethod("showMenu",null);
    }else{
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, function(){});
            bridge.callHandler('showMenu', jsonString, function(response){});
        }
    }
}

/**
 * 隐藏menu
 */
Wanxiao.prototype.hideMenu = function(){
    if (!isIphone()) {
        window.wanxiao_menu.executeBindMethod("hideMenu",null);
    }else{
        if (window.bridge) {
            jsname = this.get_jsname();
            jsonString = this.add_js_name('{}', jsname);
            bridge.registerHandler(jsname, function(){});
            bridge.callHandler('hideMenu', jsonString, function(response){});
        }
    }
}

var wanxiao = new Wanxiao();

/*
 * 智能机浏览器版本信息:
 *
 */
var browser = {
versions: function () {
    var u = navigator.userAgent, app = navigator.appVersion;
    return {// 移动终端浏览器版本信息
    trident: u.indexOf('Trident') > -1, // IE内核
    presto: u.indexOf('Presto') > -1, // opera内核
    webKit: u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
    gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, // 火狐内核
    mobile: !!u.match(/AppleWebKit.*Mobile.*/)
        || !!u.match(/AppleWebKit/), // 是否为移动终端
    ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), // ios终端
                   android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或者uc浏览器
                   iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, // 是否为iPhone或者QQHD浏览器
                   iPad: u.indexOf('iPad') > -1, // 是否iPad
                   webApp: u.indexOf('Safari') == -1
                   // 是否web应该程序，没有头部与底部
                   };
                   }(),
                   language: (navigator.browserLanguage || navigator.language).toLowerCase()
                   }
                   
                   function isIphone() {
                   if (browser.versions.ios || browser.versions.iPhone
                       || browser.versions.iPad) {
                   return true;
                   } else {
                   return false;
                   }
                   }
                   
        /**
         * IOS初始化js接口
         */
                   document.addEventListener('WebViewJavascriptBridgeReady', function () {
                                             window.bridge = WebViewJavascriptBridge;
                                             bridge.init(function (message, responseCallback) {
                                                         
                                                         });
                                             wanxiao.readycallback && wanxiao.readycallback();
                                             }, false);
