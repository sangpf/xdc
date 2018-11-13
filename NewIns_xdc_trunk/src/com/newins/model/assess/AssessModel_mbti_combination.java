package com.newins.model.assess;

public class AssessModel_mbti_combination {
	
	private Integer aqnId;  // 联合主键
	private String dimension,resultSummary,resultDetail,comment;
	
	public Integer getAqnId() {
		return aqnId;
	}
	public void setAqnId(Integer aqnId) {
		this.aqnId = aqnId;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
