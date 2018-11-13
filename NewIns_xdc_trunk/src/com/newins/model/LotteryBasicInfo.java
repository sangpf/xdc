package com.newins.model;

import org.springframework.stereotype.Component;

/**@Description  抽奖命运表Model
 * @author MaNia_chAng
 * @time 2016年5月24日 下午5:27:02
 */
@Component(value = "LotteryBasicInfo")
public class LotteryBasicInfo {
	String awardTime,comment;
	int deliveryId,qnType,channel,sequenceNum,lotteryId,awardRank;
	Integer userId;
	public String getAwardTime() {
		return awardTime;
	}
	public void setAwardTime(String awardTime) {
		this.awardTime = awardTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getQnType() {
		return qnType;
	}
	public void setQnType(int qnType) {
		this.qnType = qnType;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getSequenceNum() {
		return sequenceNum;
	}
	public void setSequenceNum(int sequenceNum) {
		this.sequenceNum = sequenceNum;
	}
	public int getLotteryId() {
		return lotteryId;
	}
	public void setLotteryId(int lotteryId) {
		this.lotteryId = lotteryId;
	}
	public int getAwardRank() {
		return awardRank;
	}
	public void setAwardRank(int awardRank) {
		this.awardRank = awardRank;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
}
