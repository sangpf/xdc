package com.newins.dao.assess;

import java.util.List;
import java.util.Map;

import com.newins.model.assess.AssessModel_MBTI;
import com.newins.model.assess.AssessModel_mbti_combination;
import com.newins.model.assess.ScoreByDimension;

public interface AssessModel_MBTIDao {
	
	List<AssessModel_MBTI> findAssessModel_MBTI(Map<String,Object> dataMap);

	
	List<ScoreByDimension> getMaxScoreByDimension_mbti(Map<String, Object> dataMap);


	// 根据 问卷id 联合维度编号 ,查询联合维度输出
	List<AssessModel_mbti_combination> getAssessModel_mbti_combination(Map<String, Object> dataMap);
	
	
	
}
