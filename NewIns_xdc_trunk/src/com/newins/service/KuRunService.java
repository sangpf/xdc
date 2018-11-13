package com.newins.service;

import com.newins.model.KuRunGather;
import com.newins.model.KuRunSurvey;

/**
 * 库润相关业务逻辑类
 * @author Zhangwenhao
 *
 */
public interface KuRunService {
	/**
	 * 保存库润采集信息
	 * @return
	 */
	int SaveGather(KuRunGather kuRunGather);
	
	/**
	 * 查询用户是否已经填写过信息采集
	 * @param userId:用户Id
	 * @return:返回数据库查询行数
	 */
	int IsGather(int userId);
	/**
	 * 获取用户的采集信息
	 * @return
	 */
	KuRunGather getGather(int userId);
	/**
	 * 查询当前库润问卷抽奖状态
	 * @param userId:用户Id
	 * @param deliveryId:库润问卷id
	 * @return
	 */
	int checkKuRunAward(int userId,int deliveryId);
	/**
	 * 保存库润答题结果
	 * @param kuRunSurvey:保存的数据
	 * @return :返回响应行数
	 */
	int SaveKuRunSurvey(KuRunSurvey kuRunSurvey);
}
