package com.newins.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.user.UserBaseDao;
import com.newins.model.user.UserIdentifer;

@Service
public class UserIdentiferServiceImp implements UserIdentiferService {

	@Autowired
	private UserBaseDao serBaseDao;
	
	public void add(UserIdentifer userIdentifer) {
		
		serBaseDao.addUserIdentifer(userIdentifer);
		
	}
	
}
