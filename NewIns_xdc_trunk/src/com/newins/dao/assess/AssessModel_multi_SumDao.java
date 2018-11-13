package com.newins.dao.assess;

import java.util.List;
import java.util.Map;

import com.newins.model.assess.AssessModel_multi_Sum;

public interface AssessModel_multi_SumDao {
	
	List<AssessModel_multi_Sum> selectByKey(Map<String,Object> dataMap);
	
}
