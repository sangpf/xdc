package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.MyAwardService;
import com.newins.util.ErrorMessage;
/**
 * @Description 
 * @author 星仔
 * @time 2017年2月17日上午11:34:39
 */

@Controller
@RequestMapping("/wanx")
public class MyAwardController {
	@Autowired
	@Qualifier("myAwardService")
	private MyAwardService myAwardService;

	public MyAwardService getMyAwardService() {
		return myAwardService;
	}

	public void setMyAwardService(MyAwardService myAwardService) {
		this.myAwardService = myAwardService;
	}
	
	/**
	 * @Description 调用service处理过的数据
	 * @return
	 */
	@RequestMapping("/myAward")
	@ResponseBody
	public Object getMyAward(HttpServletRequest request){
		
		HttpSession httpSession = request.getSession();
		Object oUserId = httpSession.getAttribute("userId");
		
//		String oUserId = request.getParameter("userId");
		
		//判断传来的数据是否为空
		if (oUserId!=null) {
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			int page = Integer.parseInt(request.getParameter("page"));
			
			int userId = Integer.parseInt(oUserId.toString());
			Object oPage = request.getParameter("page");
			int page = Integer.parseInt(oPage.toString());
			
			Object myAwardList = myAwardService.getMyAwardList(userId, page);			
			return myAwardList;
		}else{
			
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		
	}
	
}
