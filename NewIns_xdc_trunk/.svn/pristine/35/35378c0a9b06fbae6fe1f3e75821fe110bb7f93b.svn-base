/**
 * 
 */
package com.newins.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.dao.SurveyResultMapper;
import com.newins.service.LoadSurveyQuestionnaireService;
import com.newins.util.AjaxResult;

/**
 * @Description 加载调查问卷页面controller层 url：wanx/loadSqn
 * @author Guan
 * @time 2016年6月28日 下午7:24:15
 */
@Controller
@RequestMapping("/wanx")
public class LoadSurveyQuestionnaireController {
	private static Logger log = Logger
			.getLogger(LoadSurveyQuestionnaireController.class);
	@Autowired
	@Qualifier("LoadSurveyQuestionnaireService")
	private LoadSurveyQuestionnaireService loadSvySqnService;
	@Autowired
	private SurveyResultMapper surveyResultMapper;

	/**
	 * @Title: LoadSurveyQuestionnaire
	 * @Author: Guan
	 * @Description: 根据问卷Id加载出相应的问卷内容
	 * @param sqnId
	 * @return SurveyQuestionnaire
	 * @Time 2016年6月30日 下午3:32:22
	 */
	@RequestMapping(value = "/loadSqn", method = RequestMethod.GET)
	@ResponseBody
	public Object LoadSurveyQuestionnaire(HttpServletRequest request) {
		log.info("this is controller: LoadSurveyQuestionnaire()");
		//String userId = request.getParameter("userId").trim();
		//int user_Id = Integer.parseInt(userId);
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			String sqnId = request.getParameter("sqnId").trim();
			int sqn_Id = Integer.parseInt(sqnId);
			String answered = request.getParameter("answered").trim();//是否答过（从结果页进入传入1，其余不传值）
			String sqnCategoryStr = request.getParameter("sqnCategory").trim();
			int sqnCategory = Integer.parseInt(sqnCategoryStr);
				return loadSvySqnService.loadSurveyQuestionnaire(sqn_Id,user_Id,answered,sqnCategory);
		} else return AjaxResult.errorResult("userId is null");

	}
}
