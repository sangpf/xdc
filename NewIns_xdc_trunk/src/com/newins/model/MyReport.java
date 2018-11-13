package com.newins.model;

import java.io.Serializable;

/**
 * 我的收藏实体类
 * @author zhangwenhao
 *
 */
public class MyReport implements Serializable {
	
	private int favoriteId;//我的收藏Id
	private int userId;//"谁(userId)"收藏的报告
	private int reportId;//收藏的报告Id
	private String favoriteTime;//收藏的时间
	private String reportTitle;//报告名称
	private int qnType;//报告类型
	private String reportUrl;//结果页路径
	private int thumbUp;//点赞数
	private String reportClassName;//报告分类
	private int reportStatus;//报告状态
	/**
	 * 封装属性
	 * @return
	 */
	public int getFavoriteId() {
		return favoriteId;
	}
	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getFavoriteTime() {
		return favoriteTime;
	}
	public void setFavoriteTime(String favoriteTime) {
		this.favoriteTime = favoriteTime;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public int getQnType() {
		return qnType;
	}
	public void setQnType(int qnType) {
		this.qnType = qnType;
	}
	public String getReportUrl() {
		return reportUrl;
	}
	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}
	
	public String getReportClassName() {
		return reportClassName;
	}
	public void setReportClassName(String reportClassName) {
		this.reportClassName = reportClassName;
	}
	
	public int getThumbUp() {
		return thumbUp;
	}
	public void setThumbUp(int thumbUp) {
		this.thumbUp = thumbUp;
	}
	
	public int getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}
	/**
	 * 空参构造
	 */
	public MyReport() {
		super();
	}
	/**
	 * 添加收藏用构造
	 * @param userId
	 * @param reportId
	 * @param favoriteTime
	 */
	public MyReport(int userId, int reportId, String favoriteTime) {
		super();
		this.userId = userId;
		this.reportId = reportId;
		this.favoriteTime = favoriteTime;
	}
	
	
}
