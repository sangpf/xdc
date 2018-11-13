package com.newins.service;

import com.newins.model.VoteData;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年11月21日 下午8:51:17
 */
public interface VoteResultService {
	/**
	 * @Title: getVoteData  
	 * @Author: MaNia_chAng
	 * @Description: 统计投票结果
	 * @param vqnId
	 * @param deliveryId
	 * @return VoteData
	 * @Time 2016年11月21日 下午8:55:43
	 */
	VoteData getVoteData(int vqnId,int deliveryId,int userId);
	

}
