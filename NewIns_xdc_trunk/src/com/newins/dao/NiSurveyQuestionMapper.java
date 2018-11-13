package com.newins.dao;

import com.newins.model.NiSurveyQuestion;
import com.newins.model.NiSurveyQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiSurveyQuestionMapper {
    int countByExample(NiSurveyQuestionExample example);

    int deleteByExample(NiSurveyQuestionExample example);

    int deleteByPrimaryKey(Integer sqid);

    int insert(NiSurveyQuestion record);

    int insertSelective(NiSurveyQuestion record);

    List<NiSurveyQuestion> selectByExample(NiSurveyQuestionExample example);

    NiSurveyQuestion selectByPrimaryKey(Integer sqid);

    int updateByExampleSelective(@Param("record") NiSurveyQuestion record, @Param("example") NiSurveyQuestionExample example);

    int updateByExample(@Param("record") NiSurveyQuestion record, @Param("example") NiSurveyQuestionExample example);

    int updateByPrimaryKeySelective(NiSurveyQuestion record);

    int updateByPrimaryKey(NiSurveyQuestion record);
    
    List<NiSurveyQuestion> selectSurveyQuestion(int id);
}