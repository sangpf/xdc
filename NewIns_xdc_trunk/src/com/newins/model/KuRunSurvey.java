package com.newins.model;

import java.sql.Timestamp;

/**
 * 库润问卷答题结果实体类
 * @author Zhang
 *
 */
public class KuRunSurvey {
	private int userId;//用户Id
	private int state;//答题状态
	private int surveyId;//问卷Id
	private String Etime;//答题完成时间
	//封装属性
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getTime() {
		return Etime;
	}
	public void setTime(String time) {
		this.Etime = time;
	}
	/**
	 * 全参构造
	 * @param userId
	 * @param state
	 * @param surveyId
	 * @param time
	 */
	public KuRunSurvey(int userId, int state, int surveyId, String time) {
		super();
		this.userId = userId;
		this.state = state;
		this.surveyId = surveyId;
		this.Etime = time;
	}
	/**
	 * 空参构造
	 */
	public KuRunSurvey() {
		super();
	}
	
}
