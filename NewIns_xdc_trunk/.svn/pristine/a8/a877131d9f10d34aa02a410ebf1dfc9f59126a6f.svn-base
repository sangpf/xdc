package com.newins.dao;

import com.newins.model.KuRunGather;
import com.newins.model.KuRunSurvey;
import com.newins.model.SurveyOrder;

/**
 * 库润相关数据库操作类
 * @author Zhangwenhao
 *
 */
public interface KuRunDao {
	/**
	 * 保存采集信息
	 * @return:返回数据库影响行数
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
	 * 保存库润问卷答题结果
	 * @return
	 */
	int SaveKuRunSurvey(KuRunSurvey kuRunSurvey);
}
