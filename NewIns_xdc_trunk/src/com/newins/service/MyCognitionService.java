package com.newins.service;

import com.newins.model.MyCognitionModel;

/**
 * @Description 
 * @author 星仔
 * @time 2017年2月21日下午3:20:51
 */
public interface MyCognitionService {
	/**
	 * @Description 查询用户名和头像
	 * @param userId
	 * @return
	 */
	public MyCognitionModel getMyCognitionList(int userId);
	
	/**
	 * @Description 查询用户参与过的调查总数
	 * @param userId
	 * @return
	 */
	public int getMySuperSurveyCount(int userId);
	
	/**
	 * @Description 查询用户参与过的测评总数
	 * @param userId
	 * @return
	 */
	public int getMyAssessCount(int userId);
	
	/**
	 * @Description 查询用户收藏过的报告总数
	 * @param userId
	 * @return
	 */
	public int getMyFavoriteReportCount(int userId);
	
	/**
	 * @Description 查询用户获得过的奖励总数
	 * @param userId
	 * @return
	 */
	public int getMyAwardCount(int userId);
}
