package cn.xdc.login.dao;

import cn.xdc.login.po.NiUserPostal;


public interface NiUserPostalMapper {
	
    int deleteByPrimaryKey(Integer postalid);

    int insert(NiUserPostal record);

    int insertSelective(NiUserPostal record);

    NiUserPostal selectByPrimaryKey(Integer postalid);

    int updateByPrimaryKeySelective(NiUserPostal record);

    int updateByPrimaryKey(NiUserPostal record);
    
}