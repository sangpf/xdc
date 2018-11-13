/**
 * 
 */
package com.newins.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.SurveyOrderDao;
import com.newins.model.SurveyOrder;
import com.newins.service.SurveyOrderService;

/**
 * @Description 问卷订单service
 * @author Guan
 * @time 2016年6月1日 下午4:42:39
 */
@Service(value = "SurveyOrderService")
public class SurveyOrderServiceImp implements SurveyOrderService {
	@Autowired
	private SurveyOrderDao svyOrderDao;

	/**
	 * @Title: searchOrderById
	 * @Author: Guan
	 * @Description: 根据userId和sqnId查询一条订单
	 * @param user_Id
	 * @param sqn_Id
	 * @return SurveyOrder
	 * @Time 2016年6月2日 上午9:18:31
	 */
	public SurveyOrder searchOrderById(int user_Id, int sqn_Id) {
		Map<String, Object> param = new HashMap<String, Object>();//将参数封装成map格式
		param.put("userId", user_Id);
		param.put("sqnId", sqn_Id);
		return svyOrderDao.getSurveyOrder(param);
	}
	
	public List<SurveyOrder> searchOrderBySqnIdList(int userId,
			List<Integer> sqnIdList) {
		Map<String, Object> dataMap = new HashMap<String, Object>();//将参数封装成map格式
		dataMap.put("userId", userId);
		dataMap.put("sqnIdList", sqnIdList);
		return svyOrderDao.searchOrderBySqnIdList(dataMap);
	}
}
