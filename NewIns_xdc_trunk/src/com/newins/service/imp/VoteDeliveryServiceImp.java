/**
 * 
 */
package com.newins.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.VoteDeliveryMapper;
import com.newins.model.VoteDelivery;
import com.newins.service.VoteDeliveryService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月25日 下午2:06:06
 */
@Service
public class VoteDeliveryServiceImp implements VoteDeliveryService{
	
	@Resource
	private VoteDeliveryMapper voteDeliveryMapper;
	
	public VoteDelivery getDeliveryById(int deliveryId){
		VoteDelivery voteDeliveryItem = voteDeliveryMapper.getDeliveryById(deliveryId);
		return voteDeliveryItem;
	}

}
