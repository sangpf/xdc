/**
 * 
 */
package com.newins.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.SurveyDelivery;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.service.SubmitSurveyAnswerService;
import com.newins.service.SurveyDeliveryService;
import com.newins.util.AjaxResult;

/**
 * @Description 递交问卷答案的controller
 * @author Guan
 * @time 2016年5月24日 上午8:47:56
 */
@Controller
@RequestMapping("/wanx")
public class SubmitSurveyAnswerController {
	private static Logger log = Logger.getLogger(SubmitSurveyAnswerController.class);
	@Autowired
	private SubmitSurveyAnswerService submitSvyAnsService;
	@Autowired
	private NiUserAwardStatisticsService niUserAwardStatisticsService;
	@Autowired
	private SurveyDeliveryService surveyDeliveryService;

	/**
	 * @Title: getSurveyAnswer
	 * @Author: Guan
	 * @Description: 截获request，并将参数取出。相应URL为/wanx/saveSurveyAnswer
	 * @param request
	 *            HTTP请求
	 * @return String 成功的状态
	 * @Time 2016年5月31日 上午10:55:17
	 */
	@RequestMapping(value = "/saveSurveyAnswer", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Object submitSurveyAnswer(HttpServletRequest request) {
		// 取出request的参数，其中answers为JSONArray,其余变量为单值变量

		//String successStus = null;// 初始化最终返回的递交答案成功状态
		Object successStus = null;
		HttpSession newSession = request.getSession(true);
		Object userId = newSession.getAttribute("userId");
		if (userId != null) {
			int user_Id = Integer.parseInt(userId.toString());

			String answerNum = request.getParameter("answerNum").trim();
			int answer_Num = Integer.parseInt(answerNum);
			
			String sqnId = request.getParameter("sqnId").trim();
			int sqn_Id = Integer.parseInt(sqnId);
			
			String answers = request.getParameter("answers");
			String awardIdStr = request.getParameter("awardId").trim();
			String answerBTimeStr = request.getParameter("answerBTime").trim();
			Timestamp answerBTime = Timestamp.valueOf(answerBTimeStr);
			String deliveryId = request.getParameter("deliveryId").trim();
			int delivery_Id = Integer.parseInt(deliveryId);

			String awardMethodStr = request.getParameter("awardMethod").trim();

			int award_Id = 0;
			if (awardIdStr != null) {
				award_Id = Integer.parseInt(awardIdStr);
			}
			int awardMethod = 0;
			if (awardMethodStr != null) {
				awardMethod = Integer.parseInt(awardMethodStr);
			}
			// 将answers转化成大的JSON对象
			String answerStr = "{'answers':" + answers + "}";
			JSONObject jsonObject = JSONObject.fromObject(answerStr);
			// 取出answers的JSONArray
			JSONArray jsonAnswerArray = jsonObject.getJSONArray("answers");

		//	String successStus = null;// 初始化最终返回的递交答案成功状态
			// 根据投放id查询投放状态
			SurveyDelivery svyDelivery = surveyDeliveryService.getDeliveryStatusById(delivery_Id);
			if (svyDelivery != null) {
				int deliveryStatus = svyDelivery.getStatus();
				if (deliveryStatus == 2) {// 如果投放状态为投放中则向下进行

					// 创建一条订单，返回订单创建是否成功的状态
					String initStus = submitSvyAnsService.initSurveyOrder(user_Id, sqn_Id, award_Id,
									answerBTime, awardMethod,delivery_Id);
					log.info("order?" + initStus);

					// 将参数，以及订单创建状态传入service，返回最终用户递交答案状态
					successStus = submitSvyAnsService.verifySubmitStus(user_Id,
							answer_Num, sqn_Id, jsonAnswerArray, initStus,delivery_Id);
					// 将定奖信息写入用户获奖统计表
/*					if (award_Id != 0 && initStus == "success") {
						NiUserAwardStatistics niUserAwardStatistics = new NiUserAwardStatistics();
						niUserAwardStatistics.setUserId(user_Id);
						niUserAwardStatistics.setAwardId(award_Id);
						niUserAwardStatistics.setAwardMethod(1);
						niUserAwardStatistics.setAwardCause(1);
						niUserAwardStatistics.setDeliveryId(delivery_Id);
						niUserAwardStatistics.setQnChannel(1);
						niUserAwardStatistics.setQnType(1);
						Timestamp awardGetTime = new Timestamp(
								System.currentTimeMillis());
						niUserAwardStatistics.setAwardGetTime(awardGetTime);
						int awardStatisticsRecord = niUserAwardStatisticsService
								.insertUserAwardStatistics(niUserAwardStatistics);
						if (awardStatisticsRecord <= 0) {
							log.info("==================>统计获奖信息插入错误");
						}
					}*/
					return successStus;

				} else {
					
					return AjaxResult.errorCodeInfo("false", "The survey is not on delivery", "006");
				}

			} else {
				
				return AjaxResult.errorCodeInfo("false", "The delivery is not exist", "007");
			}
		} else {
		
			return AjaxResult.errorCodeInfo("false", "userId is null", "005");
		}
	}
}
