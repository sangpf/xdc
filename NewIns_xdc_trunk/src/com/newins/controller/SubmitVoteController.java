package com.newins.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.VoteData;
import com.newins.model.VoteDelivery;
import com.newins.service.SubmitVoteService;
import com.newins.service.VoteDeliveryService;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;

/**
 * @Description 提交投票结果的controller,url为/NewIns/saveVoteAnswer
 * @author MaNia_chAng
 * @time 2016年6月20日 下午12:10:30
 */
@Controller
@RequestMapping("/wanx")
public class SubmitVoteController {
	@Autowired
	private SubmitVoteService submitVoteService;
	@Autowired
	private VoteData voteData;
	private static Logger log = Logger.getLogger(SubmitVoteController.class);
	@Resource
	private VoteDeliveryService voteDeliveryService;

	/**
	 * @Title: submitVote
	 * @Author: MaNia_chAng
	 * @Description: 
	 *               传入参数userId,vqnId,answer。Setp1:创建订单;Step2：提交答案；Step3：返回投票统计数据
	 *               。
	 * @param request
	 * @return VoteData
	 * @Time 2016年6月21日 下午5:54:58
	 */
	@RequestMapping(value = "/saveVoteAnswer", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Object submitVote(HttpServletRequest request) {
		
		int userId = 0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
		if (userIdObj == null) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}
		 
/*		String userIdStr = request.getParameter("userId").trim();
		int userId = Integer.parseInt(userIdStr);*/
		String vqnIdStr = request.getParameter("vqnId").trim();
		String answer = request.getParameter("answer");
		String awardIdStr = request.getParameter("awardId");
		String answerBTime = request.getParameter("answerBTime");
		String deliveryIdStr = request.getParameter("deliveryId");
		String awardMethodStr = request.getParameter("awardMethod");

		int vqnId = 0;
		if (vqnIdStr != null) {
			vqnId = Integer.parseInt(vqnIdStr);
		}

		int awardId = 0;
		if (awardIdStr != null) {
			awardId = Integer.parseInt(awardIdStr);
		}
		int deliveryId = Integer.parseInt(deliveryIdStr);
		int awardMethod = Integer.parseInt(awardMethodStr);
		
		//查询投票问卷是否在投放中
		VoteDelivery voteDelivey = voteDeliveryService.getDeliveryById(deliveryId);
		log.info("=========问卷状态===========："+ voteDelivey.getStatus());
		if(voteDelivey.getStatus()!=2){
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("003");
			error.setErrInfo("问卷不在投放中");
			return error;
		}

		// 创建订单,提交答案。
		String submitStatus = null;
		submitStatus = submitVoteService.saveVoteAnswer(userId, vqnId, answer,awardId, answerBTime, deliveryId,awardMethod);
		log.info("submitStatus:" + submitStatus);
		if(submitStatus == "failed"||"failed".equals(submitStatus)){
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("002");
			error.setErrInfo("您已经答过该份问卷！");
			return error;
		}
		//判断是否收满，收满则 更改投放状态
		 String deliveryStatus = null;
		 deliveryStatus = submitVoteService.changeDeliveryStatus(deliveryId);
		 log.info(deliveryStatus);
		 
		//return  AjaxResult.successResult("答案成功提交!");
		 return  AjaxResult.successInfo("true", "答案成功提交!");


	}

}
