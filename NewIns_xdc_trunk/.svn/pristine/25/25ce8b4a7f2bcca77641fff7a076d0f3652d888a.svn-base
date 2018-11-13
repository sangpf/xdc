package com.newins.dao;

import com.newins.model.NiUserEduHist;
import com.newins.model.NiUserEduHistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NiUserEduHistMapper {
    int countByExample(NiUserEduHistExample example);

    int deleteByExample(NiUserEduHistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NiUserEduHist record);

    int insertSelective(NiUserEduHist record);

    List<NiUserEduHist> selectByExample(NiUserEduHistExample example);

    NiUserEduHist selectByPrimaryKey(Integer id);
    //根据用户id查询
    List<NiUserEduHist> selectByUserId(Integer id);

    int updateByExampleSelective(@Param("record") NiUserEduHist record, @Param("example") NiUserEduHistExample example);

    int updateByExample(@Param("record") NiUserEduHist record, @Param("example") NiUserEduHistExample example);

    int updateByPrimaryKeySelective(NiUserEduHist record);

    int updateByPrimaryKey(NiUserEduHist record);
}