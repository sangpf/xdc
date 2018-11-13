package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.AssessOrder;

/**@Description  根据userId和aqnId查询一条assess订单Dao
 * @author Guan
 * @time 2016年6月20日 下午15:03:10
 */

public interface AssessOrderDao {
	/**
	 *  根据userId和sqnId查询一条订单
	 */
	AssessOrder getAssessOrder(Map<String, Object> param);
	
	List<AssessOrder> searchOrderByAqnIdList(Map<String, Object> param);
}
