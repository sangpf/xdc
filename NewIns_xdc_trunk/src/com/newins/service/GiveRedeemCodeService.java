package com.newins.service;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newins.dao.GiveRedeemCodeDao;
import com.newins.model.RedeemCode;
import com.newins.service.imp.NiUserAwardStatisticsServiceImp;

/**
 * 获取口粮兑换码并修改其相关状态业务逻辑层
 * @author zhangwenhao
 *
 */
public interface GiveRedeemCodeService {
	/**
	 * 领取兑换码
	 * @param userId
	 * @param phoneNum
	 * @return
	 */
	public JSONObject giveRedeemCode(int userId,String phoneNum,int awardId);
}