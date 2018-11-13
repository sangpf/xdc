/**
 * 
 */
package com.newins.service;


/**@Description  动态加载调查问卷service
 * @author Guan
 * @time 2016年6月28日 下午9:19:24
 */

public interface LoadSurveyQuestionnaireService {
	/**
	 * @Title: loadSurveyQuestionnaire  
	 * @Author: Guan
	 * @Description: 根据问卷Id加载问卷内容(并根据是否答过以及sqnCategory来判断是否加载用户选择的答案)
	 * @param sqnId
	 * @return SurveyQuestionnaire
	 * @Time 2016年6月30日 下午3:28:19
	 */
	Object loadSurveyQuestionnaire(int sqnId,int userId, String answered, int sqnCategory);
}
