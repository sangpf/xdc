package com.newins.service;



/**@Description  提交投票结果的Service接口
 * @author MaNia_chAng
 * @time 2016年6月20日 下午12:52:47
 */
public interface SubmitVoteService {
	
	/**
	 * @Title: createVoteOrder  
	 * @Author: 根据userId和vqnId创建一条新的订单
	 * @Description: TODO
	 * @param userId
	 * @param vqnId
	 * @return String
	 * @Time 2016年6月21日 下午6:02:10
	 */

	public String createVoteOrder(int userId,int vqnId,int awardId,String answerBTime,int awardMethod,int deliveryId);
	
	/**
	 * @Title: submitVote  
	 * @Author: MaNia_chAng
	 * @Description: 根据userId,vqnId,answer和订单创建的状态，提交答案
	 * @param userId
	 * @param vqnId
	 * @param answer
	 * @param voteOrderCreated
	 * @return String
	 * @Time 2016年6月21日 下午6:03:07
	 */
	public String submitVote(int userId,int vqnId,String answer,String voteOrderCreated);
	


	/**@Title: saveVoteAnswer  
	 * @Author: MaNia_chAng
	 * @Description: 保存投票答案。
	 * @param userId
	 * @param vqnId
	 * @param answer
	 * @return String
	 * @Time 2016年6月24日 下午9:14:32
	 */ 
	public String saveVoteAnswer(int userId, int vqnId, String answer,int awardId,String answerBTime,int deliveryId,int awardMethod);
	/**
	 * @Title: changeDeliveryStatus  
	 * @Author: MaNia_chAng
	 * @Description: TODO
	 * @param deliveryId
	 * @return String
	 * @Time 2016年6月28日 上午11:37:59
	 */
	public String changeDeliveryStatus(int deliveryId);

}
