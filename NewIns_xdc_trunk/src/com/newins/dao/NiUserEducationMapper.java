package com.newins.dao;

import com.newins.model.NiUserEducation;
import com.newins.model.NiUserEducationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiUserEducationMapper {
    int countByExample(NiUserEducationExample example);

    int deleteByExample(NiUserEducationExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(NiUserEducation record);

    int insertSelective(NiUserEducation record);

    List<NiUserEducation> selectByExample(NiUserEducationExample example);

    NiUserEducation selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") NiUserEducation record, @Param("example") NiUserEducationExample example);

    int updateByExample(@Param("record") NiUserEducation record, @Param("example") NiUserEducationExample example);

    int updateByPrimaryKeySelective(NiUserEducation record);

    int updateByPrimaryKey(NiUserEducation record);
}