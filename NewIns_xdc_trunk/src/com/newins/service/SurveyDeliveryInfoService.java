package com.newins.service;

import com.newins.model.SurveyDeliveryInfo;

/**
 * @Description 调查问卷投放信息
 * @author Guan
 * @time 2017年1月6日 下午4:42:17
 */
public interface SurveyDeliveryInfoService {

	SurveyDeliveryInfo getDeliveryInfo(int userId, int deliveryId);

}
