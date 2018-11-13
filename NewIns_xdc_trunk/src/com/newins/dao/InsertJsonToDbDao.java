package com.newins.dao;

import java.util.List;

import com.newins.model.InsertJson;
import com.newins.model.NiUserEducation;

/**
 * 将Openid一样的数据保存到identifer，education,edu-hist表中
 * @author zhangwenhao
 *
 */
public interface InsertJsonToDbDao {
	/**
	 * 查询40000个要加入的数据表所有数据
	 * @return
	 */
	public List<InsertJson> InsertJsonData(); 
	/**
	 * 查询ni_user_Base加入的userId是否已经存在
	 * @param userId:要查询的UserId
	 * @return sql语句执行返回影响行数
	 */
	int selectUserBaseUserId(int userId);
	/**
	 * 查询ni_user_education表加入的userId是否存在
	 * @param userId：要查询的userId
	 * @return:sql语句执行返回影响行数
	 */
	int selectEduUserId(int userId);
	/**
	 * 查询ni_user_education_hist表加入的userId是否存在
	 * @param userId：要查询的userId
	 * @return:sql语句执行返回影响行数
	 */
	int selectEduHistUserId(int userId);
}
