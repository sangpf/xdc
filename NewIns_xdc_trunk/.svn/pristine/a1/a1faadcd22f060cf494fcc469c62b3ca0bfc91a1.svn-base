package com.newins.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.LotteryBasicInfo;
import com.newins.model.SurveyOrder;
import com.newins.service.LotteryPreferService;
import com.newins.service.LotteryService;
import com.newins.util.ErrorMessage;

/**
 * @Description 问卷抽奖的controller,url为/NewIns/wanx
 * @author MaNia_chAng
 * @time 2016年5月24日 下午4:50:07
 */

@Controller
@RequestMapping("/wanx")
public class LotteryController {

	@Autowired
	private LotteryService lotteryService;
	@Autowired
	private LotteryPreferService lotteryPreferService;

	/**
	 * @Title: getLottery
	 * @Author: MaNia_chAng
	 * @Description: 通过入参userId,deliveryId加载相应的抽奖信息.随机抽奖接口
	 * @param request
	 * @return Lottery
	 * @Time 2016年5月24日 下午5:02:34
	 */
	@RequestMapping(value = "/lottery", method = RequestMethod.GET)
	@ResponseBody
	public Object getLottery(HttpServletRequest request) {
		//声明参数Map
		Map<String, Object> retMap = new HashMap<String, Object>();
		int userId = 0;
		// Map<String, Object> hashMap = new HashMap<>();
		//获取session回话
		HttpSession session = request.getSession(true);
		//获取session中的用户id
		Object userIdObj = session.getAttribute("userId");
		//判断用户id是否为空
		if (userIdObj == null) {
			//进入这里表示用户id为空
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("003");
			error.setErrInfo("userId is null");
			//返回错误信息
			return error;
		} else {
			//转换类型
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}

		// String userIdStr = request.getParameter("userId");
		// userId = Integer.parseInt(userIdStr);
		//获取前端传递的参数
		String deliveryIdStr = request.getParameter("deliveryId");//投放id
		String qnIdStr = request.getParameter("qnId");//问卷id
		String qnTypeStr = request.getParameter("qnType");//问卷类型
		String channelStr = request.getParameter("channel");//投放渠道
		//声明整型类型的投放id
		int deliveryId = 0;
		//判断前端获取到的投放id是否为空
		if (deliveryIdStr != null) {
			//进入这里表示不为空
			//将字符串的投放id转为整型类型
			deliveryId = Integer.parseInt(deliveryIdStr);
		}
		int qnId = 0;
		if (qnIdStr != null) {
			qnId = Integer.parseInt(qnIdStr);
		}

		int qnType = 0;
		if (qnTypeStr != null) {
			qnType = Integer.parseInt(qnTypeStr);
		}
		int channel = 0;
		if (channelStr != null) {
			channel = Integer.parseInt(channelStr);
		}
		//将处理好的参数
		retMap.put("userId", userId);
		retMap.put("deliveryId", deliveryId);
		retMap.put("qnId", qnId);
		retMap.put("qnType", qnType);
		retMap.put("channel", channel);

		// Step 1:从order里查sequenceNum;
		// Step 2:根据sequenceNum从命运表中查询lotteryInfo;
		// Step 3:向命运表中插入中奖时间和userId；向order表中插入awardId；
		
		SurveyOrder surveyOrder = lotteryService
				.getSequenceNumAndLotteryRank(retMap);
		if (surveyOrder.getLotteryRank() != 0) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("002");
			error.setErrInfo("您已经抽过奖了");
			return error;
		} else {
			retMap.put("sequenceNum", surveyOrder.getSequenceNum());
			LotteryBasicInfo lotteryBasicInfo = lotteryService
					.getLotteryBasicInfo(retMap);
			retMap.put("lotteryBasicInfo", lotteryBasicInfo);
			return lotteryService.verifyLotteryStatus(retMap);
		}

	}

	/**
	 * @Title: getLotteryPrefer
	 * @Author: Guan
	 * @Description: 倾向型抽奖
	 * @param request
	 * @return Object
	 * @Time 2016年12月21日 上午10:06:59
	 */
	@RequestMapping(value = "/lotteryPrefer", method = RequestMethod.GET)
	@ResponseBody
	@Transactional
	public Object getLotteryPrefer(HttpServletRequest request) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		int userId = 0;
		// Map<String, Object> hashMap = new HashMap<>();

		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
		if (userIdObj == null) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("003");
			error.setErrInfo("userId is null");
			return error;
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}

		//String userIdStr = request.getParameter("userId");
		//userId = Integer.parseInt(userIdStr);
		String deliveryIdStr = request.getParameter("deliveryId");
		String qnIdStr = request.getParameter("qnId");
		String qnTypeStr = request.getParameter("qnType");
		String channelStr = request.getParameter("channel");

		int deliveryId = 0;
		if (deliveryIdStr != null) {
			deliveryId = Integer.parseInt(deliveryIdStr);
		}
		int qnId = 0;
		if (qnIdStr != null) {
			qnId = Integer.parseInt(qnIdStr);
		}

		int qnType = 0;
		if (qnTypeStr != null) {
			qnType = Integer.parseInt(qnTypeStr);
		}
		int channel = 0;
		if (channelStr != null) {
			channel = Integer.parseInt(channelStr);
		}

		retMap.put("userId", userId);
		retMap.put("deliveryId", deliveryId);
		retMap.put("qnId", qnId);
		retMap.put("qnType", qnType);
		retMap.put("channel", channel);

		// step1:查order表中的lotteryRank 如果！=0 则抽过奖（0 未抽过 -1抽过未中）
		SurveyOrder surveyOrder = lotteryPreferService.getLotteryRank(retMap);
		if (surveyOrder.getLotteryRank() != 0) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("002");
			error.setErrInfo("您已经抽过奖了");
			return error;
		} else {
			return lotteryPreferService.doLotteryPrefer(retMap);
		}
	}

}
