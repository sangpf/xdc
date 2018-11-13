package com.newins.model.assess;

public class AssessModel_MBTI {
	
	private Integer aqnId;
	private Integer dimension; // 一级维度编号   联合主键
	private String leftSecond,rightSecond,comment;
	
	public Integer getAqnId() {
		return aqnId;
	}
	public void setAqnId(Integer aqnId) {
		this.aqnId = aqnId;
	}
	public Integer getDimension() {
		return dimension;
	}
	public void setDimension(Integer dimension) {
		this.dimension = dimension;
	}
	public String getLeftSecond() {
		return leftSecond;
	}
	public void setLeftSecond(String leftSecond) {
		this.leftSecond = leftSecond;
	}
	public String getRightSecond() {
		return rightSecond;
	}
	public void setRightSecond(String rightSecond) {
		this.rightSecond = rightSecond;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
}
