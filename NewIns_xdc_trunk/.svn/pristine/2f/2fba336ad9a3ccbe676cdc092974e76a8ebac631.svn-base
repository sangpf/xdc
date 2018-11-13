package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.GiveRedeemCodeService;
import com.newins.util.ErrorMessage;

/**
 * 获取口粮兑换码并修改其相关状态
 * @author zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class GetRedeemCodeDoSomthingController {
	//创建日志对象
	private Logger logger=Logger.getLogger(this.getClass());
	//使用注解自动绑定相关Service
	@Autowired
	private GiveRedeemCodeService giveRedeemCodeService;
	
	@RequestMapping(value="/giveRedeemCode",method=RequestMethod.GET)
	@ResponseBody
	public Object GetRedeemCodeAndUpdateRedeemCodStauts(HttpServletRequest request){
		//创建接收Servic返回的数据JSON格式
		JSONObject jsonObject=new JSONObject();
		//声明接收前端的变量
		String phoneNum=null;
		int awardId=0;
		//获取session
		HttpSession session=request.getSession();
		//获取前端数据
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		phoneNum=request.getParameter("phoneNum");
		awardId=Integer.parseInt(request.getParameter("awardId").toString());
		if(userId!=null&&phoneNum!=null&&awardId!=0){
			//把userId转换成需要的格式
			int newuserId=Integer.parseInt(userId.toString());
			jsonObject =giveRedeemCodeService.giveRedeemCode(newuserId, phoneNum,awardId);
		}else{
			//返回错误信息
			ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrCode("002");
			errorMessage.setErrInfo(" userId is null");
			errorMessage.setSuccess("false");
			return errorMessage;
		}
		
		return jsonObject;
	}
	
}
