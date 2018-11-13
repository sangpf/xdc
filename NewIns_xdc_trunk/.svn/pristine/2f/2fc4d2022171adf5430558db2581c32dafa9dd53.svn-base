/**
 * 
 */
package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.SurveyAnswer;

/**@Description  
 * @author Guan
 * @time 2016年10月11日 下午2:58:38
 */

public interface SurveyResultMapper {
	//根据userId和sqnId 在SurveyAnswer表中查询答题结果
	List<SurveyAnswer> getSurveyAnswerList(Map<String,Object> retMap);
	//根据userId,sqnId,和sqId查询 在SurveyAnswer表中查询答题结果，这个用户在这个题上的选项（核心题统计）
	SurveyAnswer getSurveyAnswer(Map<String,Object> retMap);
	
}
