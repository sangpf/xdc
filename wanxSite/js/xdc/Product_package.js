/*
 * 本js集合下几个页面的
 * pay_vip.html 
 * pay_page.html
 * pay_column.html
 * vip_page.html
 * paid_guide.html
 * vip.html
 * career_planning.html
 * */
//弹窗居中显示
function rize() {//自适应窗口位置函数
	    var objw=$(window);
	    var objc=$(".open_vip-alert-con");//获取弹窗
	    var brsw=objw.width();//获取窗口的宽
	    var brsh=objw.height();//获取窗口的高
	    var sclT=objw.scrollTop();//获取窗口滚动条位置
	    var sclL=objw.scrollLeft();//获取窗口滚动条位置
	    var corw=objc.width();//获取弹窗的宽
	    var corh=objc.height();//获取弹窗的高
	    //计算弹窗居中时候的左边距
	    var left=(brsw-corw)/2;
	    //计算弹窗居中时候的上边距
	    var top=(brsh-corh)/2;
	    objc.css({"top":top+"px","left":left+"px"});
	}
//////////////////////
///开通会员页//购买成功页///
/////////////////////
function pay_vip(callback){
	var pageType=getIdFromQueryString()//获取当前进来的途径
	var packageId=getVersion()//获取产品包的id
	var title=sessionStorage.getItem("title")//获取当前产品包的标题
	rize()
		//判断用户是什么会员
		//根据进来的路径显示不同的内容
		if(pageType==1){
			//开通会员页
			$(".open_vip-btn").html("立即开通会员");
			$(".open_vip img").attr("src","img/pay/u14.png");
			$(".open_vip-title1").css("display","block");
			$(".open_vip-title2").css("display","none");
			$(".open_vip-explain").html("<ul><li>会员免费开通，无需缴纳任何费用</li><li>会员可参与更多独家专业测评</li><li>会员可购买就业、求职等定向测评服务包</li><li>开通会员同时可0元购买大学生新生体验包</li></ul>");
			callback()
		}else if(pageType==2){
			//购买成功页
			$(".open_vip-btn").html("进入产品包");
			$(".open_vip img").attr("src","img/pay/u100.png");
			$(".open_vip img").css("margin-bottom",".3rem");
			$(".open_vip-title1").css("display","none");
			$(".open_vip-title2").css("display","block");
			$(".open_vip-title2").html("您已经成功购买"+title);
			$(".open_vip-explain").html("<p>快点开启自己的心灵之路吧</p>");
		//	判断用户是否购买过当前的产品包
			mui.ajax(baseUrl+'/wanx/isPayProduct',{
				data:{
					packageId:packageId
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
		//			购买过的是1没购买过的是0
					if(data==0){
						mui.alert("付费失败","提示","确定",function(){
							jumpTo("vip_page")
						})
						
					}else if(data==1){
						callback()
					}
				},
				error:function(){
					mui.toast("网络错误...")
				}
			})
		}

	//窗口改变大小而调整显示的位置
	$(window).resize(function () {
		if(!$(".open_vip-alert-con").is(":visible")){
			return
		}
	    rize();
	});
	//判断当前的pageType参数的值是多少然后执行什么步骤
		$(".open_vip-btn").click(function(){
			if(pageType==1){
				//查询会员是否开通过
				mui.ajax(baseUrl+'/wanx/membership',{
					type:'get',
					dataType:'json',
					timeout:10000,
					success:function(data){
						if(data>0){
							$(".open_vip-alert").css("display","block");
						}else{
							$(".open_vip-alert .alert-title").html("您已经开通过会员了");
							$(".open_vip-alert .alert-con").html("不需要重复购买")
							$(".open_vip-alert").css("display","block");
						}
					},
					error:function(){
						mui.toast("网络错误...")
					}
				})
				
			}else if(pageType==2){
				
			}
		})
//	返回会员页点击事件
	$(".alert-btn").click(function(){
		jumpTo('vip_page');
	})
}


////////////////////////////////
////////////订单页js/////////////
///////////////////////////////
//function pay_page(callback){
////	获取上个页面的内容
//	var title=sessionStorage.getItem("title");//获取产品包的标题	
//	var yuan=sessionStorage.getItem("yuan");//获取产品包的价格
//	var packageId=sessionStorage.getItem("packageId");//获取产品包的id
//	//	创建到本页面
//	$('.pay-price span b').html(yuan+"元");
//	$('.pay-title-author span').eq(1).html(title);
////支付接口
//	document.getElementById('pay').addEventListener('tap',function(){
//		if($(".pay_method:checked").val()==1){//根据用户选择的支付方式而调用不同的支付接口
//			mui.ajax(baseUrl+'/wanx/wanxPay',{//微信支付
//				data:{
//					contentType:3,
//					contentId:packageId
//				},
//				type:'get',
//				dataType:'json',
//				timeout:10000,
//				success:function(data){
//					console.log(data)
//					console.log(data.orderInfo)
//					console.log(typeof data.orderInfo)
//					
//					var orderInfo=JSON.parse(data.orderInfo);
//					console.log(orderInfo)
//					
//					console.log(typeof orderInfo)
//					var pay_data= {};
//			        pay_data.orderInfo=orderInfo;
//			        pay_data.targetUrl="";
//			        //转换为string
//			        console.log(pay_data)
//			        var dataStr=JSON.stringify(pay_data);
////			        	去掉字符串中的\
////			       	var dataStr1=dataStr.replace(/[\\]/g ,"");
//			        //拼接 玩校支付收银台scheme
//			        //schemeURI是一个还是两个
//			        
//		        	var schemeURI="wanxiao://17wanxiao.com?page=payway&iosLaunchType=iosLaunchTypeModal&data="+dataStr;
//		        	console.log(dataStr)
//		        	console.log(schemeURI)
//			        //跳转到scheme
//			        window.location.href= schemeURI;
//			        wanxiao.commonCallback(function(result){
//					   //收银台结果， 同步状态通知，参数说明如下章节：同步通知
////					   alert(result);
//					   if(result.code==0){
//					   		jumpTo("career_planning");
//					   }else{
//						   	mui.alert("支付失败","提示","返回",function(){
//						   		jumpTo("paid_guide")
//						   	})
//					   }
//					   
//					   
//					   //你的业务处理..
//					});
//
//		        	
//
//				},
//				error:function(){
//					mui.toast("网络错误...")
//				}
//			})
//		}else if($(".pay_method:checked").val()==2){//支付宝支付
//			mui.alert("支付宝支付功能暂时没有上线，现在仅支持微信支付","提示","确定",function(){
//				$(".pay_method").eq(0).attr("checked","checked")
//			})
//		}
//	})
//	callback()
//}

////////////////////////////////
//////////开通会员页js/////////////
///////////////////////////////
function pay_column(callback){
		var columnNum=sessionStorage.getItem("columnNum")
	var packageId=sessionStorage.getItem("packageId")
	var sourceId=sessionStorage.getItem("sourceId")
	//根据columnNum的值来判断用户点的是哪一个按钮来加载
	//	0是场景测试页    1是职场宝典   2是推荐秘籍
		if(columnNum==0){
			$("title").html("场景测试")
			mui.ajax(baseUrl+'/wanx/getProductContentList',{
				data:{
					packageId:packageId,
					columId:2
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					if(data.length==0){
						$(".list-empty").css("display","block");
					}
//					创建数据
					for (var i=0; i<data.length; i++) {
						var qn=$("<li class='mui-table-view-cell mui-media'><a qntype="+data[i].qnType+" answered="+data[i].answered+" qnid="+data[i].qnId+" deliveryid="+data[i].deliveryId+" class='jx-a-width'><div class='card-intro'><img class='mui-media-object mui-pull-left card-img' src="+data[i].picPath+"><div class='mui-media-body'><h4 class='mui-ellipsis-2 card-title'>"+data[i].qnName+"</h4><p class='card-detail card-publisher'>"+data[i].author+"</p><p class='card-detail card-collect'>0</p></div></div><div class='mui-media-body card-tags'><span class='card-tag card-foot-tag card-tag-gray'>"+data[i].tag1Str+"</span><span class='card-tag card-foot-tag card-tag-gray'>"+data[i].tag2Str+"</span><span class='card-tag card-foot-tag card-tag-gray'>"+data[i].tag3Str+"</span><span class='card-tag card-foot-tag card-tag-gray'>"+data[i].tag4Str+"</span></div><p class='mui-ellipsis-2 card-summary'>"+data[i].showDes+"</p></a></li>")
						$(".mui-content ul").append(qn)
					}
//					li的点击事件
					$(".card-list li").live('tap',function(){
						var data_deliveryid=$(this).children().attr("deliveryid");
						var data_qnid=$(this).children().attr("qnid");
						var data_qntype=$(this).children().attr("qntype");
						var data_answered=$(this).children().attr("answered");
						if(data_deliveryid!=0){
							localStorage.setItem("fromPos","career_planning.html?=version"+xdcVersion)
							jumpToQn(data_qntype,data_answered,data_qnid,data_deliveryid);
						}
					})
//					隐藏空标签
					deshtml(".card-tags span");
//					回调函数
					callback()
				},
				error:function(){
					mui.toast("网络错误...")
				}
			})
		}else if(columnNum==1){
			$("title").html("职场宝典")
			mui.ajax(baseUrl+'/wanx/getProductContentList',{
				data:{
					packageId:packageId,
					columId:3
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					if(data.length==0){
						$(".list-empty").css("display","block");
					}
					for (var j=0; j<data.length; j++) {
						var tweet=$("<li class='mui-table-view-cell mui-media'><a qntype="+data[j].qnType+" href="+data[j].tweetUrl+" class='card-intro jx-a-width'><img src="+data[j].picUrl+" alt='大图' class='mui-media-object mui-pull-left card-img'><div class='mui-media-body'><h4 class='mui-ellipsis-2 card-title'>"+data[j].title+"</h4><p class='card-detail card-time2'>"+data[j].pTime.substring(0,10)+"</p><p class='card-detail card-publisher2'>"+data[j].authorName+"</p></div></a></li>")
						$(".mui-content ul").append(tweet)
					}
					callback()
				},
				error:function(){
					mui.toast("网络错误...")
				}
			})
		}else if(columnNum==2){
			$("title").html("推荐秘籍")
			mui.ajax(baseUrl+'/wanx/getrecommendedList',{
				data:{
					sourceId:sourceId
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					for (var j=0; j<data.length; j++) {
						var tweet=$("<li class='mui-table-view-cell mui-media'><a href="+data[j].url+" class='card-intro jx-a-width'><img src="+data[j].picUrl+" alt='大图' class='mui-media-object mui-pull-left card-img'><div class='mui-media-body'><h4 class='mui-ellipsis-2 card-title'>"+data[j].title+"</h4><p class='card-detail card-time2'>"+data[j].pTime.substring(0,10)+"</p><p class='card-detail card-publisher2'>"+data[j].author+"</p></div></a></li>")
						$(".mui-content ul").append(tweet)
					}
				callback()
				},
				error:function(){
					mui.toast("网络错误...")
				}
			})
		}
}

////////////////////////////////
//////////产品包列表页js///////////
///////////////////////////////
function vip_page(callback){
	//			验证是否开通会员
			mui.ajax(baseUrl+'/wanx/isMember',{
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					sessionStorage.setItem("isMember",data)
					var ulc=$("<ul><li>团体会员为您所在院校统一购买的服务，可直接使用</li><li>本服务提供心理测评、个人报告、推荐阅读等内容</li><li>本服务涵盖大学生在校期间的基本心理服务场景</li></ul>");
					if(data==1){//个人会员
						$(".group").html("团体会员")
						currency()
					}else if(data==2){//团体会员
						$(".group").html("会员")
						currency()
					}else if(data==3){//即使个人会员有是团体会员
						$(".group").html("团体会员")
						currency()
					}
					function currency(){
						$(".group").css("display","block");
						$("#vip-open").css("display","none")
						$(".vip-txt").html("您已开通会员服务")
						$(".vap-introduce-con").html(ulc)
					}
				},
				error:function(){
					mui.toast('网络错误...')
				}
			})
//			加载产品包
			mui.ajax(baseUrl+'/wanx/getProductList',{
				data:{
					channelId:1
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					console.log(data)
					var isMember=sessionStorage.getItem("isMember")
					for (var i=0; i<data.length; i++) {
//						状态图片
						function state(img){
							var state=$("<li packageId="+data[i].id+" userState="+data[i].userState+" discount="+data[i].discount+" packState="+data[i].packState+"><img src="+img+" alt=''/></li>")
							return state
						}
//						判断当前的产品包是付费的还是免费的
//						根据价钱显示不同的图片
//						判断是否是会员
						if(isMember==0){
							$("#product-box").append(state(data[i].unlockedpic));
						}else{
//							判断是否上架
							if(data[i].packState==1){
//								判断是否免费
								if(data[i].discount==0){
									$("#product-box").append(state(data[i].unlockpic));
								}else{
//									判断是否购买
									if(data[i].userState==0){
										$("#product-box").append(state(data[i].unlockedpic));
									}else if(data[i].userState==1){
										$("#product-box").append(state(data[i].unlockpic));
									}
								}
							}else if(data[i].packState==2){
								$("#product-box").append(state(data[i].pendingOpenPic));
							}
						}

					}
					callback()
				},
				error:function(){
					mui.toast('网络错误...')
				}
			
			})
			
//			弹窗
			rize();	
//			产品包点击事件
			document.getElementById("product-box").addEventListener("tap",function(){
				tag=event.target
				while(tag!=this){
					if(tag.tagName.toLowerCase()=="li"){
						break;
					}
					tag=tag.parentNode;
				}
				var data_packageId=tag.getAttribute("packageId");
//				获取是否购买状态码
				var data_state=tag.getAttribute("userState");
//				是否上架
				var packState=tag.getAttribute("packState");
//				是否免费
				var discount=tag.getAttribute("discount");
//				会员码
				var isMember=sessionStorage.getItem("isMember");
				if(data_packageId!=null||data_packageId!=undefined){
//					判断是否购买会员
					if(isMember==0){
//							根据窗口大小让弹窗居中
							$(window).resize(function () {
								if(!$(".open_vip-alert-con").is(":visible")){
									return
								}
							    rize();
							});
//							显示弹窗
							$(".open_vip-alert").css("display","block")
					}else{
//						判断是否上线
						if(packState==1){
//							判断是否免费
							if(discount==0){
								localStorage.setItem("listType","box")
								sessionStorage.setItem("packageId",data_packageId);
								sessionStorage.setItem("ispay",data_state);;
								jumpTo('paid_guide');
							}else{
//								判断是否购买
								if(data_state==0){
									localStorage.setItem("listType","box");
									sessionStorage.setItem("packageId",data_packageId);
									sessionStorage.setItem("ispay",data_state);
									jumpTo('paid_guide');
								}else if(data_state==1){
									localStorage.setItem("listType","box");
									sessionStorage.setItem("packageId",data_packageId);
									jumpTo('career_planning');
									
								}
								
							}
						}else{
							mui.toast("此产品包暂未上线");
						}
						
					}
//						
				}
			})

//			购买会员按钮跳转
			document.getElementById('vip-open-btn').addEventListener('tap',function(){
				window.location.href="pay_vip.html?version="+xdcVersion+"&pageType=1"
			})
			//点击按钮隐藏
			$(".vip-alert-btn").click(function(){
				$(".open_vip-alert").css("display","none")
			})
}
////////////////////////////////
////////////支付页js/////////////
///////////////////////////////
function paid_guide(callback){
	var productId=sessionStorage.getItem("packageId");
	var listType=localStorage.getItem("listType");
	var ajaxData={
	        Url: "",
	        data:{},
	        payData:{}
		}
		if(listType=="list"){
			var deliveryId=getDeliveryIdFromQueryString()
			ajaxData.Url="/wanx/getBootPageInfo";
			ajaxData.data.deliveryId=deliveryId;
			ajaxData.payData.contentType=1;
			ajaxData.payData.contentId=deliveryId
			mui.ajax(baseUrl+'/lightApp/weix/isPaid',{
				data:{
					deliveryId:deliveryId,
					channelId:2
				},
				type:'get',
				dataType:'json',
				timeout:10000,
				success:function(data){
					sessionStorage.setItem("isPaid",data)
				}
				
			})
		}else if(listType=="box"){
			ajaxData.Url="/wanx/getPageInfo";
			ajaxData.data.productId=productId;
			ajaxData.payData.contentType=3;
			ajaxData.payData.contentId=productId
		}
	
		console.log(ajaxData.Url)
	
		mui.ajax(baseUrl+ajaxData.Url,{
			data:ajaxData.data,
			type:'get',
			dataType:'json',
			timeout:10000,
			success:function(data){
				console.log(data)
				var isPaid=sessionStorage.getItem("isPaid");
				var banner="",title="",subtitle="",price="",discount="",attendNum="",tag1="",tag2="",tag3="",introduce="",author="",author_in="",success_page="",ispay="",payTag="",payBtn="";
				if(listType=="list"){
					banner+=data.picPath;//标题图
					title+=data.qnName;//标题
					subtitle+=data.subtitle;//副标题
					price+=data.discountInfo;//优惠信息
					discount+=data.price;//价钱
					attendNum+=data.answerNumber;//测试人数
					tag1+=data.payTag1;//标签
					tag2+=data.payTag2;//标签
					tag3+=data.payTag3;//标签
					introduce+=data.qnSummary;//介绍
					author_in+="作者语"
					author+="<div class='mui-row author-border'><div class='mui-col-xs-3'><div class='mui-row'><div class='mui-col-xs-5'></div><div class='mui-col-xs-4'><img src="+data.headImg+" alt='头像' class='portrait'/></div><div class='mui-col-xs-2'></div></div></div><div class='mui-col-xs-8 author-introduce'><span>"+data.authorName+"</span><p>"+data.introduce+"</p></div><div class='mui-col-xs-1'></div></div>"
					success_page+="assess_content"//成功页面
					if(isPaid==2){
						ispay+=1//购买状态0未购买，1是购买过的
					}else{
						ispay+=0
					}
					if(discount<=0){
						payTag+="免费"
						payBtn+="开始答题"
					}else{
						if(isPaid==2){
							payTag+="已购买"
						}
					}
				}else if(listType=="box"){
					banner+=data.picurl;//标题图
					title+=data.title;//标题
					subtitle+=data.subtitle;//副标题
					price+="原价"+data.price+"元";//优惠信息
					discount+=data.discount;//价钱
					attendNum+=data.attendNum;//测试人数
					tag1+=data.tag1;//标签
					tag2+=data.tag2;//标签
					tag3+=data.tag3;//标签
					introduce+=data.introduce;//介绍
					author_in+="产品介绍"
					success_page+="career_planning";//成功页面
					ispay+=isPaid;
					payTag+="限时免费"
					payBtn+="开始测试"
				}
				var banner=$("<div class='mui-row'><div class='mui-col-xs-12'><img src="+banner+" class='banner'/></div></div>")
//				题目信息
				var pay_con=$("<div class='mui-row mbottom'><div class='mui-col-xs-12 pay-details bg-color po-r'><ul><li class='pay-details-title'>"+title+"</li><li class='pay-details-txt'>"+subtitle+"</li><li class='pay-details-amount'><div><span class='price'>"+price+"</span><i><em>|</em><span class='yuan'>体验价"+discount+"元</span></i></div></li><li class='pay-details-num'>"+attendNum+"人已测试</li></ul></div></div>");
//				标签
				var pay_tag=$("<div class='mui-row pay-tags bg-color mbottom'><div class='mui-col-xs-4'>"+tag1+"</div><div class='mui-col-xs-4'>"+tag2+"</div><div class='mui-col-xs-4'>"+tag3+"</div></div>")
//				作者信息
				var author_border=$("<div class='mui-col-xs-12 pay-author-title'><div class='po-r'><p class='po-a'>"+author_in+"</p></div></div>")
				var qnSummary=$(author+"<div class='mui-col-xs-12 author-txt'><div>"+introduce+"</div><span id='txt-btn'><b><img src='img/pay/down.png'></b>更多介绍</span></div>")
				var pay_author=$("<div class='mui-row bg-color pay-author mbottom'></div>")
//				说明
				var notice=$("<div class='mui-row notice bg-color'><div class='mui-col-xs-12 pay-author-title'><div class='po-r'><p class='po-a'>测评须知</p></div></div><div class='mui-col-xs-12 notice-txt'><ul><li>本测试为心发现专家团队参照大学生实际情况改变</li><li>当您完成测试后，我们将提供一份专业个人测评报告</li><li>请根据您的真实情况作答，本报告不适用于临床诊断</li><li>本测试知识产权为新洞察拥有</li></ul></div></div>")
				pay_author.append(author_border,qnSummary);
				
				$('.mui-content').append(banner,pay_con,pay_tag,pay_author,notice);
				
				
				
				
				if(discount<=0){
					$(".pay-details-amount i").css("color","#43D13F");
					$(".pay-details-amount i span").html(payTag);
					$(".purchase a").html(payBtn);
					$('.purchase').click(function(){
						jumpTo(success_page);
					})
				}else{
					if(ispay==0){
						$('.purchase').click(function(){
							sessionStorage.setItem("title",title);//当前产品包标题
							sessionStorage.setItem("yuan",discount);//当前产品包价格
							mui.ajax(baseUrl+'/wanx/wanxPay',{//微信支付
								data:ajaxData.payData,
								type:'get',
								dataType:'json',
								timeout:10000,
								success:function(data){
									var orderInfo=JSON.parse(data.orderInfo);
									var pay_data= {};
							        pay_data.orderInfo=orderInfo;
							        pay_data.targetUrl="";
							        //转换为string
							        var dataStr=JSON.stringify(pay_data);
							        
						        	var schemeURI="wanxiao://17wanxiao.com?page=payway&iosLaunchType=iosLaunchTypeModal&data="+dataStr;
							        //跳转到scheme
							        window.location.href= schemeURI;
				//			                    把callback参数转换成对象
							        function toObject(a){
									    return (new Function('return ' + a))();
									};
								    
							        wanxiao.commonCallback(function(result){
									   var data=toObject(result);
				//					   code参数0代表支付成功其他为失败
									   if(data.code==0){
									   		jumpTo(success_page);
									   }else{
									   		mui.alert("支付失败","提示","确定",function(){
										   		jumpTo("paid_guide")
										   	})
									   }
									});
				
						        	
				
								},
								error:function(){
									mui.toast("网络错误...")
								}
							})
	
						})
					
					}else{
						$(".pay-details-amount i").css("color","#43D13F");
						$(".pay-details-amount i span").html(payTag);
						$(".purchase a").html(payBtn);
						$('.purchase').click(function(){
							jumpTo(success_page);
						})
					}
				}
				callback();
			},
			error:function(){
				mui.toast("网络错误...");
			}
		})



var a=true;
$("#txt-btn").live("tap",function () {
	if(a){
		$('.author-txt div').css('height','auto');
		$('#txt-btn').html('<b><img src="img/pay/up.png"></b>收起');
		a=false;
	}else{
		$('.author-txt div').css('height','.85rem');
		$('#txt-btn').html('<b><img src="img/pay/down.png"></b>更多介绍');
		a=true;
	}
});
}
////////////////////////////////
///////////产品包页js/////////////
///////////////////////////////
function career_planning(callback){
		var packageId=sessionStorage.getItem("packageId")//获取产品包id
//			加载产品包内容
			mui.ajax(baseUrl+'/wanx/getProductContentList',{
			data:{
				columId:1,
				packageId:packageId
			},
			type:'get',
			dataType:'json',
			timeout:10000,
			success:function(data){
				//头图和按钮加载
				var head=$("<div class='mui-row'><div class='mui-col-xs-12'><img src="+data.head[0].adImg+" alt='banner' class='banner'/></div></div><div class='mui-row bg-color mbottom column'><div class='mui-col-xs-5 scene_entrance'><div><img src='img/pay/u85.png' alt="+data.head[0].column1Name+" />"+data.head[0].column1Name+"</div></div><div class='mui-col-xs-5 video_entrance'><div><img src='img/pay/u61.png' alt="+data.head[0].column2Name+" />"+data.head[0].column2Name+"</div></div></div>");
				$(".mui-content").append(head);
//				//产品包内容主题
				var tweet=$("<div class='mui-row'><div class='mui-col-xs-12 ification-title bg-color'><img src='img/pay/u83.png' alt='基础测评' /><span>基础测评</span></div><div class='mui-col-xs-12 bg-color'><ul class='basic_evaluation' id='basic_evaluation'></ul></div></div>");
				$(".video_entrance").parent().after(tweet);
//				//创建tweet
				for (var i=0; i<data.tweet.length; i++){
					var tweet_con=$("<li deliveryId="+data.tweet[i].deliveryId+" qnId="+data.tweet[i].qnId+" qnType="+data.tweet[i].qnType+" answered="+data.tweet[i].answered+"><a href="+data.tweet[i].tweetUrl+"><div class='mui-row po-r basic_video'><div class='mui-col-xs-2'><img src="+data.tweet[i].picUrl+" alt='视频' class='icon_video'/></div><div class='mui-col-xs-8 basic-title'>"+data.tweet[i].title+"</div><div class='mui-col-xs-8 basic-author'><span>陈文静博士</span></div><img src='img/pay/u51.png' alt='球' class='basic-ball po-a'/></div></a></li>");
					$(".basic_evaluation").append(tweet_con);
				}
//				//创建测评
				for (var j=0; j<data.qn.length; j++) {
					var qn=$("<li deliveryId="+data.qn[j].deliveryId+" qnId="+data.qn[j].qnId+" qnType="+data.qn[j].qnType+" answered="+data.qn[j].answered+" class='basic_qn po-r'><div class='mui-row basic_qn-con'><div class='mui-col-xs-2'><img src="+data.qn[j].picUrl+" alt='缩略图' class='icon_img'/></div><div class='mui-col-xs-8 basic-title'>"+data.qn[j].title+"</div><div class='mui-col-xs-8 basic-author'><span>"+data.qn[j].authorName+"</span></div></div><div class='mui-row po-r basic_qn-tags'><div class='mui-col-xs-12 basic-tag'><p>推荐秘籍>></p></div></div><img src='img/pay/u21.png' alt='球' class='basic-ball po-a'/></li>");
					//判断$(".basic_evaluation")html()的空内容和非空内容的创建方式
					if($(".basic_evaluation").html()!=""){
						$(".basic_evaluation li:last-child").after(qn);
					}else{
						$(".basic_evaluation").append(qn);
					}
//					判断没打过的测试标签显示方式
					if(data.qn[j].answered==0){
						$(".basic_qn-tags").css("display","none");
						$(".basic_qn-con").css("padding-bottom",".446rem");
					}else{
//						判断推荐秘籍是否有内容
						if(data.qn[j].isRecommended==0){
							$(".basic_qn-tags").css("display","none");
							$(".basic_qn-con").css("padding-bottom",".446rem");
							$(".basic_qn .basic-ball").eq(j).attr("src","img/pay/true.png");
						}else{
							$(".basic_qn .basic-ball").eq(j).attr("src","img/pay/true.png");
						}
					}
//					
//					推荐秘籍点击事件
					$(".basic-tag p").live('tap',function(){
						sessionStorage.setItem("sourceId",$(this).parent().parent().parent().attr("deliveryid"));
						sessionStorage.setItem("columnNum",2);
						jumpTo("pay_column");
					})
//					测试题点击事件
					$(".basic_qn-con").live('tap',function(){
						var data_deliveryid=$(this).parent().attr("deliveryid");
						var data_qnid=$(this).parent().attr("qnid");
						var data_qntype=$(this).parent().attr("qntype");
						var data_answered=$(this).parent().attr("answered");
						if(data_deliveryid!=0){
							localStorage.setItem("fromPos","career_planning.html?=version"+xdcVersion)
							jumpToQn(data_qntype,data_answered,data_qnid,data_deliveryid);
						}
					})
					
				}

				//头部栏目的点击事件
				$(".column>div").live('tap',function(){
					sessionStorage.setItem("columnNum",$(this).index())
					jumpTo("pay_column");
				})
				
				
			callback()
			},
			error:function(){
				mui.toast("网络错误...");
			}
		})
}
