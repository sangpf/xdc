package com.newins.service;

import java.util.List;

import com.newins.model.VoteOrder;

/**@Description  投票订单对应的Service接口
 * @author MaNia_chAng
 * @time 2016年6月21日 下午3:21:38
 */
public interface VoteOrderService {
	/**
	 * @Title: getVoteOrderById  
	 * @Author: MaNia_chAng
	 * @Description: 根据userId和vqnId查询返回订单信息
	 * @param userId
	 * @param vqnId
	 * @return VoteOrder
	 * @Time 2016年6月21日 下午7:15:38
	 */
	public VoteOrder getVoteOrderById(int userId,int vqnId);
	
	
	/**
	 * @Title: searchOrderByVqnIdList  
	 * @Author: Guan
	 * @Description: 根据userId和页面列表中的vqnId，来查找相关order；主要用于判断该用户是否答过该题
	 * @param userId
	 * @param vqnIdList
	 * @return List<VoteOrder>
	 * @Time 2016年8月8日 下午5:01:41
	 */
	public List<VoteOrder> searchOrderByVqnIdList(int userId, List<Integer>vqnIdList);

}
