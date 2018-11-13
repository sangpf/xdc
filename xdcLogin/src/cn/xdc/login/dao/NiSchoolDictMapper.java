package cn.xdc.login.dao;

import cn.xdc.login.po.NiSchoolDict;

public interface NiSchoolDictMapper {

    int deleteByPrimaryKey(Integer schoolid);

    int insert(NiSchoolDict record);

    int insertSelective(NiSchoolDict record);

    NiSchoolDict selectByPrimaryKey(Integer schoolid);
    
    NiSchoolDict selectByWanxSchoolName(String wanxSchoolid);

    int updateByPrimaryKeySelective(NiSchoolDict record);

    int updateByPrimaryKey(NiSchoolDict record);
}