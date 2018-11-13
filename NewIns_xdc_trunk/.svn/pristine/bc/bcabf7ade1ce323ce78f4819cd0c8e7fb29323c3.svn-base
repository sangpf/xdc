/**
 * 
 */
package com.newins.service;

import java.util.List;

import com.newins.model.NiSurveyQuestion;
import com.newins.model.SurveyQuestionWithOption;

/**@Description  加载问题完整信息service
 * @author Guan
 * @time 2016年6月29日 下午4:54:56
 */

public interface LoadSurveyQuestionService {
	/**
	 * @Title: loadSurveyQuestionWithOption  
	 * @Author: Guan
	 * @Description: 根据问卷Id将所有问题的完整信息（包含选项）加载出来
	 * @param sqnId
	 * @return List<SurveyQuestionWithOption>
	 * @Time 2016年6月30日 下午3:30:31
	 */
	List<SurveyQuestionWithOption> loadSurveyQuestionWithOption(int sqnId);
	
	/**
	 * @Title: selectSurveyQuestionBySqnId  
	 * @Author: Guan
	 * @Description: 根据问卷Id 查出所有的问题
	 * @param sqnId
	 * @return List<NiSurveyQuestion>
	 * @Time 2016年10月10日 下午8:20:03
	 */
    List<SurveyQuestionWithOption> selectSurveyQuestionBySqnId(int sqnId);
    
/**
 * @Title: loadSurveyQuestionWithOption  
 * @Author: Guan
 * @Description: 核心题，根据sqnId和keyQuestionNum查询一条问题和选项内容
 * @param sqnId
 * @param keyQuestionNum
 * @return SurveyQuestionWithOption
 * @Time 2016年11月18日 下午3:42:56
 */
	SurveyQuestionWithOption loadSurveyKeyQuestionWithOption(int sqnId,int keyQuestionNum);
}
