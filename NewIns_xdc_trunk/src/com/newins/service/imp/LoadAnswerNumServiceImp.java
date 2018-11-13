package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.LoadAnswerNumDao;
import com.newins.service.LoadAnswerNumService;

/**
 * 加载指定投放的答题人数业务逻辑操作层
 * @author ZhangWenHao
 *
 */
@Service
public class LoadAnswerNumServiceImp implements LoadAnswerNumService {

	@Autowired
	private LoadAnswerNumDao loadAnswerNumDao;
	
	@Override
	public Integer ToDo(int deliveryId) {
		// TODO Auto-generated method stub
		return loadAnswerNumDao.ToDo(deliveryId);
	}

	@Override
	public int GetResultShowType(int aqnId) {
		// TODO Auto-generated method stub
		return loadAnswerNumDao.GetResultShowType(aqnId);
	}

}
