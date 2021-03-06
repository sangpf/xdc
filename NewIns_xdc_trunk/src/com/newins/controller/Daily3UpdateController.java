package com.newins.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.Daily3UpdateService;
import com.newins.service.NiUserIdentiferService;
import com.newins.util.AjaxResult;

/**
 * @Description 每日三更的controller，响应的url为 /wanx
 * @author Fanyuelin
 * @time May 15, 2016 12:15:49 PM
 */
@Controller
@RequestMapping("/wanx")
public class Daily3UpdateController {
	private static Logger log = Logger.getLogger(Daily3UpdateController.class);
	@Autowired
	private Daily3UpdateService daily3UpdateService;
	@Resource
	private NiUserIdentiferService niUserIdentiferService;
	
	/**
	 * 加载每日三更的list，响应的url为 /wanx/daily3UpdateList
	 */
	@RequestMapping(value = "/daily3UpdateList", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getDaily3UpdateInfo(HttpServletRequest request,HttpServletResponse response) {
		log.info("======================>>首页加载三更列表...");
		HttpSession session = request.getSession(true);
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Object userIdObj = session.getAttribute("userId");
		String pageStr = request.getParameter("page");
		int page = Integer.valueOf(pageStr);
		String qnListCategory = request.getParameter("qnListCategory");
		
		if(userIdObj==null){
			return AjaxResult.errorCode("userId is null", "001");
		}
		else{
			int userId = Integer.parseInt(String.valueOf(userIdObj));
			return daily3UpdateService.getDaily3UpdateList(userId,page,qnListCategory);
			
		}
		
	}
	
	/**
	 * 更新用户信息
	 * @param request
	 */
	@RequestMapping(value ="/updateUserInfo", method = RequestMethod.GET)
	@ResponseBody
	public String updateUserInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		
		Object detailUserInfo_obj = session.getAttribute("detailUserInfo");
		
		String detailUserInfo = "";
		if(detailUserInfo_obj != null){
			detailUserInfo = detailUserInfo_obj.toString();
		}
		
		try {
			niUserIdentiferService.updateUserInfo(detailUserInfo,session);
			return "true";
		} catch (Exception e) {
			log.info("===========================updateUserInfo 出现异常");
			e.printStackTrace();
			return "false";
		}
	}
}
