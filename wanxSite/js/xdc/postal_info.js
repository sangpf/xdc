"use strict";
(function() {

    // mui初始化
    mui.init({
        swipeBack: true, //启用右滑关闭功能
        beforeback: function() {
            MtaH5.clickStat('5102')
            jumpTo('index');
            return false;
        }
    });

    // h5统计
    MtaH5.clickStat('5100');

    // 监听提交按钮
    if (document.getElementById('submit-postal')) {
        document.getElementById('submit-postal').addEventListener('tap', function() {
            submitStatics();
            savePostalInfo();
        });
    }
    if (document.getElementById('submit-postal-virtual')) {
        document.getElementById('submit-postal-virtual').addEventListener('tap', function() {
            submitStatics();
            savePostalInfoVirtual();
        });
    }

})()

// 统计提交
function submitStatics() {
    MtaH5.clickStat('5101');
    addLog({
        logType: 'awardAction',
        action: 'submitAwardMessage',
        actResult: 'success'
    });
}

function savePostalInfo() {
    // 获取输入
    var recipientName = document.getElementsByTagName('input')[0].value;
    var recipientPhone = document.getElementsByTagName('input')[1].value;
    var mailAddress = document.getElementsByTagName('input')[2].value;
    var postCode = document.getElementsByTagName('input')[3].value;
    var province = document.getElementsByTagName('input')[4].value;

    // 表单验证
    if (recipientName == "" || recipientPhone == "" || mailAddress == "" || postCode == "" || province == "") { //验证信息输入完整性
        mui.toast("请填写完整信息哟...");
        return;
    }
    if (!checkIsName(recipientName)) {
        mui.toast("请输入正确收件人姓名...");
        return;
    }
    if (!(checkIsPhone(recipientPhone))) {
        mui.toast("请输入正确手机号码...");
        return;
    }
    if (!checkContainChinese(mailAddress)) {
        mui.toast("请输入正确地址...");
        return;
    }
    if (!checkIsPostCode(postCode)) {
        mui.toast("请输入正确邮编...");
        return;
    }
    if (!checkAllChinese(province)) {
        mui.toast("请输入正确省份...");
        return;
    }

    // 向后台提交数据
    var data =  {
        userId: "1",
        recipientName: recipientName,
        recipientPhone: recipientPhone,
        mailAddress: mailAddress,
        postCode: postCode,
        province: province
    }
    postal(data, function() {
        // 奖品领取状态更新：2已领取  1未发放
        updateAwardGetStatus(2,1);
        addAwardStatistics();
        mui.alert('领取成功，我们将会在10日内寄出您的奖品，请耐心等待！', '', '我知道了', function() {
            jumpTo('index');
        })
    });
}


function savePostalInfoVirtual() {
    // 获取输入
    var recipientName = document.getElementsByTagName('input')[0].value;
    var recipientSchool = document.getElementsByTagName('input')[1].value;
    var emailAddress = document.getElementsByTagName('input')[2].value;

    // 表单验证
    if (recipientName == "" || recipientSchool == "" || emailAddress == "") { //验证信息输入完整性
        mui.toast("请填写完整信息哟...");
        return;
    }
    if (!checkIsName(recipientName)) {
        mui.toast("请输入正确收件人姓名...");
        return;
    }
    if (!checkAllChinese(recipientSchool)) {
        mui.toast("请输入正确学校名称...");
        return;
    }
    if (!checkIsEmail(emailAddress)) {
        mui.toast("请输入正确电子邮箱地址...");
        return;
    }

    // 向后台提交数据
    var data = {
        userId: "1",
        recipientName: recipientName,
        schoolName: recipientSchool,
        email: emailAddress
    }

    postal(data, function() {
        // 奖品领取状态更新：2已领取  1未发放
        updateAwardGetStatus(2,1);
        // addAwardStatistics();  // virtual页面作为外链的一种，已经在跳转到外链前添加了获奖统计，这里不必重复记，否则会导致“我获得的奖励”出现重复
        mui.alert('领取成功，我们将会在问卷调研结束的5个工作日内把奖品发送至您的邮箱，请耐心等待！', '', '我知道了', function() {
            jumpTo('index');
        })
    });
}

/**
 * 向后台提交数据
 *
 * 输入：
 *     data: ajax要传输的数据
 *     successCallback: ajax成功的回调函数
 */
function postal(data, successCallback) {
    mui.ajax(baseUrl+'/wanx/postal', {
        data: data,
        dataType: 'json',
        type: 'POST',
        contentType: "application/x-www-form-urlencoded;charset=utf-8",
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
               successCallback();
            }
        },
        error: function() {
            mui.toast('网络错误, 请重新提交');
        }
    });
}
