(function() {

    // mui初始化
    mui.init({
        swipeBack: false
    });

    // H5统计
    MtaH5.clickStat('8100', {
    	'write': 'true'
  	});
	//当评论输入框获得焦点时隐藏表情列表
	document.getElementById('commentInput').addEventListener('mouseover',function(){
		document.getElementById('emoji').style.display='none';
	});
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
    //监听点击表情
    inputFac();
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
 * 评论输入框的点击提交函数
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
        mui.toast("您还没有写评论哦～");
    } else {
        commentInput.disabled = true;
        //inputVal = AnalyticEmotion(inputVal); // 新浪表情解析
        // 统计提交评论
        if (isReport == '1') {
            commentObjId = reportId;
            commentObjType = '4';
            addLog({
                logType: 'reportAction',
                action: 'comment',
                reportId: reportId,
                actResult: inputVal
            });
        } else {
            commentObjId = deliveryId;
            commentObjType = qnType;
            addLog({
                logType: 'qnAction',
                action: 'comment',
                deliveryId: deliveryId,
                qnId: qnId,
                qnType: qnType,
                actResult: 'success'
            });
        }

        // 提交评论
        mui.ajax(baseUrl+'/wanx/addNiComment', {
            data: {
                commentObjId: commentObjId,
                commentObjType: commentObjType,
                content: inputVal,
                submitType:1
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
                    mui.toast("评论成功!");
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
                mui.toast("由于网络原因，评论失败，请重新提交！");
            }
        });
    }
}

