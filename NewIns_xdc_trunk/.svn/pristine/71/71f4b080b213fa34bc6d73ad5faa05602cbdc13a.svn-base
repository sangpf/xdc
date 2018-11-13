package com.newins.service;

import com.newins.model.Consume;

/**
 * 操作消费流水表业务逻辑层
 * @author Zhang
 *
 */
public interface ConsumeService {
	/**
	 * 增加打赏消费流水信息
	 * @param consume
	 * @return
	 */
	int addConsume(Consume consume);
	
	/**
	 * 判断当前用户是否第一次来打赏当前问卷
	 * @param userId
	 * @param deliveryId
	 * @return
	 */
	int isGratuity(int userId,int deliveryId);
}
