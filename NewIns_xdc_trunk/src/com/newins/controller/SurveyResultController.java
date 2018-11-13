package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.SurveyResultService;
import com.newins.util.AjaxResult;

/**@Description  
 * @author Guan
 * @time 2016年10月11日 下午2:21:49
 */
@Controller
@RequestMapping("/wanx")
public class SurveyResultController {
	private static Logger log = Logger.getLogger(SurveyResultController.class);
	@Autowired
	private SurveyResultService surveyResultService;
	/**
	 * @Description: 加载调查问卷结果页触发接口，获取知识总分型问卷答题结果
	 */
	@RequestMapping(value = "/getSurveyAnswerResult", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Object getSurveyAnswerResult(HttpServletRequest request) {
		
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		
		if (userId != null) {
			
			int user_Id = Integer.parseInt(userId.toString());
			String sqnId = request.getParameter("sqnId").trim();
			int sqn_Id = Integer.parseInt(sqnId);
			String sqnCategoryStr = request.getParameter("sqnCategory").trim();
			int sqnCategory = Integer.parseInt(sqnCategoryStr);
			return surveyResultService.getSurveyAnswerResult(user_Id, sqn_Id, sqnCategory);
			
		} else{
			return AjaxResult.errorResult("userId is null");
		}
	}
	
	/**
	 * @Title: getKeyQuestionResult  
	 * @Author: Guan
	 * @Description: 加载调查问卷结果页触发接口，获取核心题统计结果
	 * @param request
	 * @return Object 
	 * @Time 2016年10月11日 下午2:35:54
	 */
	@RequestMapping(value = "/getSurveyKeyQuestionResult", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Object getSurveyKeyQuestionResult(HttpServletRequest request) {
		log.info("This is controller getSurveyKeyQuestionResult");
	//	String userId = request.getParameter("userId").trim();
		//		int user_Id = Integer.parseInt(userId);
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			String sqnIdStr = request.getParameter("sqnId").trim();
			int sqnId = Integer.parseInt(sqnIdStr);
			String deliveryIdStr = request.getParameter("deliveryId").trim();
			int deliveryId = Integer.parseInt(deliveryIdStr);
			String keyQuestionNumStr = request.getParameter("keyQuestionNum").trim();
			int keyQuestionNum = Integer.parseInt(keyQuestionNumStr);
			return surveyResultService.getSurveyKeyQuestionResult(sqnId, keyQuestionNum,deliveryId,user_Id);
		}else{
			return AjaxResult.errorResult("userId is null");
		}
	}

}
