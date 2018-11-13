package com.newins.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.SubmitAssessAnswerService;
import com.newins.util.AjaxResult;

/**
 * @Description 查找测评结果 ,用于当用户答过某题，在列表中点击该题直接跳转到测评结果页
 * @author Guan
 * @time 2016年8月18日 下午4:16:39
 */
@Controller
@RequestMapping("/wanx")
public class CheckAssessResultController {
	private static Logger log = Logger.getLogger(CheckAssessResultController.class);
	
	@Autowired
	private SubmitAssessAnswerService submitAssessAnswerService;

	/**
	 * 查询测评结果页  ,用于当用户答过某题，在列表中点击该题直接跳转到测评结果页
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/checkAssessResult")
	public AjaxResult checkAssessResultFromSimple(HttpServletRequest request) {
		
		return submitAssessAnswerService.getAssessResultFromOrder(request);

	}
}
