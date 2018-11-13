package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.Assess;
import com.newins.model.AssessAnswer;
import com.newins.model.AssessOrder;
import com.newins.model.AssessResult;
import com.newins.model.assess.ScoreByDimension;
/**
 *  递交测评答案Dao层
 */
public interface SubmitAssessAnswerDao {
/**
 * : 将测评问卷答案写入数据库
 */
	void insertAssessAnswer(List<AssessAnswer> assessAnsList);
	/**
	 * : 初始化一条测评订单，将订单写入数据库
	 */
	void initAssessOrder(AssessOrder assessOrder);
	/**
	 * : 从简单模型中查测评结果
	 */
	AssessResult getAssessResultFromSimple(Map<String, Object> param);
	/**
	 *  从多维度加总模型查询结果
	 */
	AssessResult getAssessResultFromMultiSum(Map<String, Object> param);
	/**
	 * : 从订单表里查询测评结果
	 */
	AssessResult getAssessResultFromOrder (Map<String, Object> param);
	/**
	 * : 将测评结果写入订单中
	 */
	void insertResultToOrder(AssessResult assessResult);
	/**
	 * : 根据aqnId获取已收集问卷数和需要收集问卷数
	 */
	Assess getCollectedNumById(int deliveryId);
	/**
	 * : 将Delivery status置为完成状态
	 */
	void changeDeliveryStatus(int deliveryId);

	List<ScoreByDimension> getScoreByDimension(Map<String, Object> dataMap);
	
	List<ScoreByDimension> getTotalScoreByDimension(Map<String, Object> dataMap);
	
	List<ScoreByDimension> get_avg_Assess_model_multi_combination_score(Map<String, Object> dataMap);
	
	List<ScoreByDimension> findAssessModelMulti_sum(Map<String, Object> dataMap);
	
	// 多维度测评模型 所有用户答题 查询每个维度 得分情况 根据维度和用户分组
	List<ScoreByDimension> getAllUserScoreByDimension(Map<String, Object> dataMap);
	
	// 查询每个维度 所有用户得分平均分值  不进行用户的分组
	List<ScoreByDimension> allUserScoreByDimension_noGroupByUser(Map<String, Object> dataMap);
	
	Integer getUserNum_accessAnswer(Map<String, Object> dataMap);
	
}
