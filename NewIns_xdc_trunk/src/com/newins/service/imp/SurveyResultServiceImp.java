/**
 * 
 */
package com.newins.service.imp;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.SubmitSurveyAnswerDao;
import com.newins.dao.SurveyDeliveryMapper;
import com.newins.dao.SurveyResultMapper;
import com.newins.model.SurveyAnswer;
import com.newins.model.SurveyDelivery;
import com.newins.model.SurveyKeyQuestionOptionData;
import com.newins.model.SurveyKeyQuestionResult;
import com.newins.model.SurveyQuestionWithOption;
import com.newins.model.VoteOptionData;
import com.newins.service.LoadSurveyQuestionService;
import com.newins.service.SurveyResultService;
import com.newins.util.AjaxResult;

/**
 * @Description 调查结果service
 * @author Guan
 * @time 2016年10月11日 下午2:43:14
 */
@Service(value = "SurveyResultService")
public class SurveyResultServiceImp implements SurveyResultService {
	private static Logger log = Logger.getLogger(SurveyResultServiceImp.class);
	@Autowired
	private SurveyResultMapper surveyResultMapper;
	@Autowired
	private LoadSurveyQuestionService loadSurveyQuestionService;
	@Autowired
	private SubmitSurveyAnswerDao submitSurveyAnswerDao;
	@Autowired
	private SurveyDeliveryMapper surveyDeliveryMapper;

	public AjaxResult getSurveyAnswerResult(int userId, int sqnId,
			int sqnCategory) {
		log.info("This is service:getSurveyAnswerResult");

		if (sqnCategory == 1) {// 知识总分型
			// 根据参数userId和sqnId查询用户选择的答案
			return this.getTotalNum(userId, sqnId);
		} else {
			return AjaxResult.successResult("no answer result");
		}
	}

	/**
	 * @Title: getTotalNum
	 * @Author: Guan
	 * @Description: 总分知识题计算总分和正确答题数
	 * @param userId
	 * @param sqnId
	 * @return AjaxResult
	 * @Time 2016年10月11日 下午3:55:11
	 */
	public AjaxResult getTotalNum(int userId, int sqnId) {
		log.info("This is service:getTotalNum");
		AjaxResult ajaxResult = new AjaxResult();
		Map<String, Object> param = new HashMap<String, Object>();// 将参数封装成map格式
		param.put("userId", userId);
		param.put("sqnId", sqnId);
		List<String> correctAnswerList = new ArrayList<String>();
		List<String> userAnswerList = new ArrayList<String>();
		// 查询用户选择的答案
		try {
			List<SurveyAnswer> surveyAnswerList = surveyResultMapper
					.getSurveyAnswerList(param);
			if (surveyAnswerList.size() > 0) {
				// 遍历答案将用户选择的答案存入List
				for (int i = 0; i < surveyAnswerList.size(); i++) {
					String userAnswer = surveyAnswerList.get(i).getChoice();
					userAnswerList.add(i, userAnswer);
				}
				// 根据问卷Id查询所有题目的正确答案并存入List
				List<SurveyQuestionWithOption> svyQuestionList = loadSurveyQuestionService
						.selectSurveyQuestionBySqnId(sqnId);
				for (int j = 0; j < svyQuestionList.size(); j++) {
					String correctAnswer = svyQuestionList.get(j)
							.getCorrectAnswer();
					correctAnswerList.add(j, correctAnswer);
				}
				int questionNum = 0;
				int correctNum = 0;
				// 遍历两个List对比是否相等(由于并不是每一道题都有correctAnswer，意味着无正确答案的题目不计入总分，所以要先排除correctAnswerList中空值)
				for (int k = 0; k < correctAnswerList.size(); k++) {
					if (correctAnswerList.get(k) != null && !correctAnswerList.get(k).equals("")) {
						questionNum = questionNum + 1;// 正确答案非空
						if (correctAnswerList.get(k).toUpperCase() == userAnswerList.get(k)
								|| correctAnswerList.get(k).toUpperCase().equals(userAnswerList.get(k))) {
							correctNum = correctNum + 1;// 计算回答正确的题目数量
						}
					} else
						questionNum = questionNum + 0;
				}

				int totalScore = (int) Math.ceil(((double) correctNum / (double) questionNum) * 100);// 计算总分，百分制向上取整
				ajaxResult.put("success", true);
				ajaxResult.put("msg", "get survey result successfully");
				ajaxResult.put("sqnCategory", 1);
				ajaxResult.put("totalScore", totalScore);
				ajaxResult.put("correctAnswerNum", correctNum);
				ajaxResult.put("questionQty", questionNum);

				return ajaxResult;

			} else {
				ajaxResult.put("success", false);
				ajaxResult.put("msg", "get survey result error");
				return ajaxResult;
			}
		} catch (Exception e) {
			ajaxResult.put("success", false);
			ajaxResult.put("msg", "get survey result error");
			System.out.println(e);
			return ajaxResult;
		}
	}

	/**
	 * 核心题统计过程
	 */
	public Object getSurveyKeyQuestionResult(int sqnId, int keyQuestionNum,
			int deliveryId, int userId) {
		SurveyKeyQuestionResult surveyKeyQuestionResult = new SurveyKeyQuestionResult();
		int sqId;
		// 根据sqnId和keyQuestionNum查询一条surveyQuestionWithOption
		SurveyQuestionWithOption sqWithOption = loadSurveyQuestionService
				.loadSurveyKeyQuestionWithOption(sqnId, keyQuestionNum);
		if (sqWithOption != null) {
			//获取问题类型，判断如果不为单选题或多选题则证明配置的核心题题号有误
			int questionType = sqWithOption.getQuestionType();
			//判断问题类型
			switch(questionType){
				case 1:
					break;
				case 2:
					break;
				default:
					return AjaxResult.errorCodeInfo("false", "keyQuestionNum is wrong, not single or multiple choice type", "002");
				
			}
			
			int optionNum = sqWithOption.getOptionNum();// 获取选项数量
			surveyKeyQuestionResult.setSuccess("true");
			surveyKeyQuestionResult.setQuestionNum(keyQuestionNum);
			surveyKeyQuestionResult.setOptionNum(optionNum);
			surveyKeyQuestionResult.setSqTitle(sqWithOption.getSqTitle());
			if(sqWithOption.getqImgUrl()!=null)	surveyKeyQuestionResult.setqImgUrl(sqWithOption.getqImgUrl());
			// 查出该核心题的问题id
			sqId = sqWithOption.getSqId();
			int totalAmount = 0;// 初始化选项总票数计数器
			// 初始化每个选项票数计数器
			int[] amount = new int[26];
			for (int i = 0; i < 26; i++) {
				amount[i] = 0;
			}
			List<String> surveyChoice = submitSurveyAnswerDao
					.getSurveyChoiceBySqId(sqId);
			for (int i = 0; i < surveyChoice.size(); i++) {
				if (surveyChoice.get(i) != null
						&& !(surveyChoice.get(i).equals(""))) {
					char[] choiceCharArray = surveyChoice.get(i).toCharArray();// 多选题将字符串转换为字符数组
					totalAmount = totalAmount + choiceCharArray.length;
					// 循环计算每个选项个数
					for (int j = 0; j < choiceCharArray.length; j++) {
						switch (choiceCharArray[j]) {
						case 'A':
							amount[0] = amount[0] + 1;
							break;
						case 'B':
							amount[1] = amount[1] + 1;
							break;
						case 'C':
							amount[2] = amount[2] + 1;
							break;
						case 'D':
							amount[3] = amount[3] + 1;
							break;
						case 'E':
							amount[4] = amount[4] + 1;
							break;
						case 'F':
							amount[5] = amount[5] + 1;
							break;
						case 'G':
							amount[6] = amount[6] + 1;
							break;
						case 'H':
							amount[7] = amount[7] + 1;
							break;
						case 'I':
							amount[8] = amount[8] + 1;
							break;
						case 'J':
							amount[9] = amount[9] + 1;
							break;
						case 'K':
							amount[10] = amount[10] + 1;
							break;
						case 'L':
							amount[11] = amount[11] + 1;
							break;
						case 'M':
							amount[12] = amount[12] + 1;
							break;
						case 'N':
							amount[13] = amount[13] + 1;
							break;
						case 'O':
							amount[14] = amount[14] + 1;
							break;
						case 'P':
							amount[15] = amount[15] + 1;
							break;
						case 'Q':
							amount[16] = amount[16] + 1;
							break;
						case 'R':
							amount[17] = amount[17] + 1;
							break;
						case 'S':
							amount[18] = amount[18] + 1;
							break;
						case 'T':
							amount[19] = amount[19] + 1;
							break;
						case 'U':
							amount[20] = amount[20] + 1;
							break;
						case 'V':
							amount[21] = amount[21] + 1;
							break;
						case 'W':
							amount[22] = amount[22] + 1;
							break;
						case 'X':
							amount[23] = amount[23] + 1;
							break;
						case 'Y':
							amount[24] = amount[24] + 1;
							break;
						case 'Z':
							amount[25] = amount[25] + 1;
							break;
						}
					}
				} else {
					continue;
				}
			}
			surveyKeyQuestionResult.setTotalAmount(totalAmount);

			// 从从订单数量和运营调整数量统计参与人数
			SurveyDelivery surveyDelivery = surveyDeliveryMapper
					.getCollectedNumById(deliveryId);
			surveyKeyQuestionResult.setParticipant(surveyDelivery
					.getCollectedNum());

			// 获得每个选项的相关数据
			List<SurveyKeyQuestionOptionData> surveyKeyQuestionOptionDataList = new ArrayList<SurveyKeyQuestionOptionData>();
			DecimalFormat df = new DecimalFormat("0.00");// 设置小数的格式
			List<String> optionDes = new ArrayList<>();

			for (int i = 0; i < optionNum; i++) {
				// 存放选项描述
				String optionDesItem = sqWithOption.getOptionDesByIndex(i+1);
				optionDes.add(optionDesItem);
				// 初始化一个选项对象，设置其属性值
				SurveyKeyQuestionOptionData surveyKeyQuestionOptionData = new SurveyKeyQuestionOptionData();
				surveyKeyQuestionOptionData.setOptionId(i + 1);
				surveyKeyQuestionOptionData.setOptionAmount(amount[i]);
				double percentDouble = (double) amount[i] / totalAmount;

				// 格式化小数，保留两位,将surveyKeyQuestionOptionData写入List
				String percent = df.format(percentDouble);
				surveyKeyQuestionOptionData.setOptionPercent(percent);
				surveyKeyQuestionOptionDataList.add(surveyKeyQuestionOptionData);
			}

			//设置外层对象的属性值
			surveyKeyQuestionResult.setSurveyKeyQuestionOptionData(surveyKeyQuestionOptionDataList);
			
			//获取选项描述
			surveyKeyQuestionResult.setOptionDes(optionDes);
			surveyKeyQuestionResult.setComments("success get result");

		} else {
			return AjaxResult.errorCodeInfo("false", "not find survey question", "001");
		}
		//查询
		Map<String, Object> param = new HashMap<String, Object>();// 将参数封装成map格式
		param.put("userId", userId);
		param.put("sqnId", sqnId);	
		param.put("sqId", sqId);
		SurveyAnswer svyAnswer = surveyResultMapper.getSurveyAnswer(param);
		if(svyAnswer!=null){
		surveyKeyQuestionResult.setUserAnswer(svyAnswer.getChoice());}
		else {
			return AjaxResult.errorCodeInfo("false", "not find userAnswer", "002");
		}
		return surveyKeyQuestionResult;
	}
}
