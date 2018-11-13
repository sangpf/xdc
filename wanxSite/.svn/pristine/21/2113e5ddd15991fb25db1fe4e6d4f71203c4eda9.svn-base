var turnplate = {
    restaraunts: [], //大转盘奖品名称
    colors: [], //大转盘奖品区块对应背景颜色
    outsideRadius: 192, //大转盘外圆的半径
    textRadius: 155, //大转盘奖品位置距离圆心的距离
    insideRadius: 68, //大转盘内圆的半径
    startAngle: 0, //开始角度
    bRotate: false //false:停止;ture:旋转
};

// 动态添加大转盘的奖品与奖品区域背景颜色
turnplate.restaraunts = ["谢谢参与", "一等奖", "三等奖", "谢谢参与", "二等奖", "谢谢参与", "三等奖 ", "谢谢参与", "二等奖", "三等奖"];
turnplate.colors = ["#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF", "#FFF4D6", "#FFFFFF"];

(function() {

    // mui初始化
    mui.init({
        swipeBack: true,
        beforeback: function() {
            MtaH5.clickStat('5002')
            mui.confirm('亲！真的要放弃本次抽奖吗？', '', ['残忍放弃', '我要继续'], function(e) {
                if (e.index == 0) {
                    // 放弃领奖统计
                    addLog({
                        logType: 'awardAction',
                        action: 'giveupLotteryAward',
                        actResult: 'null'
                    });
                    jumpTo('index');
                }
            })
            return false;
        }
    })

    // 监听点击指针
    document.getElementById('pointer').addEventListener('tap', function() {
        handlePointerClick();
    });

    // 渲染轮盘
    drawRouletteWheel();
    
    // 加载奖品信息
    loadLotteryAward();
})()

/**
 * 渲染轮盘
 */
function drawRouletteWheel() {
    var canvas = document.getElementById("wheelcanvas");
    if (canvas.getContext) {
        //根据奖品个数计算圆周角度
        var arc = Math.PI / (turnplate.restaraunts.length / 2);
        var ctx = canvas.getContext("2d");
        //在给定矩形内清空一个矩形
        ctx.clearRect(0, 0, 422, 422);
        //strokeStyle 属性设置或返回用于笔触的颜色、渐变或模式
        ctx.strokeStyle = "#FFBE04";
        //font 属性设置或返回画布上文本内容的当前字体属性
        ctx.font = '16px Microsoft YaHei';
        for (var i = 0; i < turnplate.restaraunts.length; i++) {
            var angle = turnplate.startAngle + i * arc;
            ctx.fillStyle = turnplate.colors[i];
            ctx.beginPath();
            //arc(x,y,r,起始角,结束角,绘制方向) 方法创建弧/曲线（用于创建圆或部分圆）
            ctx.arc(211, 211, turnplate.outsideRadius, angle, angle + arc, false);
            ctx.arc(211, 211, turnplate.insideRadius, angle + arc, angle, true);
            ctx.stroke();
            ctx.fill();
            //锁画布(为了保存之前的画布状态)
            ctx.save();
            //----绘制奖品开始----
            ctx.fillStyle = "#E5302F";
            var text = turnplate.restaraunts[i];
            var line_height = 17;
            //translate方法重新映射画布上的 (0,0) 位置
            ctx.translate(211 + Math.cos(angle + arc / 2) * turnplate.textRadius, 211 + Math.sin(angle + arc / 2) * turnplate.textRadius);
            //rotate方法旋转当前的绘图
            ctx.rotate(angle + arc / 2 + Math.PI / 2);
            /** 下面代码根据奖品类型、奖品名称长度渲染不同效果，如字体、颜色、图片效果。(具体根据实际情况改变) **/
            if (text.indexOf("M") > 0) { //流量包
                var texts = text.split("M");
                for (var j = 0; j < texts.length; j++) {
                    ctx.font = j == 0 ? 'bold 20px Microsoft YaHei' : '16px Microsoft YaHei';
                    if (j == 0) {
                        ctx.fillText(texts[j] + "M", -ctx.measureText(texts[j] + "M").width / 2, j * line_height);
                    } else {
                        ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
                    }
                }
            } else if (text.indexOf("M") == -1 && text.length > 6) { //奖品名称长度超过一定范围
                text = text.substring(0, 6) + "||" + text.substring(6);
                var texts = text.split("||");
                for (var j = 0; j < texts.length; j++) {
                    ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
                }
            } else {
                //在画布上绘制填色的文本。文本的默认颜色是黑色
                //measureText()方法返回包含一个对象，该对象包含以像素计的指定字体宽度
                ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
            }
            //添加对应图标
            if (text.indexOf("闪币") > 0) {
                var img = document.getElementById("shan-img");
                ctx.drawImage(img, -15, 10);
            } else if (text.indexOf("谢谢参与") >= 0) {
                var img = document.getElementById("sorry-img");
                ctx.drawImage(img, -15, 10);
            }
            //把当前画布返回（调整）到上一个save()状态之前
            ctx.restore();
            //----绘制奖品结束----
        }
    }
}

/**
 * 加载奖品信息。
 * 包括：一二三等奖的名称、数量、图片，活动规则
 */
function loadLotteryAward() {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);
    mui.ajax(baseUrl+'/wanx/lotteryAward', {
        data: {
            deliveryId: getDeliveryIdFromQueryString(),
            qnType: 1,
            channel: 1,
            awardMethod: award.awardMethod
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            var $prize = $('.prize-list').find('div');
            for (var i = 0, length = data.length; i < length; i++) {
                $prize.eq(i).find('.prize-name').html(data[i].awardName)
                $prize.eq(i).find('.prize-num').html(data[i].awardQty)
                $prize.eq(i).find('img').attr('src', baseUrl + data[i].awardPic)
            }
            document.getElementById("lotteryIntro").innerHTML = data[2].lotteryIntro;
        }
    })
}

/**
 * 轮盘指针的click函数
 * 
 * 根据awardMethod判断是随机型抽奖、倾向型抽奖
 *     awardMethod == 2: 随机型 -> 调用接口 lottery
 *     awardMethos == 3: 倾向型 -> 调用接口 lotteryPrefer
 */
function handlePointerClick() {
    MtaH5.clickStat('5001');
    if (turnplate.bRotate) return;
    turnplate.bRotate = !turnplate.bRotate;

    // 根据awardMethod判断是随机型抽奖、倾向型抽奖
    var award = localStorage.getItem('award');
    award = JSON.parse(award);
    var lotteryInterface = {
        '2': '/wanx/lottery',
        '3': '/wanx/lotteryPrefer'
    }

    // 调用抽奖接口
    mui.ajax(baseUrl+lotteryInterface[award.awardMethod], {
        data: {
            userId: 1,
            deliveryId: getDeliveryIdFromQueryString(),
            qnId: getIdFromQueryString(),
            qnType: 1,
            channel: 1
        },
        dataType: 'json',
        type: 'get',
        timeout: 10000,
        success: function(data) {
            if (isDataSuccess(data)) {
                // 中奖：rank = 1,2,3
                // 未中奖：rank = 0
                var rank = data.awardRank;
                data.awardMethod = award.awardMethod;
                localStorage.setItem('award', JSON.stringify(data));

                // 根据几等奖，旋转转盘
                rotateByRank(rank);

                // 点击转盘统计
                addLog({
                    logType: 'awardAction',
                    action: 'doLottery',
                    actResult: rank
                });
            } else {
                if (data.errCode == "001") {
                    // 未中奖
                    var rank = 0;
                    rotateByRank(rank);

                    // 点击转盘统计
                    addLog({
                        logType: 'awardAction',
                        action: 'doLottery',
                        actResult: rank
                    });
                } else if (data.errCode == "002") {
                    //已经抽过奖
                    mui.alert('点击其他问卷获得更多抽奖机会...', '您已抽过奖了呦 ', '确认', function() {
                        jumpTo('index');
                    })
                } else {
                    mui.alert('网络错误...', function() {
                        jumpTo('index');
                    });
                }
            }
        }
    });
}

/**
 * 根据几等奖，旋转轮盘。
 *
 * 输入：
 *     rank: 奖励等级。
 *         中奖：rank = 1,2,3
 *         未中奖：rank = 0
 */
function rotateByRank(rank) {

    // 产生随机数。范围： n <= 随机数 <= m
    var rnd = function(n, m) {
        do {
            var random = Math.floor(Math.random() * (m - n + 1) + n);
        } while (random < 1 || random > 9);
        return random;
    }

    // 根据奖励等级，计算轮盘旋转参数
    if (rank == 1) {
        var item = 1;
    } else if (rank == 2) {
        var random = rnd(1, 2)
        var secondAwardArray = new Array(4, 8);
        var item = secondAwardArray[random - 1];
    } else if (rank == 3) {
        var random = rnd(1, 2)
        var thirdAwardArray = new Array(2, 6, 9);
        var item = thirdAwardArray[random - 1];
    } else if (rank == 0) {
        var random = rnd(1, 4)
        var noAwardArray = new Array(0, 3, 5, 7);
        var item = noAwardArray[random - 1];
    }
    var angles = 36 + item * (360 / turnplate.restaraunts.length) - (360 / (turnplate.restaraunts.length * 2));
    if (angles < 270) {
        angles = 270 - angles;
    } else {
        angles = 360 - angles + 270;
    }

    // 旋转轮盘
    $('#wheelcanvas').stopRotate();
    $('#wheelcanvas').rotate({
        angle: 0,
        animateTo: angles + 1800,
        duration: 8000,
        callback: function() {
            turnplate.bRotate = !turnplate.bRotate;
            stopRotateCallback(rank);
        }
    });
}

/**
 * 轮盘停止转动时的回调函数。用来提示用户是否中奖、是否领奖
 */
function stopRotateCallback(rank) {
    var award = localStorage.getItem('award');
    award = JSON.parse(award);

    // 没有中奖的逻辑
    var zeroAward = function() {
        mui.alert('您没有中奖', '很遗憾', '确认', function() {
            jumpTo('index');
        });
    }

    // 放弃领奖的逻辑
    var cancelAward = function() {
        // 放弃领奖统计
        MtaH5.clickStat('5005');
        addLog({
            logType: 'awardAction',
            action: 'giveupLotteryAward',
            actResult: 'null'
        });

        // 将奖品领取状态更新: 3未领取  1未发放
        updateAwardGetStatus(3, 1);

        // 跳转到首页
        jumpTo('index');
    }

    // 确认领奖的逻辑
    var confirmAward = function() {
        MtaH5.clickStat('5003');
        addLog({
            logType: 'awardAction',
            action: 'getLotteryAward',
            actResult: award.awardId
        });
        getAward();
    }

    if (rank == 0) {
        zeroAward();
    } else {
        mui.confirm(award.comment, '恭喜您', ['放弃领奖', '确认领奖'], function(e) {
            if (e.index == 0) {
                cancelAward();
            } else if (e.index == 1) {
                confirmAward();
            }
        });
    }
}            