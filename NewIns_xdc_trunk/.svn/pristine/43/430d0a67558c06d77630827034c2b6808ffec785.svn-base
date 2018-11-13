package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.ConsumeDao;
import com.newins.model.Consume;
import com.newins.service.ConsumeService;

/**
 * 操作消费流水业务逻辑层是实现类
 * @author Zhang
 *
 */
@Service
public class ConsumeServiceImp implements ConsumeService {
	@Autowired
	private ConsumeDao consumeDao;
	/**
	 * 记录打赏消费流水方法
	 */
	public int addConsume(Consume consume) {
		//调用Dao层相关方法
		return consumeDao.addConsume(consume);
	}
	/**
	 * 判断用户是否第一次打赏当前问卷
	 */
	public int isGratuity(int userId, int deliveryId) {
		//调用Dao层相关方法
		return consumeDao.isGratuity(userId, deliveryId);
	}
	
	
}
