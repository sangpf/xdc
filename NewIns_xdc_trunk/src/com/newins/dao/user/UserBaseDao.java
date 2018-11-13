package com.newins.dao.user;

import com.newins.model.user.UserBase;
import com.newins.model.user.UserIdentifer;

public interface UserBaseDao {
	
	int addUserBase(UserBase userBase);
	
	void addUserIdentifer(UserIdentifer userIdentifer);
	
}
