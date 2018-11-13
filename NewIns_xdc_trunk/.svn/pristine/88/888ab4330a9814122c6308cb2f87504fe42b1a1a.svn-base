package com.newins.dao;

import com.newins.model.SurveyQuestionnaire;
import com.newins.model.NiSurveyQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiSurveyQuestionnaireMapper {
    int countByExample(NiSurveyQuestionnaireExample example);

    int deleteByExample(NiSurveyQuestionnaireExample example);

    int deleteByPrimaryKey(Integer sqnid);

    int insert(SurveyQuestionnaire record);

    int insertSelective(SurveyQuestionnaire record);

    List<SurveyQuestionnaire> selectByExample(NiSurveyQuestionnaireExample example);

    SurveyQuestionnaire selectByPrimaryKey(Integer sqnid);

    int updateByExampleSelective(@Param("record") SurveyQuestionnaire record, @Param("example") NiSurveyQuestionnaireExample example);

    int updateByExample(@Param("record") SurveyQuestionnaire record, @Param("example") NiSurveyQuestionnaireExample example);

    int updateByPrimaryKeySelective(SurveyQuestionnaire record);

    int updateByPrimaryKey(SurveyQuestionnaire record);
}