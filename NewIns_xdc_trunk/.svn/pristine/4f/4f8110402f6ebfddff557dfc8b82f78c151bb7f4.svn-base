package com.newins.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.user.UserBaseDao;
import com.newins.model.user.UserBase;

@Service
public class UserBaseServiceImp implements UserBaseService {

	@Autowired
	private UserBaseDao userBaseDao;
	
	/**
	 * 新增用户
	 */
	public int addUserBase(UserBase userBase) {
		
		int addUserBase = userBaseDao.addUserBase(userBase);
		
		return addUserBase;
	}
	
	
	
}
