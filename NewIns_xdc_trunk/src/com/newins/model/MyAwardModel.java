package com.newins.model;


/**
 * @Description 用户的奖励历史model
 * @author 星仔
 * @time 2017年2月17日下午4:39:50
 */
public class MyAwardModel {
	private int awardId;
	private int awardNum;
	private String awardName;
	private int awardType;
	private String awardGetTime;
	private int awardMethod;
	private String redeemCode;
	
	
	public String getRedeemCode() {
		return redeemCode;
	}
	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	public int getAwardNum() {
		return awardNum;
	}
	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	public String getAwardGetTime() {
		return awardGetTime;
	}
	public void setAwardGetTime(String awardGetTime) {
		this.awardGetTime = awardGetTime;
	}
	public int getAwardMethod() {
		return awardMethod;
	}
	public void setAwardMethod(int awardMethod) {
		this.awardMethod = awardMethod;
	}
	public MyAwardModel(int awardId, int awardNum, String awardName,
			int awardType, String awardGetTime, int awardMethod,
			String redeemCode) {
		super();
		this.awardId = awardId;
		this.awardNum = awardNum;
		this.awardName = awardName;
		this.awardType = awardType;
		this.awardGetTime = awardGetTime;
		this.awardMethod = awardMethod;
		this.redeemCode = redeemCode;
	}
	public MyAwardModel() {
		super();
	}
	@Override
	public String toString() {
		return "MyAwardModel [awardId=" + awardId + ", awardNum=" + awardNum
				+ ", awardName=" + awardName + ", awardType=" + awardType
				+ ", awardGetTime=" + awardGetTime + ", awardMethod="
				+ awardMethod + ", redeemCode=" + redeemCode + "]";
	}
	
}
