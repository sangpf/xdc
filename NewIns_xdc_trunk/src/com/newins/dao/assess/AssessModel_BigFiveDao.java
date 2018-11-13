package com.newins.dao.assess;

import java.util.List;
import java.util.Map;

import com.newins.model.assess.AssessModel_BigFive;

/**
 * 大五模型
 * @author sang
 *
 */
public interface AssessModel_BigFiveDao {
	
	List<AssessModel_BigFive> findAssessModel_BigFive(Map<String,Object> dataMap);
	
}
