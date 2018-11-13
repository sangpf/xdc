package com.newins.dao;

import com.newins.model.NiVoteQuestionnaire;
import com.newins.model.NiVoteQuestionnaireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiVoteQuestionnaireMapper {
    int countByExample(NiVoteQuestionnaireExample example);

    int deleteByExample(NiVoteQuestionnaireExample example);

    int deleteByPrimaryKey(Integer vqnid);

    int insert(NiVoteQuestionnaire record);

    int insertSelective(NiVoteQuestionnaire record);

    List<NiVoteQuestionnaire> selectByExample(NiVoteQuestionnaireExample example);

    NiVoteQuestionnaire selectByPrimaryKey(Integer vqnid);

    int updateByExampleSelective(@Param("record") NiVoteQuestionnaire record, @Param("example") NiVoteQuestionnaireExample example);

    int updateByExample(@Param("record") NiVoteQuestionnaire record, @Param("example") NiVoteQuestionnaireExample example);

    int updateByPrimaryKeySelective(NiVoteQuestionnaire record);

    int updateByPrimaryKey(NiVoteQuestionnaire record);
}