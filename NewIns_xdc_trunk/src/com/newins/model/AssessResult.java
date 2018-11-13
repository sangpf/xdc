/**
 * 
 */
package com.newins.model;

import org.springframework.stereotype.Component;

/**
 * @Description 测评结果model
 * @author Guan
 * @time 2016年6月21日 上午9:47:37
 */
@Component(value = "AssessResult")
public class AssessResult {
	
	private Integer totalScore, userId, aqnId;
	private String resultSummary, resultDetail;
	
	private Integer percentageScore;  // 得分百分比
	
	public Integer getPercentageScore() {
		return percentageScore;
	}
	public void setPercentageScore(Integer percentageScore) {
		this.percentageScore = percentageScore;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getAqnId() {
		return aqnId;
	}
	public void setAqnId(Integer aqnId) {
		this.aqnId = aqnId;
	}
	public String getResultSummary() {
		return resultSummary;
	}
	public void setResultSummary(String resultSummary) {
		this.resultSummary = resultSummary;
	}
	public String getResultDetail() {
		return resultDetail;
	}
	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}
	@Override
	public String toString() {
		return "AssessResult [totalScore=" + totalScore + ", userId=" + userId
				+ ", aqnId=" + aqnId + ", resultSummary=" + resultSummary
				+ ", resultDetail=" + resultDetail + ", percentageScore="
				+ percentageScore + "]";
	}


}