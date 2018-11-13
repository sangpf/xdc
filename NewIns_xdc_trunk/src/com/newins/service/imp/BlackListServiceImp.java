package com.newins.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.BlackListDao;
import com.newins.model.AdInfo;
import com.newins.service.BlackListService;
@Service
public class BlackListServiceImp implements BlackListService {
	@Autowired
	private BlackListDao blackListDao;
	/**
	 * 获取学校黑名单列表
	 */
	public List<Integer> getSchoolBlackList() {
		//无需处理直接调用Dao
		return blackListDao.getSchoolBlackList();
	}

	/**
	 * 根据完美校园schoolId查询我们学校字典表中对应的学校id
	 */
	public Integer userSchoolId(int wanxSchoolId) {
		//无需处理直接调用Dao
		return blackListDao.userSchoolId(wanxSchoolId);
	}

	/**
	 * 获取指定替换广告id的广告信息
	 * @param replaceAdId:替换的广告id
	 * @return
	 */
	public AdInfo getReplaceAdInfo(int replaceAdId) {
		//无需处理直接调用Dao
		return blackListDao.getReplaceAdInfo(replaceAdId);
	}

}
