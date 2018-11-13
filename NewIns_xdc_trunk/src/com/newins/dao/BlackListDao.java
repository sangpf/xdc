package com.newins.dao;

import java.util.List;

import com.newins.model.AdInfo;

/**
 * 黑名单dao层
 * @author Zhang
 *
 */
public  interface BlackListDao {
	/**
	 * 获取学校黑名单列表
	 */
	List<Integer> getSchoolBlackList();
	/**
	 * 根据完美校园schoolId查询我们学校字典表中对应的学校id
	 * @return
	 */
	Integer userSchoolId(int wanxSchoolId);
	/**
	 * 获取指定替换广告id的广告信息
	 * @param replaceAdId:替换的广告id
	 * @return
	 */
	AdInfo getReplaceAdInfo(int replaceAdId);
}
