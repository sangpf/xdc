package com.newins.dao;


import java.util.Map;

import com.newins.model.LotteryAward;


/**@Description  
 * @author MaNia_chAng
 * @time 2016年7月4日 下午3:41:50
 */
public interface LotteryAwardMapper {
	LotteryAward getLotteryAward(Map<String, Object> hashMap);//查询随机抽奖奖品
	//String getAwardPicById(int awardId);

	LotteryAward getLotteryPreferAward (Map<String, Object> hashMap);//查询倾向型抽奖奖品信息

}
