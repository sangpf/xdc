package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.CheckUserIdTemporaryDao;
import com.newins.service.CheckUserIdTemporaryService;

/**
 * 检查当前用户是否是临时用户数据库操作层
 * @author ZhangWenHao
 *
 */
@Service
public class CheckUserIdTemporaryServiceImp implements CheckUserIdTemporaryService {
	
	@Autowired
	private CheckUserIdTemporaryDao checkUserIdTemporaryDao;
	
	@Override
	public String checkUserType(int userId) {
		
		return checkUserIdTemporaryDao.checkUserType(userId);
	}

	@Override
	public int getResultShowType(int qnId) {
		// TODO Auto-generated method stub
		return checkUserIdTemporaryDao.getResultShowType(qnId);
	}

	@Override
	public String getNickName(int userId) {
		// TODO Auto-generated method stub
		return checkUserIdTemporaryDao.getNickName(userId);
	}

}
