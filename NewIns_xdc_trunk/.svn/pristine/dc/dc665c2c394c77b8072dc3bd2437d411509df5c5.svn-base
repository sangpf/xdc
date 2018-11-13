/**
 * 
 */
package com.newins.service.imp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.newins.controller.AssessController;
import com.newins.dao.SubmitSurveyAnswerDao;
import com.newins.model.SuperSurvey;
import com.newins.model.SurveyAnswer;
import com.newins.model.SurveyOrder;
import com.newins.model.SurveyQuestionWithOption;
import com.newins.service.LoadSurveyQuestionService;
import com.newins.service.SubmitSurveyAnswerService;
import com.newins.service.SurveyOrderService;
import com.newins.util.AjaxResult;

/**
 * @Description 递交问卷答案Service层
 * @author Guan
 * @time 2016年5月24日 下午9:00:39
 */
@Service(value = "SubmitSurveyAnswerService")
public class SubmitSurveyAnswerServiceImp implements SubmitSurveyAnswerService {
	private static Logger log = Logger.getLogger(AssessController.class);
	@Autowired
	private SubmitSurveyAnswerDao submitSvyAnsDao;
	@Autowired
	@Qualifier("SurveyOrder")
	private SurveyOrder svyOrder;
	@Autowired
	private SurveyOrderService svyOrderService;
	@Autowired
	private LoadSurveyQuestionService loadSurveyQuestionService;

	/**
	 * @Title: postSurveyAnswer
	 * @Author: Guan
	 * @Description: 将每条答案值付给1个SurveyAnswer对象，并组成List递交到Dao层
	 * @param user_Id
	 * @param answer_Num
	 * @param sqn_Id
	 * @param jsonAnswerArray
	 *            void
	 * @Time 2016年5月31日 上午11:06:23
	 */
	public boolean postSurveyAnswer(int user_Id, int answer_Num, int sqn_Id,
			JSONArray jsonAnswerArray) {
		// 根据sqnid查询问卷的所有问题的preferValue 并计算该用户的每道题得分存到答案表
		List<SurveyQuestionWithOption> svyQuestionWithOptionList = loadSurveyQuestionService
				.loadSurveyQuestionWithOption(sqn_Id);
		
		// 初始化一个answerList存放每条问卷答案对象（SurveyAnswer)
		List<SurveyAnswer> svyAnsList = new ArrayList<SurveyAnswer>();
		for (int i = 0; i < answer_Num; i++) {
			int preferValue = 0;// 倾向型抽奖指数
			SurveyAnswer svyAns = new SurveyAnswer();
			JSONObject oneAnswer = (JSONObject) jsonAnswerArray.get(i);
			int qType = Integer.parseInt(oneAnswer.getString("questionType"));
			int sqId = Integer.parseInt(oneAnswer.getString("sqId"));
			String qAnswer = oneAnswer.getString("qAnswer");
			String duration = oneAnswer.getString("duration");
			// 如果是单选题或多选题计算preferValue，否则默认值为0
			if (qType == 1 || qType == 2 || qType == 6) {
				preferValue = getPreferValueByAnswer(qAnswer,
						svyQuestionWithOptionList.get(i));// 计算每道题的preferValue（主要为了处理多选）
			}
			// 添加属性到model
			svyAns.setUserId(user_Id);
			svyAns.setSqnId(sqn_Id);
			svyAns.setQuestionType(qType);
			svyAns.setSqId(sqId);
			svyAns.setqAnswer(qAnswer);
			svyAns.setDuration(duration);
			svyAns.setPreferValue(preferValue);
			preferValue=0;//将preferValue置回零
			svyAnsList.add(i, svyAns);

			log.info(JSONObject.fromObject(svyAns));
		}
		// 将svyAnsList递交到Dao层
		return submitSvyAnsDao.setSurveyAnswer(svyAnsList);
	}

	/**
	 * @Title: initSurveyOrder
	 * @Author: Guan
	 * @Description: 生成一条新的Survey订单
	 * @param user_Id
	 * @param sqn_Id
	 *            void
	 * @Time 2016年6月1日 上午11:30:06
	 */
	public synchronized String initSurveyOrder(int user_Id, int sqn_Id,
			int award_Id, Timestamp answerBTime, int awardMethod, int deliveryId) {
		String initStatus = null;// 声明一个生成订单的状态
		// 创建order前先查询并判断这条订单是否存在
		SurveyOrder orderResult = svyOrderService.searchOrderById(user_Id,
				sqn_Id);
		if (orderResult == null) {
			Timestamp orderCTime = new Timestamp(System.currentTimeMillis());// 获取当前系统时间
			Timestamp answerETime = new Timestamp(System.currentTimeMillis());

			svyOrder.setUserId(user_Id);
			svyOrder.setDeliveryId(deliveryId);
			svyOrder.setSqnId(sqn_Id);
			svyOrder.setAwardId(award_Id);
			svyOrder.setOrderCTime(orderCTime);
			svyOrder.setAnswerETime(answerETime);
			svyOrder.setAnswerBTime(answerBTime);
			svyOrder.setOrderStatus(1);// 订单状态为订单生成
			svyOrder.setAwardMethod(awardMethod);
			// 如果该订单结果不存在则生成一条订单
			// 递交给Dao生成订单
			submitSvyAnsDao.initSurveyOrder(svyOrder);
			initStatus = "success";// 订单生成状态为"success"
		} else
			initStatus = "error";
		log.info(initStatus);
		return initStatus;
	}

	/**
	 * @Title: verifySubmitStus
	 * @Author: Guan
	 * @Description: 验证答案递交状态，返回递交成功状态
	 * @param user_Id
	 * @param answer_Num
	 * @param sqn_Id
	 * @param jsonAnswerArray
	 * @param initStus
	 * @return String
	 * @Time 2016年6月7日 上午9:52:36
	 */
	public Object verifySubmitStus(int user_Id, int answer_Num, int sqn_Id,
			JSONArray jsonAnswerArray, String initStus, int deliveryId) {
		//String successStus = null;// 初始化最终返回的成功状态
		JSONObject successStus = new JSONObject();
		// 判断订单创建的成功状态，如果订单创建成功将所有整理好的answers参数递交到service层
		if (initStus == "success" || "success".equals(initStus)) {

			boolean postResult = postSurveyAnswer(user_Id, answer_Num, sqn_Id,
					jsonAnswerArray);
			if (postResult) {
				successStus.put("success", "true");
				successStus.put("comments", "submission done successfully");
				changeDeliveryStatus(deliveryId);// 更改投放状态
			} else {
				return AjaxResult.errorCodeInfo("false", "insert into survey answer db failed", "003");
			}

		} else {
			return AjaxResult.errorCodeInfo("false", "You cannot submit this survey again", "002");
		}
		log.info(successStus);
		return successStus;
	}

	/**
	 * @Title: changeDeliveryStatus
	 * @Author: Guan
	 * @Description: 验证是否答题人数达到需要收集人数，如果达到将问卷状态改为6，数量完成
	 * @param sqn_Id
	 *            void
	 * @Time 2016年6月27日 下午9:09:55
	 */
	public void changeDeliveryStatus(int deliveryId) {
		SuperSurvey superSurvey = submitSvyAnsDao
				.getCollectedNumById(deliveryId);
		if (superSurvey.getCollectedNum() >= superSurvey.getCollectNum()) {
			submitSvyAnsDao.changeDeliveryStatus(deliveryId);
			log.info("Delivery status has been changed into 6");// 6为数量完成
		} else {
			log.info("Delivery status is not changed");
		}
	}

	/**
	 * @Title: getPreferValueByAnswer
	 * @Author: Guan
	 * @Description: 根据用户选择答案计算prefervalue 主要用于多选题
	 * @param qAnswer
	 * @param surveyQuestionWithOption
	 * @return int
	 * @Time 2016年12月23日 下午2:25:59
	 */
	public int getPreferValueByAnswer(String qAnswer,
			SurveyQuestionWithOption surveyQuestionWithOption) {
		int preferValue = 0;
		for (int i = 0; i < qAnswer.length(); i++) {
			String qAnswerOneOption = qAnswer.substring(i, i+1).toUpperCase();

			preferValue = preferValue
					+ surveyQuestionWithOption
							.getOptionPreferValueByAnswer(qAnswerOneOption);

		}
		return preferValue;
	}
}
