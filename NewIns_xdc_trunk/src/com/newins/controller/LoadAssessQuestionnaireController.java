/**
 * 
 */
package com.newins.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.LoadAssessQuestionnaireService;

/**
 * @Description 加载测评问卷页面controller层 url：wanx/loadAqn
 * @author Guan
 * @time 2016年6月28日 下午7:24:15
 */
@Controller
@RequestMapping("/wanx")
public class LoadAssessQuestionnaireController {
	private static Logger log = Logger.getLogger(LoadAssessQuestionnaireController.class);
	
	@Autowired
	@Qualifier("LoadAssessQuestionnaireService")
	private LoadAssessQuestionnaireService loadAqnService;

	/**
	 * @Title: LoadAssessQuestionnaire
	 * @Author: Guan
	 * @Description: 根据问卷Id加载出相应的问卷内容
	 * @param aqnId
	 * @return SurveyQuestionnaire
	 * @Time 2016年6月30日 下午3:32:22
	 */
	@RequestMapping(value = "/loadAqn", method = RequestMethod.GET)
	@ResponseBody
	public Object LoadAssessQuestionnaire(int aqnId) {
		
		return loadAqnService.loadAssessQuestionnaire(aqnId);
	}
}
