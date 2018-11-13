
package com.newins.controller;


import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.MyAssessService;
import com.newins.util.ErrorMessage;
/**
 * @Description 
 * @author 星仔
 * @time 2017年2月17日上午11:34:39
 */

@Controller
@RequestMapping("/wanx")
public class MyAssessController {
	private static Logger log = Logger.getLogger(AssessController.class);
	@Autowired
	@Qualifier("myAssessService")
	private MyAssessService myAssessService;

	public MyAssessService getMyAssessService() {
		return myAssessService;
	}

	public void setMyAssessService(MyAssessService myAssessService) {
		this.myAssessService = myAssessService;
	}
	
	/**
	 * @Description 调用service处理过的数据
	 * @return
	 */
	@RequestMapping("/myAssess")
	@ResponseBody
	public Object getMyAssess(HttpServletRequest request){
		
		log.info("this is controller: getMyAssessList()");
		
//		session接收前端传来的参数
		HttpSession httpSession = request.getSession();
		Object oUserId = httpSession.getAttribute("userId");
		
//		String oUserId = request.getParameter("userId");
		
		//判断传来的userId数据是否为空
		if (oUserId!=null) {
//			int userId = Integer.parseInt(request.getParameter("userId"));
//			int page = Integer.parseInt(request.getParameter("page"));
			
			int userId = Integer.parseInt(oUserId.toString());
			Object oPage = request.getParameter("page");
			int page = Integer.parseInt(oPage.toString());
			//调用service方法
			Object myAssessList = myAssessService.getMyAssessList(userId, page);
		
			return myAssessList;
		}else{
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		
	}
	
}
