/**
 * 
 */
package com.newins.dao;

import java.util.HashMap;

import com.newins.model.AssessOrder;
import com.newins.model.SurveyOrder;

/**@Description  
 * @author Guan
 * @time 2016年8月23日 上午10:26:06
 */

public interface CheckAwardGetStatusMapper {
	SurveyOrder checkAwardGetStatus(HashMap<String, Object> hashMap); 
	
	AssessOrder checkAssessAwardGetStatus(HashMap<String, Object> hashMap);
}
