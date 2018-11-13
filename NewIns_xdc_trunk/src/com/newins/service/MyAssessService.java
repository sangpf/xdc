package com.newins.service;


/**
 * @Description 操作用户的历史评测信息
 * @author 星仔
 * @time 2017年2月16日下午3:54:46
 */
public interface MyAssessService {
	
	public Object getMyAssessList(int userId,int page);
	
	/**
	 * @Description 根据测评报告ID查询用户是否收藏过
	 * @param userId
	 * @param reportId
	 * @return
	 */
	public int getUserIsFavorite(int userId,int reportId);
	
//	/**
//	 * @Description 查询时候对此测评问卷做过报告
//	 * @param aqnId
//	 * @return
//	 */
//	public int getIsMakeReport(int aqnId);
	
//	/**
//	 * @Description 查询没有做过报告的测评
//	 * @param userId
//	 * @param page
//	 * @return
//	 */
//	public Object getNoReportList(int userId,int page);
}
