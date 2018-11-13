package com.newins.dao;

import java.util.List;

import com.newins.model.MyAssessModel;

/**
 * @Description 
 * @author 星仔
 * @time 2017年2月15日下午4:21:10
 */
public interface MyAssessDao {
	/**
	 * @Description 查询指定用户的历史评测信息
	 * @param userId
	 * @return
	 */
	List<MyAssessModel> myAssessList(int userId);
	
	/**
	 * @Description 根据测评报告ID查询用户是否收藏过
	 * @param reportId
	 * @return
	 */
	public int userIsFavorite(int userId,int reportId);
	
//	/**
//	 * @Description 根据aqnId查询是否已经做过报告（在报告表中时候存在aqnId的报告）
//	 * @param aqnId
//	 * @return
//	 */
//	public int isMakeReport(int aqnId);
	
	/**
	 * @Description 没有写过报告的测评
	 * @param userId
	 * @return
	 */
//	public List<MyAssessModel> noReportList(int userId);
}
