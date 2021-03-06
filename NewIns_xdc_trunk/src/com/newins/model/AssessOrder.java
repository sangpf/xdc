/**
 * 
 */
package com.newins.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * @Description 测评订单model
 * @author Guan
 * @time 2016年6月20日 下午14:18:43
 */
@Component(value = "AssessOrder")
public class AssessOrder {
	int orderId, userId, deliveryId, aqnId, awardId, sequenceNum, orderStatus, awardMethod,awardGetStatus;
	Timestamp orderCTime, answerBTime, answerETime;

	
	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAqnId() {
		return aqnId;
	}

	public void setAqnId(int aqnId) {
		this.aqnId = aqnId;
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public int getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public Timestamp getOrderCTime() {
		return orderCTime;
	}

	public void setOrderCTime(Timestamp orderCTime) {
		this.orderCTime = orderCTime;
	}

	public Timestamp getAnswerBTime() {
		return answerBTime;
	}

	public void setAnswerBTime(Timestamp answerBTime) {
		this.answerBTime = answerBTime;
	}

	public Timestamp getAnswerETime() {
		return answerETime;
	}

	public void setAnswerETime(Timestamp answerETime) {
		this.answerETime = answerETime;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getAwardMethod() {
		return awardMethod;
	}

	public void setAwardMethod(int awardMethod) {
		this.awardMethod = awardMethod;
	}

	public int getAwardGetStatus() {
		return awardGetStatus;
	}

	public void setAwardGetStatus(int awardGetStatus) {
		this.awardGetStatus = awardGetStatus;
	}
	
	
}
