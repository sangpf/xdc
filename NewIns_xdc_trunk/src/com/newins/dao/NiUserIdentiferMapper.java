package com.newins.dao;

import com.newins.model.NiUserIdentifer;


public interface NiUserIdentiferMapper {

	//根据玩校id查询用户标识表
	NiUserIdentifer selectByWanxuserId(Integer wanxId);

	//根据主键修改
	int updateByPrimaryKeySelective(NiUserIdentifer recoed);
	
	//添加
	int insertSelective(NiUserIdentifer recoed);
	
	//根据主键查询
	NiUserIdentifer selectByPrimaryKey(Integer userId);
	
}