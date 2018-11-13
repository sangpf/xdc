package com.newins.model;

import java.sql.Timestamp;

/**
 * @Description 测评问卷玩校投放点击流水表model(ni_assess_delivery_wanx_flow表)
 * @author wanq
 * @time 2016年10月11日
 */
public class NiAssessDeliveryWanxFlow {
	private int flowId; // 流水id
	private int deliveryId; // 投放id
	private int userId; // 用户id
	private Timestamp tapTime; // 点击时间
	private String comment; // 备注
	private int tapSource;// 点击来源

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getTapTime() {
		return tapTime;
	}

	public void setTapTime(Timestamp tapTime) {
		this.tapTime = tapTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getTapSource() {
		return tapSource;
	}

	public void setTapSource(int tapSource) {
		this.tapSource = tapSource;
	}

}
