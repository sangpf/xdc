/**
 * 
 */
package com.newins.controller;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.UserContext;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.service.LogPersonalInfoService;
import com.newins.service.UtilService;
import com.newins.util.AjaxResult;

/**
 * @Description
 * @author Guan
 * @time 2017年1月16日 下午2:20:47
 */
@Controller
@RequestMapping("/wanx")
public class UtilController {

	private static final Logger log = Logger.getLogger(UtilController.class);

	// private static final Logger login = Logger.getLogger("login");
	private static final Logger advertise = Logger.getLogger("advertise");
	private static final Logger listSkip = Logger.getLogger("listSkip");
	private static final Logger qnAction = Logger.getLogger("qnAction");
	private static final Logger qnPageSkip = Logger.getLogger("qnPageSkip");
	private static final Logger reportAction = Logger.getLogger("reportAction");
	private static final Logger reportPageSkip = Logger
			.getLogger("reportPageSkip");
	private static final Logger awardAction = Logger.getLogger("awardAction");
	private static final Logger awardPageSkip = Logger
			.getLogger("awardPageSkip");
	private static final Logger personalAction = Logger
			.getLogger("personalAction");
	private static final Logger personalPageSkip = Logger
			.getLogger("personalPageSkip");

	@Resource
	private UtilService utilService;
	@Autowired
	private LogPersonalInfoService logPersonalInfoService;

	/**
	 * @Title: updateRelatedUrl
	 * @Author: Guan
	 * @Description: TODO 用于上线部署前通过浏览器出发- 更新相关推荐
	 * @return AjaxResult
	 * @Time 2017年1月16日 下午2:31:42
	 */
	@RequestMapping(value = "/updateRelatedUrl", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult updateRelatedUrl(HttpServletRequest request) {
		String version = request.getParameter("version");
		String qnTypeStr = request.getParameter("qnType");
		int qnType = Integer.parseInt(qnTypeStr);
		// try {
		utilService.updateRelatedUrl(version, qnType);
		/*
		 * } catch (Exception e) { return AjaxResult.errorResult("error"); }
		 */
		return AjaxResult.successResult("related url is updated");

	}

	/**
	 * @Title: addLog
	 * @Author: Guan
	 * @Description: 添加日志
	 * @param request
	 *            void
	 * @Time 2017年3月16日 下午3:18:44
	 */
	@RequestMapping(value = "/addLog", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addLog(HttpServletRequest request) {
		UserContext userContext = null;
		String comment = null;
		String logType = request.getParameter("logType"); // 日志类型
		String version = request.getParameter("version"); // 版本号
		String channel = request.getParameter("channel"); // 渠道
		String action = request.getParameter("action"); // 行为代码
		String actResult = request.getParameter("actResult"); // 行为结果
		String sourcePage = request.getParameter("sourcePage"); // 来源页面
		String targetPage = request.getParameter("targetPage"); // 目标页面
		Timestamp time = new Timestamp(System.currentTimeMillis());
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
		int userId = 0;
		if (userIdObj != null) {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		} // 用户Id

		String accseeToken = (String) session.getAttribute("access_Token");
		userContext = new UserContext(accseeToken);// 根据token获取用户信息

		String detailUserInfo = userContext.getDetailUserInfo();
		JSONObject fromObject1 = JSONObject.fromObject(detailUserInfo);
		//if (fromObject1.toString().contains("errorCode")) {
		//.info("================>>当前登录用户我们无权限获取详细信息!!");
		//	return AjaxResult.successInfo("false", "无权获取用户详细信息");
	//	} else {
			// openid
			// 1.广告日志
			if (logType == "advertise" || logType.equals("advertise")) {
				String adId = request.getParameter("adId");// 广告Id
				String adTitle = request.getParameter("adTitle");// 广告名称
				String adPosCode = request.getParameter("adPosCode");// 广告位编码
				advertise.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ action + "\"    \"" + adPosCode + "\"    \"" + adId
						+ "\"    \"" + adTitle + "\"    \"" + comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 2.List跳转
			else if (logType == "listSkip" || logType.equals("listSkip")) {

				listSkip.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ sourcePage + "\"    \"" + targetPage + "\"    \""
						+ comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 3.问卷行为
			else if (logType == "qnAction" || logType.equals("qnAction")) {
				String deliveryId = request.getParameter("deliveryId");// 投放Id
				String qnId = request.getParameter("qnId");// 问卷Id
				String qnType = request.getParameter("qnType");// 问卷种类
				qnAction.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \"" + deliveryId
						+ "\"    \"" + qnId + "\"    \"" + qnType + "\"    \""
						+ action + "\"    \"" + actResult + "\"    \""
						+ comment + "\"");
				return AjaxResult.successInfo("true", "success add log");

			}// 4.问卷页面跳转
			else if (logType == "qnPageSkip" || logType.equals("qnPageSkip")) {
				String deliveryId = request.getParameter("deliveryId");// 投放Id
				String qnId = request.getParameter("qnId");// 问卷Id
				String qnType = request.getParameter("qnType");// 问卷种类
				qnPageSkip.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ sourcePage + "\"    \"" + targetPage + "\"    \""
						+ deliveryId + "\"    \"" + qnId + "\"    \"" + qnType
						+ "\"    \"" + comment + "\"");
				return AjaxResult.successInfo("true", "success add log");

			}// 5.报告行为
			else if (logType == "reportAction"
					|| logType.equals("reportAction")) {
				String reportId = request.getParameter("reportId");// 报告Id
				reportAction.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ reportId + "\"    \"" + action + "\"    \""
						+ actResult + "\"    \"" + comment + "\"");
				return AjaxResult.successInfo("true", "success add log");

			}// 6.报告页面跳转
			else if (logType == "reportPageSkip"
					|| logType.equals("reportPageSkip")) {
				String reportId = request.getParameter("reportId");// 投放Id
				reportPageSkip.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ sourcePage + "\"    \"" + targetPage + "\"    \""
						+ reportId + "\"    \"" + comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 7.奖励行为
			else if (logType == "awardAction" || logType.equals("awardAction")) {
				awardAction.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ action + "\"    \"" + actResult + "\"    \""
						+ comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 8.奖励行为页面跳转
			else if (logType == "awardPageSkip"
					|| logType.equals("awardPageSkip")) {
				String deliveryId = request.getParameter("deliveryId");// 投放Id
				String qnId = request.getParameter("qnId");// 问卷Id
				awardPageSkip.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ sourcePage + "\"    \"" + targetPage + "\"    \""
						+ deliveryId + "\"    \"" + qnId + "\"    \"" + comment
						+ "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 9.我的-行为
			else if (logType == "personalAction"
					|| logType.equals("personalAction")) {
				personalAction.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ action + "\"    \"" + actResult + "\"    \""
						+ comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}// 10.用户中心跳转情况
			else if (logType == "personalPageSkip"
					|| logType.equals("personalPageSkip")) {
				personalPageSkip.info("\"" + version + "\"    \"" + channel
						+ "\"    \"" + time + "\"    \"" + userId + "\"    \""
						+ sourcePage + "\"    \"" + targetPage + "\"    \""
						+ "\"    \"" + comment + "\"");
				return AjaxResult.successInfo("true", "success add log");
			}else
				return AjaxResult.successInfo("false", "parameter error");

		//}
	}

	/**
	 * @Title: getIpAddr
	 * @Author: Guan
	 * @Description: 根据http请求获取用户Ip地址
	 * @param request
	 * @return String
	 * @Time 2017年3月24日 下午3:22:56
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = null;
		Enumeration enu = request.getHeaderNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			if (name.equalsIgnoreCase("X-Forwarded-For")) {
				ip = request.getHeader(name);
			} else if (name.equalsIgnoreCase("Proxy-Client-IP")) {
				ip = request.getHeader(name);
			} else if (name.equalsIgnoreCase("WL-Proxy-Client-IP")) {
				ip = request.getHeader(name);
			}

			if ((ip != null) && (ip.length() != 0))
				break;

		}

		if ((ip == null) || (ip.length() == 0))
			ip = request.getRemoteAddr();

		return ip;
	}

}
