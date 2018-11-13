package com.newins.model;

import org.springframework.stereotype.Component;

/**@Description  抽奖对应Model
 * @author MaNia_chAng
 * @time 2016年5月24日 下午5:27:02
 */
@Component(value = "Lottery")
public class Lottery {
	String awardName,awardDes,comment;
	int awardRank,awardNum,awardId;
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getAwardDes() {
		return awardDes;
	}
	public void setAwardDes(String awardDes) {
		this.awardDes = awardDes;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getAwardRank() {
		return awardRank;
	}
	public void setAwardRank(int awardRank) {
		this.awardRank = awardRank;
	}
	public int getAwardNum() {
		return awardNum;
	}
	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}
	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}
	
	

}
