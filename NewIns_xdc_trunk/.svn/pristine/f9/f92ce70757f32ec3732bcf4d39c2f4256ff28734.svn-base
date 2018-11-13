package com.newins.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.NiAssessDeliveryWanxFlow;
import com.newins.model.NiReportFlow;
import com.newins.model.NiSurveyDeliveryWanxFlow;
import com.newins.model.NiVoteWanxFlow;
import com.newins.service.FlowStatisticsService;
import com.newins.util.ErrorMessage;

/**
 * 
 * @author wanq
 * @Description 报告列表的controller,相应的Url为/wanx
 * @time 2016年10月11日
 */
@Controller
@RequestMapping("/wanx")
public class FlowStatisticsController {
	private static Logger log = Logger
			.getLogger(FlowStatisticsController.class);
	@Resource
	private FlowStatisticsService flowStatisticsService;

	/**
	 * @Description 调查问卷玩校投放点击
	 * @param request
	 * @return
	 */
	@RequestMapping("/addSurveyDeliveryWanxFlowRecord")
	@ResponseBody
	public Object addSurveyDeliveryWanxFlowRecord(HttpServletRequest request) {
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
//		 String userId = request.getParameter("userId");
		String deliveryIdStr = request.getParameter("deliveryId");
		String tapSourceStr = request.getParameter("tapSource");
		if (userId != null) {
			if (deliveryIdStr != null) {
				NiSurveyDeliveryWanxFlow niSurveyDeliveryWanxFlow = new NiSurveyDeliveryWanxFlow();
				int user_id = Integer.parseInt(userId.toString());
				int deliveryId = Integer.parseInt(deliveryIdStr.trim());
				int tapSource = Integer.parseInt(tapSourceStr.trim());
				Timestamp tapTime = new Timestamp(System.currentTimeMillis());
				niSurveyDeliveryWanxFlow.setUserId(user_id);
				niSurveyDeliveryWanxFlow.setDeliveryId(deliveryId);
				niSurveyDeliveryWanxFlow.setTapTime(tapTime);
				niSurveyDeliveryWanxFlow.setTapSource(tapSource);
				flowStatisticsService
						.insertNiSurveyDeliveryWanxFlow(niSurveyDeliveryWanxFlow);
			} else {
				log.info("=======================>Assess page deliveryId is null");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("007");// ????
				errormsg.setErrInfo("deliveryId is null");
				return errormsg;
			}
		} else {
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		return "{\"success\":\"true\",\"comments\":\"add Survey Delivery Wanx Flow Record successfully\"}";
	}

	/**
	 * @Description 测评问卷玩校投放点击
	 * @param request
	 * @return
	 */
	@RequestMapping("/addAssessDeliveryWanxFlowRecord")
	@ResponseBody
	public Object addAssessDeliveryWanxFlowRecord(HttpServletRequest request) {
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
//		 String userId = request.getParameter("userId");
		String deliveryIdStr = request.getParameter("deliveryId");
		String tapSourceStr = request.getParameter("tapSource");
		if (userId != null) {
			if (deliveryIdStr != null) {
				NiAssessDeliveryWanxFlow niAssessDeliveryWanxFlow = new NiAssessDeliveryWanxFlow();
				int user_id = Integer.parseInt(userId.toString());
				int deliveryId = Integer.parseInt(deliveryIdStr.trim());
				int tapSource = Integer.parseInt(tapSourceStr.trim());
				Timestamp tapTime = new Timestamp(System.currentTimeMillis());
				niAssessDeliveryWanxFlow.setUserId(user_id);
				niAssessDeliveryWanxFlow.setDeliveryId(deliveryId);
				niAssessDeliveryWanxFlow.setTapTime(tapTime);
				niAssessDeliveryWanxFlow.setTapSource(tapSource);
				flowStatisticsService
						.insertNiAssessDeliveryWanxFlow(niAssessDeliveryWanxFlow);
			} else {
				log.info("=======================>Assess page deliveryId is null");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("007");// ????
				errormsg.setErrInfo("deliveryId is null");
				return errormsg;
			}
		} else {
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		return "{\"success\":\"true\",\"comments\":\"add Assess Delivery Wanx Flow Record successfully\"}";
	}

	/**
	 * @Description 投票问卷玩校投放点击
	 * @param request
	 * @return
	 */
	@RequestMapping("/addVoteWanxFlowRecord")
	@ResponseBody
	public Object addVoteWanxFlowRecord(HttpServletRequest request) {
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
//		 String userId = request.getParameter("userId");
		String deliveryIdStr = request.getParameter("deliveryId");
		String tapSourceStr = request.getParameter("tapSource");
		if (userId != null) {
			if (deliveryIdStr != null) {
				NiVoteWanxFlow niVoteWanxFlow = new NiVoteWanxFlow();
				int user_id = Integer.parseInt(userId.toString());
				int deliveryId = Integer.parseInt(deliveryIdStr.trim());
				int tapSource = Integer.parseInt(tapSourceStr.trim());
				Timestamp tapTime = new Timestamp(System.currentTimeMillis());
				niVoteWanxFlow.setUserId(user_id);
				niVoteWanxFlow.setDeliveryId(deliveryId);
				niVoteWanxFlow.setTapTime(tapTime);
				niVoteWanxFlow.setTapSource(tapSource);
				flowStatisticsService.insertNiVoteWanxFlow(niVoteWanxFlow);

			} else {
				log.info("=======================>Assess page deliveryId is null");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("007");// ????
				errormsg.setErrInfo("deliveryId is null");
				return errormsg;
			}
		} else {
			log.info("=======================>Assess page userId is null");
			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;
		}
		return "{\"success\":\"true\",\"comments\":\"add Vote Wanx Flow Record successfully\"}";
	}

	/**
	 * @Description 报告点击
	 * @param request
	 * @return
	 */
	@RequestMapping("/addReportFlowRecord")
	@ResponseBody
	public Object addReportFlowRecord(HttpServletRequest request) {
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
//		 String userId = request.getParameter("userId");
		String reportIdStr = request.getParameter("reportId");
		if (userId != null) {
			if (reportIdStr != null) {
				NiReportFlow niReportFlow = new NiReportFlow();
				int user_id = Integer.parseInt(userId.toString());
				int reportId = Integer.parseInt(reportIdStr.trim());
				Timestamp tapTime = new Timestamp(System.currentTimeMillis());
				niReportFlow.setUserId(user_id);
				niReportFlow.setReportId(reportId);
				niReportFlow.setTapTime(tapTime);
				flowStatisticsService.insertNiReportFlow(niReportFlow);
			} else {
				log.info("=======================>reportId is null");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("007");// ????
				errormsg.setErrInfo("reportId is null");
				return errormsg;
			}
		} else {
			log.info("=======================>非wanx其他渠道");
/*			ErrorMessage errormsg = new ErrorMessage();
			errormsg.setSuccess("false");
			errormsg.setErrCode("001");
			errormsg.setErrInfo("userId is null");
			return errormsg;*/
			if (reportIdStr != null) {
				NiReportFlow niReportFlow = new NiReportFlow();
				int reportId = Integer.parseInt(reportIdStr.trim());
				Timestamp tapTime = new Timestamp(System.currentTimeMillis());
				niReportFlow.setReportId(reportId);
				niReportFlow.setTapTime(tapTime);
				niReportFlow.setComment("非玩校其他渠道无法获取userId");
				flowStatisticsService.insertNiReportFlow(niReportFlow);
			} else {
				log.info("=======================>reportId is null");
				ErrorMessage errormsg = new ErrorMessage();
				errormsg.setSuccess("false");
				errormsg.setErrCode("007");// ????
				errormsg.setErrInfo("reportId is null");
				return errormsg;
			}
		}
		return "{\"success\":\"true\",\"comments\":\"add Report Flow Record successfully\"}";
	}
}
