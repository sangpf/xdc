package com.newins.dao;

import java.util.List;

import com.newins.model.MyCognitionModel;

/**
 * @Description 
 * @author 星仔
 * @time 2017年2月21日下午2:59:18
 */
public interface MyCognitionDao {
	/**
	 * @Description 查询用户名和头像
	 * @param userId
	 * @return
	 */
	public MyCognitionModel myCognitionList(int userId);
	
	/**
	 * @Description 查询tags
	 * @param userId
	 * @return
	 */
	public MyCognitionModel myTagsList(int userId);
	
	/**
	 * @Description 查询用户参与过的调查总数
	 * @return
	 */
	public int mySuperSurveyCount(int userId);
	
	/**
	 * @Description 查询用户参与过的测评总数
	 * @param userId
	 * @return
	 */
	public int myAssessCount(int userId);
	
	/**
	 * @Description 查询用户收藏过的报告总数
	 * @param userId
	 * @return
	 */
	public int myFavoriteReportCount(int userId);
	
	/**
	 * @Description 查询用户获得过的奖励总数
	 * @param userId
	 * @return
	 */
	public int myAwardCount(int userId);
}
