package com.newins.model.assess;

public class Assess_model_simple {
	private Integer aqnId,intervalId;  // 联合主键
	private Integer intervalBegin;
	private Integer intervalEnd;
	private String resultSummary;
	private String resultDetail;
	
	public Integer getAqnId() {
		return aqnId;
	}
	public void setAqnId(Integer aqnId) {
		this.aqnId = aqnId;
	}
	public Integer getIntervalId() {
		return intervalId;
	}
	public void setIntervalId(Integer intervalId) {
		this.intervalId = intervalId;
	}
	public Integer getIntervalBegin() {
		return intervalBegin;
	}
	public void setIntervalBegin(Integer intervalBegin) {
		this.intervalBegin = intervalBegin;
	}
	public Integer getIntervalEnd() {
		return intervalEnd;
	}
	public void setIntervalEnd(Integer intervalEnd) {
		this.intervalEnd = intervalEnd;
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
		return "Assess_model_simple [aqnId=" + aqnId + ", intervalId="
				+ intervalId + ", intervalBegin=" + intervalBegin
				+ ", intervalEnd=" + intervalEnd + ", resultSummary="
				+ resultSummary + ", resultDetail=" + resultDetail + "]";
	}
	
	
}
