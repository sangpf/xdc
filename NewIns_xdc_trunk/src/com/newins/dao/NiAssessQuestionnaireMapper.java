package com.newins.dao;

import com.newins.model.NiAssessQuestionnaire;
import com.newins.model.NiAssessQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiAssessQuestionnaireMapper {
    int countByExample(NiAssessQuestionnaireExample example);

    int deleteByExample(NiAssessQuestionnaireExample example);

    int deleteByPrimaryKey(Integer aqnid);

    int insert(NiAssessQuestionnaire record);

    int insertSelective(NiAssessQuestionnaire record);

    List<NiAssessQuestionnaire> selectByExample(NiAssessQuestionnaireExample example);

    NiAssessQuestionnaire selectByPrimaryKey(Integer aqnid);

    int updateByExampleSelective(@Param("record") NiAssessQuestionnaire record, @Param("example") NiAssessQuestionnaireExample example);

    int updateByExample(@Param("record") NiAssessQuestionnaire record, @Param("example") NiAssessQuestionnaireExample example);

    int updateByPrimaryKeySelective(NiAssessQuestionnaire record);

    int updateByPrimaryKey(NiAssessQuestionnaire record);
}