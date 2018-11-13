//从本地中获取data-nikename
var data_nikename=localStorage.getItem('data_nikename');
//从本地中取出data-content
var data_content=localStorage.getItem('data_content');
(function() {

    // mui初始化
    mui.init({
        swipeBack: false
    });
    //当评论输入框获得焦点时隐藏表情列表
	document.getElementById('commentInput').addEventListener('mouseover',function(){
		document.getElementById('emoji').style.display='none';
	});
    //监听点击表情
    	inputFac();
    // 监听取消按钮
    document.getElementById('cancel').addEventListener('tap', function() {
        history.go(-1);
    });
    
    // 监听提交按钮
    document.getElementById('submit').addEventListener('tap', function() {
        handleCommentSubmit();
    });

    // 监听评论输入框的输入事件
    document.getElementById('commentInput').addEventListener('input', function(e) {
        handleCommentInput(e);
    });  
})()

/**
 * 评论输入框的处理函数
 */
function handleCommentInput(e) {
    var inputVal = e.target.value;
    var maxLength = e.target.getAttribute('maxlength');
    var submit = document.getElementById("submit");
    // 检测字数限制
    if (inputVal.length >= maxLength) {
        mui.toast("很抱歉，不能超过" + maxLength + "个字");
    }
}

/**
 * 回复输入框的点击提交函数
 */
function handleCommentSubmit() {
    var commentObjId, commentObjType;
    var isReport = localStorage.getItem('isReport');
    var qnType = localStorage.getItem('qnType');
    var qnId = localStorage.getItem('qnId');
    var deliveryId = localStorage.getItem('deliveryId');
    var reportId = localStorage.getItem('reportId');

    var commentInput = document.getElementById('commentInput');
    var inputVal = commentInput.value;
    if (inputVal.trim() == '') {
        mui.toast("您还没有写回复哦～");
    } else {
        commentInput.disabled = true;
        //inputVal = AnalyticEmotion(inputVal); // 新浪表情解析
        // 统计提交回复
        if (isReport == '1') {
            commentObjId = reportId;
            commentObjType = '4';
            addLog({
                logType: 'reportAction',
                action: 'reply',
                reportId: reportId,
                actResult: inputVal
            });
        } else {
            commentObjId = deliveryId;
            commentObjType = qnType;
            addLog({
                logType: 'qnAction',
                action: 'reply',
                deliveryId: deliveryId,
                qnId: qnId,
                qnType: qnType,
                actResult: 'success'
            });
        }

        // 提交回复
        mui.ajax(baseUrl+'/wanx/addNiComment', {
            data: {
                commentObjId: commentObjId,
                commentObjType: commentObjType,
                content: inputVal,
                nikeName:data_nikename,
                data_content:data_content,
                submitType:2
            },
            dataType: 'json',
            type: 'post',
            timeout: 10000,
            success: function(data) {
                if (data.errorCode == "001") {
                    mui.toast("你写的内容太敏感，我怕被查水表...");
                    commentInput.disabled = false;
                } else if (data.errorCode == "002") {
                    mui.toast("一不小心保存失败了~");
                    commentInput.disabled = false;
                } else {
                    mui.toast("回复成功!");
                    setTimeout(function() {
                        if (isReport == '1') {
                            jumpTo('report_comment');
                        } else {
                            jumpToQn(qnType, 1, qnId, deliveryId, 'comment');
                        }
                    }, 800);
                }
            },
            error: function() {
                mui.toast("由于网络原因，回复失败，请重新提交！");
            }
        });
    }
}