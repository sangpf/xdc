package com.newins.dao;

import com.newins.model.NiSchoolDict;
import com.newins.model.NiSchoolDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiSchoolDictMapper {
    int countByExample(NiSchoolDictExample example);

    int deleteByExample(NiSchoolDictExample example);

    int deleteByPrimaryKey(Integer schoolid);

    int insert(NiSchoolDict record);

    int insertSelective(NiSchoolDict record);

    List<NiSchoolDict> selectByExample(NiSchoolDictExample example);

    NiSchoolDict selectByPrimaryKey(Integer schoolid);
    
    NiSchoolDict selectByWanxSchoolName(String wanxSchoolid);

    int updateByExampleSelective(@Param("record") NiSchoolDict record, @Param("example") NiSchoolDictExample example);

    int updateByExample(@Param("record") NiSchoolDict record, @Param("example") NiSchoolDictExample example);

    int updateByPrimaryKeySelective(NiSchoolDict record);

    int updateByPrimaryKey(NiSchoolDict record);
}