(function(){
	
	//mui组件初始化
	mui.init();
	//隐藏login动画
 	hideLoading();
})


 
//###################
// 验证完整性返回数据类#
//###################
function checkResult(rtest,rtext){
	this.rtest=rtest;
	this.rtext=rtext;
}



//################################
//编写验证完整性返回数据类的构造函数#
//################################
checkResult.prototype={
	//编写本类构造
	constructor:checkResult,
	//封装getter方法
	getRtest:function(){
		return this.rtest;
	},
	getRtext:function(){
		return this.rtext;
	}
}



//##################
//弹出省份选择器    #
//##################
//监听省份点击弹出选择器
function click_Province(){
		//初始化picker组件
		var picker=new mui.PopPicker({layer:2});
		//给picker对象添加数据
		picker.setData(init_city_picker);
		//显示选择器组件
		picker.show(function(items){	
			//获取被选中的项--返回值是数组
			var checked_sex=picker.getSelectedItems();
			//将被选中的项赋值给展示页面
			document.getElementById("item_Province").innerHTML=(items[0] || {}).text;
			//城市不允许独自选择，只允许选择省份的时候选择后给城市栏位设置值
			document.getElementById("item_city").innerHTML=(items[1] || {}).text;
			//把省份文字改成黑色显示
			document.getElementById("item_Province").style.color='black';
			//把城市文字改成黑色显示
			document.getElementById("item_city").style.color='black';
			
		});
};




//##################
//    弹出性别选择器#
//##################
//监听性别点击弹出选择器
function click_sex(){
				//初始化picker组件
				var picker=new mui.PopPicker();
				//给picker对象添加数据
				picker.setData([
					{value:"男",text:"男" },
					{value:"女",text:"女"}
				])
				//显示选择器组件
				picker.show(function(items){	
					//获取被选中的项--返回值是数组
					var checked_sex=picker.getSelectedItems();
					//循环遍历数组得到值
					mui.each(checked_sex,function(index,obj){
						
					//把文字从灰色改成黑色
					document.getElementById("item_sex").style.color="black";
					//将被选中的项赋值给展示页面
					document.getElementById("item_sex").innerHTML=obj.value;
					})
					
				});
};




//##################
//验证性别是否为空  #
//##################
function check_sex_isNull(){
	var sex=document.getElementById("item_sex").innerHTML;
	if(sex=='请选择性别'){
		//实例checkResult化类对象
		var checkresult=new checkResult(false,'性别不能为空！');
		return checkresult;
	}else{
		var checkresult=new checkResult(true,'');
		return checkresult;
	}
}




//##################
//验证年龄是否为空  #
//##################
function check_age_isNull(){
	var age=document.getElementById("item_age").value;
	if(age==''){
		//实例checkResult化类对象
		var checkresult=new checkResult(false,'年龄不能为空！');
		 return checkresult;
	}else if(checkAllNumber(age)==false){
		var checkresult=new checkResult(false,'年龄必须是数字！');
		 return checkresult;
	}if (checkIsNumber(age)==false){
		var checkresult=new checkResult(false,'年龄不能是0开头！');
		 return checkresult;
	}else {
		var checkresult=new checkResult(true,'');
		 return checkresult;
	}
	
}




//######################
//验证省份和城市是否为空 #
//######################
function check_city_Province_isNull(){
	var Province=document.getElementById("item_Province").innerHTML;
	var city=document.getElementById("item_city").innerHTML;
	if(Province=='请选择省份'||city=='请选择城市'){
		//实例checkResult化类对象
		var checkresult=new checkResult(false,'省份和城市不能为空！');
		return checkresult;
	}else{
		var checkresult=new checkResult(true,'');
		return checkresult;
	}
}




//###################
//点击确认按钮提交数据#
//###################
function submit_data(){
	//创建checkresult类实例
	var checkresult=new checkResult();
	//接收验证性别的返回值
	//提取出返回值对象的rtest属性
	var sex_test=check_sex_isNull().getRtest();
	//接收验证年龄的返回值
	//提取出返回值对象的rtest属性
	var age_test=check_age_isNull().getRtest();
	//接收验证省份和地区的返回值
	//提取出返回值对象的rtest对象
	var city_Province_test=check_city_Province_isNull().getRtest();
	//判断性别是否可以提交
	if(sex_test==false){
		//进入这里表示不可以提交显示出性别的错误提示文本
		mui.toast(check_sex_isNull().getRtext());
	//判断年龄是否可以提交
	}else if(age_test==false){
		//进入这里表示不可以提交显示出年龄的错误提示文本
		mui.toast(check_age_isNull().getRtext());
	//判断地区和省份是否可以提交
	}else if(city_Province_test==false){
		//进入这里表示不可以提交显示出地区和省份的错误提示文本
		mui.toast(check_city_Province_isNull().getRtext());
	}else{
		//进入这里表示可以请求接口完成提交操作
		//1.用mui.ajax请求保存采集也信息接口
		//1.1.获取要提交的数据
		//1.1.1.获取性别值
		var sex=document.getElementById("item_sex").innerHTML;
		//1.1.2.获取年龄
		var age=document.getElementById("item_age").value;
		//1.1.3.获取省份
		var Province=document.getElementById("item_Province").innerHTML;
		//1.1.4.获取地区
		var city=document.getElementById("item_city").innerHTML;
		//1.2.使用ajax请求保存采集信息接口
		mui.ajax(baseUrl+'/wanx/saveGather',{
			data:{
				sex:sex,
				age:age,
				province:Province,
				city:city
			},
			dataType:'json',
			type:'POST',
			timeout:10000,
			success:function(data){
				//请求成功的业务逻辑
				//1.判断用户是否提交成功
				if(data.success==true){
					//1.1.进入这里表示提交成功
					//1.2.给用户一个提示
					mui.toast(data.comments)
					//1.3.延迟2秒跳转到库润问卷列表页
					jumpTo('kurun_list');
				}else{
					//1.1.1.进入这里表示提交失败，后台接口有异常，同样提示用户
					mui.toast(data.comments)
				}
			},
			error: function() {
			//进入这里表示请求失败了
			//给用户一个提示
            mui.toast('网络错误...');
        		}
		})
	}
}




//###################
//点击重置		    #
//###################
function reset(){
		//将性别重置
		document.getElementById("item_sex").innerHTML="请选择性别";
		//把性别文字从黑色改成灰色
		document.getElementById("item_sex").style.color="darkgray";
		//将年龄重置
		document.getElementById("item_age").value='';
		//将省份重置
		document.getElementById("item_Province").innerHTML="请选择省份";
		//将城市重置
		document.getElementById("item_city").innerHTML="请选择城市";
		//把省份文字改成灰色显示
		document.getElementById("item_Province").style.color='darkgray';
		//把城市文字改成灰色显示
		document.getElementById("item_city").style.color='darkgray';
};