"use strict"; + function() {

    // mui初始化
    mui.init({
        swipeBack: true, //启用右滑关闭功能
        beforeback: function() {
            MtaH5.clickStat('2302')
        }
    });

    // h5统计
    MtaH5.clickStat('2300');

    // 监听悬浮窗
    document.getElementById('suspension').addEventListener('tap', function() {
        var qnType = localStorage.getItem('qnType');
        var qnId = localStorage.getItem('qnId');
        var deliveryId = localStorage.getItem('deliveryId');

        jumpToQn(qnType, 1, qnId, deliveryId, 'answer');
    });

    var titleTemplate = [
        "<p class=\"answerTitle\">【{{questionQty}}题】{{sqnName}}</p>",
        "<p class=\"answerInfo\">出题人：{{publisherName}} 类型：{{sqnClassName}}</p>"
    ].join("");

    var template = [
        "<div class=\"answerItem\">",
        "  <div class=\"anTitle\">{{questionNum}}.{{sqTitle}}<font color=\"red\"> (单选)</font></div>",
        "  <div class=\"anBody\">",
        "    {{#options}}",
        "    <div class=\"anBodyItem\">",
        "     <i class=\"anChoice\" id=\"q{{questionNum}}c{{optionOrder}}Type\"></i>",
        "      <div class=\"anNormal\">{{optionDes}}<i id=\"q{{questionNum}}c{{optionOrder}}Result\">&nbsp</i></div>",
        "    </div>",
        "    {{/options}}",
        "  </div>",
        "</div>"
    ].join("");

    var templateAnalysis = [
        "<div class=\"answerItem\">",
        "  <div class=\"anTitle\">{{questionNum}}.{{sqTitle}}<font color=\"red\"> (单选)</font></div>",
        "  <div class=\"anBody\">",
        "    {{#options}}",
        "    <div class=\"anBodyItem\">",
        "     <i class=\"anChoice\" id=\"q{{questionNum}}c{{optionOrder}}Type\"></i>",
        "      <div class=\"anNormal\">{{optionDes}}<i id=\"q{{questionNum}}c{{optionOrder}}Result\">&nbsp</i></div>",
        "    </div>",
        "    {{/options}}",
        "  </div>",
        "</div>",
        "<p class=\"answerAna\">答案解析：{{{answerAnalysis}}}</p>",
    ].join("");

    var templateTxt = [
        "<div class=\"answerItem\">",
        "  <div class=\"anTitle\">{{questionNum}}.{{sqTitle}}<font color=\"red\"> (填空)</font></div>",
        "  <textarea class=\"anBodyTxt\" readonly=\"readonly\">{{userAnswer}}</textarea>",
        "</div>"
    ].join("");

    mui.ajax(baseUrl+'/wanx/loadSqn', {
        data: {
            userId: 1,
            sqnId: localStorage.getItem('qnId'),
            sqnCategory: localStorage.getItem('sqnCategory'),
            answered: "1"
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {

            // 渲染问卷名称、出题人等信息
            var title = document.getElementById("title");
            var list = document.getElementById("list");
            var titleFragment = Mustache.render(titleTemplate, data);
            title.innerHTML = titleFragment;

            // 渲染问卷题目的题干、选项、答案等
            for (var i = 0, length = data.questions.length; i < length; i++) {

                // 获取题目类型。1:单选   2:多选    3:填空
                var questionType = data.questions[i].questionType;

                // 将每一道题目的题干、选项添加到DOM树中
                if (questionType == 1 || questionType == 2) {
                    // 选择题，判断有无“答案解析”
                    if (!isStrValid(data.questions[i].answerAnalysis)) {
                        var fragment = Mustache.render(template, data.questions[i]);
                    } else {
                        var fragment = Mustache.render(templateAnalysis, data.questions[i]);
                    }
                } else {
                    // 填空题
                    var fragment = Mustache.render(templateTxt, data.questions[i]);
                }
                list.innerHTML += fragment;

                // 将每一道题中，用户选择的答案、正确答案、错误答案添加相应的类
                if (questionType == 1 || questionType == 2) {
                    var userAnswer = data.questions[i].userAnswer; // 字母形式的用户答案
                    var correctAnswer = data.questions[i].correctAnswer; // 字母形式的正确答案
                    var userAnswerCode = userAnswer.toUpperCase().charCodeAt(0); // char code 形式的用户答案
                    var correctAnswerCode = correctAnswer.toUpperCase().charCodeAt(0); // char code 形式的正确答案
                    var userAnswerTypeDom = document.getElementById("q" + (i + 1) + "c" + (userAnswerCode - 64) + "Type");
                    var userAnswerResultDom = document.getElementById("q" + (i + 1) + "c" + (userAnswerCode - 64) + "Result");
                    var correctAnswerResultDom = document.getElementById("q" + (i + 1) + "c" + (correctAnswerCode - 64) + "Result");

                    if (userAnswer) {
                        // 为用户选择的答案添加“画圈”的类。
                        userAnswerTypeDom.className = "anChosed";
                        // 判断用户是否答对
                        if (userAnswerCode == correctAnswerCode) {
                            // 用户答对，添加“对号”的类
                            userAnswerResultDom.className = "anRight";
                        } else {
                            // 用户答错，添加“错号”、“正确答案”的类。
                            userAnswerResultDom.className = "anError";
                            correctAnswerResultDom.className = "anText";
                        }
                    } else {
                        // 特殊情况：如果为非必答题，且用户未作答，则只给出“正确答案”的提示
                        correctAnswerResultDom.className = "anText";
                    }
                }
            }
        }
    })
}()
