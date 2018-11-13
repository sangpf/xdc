/**
 * 
 */
package com.newins.service;

import java.util.HashMap;

import com.newins.model.AssessOrder;
import com.newins.model.SurveyOrder;

/**@Description  
 * @author Guan
 * @time 2016年8月22日 下午9:00:26
 */

public interface CheckAwardGetStatusService {
	/**
	 * @Title: checkAwardGetStatusService  
	 * @Author: Guan
	 * @Description: 根据userId 和 sqnId 查看当前用户定奖领取状态
	 * @param userId
	 * @param sqnId
	 * @return SurveyOrder
	 * @Time 2016年8月22日 下午9:06:06
	 */
	SurveyOrder checkAwardGetStatusService(int userId,int sqnId);
	
	AssessOrder checkAssessAwardGetStatus(int userId,int qnId);
}