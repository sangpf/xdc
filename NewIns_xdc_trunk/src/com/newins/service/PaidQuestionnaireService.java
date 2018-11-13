package com.newins.service;

import com.newins.model.BootPageInfo;
import com.newins.model.IsBootPageInfo;


/**
 * 付费测评问卷Service
 * @author Zhangwenhao
 * @Time:2017-08-28
 */
public interface PaidQuestionnaireService {
	/**
	 * 获取指定投放的测试
	 * @param deliveryId：投放id
	 * @return
	 */
	BootPageInfo getBootInfo(int deliveryId);
	
	/**
	 * 查询指定投放的问卷已有多少人参与
	 * @param deliveryId:投放id
	 * @return:参与人数
	 */
	int answerNumber(int deliveryId);
	
	/**
	 * 查询当前用户是否购买当前投放的问卷
	 * @param userId:用户id
	 * @param deliveryId:投放id
	 * @return
	 */
	int isPaid(int userId,int deliveryId,int ChannelId);
	
	/**
	 * 查询是否有付费信息
	 * @param deliveryId
	 * @return
	 */
	IsBootPageInfo isHave(int deliveryId);
}
