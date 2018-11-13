/**
 * 
 */
package com.newins.service;

import java.sql.Timestamp;

import net.sf.json.JSONArray;

/**@Description  
 * @author Guan
 * @time 2016年6月16日 下午1:14:18
 */

public interface SubmitSurveyAnswerService {
	boolean postSurveyAnswer(int user_Id, int answer_Num, int sqn_Id,
			JSONArray jsonAnswerArray);
	
	String initSurveyOrder(int user_Id, int sqn_Id, int award_Id, Timestamp answerBTime, int awardMethod,int deliveryId);
	
	Object verifySubmitStus(int user_Id, int answer_Num, int sqn_Id,
			JSONArray jsonAnswerArray, String initStus, int delivery_Id);
	/**
	 * @Title: changeDeliveryStatus  
	 * @Author: Guan
	 * @Description: 验证是否答题人数达到需要收集人数，如果达到将问卷状态改为6，数量完成
	 * @param sqn_Id void
	 * @Time 2016年6月27日 下午9:09:55
	 */
	void changeDeliveryStatus(int sqn_Id);
	
}
