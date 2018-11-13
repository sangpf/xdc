package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.PaidQuestionnaireDao;
import com.newins.model.BootPageInfo;
import com.newins.model.IsBootPageInfo;
import com.newins.service.PaidQuestionnaireService;

/**
 * 付费测评问卷业务逻辑实现层
 * @author Zhangwenhao
 * @Time：2017-08-28
 */
@Service
public class PaidQuestionnaireServiceImp implements PaidQuestionnaireService {
	@Autowired
	private PaidQuestionnaireDao paidQuestionnaireDao;
	
	/**
	 * 获取指定投放的测评问卷引导页信息
	 */
	public BootPageInfo getBootInfo(int deliveryId) {
		//直接调用Dao层，无需处理
		return paidQuestionnaireDao.getBootInfo(deliveryId);
	}

	/**
	 * 查询指定投放的问卷已有多少人参与
	 * @param deliveryId:投放id
	 * @return:参与人数
	 */
	public int answerNumber(int deliveryId) {
		//直接调用Dao层，无需处理
		return paidQuestionnaireDao.answerNumber(deliveryId);
	}

	/**
	 * 查询当前用户是否购买当前投放的问卷
	 * @param userId:用户id
	 * @param deliveryId:投放id
	 * @return
	 */
	public int isPaid(int userId, int deliveryId,int ChannelId) {
		//直接调用dao
		return paidQuestionnaireDao.isPaid(userId, deliveryId,ChannelId);
	}

	/**
	 * 查询是否有付费信息
	 */
	public IsBootPageInfo isHave(int deliveryId) {
		//直接调用dao
		return paidQuestionnaireDao.isHave(deliveryId);
	}

}