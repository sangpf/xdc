package com.newins.service;

import java.util.List;

import com.newins.model.NiSurveyQuestion;

public interface NiSurveyQuestionService {
	
    int insert(NiSurveyQuestion record);

    int insertSelective(NiSurveyQuestion record);
    
    List<NiSurveyQuestion> selectSurveyQuestion(int id);
}
