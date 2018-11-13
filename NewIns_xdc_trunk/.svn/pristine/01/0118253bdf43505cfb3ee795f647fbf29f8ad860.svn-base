/**
 * 
 */
package com.newins.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.AssessOrderDao;
import com.newins.model.AssessOrder;
import com.newins.service.AssessOrderService;

/**
 * @Description 测评订单service实现类
 * @author Guan
 * @time 2016年6月1日 下午4:42:39
 */
@Service(value = "AssessOrderService")
public class AssessOrderServiceImp implements AssessOrderService {
	@Autowired
	private AssessOrderDao assessOrderDao;

	public List<AssessOrder> searchOrderByAqnIdList(int userId,
			List<Integer> aqnIdList) {
		Map<String, Object> dataMap = new HashMap<String, Object>();//将参数封装成map格式
		dataMap.put("userId", userId);
		dataMap.put("aqnIdList", aqnIdList);
		return assessOrderDao.searchOrderByAqnIdList(dataMap);
	}
}
