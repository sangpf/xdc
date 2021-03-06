package com.newins.model;

import java.util.ArrayList;
import java.util.List;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:47:36
 */
public class DeliveryInfo {
	int awardMethod,awardId,awardType,awardNum,adId,qnId,qnType,answered,thumbUp,thumbDown;
	String awardName,awardLink,adImg,adLink,relatedStr1,relatedStr2,relatedStr3,relatedUrl1,relatedUrl2,relatedUrl3,resultMsg;
	Integer lotteryId,evaluateId;
	int sqnCategory,aqnCategory,keyQuestionNum;
	
	List<Related> relatedList = new ArrayList<>();
	

	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public int getAwardMethod() {
		return awardMethod;
	}
	public void setAwardMethod(int awardMethod) {
		this.awardMethod = awardMethod;
	}
	public Integer getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}

	public int getAqnCategory() {
		return aqnCategory;
	}
	public void setAqnCategory(int aqnCategory) {
		this.aqnCategory = aqnCategory;
	}
	public int getKeyQuestionNum() {
		return keyQuestionNum;
	}
	public void setKeyQuestionNum(int keyQuestionNum) {
		this.keyQuestionNum = keyQuestionNum;
	}

	public int getAwardId() {
		return awardId;
	}
	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}
	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	public int getAwardNum() {
		return awardNum;
	}
	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}
	public int getQnId() {
		return qnId;
	}
	public void setQnId(int qnId) {
		this.qnId = qnId;
	}
	public int getQnType() {
		return qnType;
	}
	public void setQnType(int qnType) {
		this.qnType = qnType;
	}
	public int getAnswered() {
		return answered;
	}
	public void setAnswered(int answered) {
		this.answered = answered;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getAwardLink() {
		return awardLink;
	}
	public void setAwardLink(String awardLink) {
		this.awardLink = awardLink;
	}
	public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
	public String getAdLink() {
		return adLink;
	}
	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}
	public int getThumbUp() {
		return thumbUp;
	}
	public void setThumbUp(int thumbUp) {
		this.thumbUp = thumbUp;
	}
	public int getThumbDown() {
		return thumbDown;
	}
	public void setThumbDown(int thumbDown) {
		this.thumbDown = thumbDown;
	}
	public String getRelatedStr1() {
		return relatedStr1;
	}
	public void setRelatedStr1(String relatedStr1) {
		this.relatedStr1 = relatedStr1;
	}
	public String getRelatedStr2() {
		return relatedStr2;
	}
	public void setRelatedStr2(String relatedStr2) {
		this.relatedStr2 = relatedStr2;
	}
	public String getRelatedStr3() {
		return relatedStr3;
	}
	public void setRelatedStr3(String relatedStr3) {
		this.relatedStr3 = relatedStr3;
	}
	public String getRelatedUrl1() {
		return relatedUrl1;
	}
	public void setRelatedUrl1(String relatedUrl1) {
		this.relatedUrl1 = relatedUrl1;
	}
	public String getRelatedUrl2() {
		return relatedUrl2;
	}
	public void setRelatedUrl2(String relatedUrl2) {
		this.relatedUrl2 = relatedUrl2;
	}
	public String getRelatedUrl3() {
		return relatedUrl3;
	}
	public void setRelatedUrl3(String relatedUrl3) {
		this.relatedUrl3 = relatedUrl3;
	}
	public List<Related> getRelatedList() {
		return relatedList;
	}
	public void setRelatedList(List<Related> relatedList) {
		this.relatedList = relatedList;
	}	
	
	public int getSqnCategory() {
		return sqnCategory;
	}
	public void setSqnCategory(int sqnCategory) {
		this.sqnCategory = sqnCategory;
	}
	
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	
	public String getRelatedStrByIndex(int relatedStrIndex){
		switch(relatedStrIndex){
		case 1:
			return relatedStr1;
		case 2:
			return relatedStr2;
		case 3:
			return relatedStr3;
		default:
			return "超级调查";
		}
	}
	
	public String getRelatedUrlByIndex(int relatedUrlIndex){
		switch(relatedUrlIndex){
		case 1:
			return relatedUrl1;
		case 2:
			return relatedUrl2;
		case 3:
			return relatedUrl3;
		default:
			return "超级调查";
		}
	}

}
