/**
 * 
 */
package com.newins.service;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import com.newins.model.AssessResult;
import com.newins.util.AjaxResult;

/**
 * @Description 递交测评答案service接口
 * @author Guan
 * @time 2016年6月16日 下午1:14:18
 */

public interface SubmitAssessAnswerService {
	
	boolean insertAssessAnswer(int user_Id, int answer_Num, int aqn_Id, JSONArray jsonAnswerArray);
	
	//从订单表里获取测评结果
	AssessResult getAssessResultFromOrder(int user_Id, int aqn_Id);
	/**
	 * @Title: changeDeliveryStatus  
	 * @Author: Guan
	 * @Description: 验证是否答题人数达到需要收集人数，如果达到将问卷状态改为6，已完成
	 * @param aqn_Id void
	 * @Time 2016年6月27日 下午9:09:55
	 */
	void changeDeliveryStatus(int aqn_Id);

	AjaxResult getAssessResultFromOrder(HttpServletRequest request);

	AjaxResult submitAssessAnswer(HttpServletRequest request);

}
