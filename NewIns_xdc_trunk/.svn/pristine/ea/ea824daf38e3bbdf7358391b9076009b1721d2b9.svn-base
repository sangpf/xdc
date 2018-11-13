package com.newins.dao;

import com.newins.model.NiUserBase;
import com.newins.model.NiUserBaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiUserBaseMapper {
    int countByExample(NiUserBaseExample example);

    int deleteByExample(NiUserBaseExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(NiUserBase record);

    int insertSelective(NiUserBase record);

    List<NiUserBase> selectByExample(NiUserBaseExample example);

    NiUserBase selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") NiUserBase record, @Param("example") NiUserBaseExample example);

    int updateByExample(@Param("record") NiUserBase record, @Param("example") NiUserBaseExample example);

    int updateByPrimaryKeySelective(NiUserBase record);

    int updateByPrimaryKey(NiUserBase record);
}