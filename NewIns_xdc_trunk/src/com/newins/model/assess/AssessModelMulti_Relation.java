package com.newins.model.assess;

public class AssessModelMulti_Relation {
	
	private Integer aqnId;
	private String relation;  // 联合主键
	
	private String resultSummary,resultDetail;  //测评结果

	public Integer getAqnId() {
		return aqnId;
	}

	public void setAqnId(Integer aqnId) {
		this.aqnId = aqnId;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
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
	
}
