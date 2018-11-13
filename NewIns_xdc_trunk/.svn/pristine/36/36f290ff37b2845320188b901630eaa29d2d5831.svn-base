/**
 * 
 */
package com.newins.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.NiUserAwardStatistics;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.util.AjaxResult;

/**
 * @Description
 * @author Guan
 * @time 2017年3月17日 下午4:13:37
 */
@Controller
@RequestMapping("/wanx")
public class AwardStatisticsController {
	private static Logger log = Logger
			.getLogger(AwardStatisticsController.class);
	@Autowired
	private NiUserAwardStatisticsService niUserAwardStatisticsService;

	@RequestMapping(value = "/addAwardStatistics", method = RequestMethod.GET)
	@ResponseBody
	public Object addAwardStatistics(HttpServletRequest request) {

		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		// String userId = request.getParameter("userId").trim();
		// int user_Id = Integer.parseInt(userId);
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());
			String awardId = request.getParameter("awardId").trim();
			int award_Id = 0;
			if (awardId != null && !awardId.equals("")) {
				award_Id = Integer.parseInt(awardId);
			}

			String awardMethod = request.getParameter("awardMethod").trim();
			int award_Method = 0;
			if (awardMethod != null && !awardMethod.equals("")) {
				award_Method = Integer.parseInt(awardMethod);
			}
			String awardCause = request.getParameter("awardCause").trim();
			int award_Cause = 0;
			if (awardCause != null && !awardCause.equals("")) {
				award_Cause = Integer.parseInt(awardCause);
			}

			String deliveryId = request.getParameter("deliveryId").trim();
			int delivery_Id = 0;
			if (deliveryId != null && !deliveryId.equals("")) {
				delivery_Id = Integer.parseInt(deliveryId);
			}

			String qnType = request.getParameter("qnType").trim();
			int qn_Type = 0;
			if (qnType != null && !qnType.equals("")) {
				qn_Type = Integer.parseInt(qnType);
			}

			String lotteryRank = request.getParameter("lotteryRank").trim();
			int lottery_Rank = 0;
			if (lotteryRank != null && !lotteryRank.equals("")) {
				lottery_Rank = Integer.parseInt(lotteryRank);
			}
			String redeemCodeId = request.getParameter("redeemCodeId").trim();
			int redeemCode_Id = 0;
			if (redeemCodeId != null && !redeemCodeId.equals("")) {
				redeemCode_Id = Integer.parseInt(redeemCodeId);
			}

			Timestamp awardGetTime = new Timestamp(System.currentTimeMillis());

			NiUserAwardStatistics niUserAwardStatistics = new NiUserAwardStatistics();

			niUserAwardStatistics.setUserId(user_Id);
			niUserAwardStatistics.setAwardId(award_Id);
			niUserAwardStatistics.setAwardMethod(award_Method);
			niUserAwardStatistics.setAwardCause(award_Cause);
			niUserAwardStatistics.setDeliveryId(delivery_Id);
			niUserAwardStatistics.setQnChannel(1);
			niUserAwardStatistics.setQnType(qn_Type);
			niUserAwardStatistics.setAwardGetTime(awardGetTime);
			niUserAwardStatistics.setLotteryRank(lottery_Rank);
			niUserAwardStatistics.setRedeemCodeId(redeemCode_Id);
			int awardStatisticsRecord = niUserAwardStatisticsService
					.insertUserAwardStatistics(niUserAwardStatistics);
			if (awardStatisticsRecord <= 0) {
				log.info("==================>统计获奖信息插入错误");
				return AjaxResult.errorCodeInfo("false", "insert error", "002");
			} else {
				return AjaxResult.successInfo("success",
						"add awardStatistics Successfully");
			}
		} else {
			return AjaxResult.errorCodeInfo("false", "userId is null", "001");
		}

	}
}
