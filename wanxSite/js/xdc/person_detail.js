var notInputHtml = '<span class="gray" data-isFirstInput="true">请填写</span>';

(function() {
    
    // mui初始化
    mui.init();

    // 图片预览初始化
    mui.previewImage();

    // 加载用户信息
    loadPersonalInfo();

    // 初始化悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        addLog({
            logType: 'personalPageSkip',
            sourcePage: 'person_detail',
            targetPage: 'person_index'
        });
        jumpTo('person_index');
    });

})(mui)

function loadPersonalInfo() {
    mui.ajax(baseUrl+'/wanx/LoadPersonalInfo', {
        data: {
            userId: 1
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            // 加载头像。如果用户没有头像，给出默认头像
            data.wanxHeadImg = isStrValid(data.wanxHeadImg) ? data.wanxHeadImg : "./images/good.png";
            document.getElementById('wanxHeadImgElem').setAttribute("src", data.wanxHeadImg);
            // 加载用户信息
            updateDom('wanxNickName', data.wanxNickName);
            updateTag('gender', data.gender);
            updateTag('career', data.career);
            updateDom('schoolName', data.schoolName);
            updateDom('enrolDate', data.enrolDate || notInputHtml);
            updateDom('college', data.college || notInputHtml);
            updateDom('degree', data.degree || notInputHtml);
            updateDom('grade', data.grade || notInputHtml);
            updateDom('major', data.major || notInputHtml);
            updateDom('birthday', data.birthday || notInputHtml);
            updateDom('starSign', data.starSign || notInputHtml);
            updateDom('bloodType', data.bloodType || notInputHtml);
            updateDom('character', data.character || notInputHtml);
            updateDom('moral', data.moral || notInputHtml);
            updateDom('loveCondition', data.loveCondition || notInputHtml);
            updateDom('phone', data.phone || notInputHtml);
            updateDom('email', data.email || notInputHtml);

            // 如果用户已填写了所有项，则把页面上”填写可获积分“类似提示删除掉
            chechIfAllScoreItemBeInput();

            // 隐藏loading动画
            hideLoading();
        }
    })
}

/**
 * 每个列表项的点击函数。包括5种：
 * 1：弹出时间选择器，如生日、入学时间
 * 2：弹出选项选择器，如星座、血型
 * 3：弹出文本输入框，如院系、专业、电话、邮箱
 * 4：切换页面标签，如性别、职业
 * 5：仅弹出提示窗，提示不允许修改，如用户名、学校
 */
function handleClick(event, key) {
    // 点击函数，弹出时间选择器
    function handleDtPickerClick(event, key) {
        var option = personData.getOption(key) || {};
        var picker = new mui.DtPicker(option);
        picker.show(function(rs) {
            var value = rs.text;
            var text = rs.text;
            if (text != getElementByKey(key).innerHTML) {
                updadtePersonalInfo(key, value, text, updateDom);
            }
            picker.dispose();
        });
    }

    // 点击函数，弹出选项选择器
    function handlePopPickerClick(event, key) {
        var picker = new mui.PopPicker();
        var data = personData.getData(key) || [];
        picker.setData(data);
        picker.show(function(items) {
            var value = items[0].value;
            var text = items[0].text;
            if (text != getElementByKey(key).innerHTML) {
                updadtePersonalInfo(key, value, text, updateDom);
            }
            picker.dispose();
        });
    }

    // 点击函数，弹出文本输入框
    function handlePromptClick(event, key) {
        var keyText = personData.getText(key);
        var validate = personData.getValidate(key);
        var maxLength = 50;

        // 输入框的提示文本
        var titleTips = '请输入' + keyText;
        var emptyTips = '输入不能为空哦';
        var tooLongTips = '最多只能输入' + maxLength + '个字哦';
        var unvalidateTips = '请输入正确的' + keyText;
        var btnArray = ['取消', '确定'];

        mui.prompt('', '', titleTips, btnArray, function(e) {
            if (e.index == 1) {
                var value = e.value;
                var text = e.value;
                // 输入为空，返回
                if (text.trim() == '') {
                    mui.toast(emptyTips);
                    return false;;
                }
                // 输入超过最大长度，返回
                if (text.length > maxLength) {
                    mui.toast(tooLongTips);
                    return false;;
                }
                // 输入不满足合法性验证，返回
                if (!eval(validate + '(text)')) {
                    mui.toast(unvalidateTips);
                    return false;;
                }
                // 更新用户信息
                updadtePersonalInfo(key, value, text, updateDom);
            }
        })
    }

    // 点击函数，切换页面的标签
    function handleTagClick(event, key) {
        // click的目标不是标签，则返回
        var classList = event.target.classList;
        if (!classList.contains('detail-tag')) {
            return
        };
        // click的目标已经是当前选中项，则返回
        if (classList.contains('active')) {
            return
        };
        // 更新用户信息
        var data = personData.getData(key) || [];
        var dataId = event.target.getAttribute('data-id');
        var value = data[dataId].value;
        var text = data[dataId].text;
        updadtePersonalInfo(key, value, text, updateTag);
    }

    // 点击函数，弹出toast提示，告诉用户无法修改
    function handleToastClick(event, key) {
        var tips = '不能修改"' + personData.getText(key) + '"哦';
        mui.toast(tips);
    }

    // 根据key，执行上述五种函数之一
    var handle = personData.getHandle(key);
    eval(handle + '(event, key)');
}

/**
 * 更新标签
 */
function updateTag(key, text) {
    var keyElem = getElementByKey(key);
    var data = personData.getData(key) || [];
    if (keyElem) {
        mui.each(keyElem.getElementsByTagName('span'), function(index, item) {
            var dataId = item.getAttribute('data-id');
            if (data[dataId].text == text) {
                item.classList.add('active');
            } else {
                item.classList.remove('active');
            }
        })
    }
}

/**
 * 更新DOM元素
 */
function updateDom(key, text) {
    var keyElem = getElementByKey(key);
    if (keyElem) {
        keyElem.innerHTML = text;
    }
}

/**
 * 更新用户信息
 */
function updadtePersonalInfo(key, value, text, updateFunction) {
    var wanxScoreNum = personData.getScore(key);
    if (wanxScoreNum > 0 && !isFirstInput(key)) {
        wanxScoreNum = 0;
    }
    var isAward = (wanxScoreNum == 0 ? 0 : 1);

    // 更新信息
    mui.ajax(baseUrl+'/wanx/updadtePersonalInfo', {
        data: {
            userId: 1,
            key: key,
            value: value,
            liangpiaoAwardNum: wanxScoreNum,
            isAward: isAward
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                updateFunction(key, text);
                chechIfAllScoreItemBeInput();
                console.log('update: ' + personData.getText(key) + ' - ' + text + ' - ' + value + ' - ' + wanxScoreNum + '粮票');
            } else {
                mui.toast('网络错误，请稍后重试...');
            }  
     },
        error: function() {
            mui.toast('网络错误，请稍后重试...');
        }
    });

    // 添加日志
    addLog({
        logType: 'personalAction',
        action: 'updatePersoanlInfo',
        actResult: key
    });
}

/**
 * 根据key，得到对应的DOM元素
 */
function getElementByKey(key) {
    return document.getElementById(key + 'Elem');
}

/**
 * 展开/关闭按钮的点击函数
 *
 * 输入：被展开/关闭的<ul class="mui-table-view">的id
 */
function toggleOpenOrClose(ulId) {
    var ulElem = document.getElementById(ulId);
    var liElem = ulElem.getElementsByTagName('li');
    var angleElem = ulElem.getElementsByClassName('detail-head-angle')[0];
    var todo = ulElem.getAttribute('data-todo');
    // 切换状态
    if (todo == 'close') {
        mui.each(liElem, function(index, item) {
            item.style.display = 'none';
        })
        ulElem.setAttribute('data-todo', 'open');
        angleElem.innerHTML = '<i class="icon-double-angle-down"></i>展开';
    } else {
        mui.each(liElem, function(index, item) {
            item.style.display = 'block';
        })
        ulElem.setAttribute('data-todo', 'close');
        angleElem.innerHTML = '<i class="icon-double-angle-up"></i>收起';
    }
}

/**
 * 对于所有填写可获积分的项，检查用户全部填写过
 * 如果是，则把页面上”填写可获积分“类似提示删除掉
 *
 * 判断标准：如果用户没有全部填完，则整个文档的HTML（字符串）中一定包含字符串 notInputHtml
 */
function chechIfAllScoreItemBeInput() {
    var srcStr = document.body.innerHTML.toLowerCase();
    var targetStr = notInputHtml.toLowerCase();
    // 如果用户没有全部填完，则不必删除提示，直接返回
    if (srcStr.indexOf(targetStr) > -1) {
        return;
    }
    // 如果用户已全部填完，由于提示的DOM具有detail-hide类。按类查找DOM，修改样式即可
    mui.each(document.getElementsByClassName('detail-hide'), function(index, item) {
        item.style.display = 'none';
    })
}

/* 判断是否是第一次填写。
 * 判断标准：如果是第一次填写，keyElem的DOM形如：
 * 
 * <span id="keyElem">
 *    <span class="gray" data-isFirstInput="true">请填写</span>
 * </span>
 * 
 * 可见，keyElem的HTML（字符串）中一定包含字符串 notInputHtml
 */
function isFirstInput (key) {
    var isFirstInput = false;
    var keyElem = getElementByKey(key);
    if (keyElem) {
        var srcStr = keyElem.innerHTML.toLowerCase();
        var targetStr = notInputHtml.toLowerCase();
        // 如果用户没有全部填完，则不必删除提示，直接返回
        if (srcStr.indexOf(targetStr) > -1) {
            isFirstInput = true;
        }
    }
    return isFirstInput;
}