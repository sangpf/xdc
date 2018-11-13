package cn.xdc.login.dao;

import cn.xdc.login.po.NiUserBase;


public interface NiUserBaseMapper {

    int deleteByPrimaryKey(Integer userid);

    int insert(NiUserBase record);

    int insertSelective(NiUserBase record);

    NiUserBase selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(NiUserBase record);

    int updateByPrimaryKey(NiUserBase record);
}