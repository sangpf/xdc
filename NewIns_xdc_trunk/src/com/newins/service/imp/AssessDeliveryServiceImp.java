/**
 * 
 */
package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.AssessDeliveryMapper;
import com.newins.model.AssessDelivery;
import com.newins.service.AssessDeliveryService;

/**@Description  
 * @author Guan
 * @time 2016年8月24日 下午7:24:45
 */
@Service(value = "AssessDeliveryService")
public class AssessDeliveryServiceImp implements AssessDeliveryService {
	@Autowired
	private AssessDeliveryMapper surveyDeliveryMapper;
	
	public AssessDelivery getDeliveryStatusById(int deliveryId){
		return surveyDeliveryMapper.getDeliveryStatusById(deliveryId);
	}
}
