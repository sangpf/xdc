package com.newins.dao;

import java.awt.List;
import java.math.BigDecimal;
import java.util.ArrayList;

import com.newins.model.Consume;

/**
 * 消费流水表操作Dao层
 * @author Zhang
 *
 */
public interface ConsumeDao {
	/**
	 * 添加流水信息方法
	 * @return
	 */
	int addConsume(Consume consume);
	/**
	 * 获得指定投放的打赏人数
	 * @param deliverId
	 * @return
	 */
	int getDonatePerson(int deliveryId);
	/**
	 * 判断当前用户是否第一次来打赏当前问卷
	 * @param userId
	 * @param deliveryId
	 * @return
	 */
	int isGratuity(int userId,int deliveryId);
	/**
	 * 查询当前投放被打赏的积分
	 * @return
	 */
	BigDecimal getDeliveryScore(int deliveryId);
}
