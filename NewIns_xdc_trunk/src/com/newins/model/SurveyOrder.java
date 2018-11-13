/**
 * 
 */
package com.newins.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @author Guan
 * @time 2016年6月1日 上午11:06:43
 */
@Component(value = "SurveyOrder")
public class SurveyOrder {
	int orderId, userId, deliveryId,sqnId, awardId, sequenceNum, orderStatus,awardMethod,lotteryRank,awardGetStatus;
	Timestamp orderCTime, answerBTime, answerETime;
	

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public int getAwardGetStatus() {
		return awardGetStatus;
	}

	public void setAwardGetStatus(int awardGetStatus) {
		this.awardGetStatus = awardGetStatus;
	}

	public int getLotteryRank() {
		return lotteryRank;
	}

	public void setLotteryRank(int lotteryRank) {
		this.lotteryRank = lotteryRank;
	}

	public int getAwardMethod() {
		return awardMethod;
	}

	public void setAwardMethod(int awardMethod) {
		this.awardMethod = awardMethod;
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

	public int getSqnId() {
		return sqnId;
	}

	public void setSqnId(int sqnId) {
		this.sqnId = sqnId;
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

}
