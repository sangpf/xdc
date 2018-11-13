package com.newins.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.SubmitAssessAnswerService;
import com.newins.util.AjaxResult;

/**
 * 递交测评答案的controller
 */
@Controller
@RequestMapping("/wanx")
public class SubmitAssessAnswerController {
	
	@Autowired
	private SubmitAssessAnswerService submitAssessAnsService;

	/**
	 *   测评问卷提交 
	 */
	@ResponseBody
	@RequestMapping("/saveAssessAnswer")
	public AjaxResult submitAssessAnswer(HttpServletRequest request) {
		
		return submitAssessAnsService.submitAssessAnswer(request);
		
	}
}
