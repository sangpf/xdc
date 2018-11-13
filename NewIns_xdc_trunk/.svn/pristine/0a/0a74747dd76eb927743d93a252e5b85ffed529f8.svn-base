package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.ActivityService;
import com.newins.util.ErrorMessage;

/**
 * @Description 每日活动的controller，响应的url为 /wanx
 * @author Fanyuelin
 * @time May 15, 2016 12:15:49 PM
 */
@Controller
@RequestMapping("/wanx")
public class ActivityController {
	private static Logger log = Logger.getLogger(ActivityController.class);
	@Autowired
	private ActivityService activityService;

	/**
	 * @Title: getActivityInfo
	 * @Author: Guan
	 * @Description: TODO 活动页面List
	 * @param request
	 * @return Object
	 * @Time 2016年8月25日 下午2:02:15
	 */
	@RequestMapping(value = "/activityList", method = RequestMethod.GET)
	@ResponseBody
	public Object getActivityInfo(HttpServletRequest request) {
		log.info("this is controller: getActivityInfo()");
		
/*		  String userIdStr = request.getParameter("userId"); 
		  int user_Id =Integer.parseInt(userIdStr);*/
		  String activityTypeStr = request.getParameter("activityType"); 
		  int activityType =Integer.parseInt(activityTypeStr);
		 
			String pageStr = request.getParameter("page");
			int page = Integer.valueOf(pageStr);
			
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			return activityService.getActivityList(user_Id,activityType,page);
		} else {
			log.info("=======================>Activity page userId is null");
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		}
	}
}
