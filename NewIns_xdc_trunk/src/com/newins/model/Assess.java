/**
 * 
 */
package com.newins.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @Description 测评列表model
 * @author Guan
 * @time 2016年6月17日 下午8:15:38
 */
@Component(value = "Assess")
public class Assess {
	int aqnId, collectedNum, winnerNum, collectNum, deliveryId, adId, awardId,
			awardMethod,answered,awardType,showType;
	String showDes, bTime, eTime, showTitle, publisher, aqnSummary, img,
			awardName, awardNum, tag1Str, tag2Str, tag3Str, tag4Str, tag5Str, adImg, adLink,awardLink,titleTag,qnClassName;
	Integer lotteryId;
	List<String> tags = new ArrayList<>();// 进存放不为空的外标签

	
	
	public String getTitleTag() {
		return titleTag;
	}

	public void setTitleTag(String titleTag) {
		this.titleTag = titleTag;
	}

	public String getQnClassName() {
		return qnClassName;
	}

	public void setQnClassName(String qnClassName) {
		this.qnClassName = qnClassName;
	}

	public int getAwardType() {
		return awardType;
	}

	public void setAwardType(int awardType) {
		this.awardType = awardType;
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

	public int getAnswered() {
		return answered;
	}

	public void setAnswered(int answered) {
		this.answered = answered;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public int getAqnId() {
		return aqnId;
	}

	public void setAqnId(int aqnId) {
		this.aqnId = aqnId;
	}

	public int getCollectedNum() {
		return collectedNum;
	}

	public void setCollectedNum(int collectedNum) {
		this.collectedNum = collectedNum;
	}

	public int getWinnerNum() {
		return winnerNum;
	}

	public void setWinnerNum(int winnerNum) {
		this.winnerNum = winnerNum;
	}

	public int getCollectNum() {
		return collectNum;
	}

	public void setCollectNum(int collectNum) {
		this.collectNum = collectNum;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}

	public String getShowDes() {
		return showDes;
	}

	public void setShowDes(String showDes) {
		this.showDes = showDes;
	}

	public String getbTime() {
		return bTime;
	}

	public void setbTime(String bTime) {
		this.bTime = bTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAqnSummary() {
		return aqnSummary;
	}

	public void setAqnSummary(String aqnSummary) {
		this.aqnSummary = aqnSummary;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getAwardId() {
		return awardId;
	}

	public void setAwardId(int awardId) {
		this.awardId = awardId;
	}

	public int getawardMethod() {
		return awardMethod;
	}

	public void setawardMethod(int awardMethod) {
		this.awardMethod = awardMethod;
	}

	public Integer getLotteryId() {
		return lotteryId;
	}

	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardNum() {
		return awardNum;
	}

	public void setAwardNum(String awardNum) {
		this.awardNum = awardNum;
	}
	public String getTag1Str() {
		return tag1Str;
	}

	public void setTag1Str(String tag1Str) {
		this.tag1Str = tag1Str;
	}

	public String getTag2Str() {
		return tag2Str;
	}

	public void setTag2Str(String tag2Str) {
		this.tag2Str = tag2Str;
	}

	public String getTag3Str() {
		return tag3Str;
	}

	public void setTag3Str(String tag3Str) {
		this.tag3Str = tag3Str;
	}

	public String getTag4Str() {
		return tag4Str;
	}

	public void setTag4Str(String tag4Str) {
		this.tag4Str = tag4Str;
	}

	public String getTag5Str() {
		return tag5Str;
	}

	public void setTag5Str(String tag5Str) {
		this.tag5Str = tag5Str;
	}

	public int getAdId() {
		return adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}
	
	
	
	
	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
	}

	public String getTagByIndex(int tagIndex) {
		switch (tagIndex) {
		case 1:
			return tag1Str;
		case 2:
			return tag2Str;
		case 3:
			return tag3Str;
		case 4:
			return tag4Str;
		case 5:
			return tag5Str;
		default:
			return "超级调查";
		}
	}
}
