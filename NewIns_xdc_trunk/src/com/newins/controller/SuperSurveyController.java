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

import com.newins.service.SuperSurveyService;
import com.newins.util.ErrorMessage;

/**
 * @Description 加载超级调查列表的controller,相应的Url为/wanx
 * @author Guanziao
 * @time 2016年5月17日 下午7:26:46
 */
// 该controller负责响应url中包含/wanx的url
@Controller
@RequestMapping("/wanx")
public class SuperSurveyController {
	private static Logger log = Logger.getLogger(SuperSurveyController.class);
	@Autowired
	@Qualifier("SuperSurveyService")
	private SuperSurveyService superSvyService;

	/**
	 * @Title: getSuperSurveyinfo
	 * @Author: Guan
	 * @Description: 加载超级调查列表，相应的url为 /wanx/supertList
	 * @return List<SuperSurvey>
	 * @Time 2016年5月17日 下午7:27:53
	 */
	@RequestMapping(value = "/superList", method = RequestMethod.GET)
	@ResponseBody
	public Object getSuperSurveyinfo(HttpServletRequest request) {
		log.info("this is controller: getSuperSurveyinfo()");

		// String userId = request.getParameter("userId"); int user_Id =
		// Integer.parseInt(userId);

		String pageStr = request.getParameter("page");
		int page = Integer.parseInt(pageStr);

		String superListCategory = request.getParameter("superListCategory"); // n宫格

		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			Object supsvy = superSvyService.getSuperSurveyList(user_Id, page,
					superListCategory);
			return supsvy;
		} else {
			log.info("=======================>SuperSurvey page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("002");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		// return superSvyService.getSuperSurveyList(1,1);
	}
}
