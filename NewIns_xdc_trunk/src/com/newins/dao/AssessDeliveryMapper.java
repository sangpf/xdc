/**
 * 
 */
package com.newins.dao;

import com.newins.model.AssessDelivery;

/**@Description  调查投放service接口
 * @author Guan
 * @time 2016年8月24日 下午7:28:15
 */

public interface AssessDeliveryMapper {
	AssessDelivery getDeliveryStatusById(int deliveryId);

}
