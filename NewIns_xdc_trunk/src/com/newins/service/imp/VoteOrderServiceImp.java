package com.newins.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.VoteOrderDao;
import com.newins.model.VoteOrder;
import com.newins.service.VoteOrderService;

/**@Description  投票订单对应Service的实现类
 * @author MaNia_chAng
 * @time 2016年6月21日 下午3:26:33
 */
@Service
public class VoteOrderServiceImp implements VoteOrderService{
	@Autowired
	private VoteOrderDao voteOrderDao;
	@Autowired
	private VoteOrder voteOrder;
	
	
	//查询投票订单信息
	public VoteOrder getVoteOrderById(int userId,int vqnId){
		Map<String, Object> param = new HashMap<String, Object>();//将参数封装成map格式
		param.put("userId", userId);
		param.put("vqnId", vqnId);
		voteOrder = voteOrderDao.getVoteOrderById(param);
		return voteOrder;
	}
	
	public List<VoteOrder> searchOrderByVqnIdList(int userId,
			List<Integer> vqnIdList) {
		Map<String, Object> param = new HashMap<String, Object>();//将参数封装成map格式
		param.put("userId", userId);
		param.put("vqnIdList", vqnIdList);
		return voteOrderDao.searchOrderByVqnIdList(param);
	}

}
