package com.newins.dao;

import com.newins.model.NiAssessQuestion;
import com.newins.model.NiAssessQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiAssessQuestionMapper {
    int countByExample(NiAssessQuestionExample example);

    int deleteByExample(NiAssessQuestionExample example);

    int deleteByPrimaryKey(Integer aqid);

    int insert(NiAssessQuestion record);

    int insertSelective(NiAssessQuestion record);

    List<NiAssessQuestion> selectByExample(NiAssessQuestionExample example);

    NiAssessQuestion selectByPrimaryKey(Integer aqid);

    int updateByExampleSelective(@Param("record") NiAssessQuestion record, @Param("example") NiAssessQuestionExample example);

    int updateByExample(@Param("record") NiAssessQuestion record, @Param("example") NiAssessQuestionExample example);

    int updateByPrimaryKeySelective(NiAssessQuestion record);

    int updateByPrimaryKey(NiAssessQuestion record);
}