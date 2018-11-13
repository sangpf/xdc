package com.newins.model;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * 口粮兑换券实体
 * @author zhangwenhao
 *
 */
public class RedeemCode implements Serializable {
	private int redeemCodeId;//兑换码Id
	private String redeemCode;//兑换码
	private String awardName;//对应的奖池的奖励名称
	private int userId;//领取兑换券的用户Id
	private String validBTime;//活动有效期开始时间
	private String validETime;//活动有效期结束时间
	private int awaedId;//奖励Id
	private String phoneNum;//手机号
	public int getRedeemCodeId() {
		return redeemCodeId;
	}
	public void setRedeemCodeId(int redeemCodeId) {
		this.redeemCodeId = redeemCodeId;
	}
	public String getRedeemCode() {
		return redeemCode;
	}
	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getValidBTime() {
		return validBTime;
	}
	public void setValidBTime(String validBTime) {
		this.validBTime = validBTime;
	}
	public String getValidETime() {
		return validETime;
	}
	public void setValidETime(String validETime) {
		this.validETime = validETime;
	}
	public int getAwaedId() {
		return awaedId;
	}
	public void setAwaedId(int awaedId) {
		this.awaedId = awaedId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 查询口粮兑换码用构造
	 * @param id
	 * @param redeemCode
	 * @param awardName
	 * @param validBTime
	 * @param validETime
	 * @param awaedId
	 */
	public RedeemCode(int redeemCodeId, String redeemCode, String awardName,
			String validBTime, String validETime, int awaedId) {
		super();
		this.redeemCodeId = redeemCodeId;
		this.redeemCode = redeemCode;
		this.awardName = awardName;
		this.validBTime = validBTime;
		this.validETime = validETime;
		this.awaedId = awaedId;
	}
	/**
	 * 更新兑换码相关信息用构造
	 * @param id
	 * @param userId
	 * @param phoneNum
	 */
	public RedeemCode(int redeemCodeId, int userId, String phoneNum) {
		super();
		this.redeemCodeId = redeemCodeId;
		this.userId = userId;
		this.phoneNum = phoneNum;
	}
	/**
	 * 空参构造
	 */
	public RedeemCode() {
		super();
	}
	@Override
	public String toString() {
		return "RedeemCode [redeemCodeId=" + redeemCodeId + ", redeemCode="
				+ redeemCode + ", awardName=" + awardName + ", userId="
				+ userId + ", validBTime=" + validBTime + ", validETime="
				+ validETime + ", awaedId=" + awaedId + ", phoneNum="
				+ phoneNum + "]";
	}
	
}
