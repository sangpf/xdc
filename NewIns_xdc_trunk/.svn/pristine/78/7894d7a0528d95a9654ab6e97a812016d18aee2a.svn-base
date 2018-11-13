/**
 * 
 */
package com.newins.dao;

import java.util.Map;

import com.newins.model.LotteryDetailInfo;
import com.newins.model.LotteryPreferBasicInfo;
import com.newins.model.SurveyOrder;

/**@Description  
 * @author Guan
 * @time 2016年12月21日 下午1:56:57
 */

public interface LotteryPreferDao {
	public SurveyOrder getLotteryRank(Map<String, Object> retMap);
	
	public LotteryPreferBasicInfo getLotteryPreferBasicInfoByDeliveryId(Map<String, Object> retMap);
	
	public LotteryPreferBasicInfo getUserLotteryResult(Map<String, Object> retMap);
	
	public int getTotalPreferValue(Map<String, Object> retMap);
	
	public LotteryDetailInfo getAwardDetailById(int awardId);
	
	public int updateAwardLeft(Map<String, Object> retMap);
	
	public void updateOrderAwardId(Map<String, Object> retMap);
}
