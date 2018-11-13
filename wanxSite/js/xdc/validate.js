// 检验：包含特殊字符
function checkContainQuote(str) {
    var items = new Array("~", "`", "!", "@", "#", "$", "%", "^", "&", "*", "{", "}", "[", "]", "(", ")");
    items.push(":", ";", "'", "|", "\\", "<", ">", "?", "/", "<<", ">>", "||", "//");
    items.push("admin", "administrators", "administrator", "管理员", "系统管理员");
    items.push("select", "delete", "update", "insert", "create", "drop", "alter", "trancate");
    str = str.toLowerCase();
    for (var i = 0; i < items.length; i++) {
        if (str.indexOf(items[i]) >= 0) {
            return true;
        }
    }
    return false;
}

// 检验：数字  非0开头
function checkIsNumber(str) {
    var reg = /^[1-9][0-9]*$/;
    return reg.test(str);
}

// 检验：全数字
function checkAllNumber(str) {
    var reg = /^[0-9]*$/;
    return reg.test(str);
}

// 检验：包含中文
function checkContainChinese(str) {
    var reg = /.*[\u4e00-\u9fa5]+.*$/;
    return reg.test(str);
}

// 检验：全中文
function checkAllChinese(str) {
    var reg = /^[\u4E00-\u9FA5]+$/;
    return reg.test(str);
}

// 检验：姓名，2至4个中文
function checkIsName(str) {
    var reg = /^[\u4E00-\u9FA5]{2,4}$/;
    return reg.test(str);
}

// 检验：手机号码
function checkIsPhone(str) {
    var reg = /^1[3|4|5|7|8][0-9]\d{8}$/;
    return reg.test(str);
}

// 检验：email格式
function checkIsEmail(str) {
    var reg = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    return reg.test(str);
}

// 检验：邮政编码，6个数字
function checkIsPostCode(str) {
    var reg = /\d{6}$/;
    return reg.test(str);
}

