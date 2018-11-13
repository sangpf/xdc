package com.newins.model;

import java.sql.Timestamp;

/**
 * 消费实体类
 * @author Zhang
 *
 */
public class Consume {
	private int consumeId;//流水号
	private int userId;//用户Id
	private int reason;//消费行为
	private String time;//消费时间
	private int qnType;//问卷类型
	private int deliveryId;//投放Id
	private int consumeType;//消费品类型
	private String consumeQuantity;//消费金额
	private int status;//消费状态
	private String comment;//备注
	
	//封装属性
	public int getConsumeId() {
		return consumeId;
	}
	public void setConsumeId(int consumeId) {
		this.consumeId = consumeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReason() {
		return reason;
	}
	public void setReason(int reason) {
		this.reason = reason;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getQnType() {
		return qnType;
	}
	public void setQnType(int qnType) {
		this.qnType = qnType;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getConsumeType() {
		return consumeType;
	}
	public void setConsumeType(int consumeType) {
		this.consumeType = consumeType;
	}
	public String getConsumeQuantity() {
		return consumeQuantity;
	}
	public void setConsumeQuantity(String consumeQuantity) {
		this.consumeQuantity = consumeQuantity;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * 消费流水添加构造
	 * @param userId
	 * @param reason
	 * @param time
	 * @param qnType
	 * @param deliveryId
	 * @param consumeType
	 * @param consumeQuantity
	 * @param status
	 */
	public Consume(int userId, int reason, String time, int qnType,
			int deliveryId, int consumeType, String consumeQuantity, int status) {
		super();
		this.userId = userId;
		this.reason = reason;
		this.time = time;
		this.qnType = qnType;
		this.deliveryId = deliveryId;
		this.consumeType = consumeType;
		this.consumeQuantity = consumeQuantity;
		this.status = status;
	}
	
	
}
