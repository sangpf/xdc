package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.BootPageInfo;
import com.newins.model.IsBootPageInfo;
import com.newins.service.PaidQuestionnaireService;
import com.newins.util.ErrorMessage;



/**
 * 付费测评相关Controller
 * @author Zhangwenhao
 * @Time:2017-08-28
 */
@Controller
@RequestMapping("/wanx")
public class PaidQuestionnaireController {
	@Autowired(required=false)
	private PaidQuestionnaireService paidQuestionnaireService;
	@Autowired(required=false)
	private BootPageInfo bootPageInfo;
	/**
	 * 获取指定投放的测评问卷引导页信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getBootPageInfo",method=RequestMethod.GET)
	@ResponseBody
	public Object getBootPageInfo(HttpServletRequest request){
		//获取前端传递的deliveryId参数
		int deliveryId=Integer.parseInt(request.getParameter("deliveryId"));
		//调用相关方法
		bootPageInfo=paidQuestionnaireService.getBootInfo(deliveryId);
		//调用方法查询当前投放问卷的参与人数
		int answerNumber=paidQuestionnaireService.answerNumber(deliveryId);
		//判断实体是否为空
		if(bootPageInfo!=null){
			//将参与人数设置给实体类中
			bootPageInfo.setAnswerNumber(answerNumber);
		}
		//调用方法查询当前投放的测评问卷是否有付费信息
		IsBootPageInfo isBootPageInfo=paidQuestionnaireService.isHave(deliveryId);
		//判断查询的付费信息是否为空
		if(isBootPageInfo!=null){
			//进入这里说明有付费信息
			bootPageInfo.setIsHave(1);
		}else{
			//进入这里表示没有付费信息
			bootPageInfo.setIsHave(0);
		}
		//返回查询数据到前端
		return bootPageInfo; 
	}
	
	/**
	 * 查询当前用户是否购买当前投放的问卷
	 * @return
	 */
	@RequestMapping(value="/isPaid",method=RequestMethod.GET)
	@ResponseBody
	public Object isPaid(HttpServletRequest request){
		//获取session会话
		HttpSession session=request.getSession();
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		//获取前端传递的参数
		int deliveryId=Integer.parseInt(request.getParameter("deliveryId"));
		Integer channelId=Integer.parseInt(request.getParameter("channelId"));
		if(userId!=null){
			//将userId转为int类型
			//调用相关方法
			int resultNum=paidQuestionnaireService.isPaid(Integer.parseInt(userId.toString()), deliveryId,channelId);
			return resultNum;
		}else{
			//进入这里表示userId是空的返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			error.setSuccess("false");
			return error;
		}
	}
}
