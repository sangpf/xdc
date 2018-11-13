/**
 * 
 */
package com.newins.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newins.model.NiSurveyQuestion;
import com.newins.model.SurveyQuestionWithOption;

/**@Description  加载问题完整信息Dao
 * @author Guan
 * @time 2016年6月29日 下午4:20:55
 */

public interface SurveyQuestionDao {

	List<SurveyQuestionWithOption> loadSurveyQuestionWithOption(int sqnId);
	
    List<SurveyQuestionWithOption> selectSurveyQuestion(int sqnId);
    
    SurveyQuestionWithOption loadSurveyKeyQuestionWithOption(@Param("sqnId")int sqnId,@Param("keyQuestionNum") int keyQuestionNum);
}
