package com.newins.service;

import com.newins.model.AssessDeliveryInfo;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:38:36
 */
public interface AssessDeliveryInfoService {
	
	AssessDeliveryInfo getDeliveryInfo(int userId,int deliveryId);

}
