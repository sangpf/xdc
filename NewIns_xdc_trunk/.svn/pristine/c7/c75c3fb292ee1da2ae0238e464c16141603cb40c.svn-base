package com.newins.dao;

import java.util.List;

import com.newins.model.VoteAnswer;
import com.newins.model.VoteDeliveryItem;
import com.newins.model.VoteOrder;

/**@Description  提交投票结果对应的Dao接口
 * @author MaNia_chAng
 * @time 2016年6月20日 下午1:26:15
 */
public interface SubmitVoteDao {
	
	/**
	 * @Title: createVoteOrder  
	 * @Author: MaNia_chAng
	 * @Description: 根据传入订单信息创建一条新的订单
	 * @param voteOrder void
	 * @Time 2016年6月21日 下午7:22:06
	 */
	public void createVoteOrder(VoteOrder voteOrder);

 
	/**
	 * @Title: submitVote  
	 * @Author: MaNia_chAng
	 * @Description: 将投票答案信息写入数据库
	 * @param voteAnswer void
	 * @Time 2016年6月21日 下午7:23:33
	 */
	public void submitVote(VoteAnswer voteAnswer);
	
	/**
	 * @Title: getOptionNum  
	 * @Author: MaNia_chAng
	 * @Description: 根据vqnId查询并返回选项数量
	 * @param vqnId
	 * @return int
	 * @Time 2016年6月21日 下午7:24:43
	 */
	public int getOptionNum(int vqnId);

	/**
	 * @Title: getChoice  
	 * @Author: MaNia_chAng
	 * @Description: 根据vqnId查询返回某个投票的所有答案
	 * @param vqnId
	 * @return List<String>
	 * @Time 2016年6月21日 下午7:25:23
	 */
	public List<String> getChoice(int vqnId);


	/**@Title: getVoteCollectedNum  
	 * @Author: MaNia_chAng
	 * @Description: TODO
	 * @param vqnId
	 * @return int
	 * @Time 2016年6月28日 上午10:47:22
	 */ 
	public int getCollectAndCollectedNum(int deliveryId);


	/**@Title: getCollectAndCollectedNumById  
	 * @Author: MaNia_chAng
	 * @Description: 根据vqnId查询collectNum和collectedNum。
	 * @param vqnId
	 * @return VoteDeliveryItem
	 * @Time 2016年6月28日 上午11:17:58
	 */ 
	public VoteDeliveryItem getCollectAndCollectedNumById(int deliveryId);


	/**@Title: changeDeliveryStatus  
	 * @Author: MaNia_chAng
	 * @Description: 更改投票订单状态。
	 * @param vqnId void
	 * @Time 2016年6月28日 上午11:18:04
	 */ 
	public void changeDeliveryStatus(int deliveryId);

}
