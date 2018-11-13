package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.SurveyOrder;

/**@Description  根据userId和sqnId查询一条订单Dao
 * @author Guan
 * @time 2016年6月1日 下午4:47:10
 */

public interface SurveyOrderDao {
	/**
	 * 根据userId和sqnId查询一条订单
	 */
	SurveyOrder getSurveyOrder(Map<String, Object> param);
	
	List<SurveyOrder> searchOrderBySqnIdList(Map<String, Object> param);
	
}
