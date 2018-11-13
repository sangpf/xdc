package com.newins.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.newins.model.LotteryBasicInfo;
import com.newins.model.LotteryDetailInfo;
import com.newins.model.SurveyOrder;

public interface LotteryDao {

	//从投放表查询bithday
	String getBithday(Map<String,Object> retMap);
	/**
	 * @Title: getSequenceNum  
	 * @Author: MaNia_chAng
	 * @Description: 根据userId和sqnId在Order表中查询sequenceNum
	 * @param userId
	 * @param sqnId
	 * @return int
	 * @Time 2016年6月3日 下午5:20:41
	 */
	public SurveyOrder getSequenceNum(Map<String, Object> retMap);
	/**
	 * @Title: getLotteryBasicInfo  
	 * @Author: MaNia_chAng
	 * @Description: 根据sequenceNum和deliveryId查询基本中奖信息LotteryBasicInfo
	 * @param sequenceNum
	 * @param deliveryId
	 * @return LotteryBasicInfo
	 * @Time 2016年6月3日 下午5:21:16
	 */
	public LotteryBasicInfo getLotteryBasicInfo(@Param("retMap") Map<String,Object> retMap);
	
	/**
	 * @Title: getLotteryDetailInfo  
	 * @Author: MaNia_chAng
	 * @Description: 根据awardRank及delieveryId获得获奖详细信息lotteryDetailInfo
	 * @param awardRank
	 * @param deliveryId
	 * @return LotteryDetailInfo
	 * @Time 2016年6月2日 下午9:32:35
	 */
	public LotteryDetailInfo getLotteryDetailInfo(Map<String, Object> hashMap);
	
	public void updateOrderAwardId(Map<String, Object> hashMap);
	
	public void updateLotteryUserIdAndAwardTime(@Param("retMap") Map<String, Object> hashMap);
	

	
}
