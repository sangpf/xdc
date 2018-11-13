/**
 * 
 */
package com.newins.service;

import java.util.List;

import com.newins.model.SurveyOrder;

/**@Description  
 * @author Guan
 * @time 2016年6月16日 下午1:21:35
 */

public interface SurveyOrderService {
	SurveyOrder searchOrderById(int user_Id, int sqn_Id);
	/**
	 * @Title: searchOrderBySqnIdList  
	 * @Author: Guan
	 * @Description: 根据userId和页面列表中的sqnId，来查找相关order；主要用于判断该用户是否答过该题
	 * @param userId
	 * @param sqnIdList
	 * @return List<SurveyOrder>
	 * @Time 2016年8月8日 下午4:29:33
	 */
	List<SurveyOrder> searchOrderBySqnIdList(int userId, List<Integer> sqnIdList);
}
