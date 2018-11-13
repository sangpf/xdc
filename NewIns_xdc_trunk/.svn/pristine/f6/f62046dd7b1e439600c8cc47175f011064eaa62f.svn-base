package com.newins.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.PersonalDao;
import com.newins.model.MyInformation;
import com.newins.model.UpDatePersonalInfo;
import com.newins.service.PersonalService;

/**
 * 个人页面相关业务逻辑层实现类
 * @author zhangwenhao
 *
 */
@Service
public class PersonalServiceImp implements PersonalService {
	//绑定相关Dao
	@Autowired
	private PersonalDao personalDao;
	/**
	 * 加载用户个人信息方法
	 */
	public MyInformation LoadPersonalInfo(int userId) {
		//调用相关方法返回数据
		return personalDao.LoadPersonalInfo(userId);
	}

	/**
	 * 修改用户个人信息方法
	 */
	public int updadtePersonalInfo(UpDatePersonalInfo upDatePersonalInfo) {
		//调用相关方法返回数据
		return personalDao.updatePersonalInfo(upDatePersonalInfo);
	}

}
