package com.newins.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.MyCognitionModel;
import com.newins.service.MyCognitionService;
import com.newins.util.ErrorMessage;

/**
 * @Description 
 * @author 星仔
 * @time 2017年2月21日下午3:35:56
 */
@Controller
@RequestMapping("wanx")
public class MyCognitionController {
	@Autowired
	@Qualifier("myCognitionService")
	private MyCognitionService myCognitionService;

	public MyCognitionService getMyCognitionService() {
		return myCognitionService;
	}

	public void setMyCognitionService(MyCognitionService myCognitionService) {
		this.myCognitionService = myCognitionService;
	}
	
	@RequestMapping("myCognitionIndex")
	@ResponseBody
	public Object getMyCognition(HttpServletRequest request){
		HttpSession session = request.getSession();
		Object oUserId = session.getAttribute("userId");
		
//		String oUserId = request.getParameter("userId");//测试
		
		if (oUserId!=null) {
			int userId = Integer.parseInt(oUserId.toString());
			
//			int userId = Integer.parseInt(oUserId);
			
			//调用service方法得到数据
			MyCognitionModel myCognitionList = myCognitionService.getMyCognitionList(userId);
	
			return myCognitionList;
		}else {
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
	}
}
