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

import com.newins.service.AssessService;
import com.newins.util.ErrorMessage;

/**
 * @Description 加载测评问卷列表的controller
 * @author Guan
 * @time 2016年6月17日 下午7:24:01
 */
@Controller
@RequestMapping("/wanx")
public class AssessController {
	private static Logger log = Logger.getLogger(AssessController.class);
	@Autowired
	@Qualifier("AssessService")
	private AssessService assessService;

	/**
	 * @Title: getAssessInfo
	 * @Author: Guan
	 * @Description: 加载测评列表controller，对应url为/assessList
	 * @return List<Assess>
	 * @Time 2016年6月20日 下午1:10:35
	 */
	@RequestMapping(value = "/assessList", method = RequestMethod.GET)
	@ResponseBody
	public Object getAssessInfo(HttpServletRequest request) {
		// System.out.println("this is controller: getAssessInfo()");
		log.info("this is controller: getAssessInfo()");
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		
		String pageStr = request.getParameter("page");
		int page = Integer.valueOf(pageStr);
		
//		 String userId = request.getParameter("userId"); 
		String assessListCategory=request.getParameter("assessListCategory").toString();
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			Object assessList = assessService.getAssessList(user_Id,page,assessListCategory);
			return assessList;
		} else {
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("002");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
//		return assessService.getAssessList(1, 1);
	}
}
