/**
 * 
 */
package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.SurveyDeliveryMapper;
import com.newins.model.SurveyDelivery;
import com.newins.service.SurveyDeliveryService;

/**@Description  
 * @author Guan
 * @time 2016年8月24日 下午7:24:45
 */
@Service(value = "SurveyDeliveryService")
public class SurveyDeliveryServiceImp implements SurveyDeliveryService {
	@Autowired
	private SurveyDeliveryMapper surveyDeliveryMapper;
	
	public SurveyDelivery getDeliveryStatusById(int deliveryId){
		return surveyDeliveryMapper.getDeliveryStatusById(deliveryId);
	}
}
