package com.newins.service;

import java.util.Map;

import com.newins.model.LotteryBasicInfo;
import com.newins.model.LotteryDetailInfo;
import com.newins.model.SurveyOrder;

public interface LotteryService {
	/**
	 * @Title: getLotteryBasicInfo  
	 * @Author: MaNia_chAng
	 * @Description: 通过userId和deliveryId查询lotteryBasicInfo
	 * @param userId
	 * @param deliveryId
	 * @return LotteryBasicInfo
	 * @Time 2016年6月3日 下午4:50:41
	 */
	public LotteryBasicInfo getLotteryBasicInfo(Map<String, Object> retMap);
	
	/**
	 * @Title: verifyLotteryStatus  
	 * @Author: MaNia_chAng
	 * @Description: 判断是否中奖，中奖则返回中奖信息同时更新命运表和order表相关字段，没中奖则返回没中奖
	 * @param lotteryBasicInfo
	 * @param userId
	 * @param deliveryId
	 * @return String
	 * @Time 2016年6月8日 下午3:16:00
	 */
	public Object verifyLotteryStatus(Map<String, Object> hashMap);
	
	public SurveyOrder getSequenceNumAndLotteryRank(Map<String, Object> retMap);
	
}
