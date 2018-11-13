package com.newins.dao;

import com.newins.model.NiUserPostal;
import com.newins.model.NiUserPostalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiUserPostalMapper {
    int countByExample(NiUserPostalExample example);

    int deleteByExample(NiUserPostalExample example);

    int deleteByPrimaryKey(Integer postalid);

    int insert(NiUserPostal record);

    int insertSelective(NiUserPostal record);

    List<NiUserPostal> selectByExample(NiUserPostalExample example);

    NiUserPostal selectByPrimaryKey(Integer postalid);

    int updateByExampleSelective(@Param("record") NiUserPostal record, @Param("example") NiUserPostalExample example);

    int updateByExample(@Param("record") NiUserPostal record, @Param("example") NiUserPostalExample example);

    int updateByPrimaryKeySelective(NiUserPostal record);

    int updateByPrimaryKey(NiUserPostal record);
}