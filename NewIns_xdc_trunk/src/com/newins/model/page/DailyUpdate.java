package com.newins.model.page;

import java.util.ArrayList;
import java.util.List;

public class DailyUpdate {
	
	private String itemType; // 内容类型, 前端页面根据该类型进行展示不同的内容
	
	// 问卷相关
	private Integer deliveryId,qnId,qnType;
	private Integer isTop,showOrder;
	private Integer collectNum,collectedNum;
	private String bTime,eTime;
	private String showTitle,showDes,img;
	
	private String tag1Str,tag2Str,tag3Str,tag4Str,tag5Str;
	
	private Integer lotteryId,awardId,awardNum;
	
	private String awardName,publisherName,qnSummary;
	private Integer adId;
	private String adImg,adLink;
	private Integer awardType;
	private String awardLink,titleTag,qnClassName;
	
	
	// 报告相关 
	private Integer reportId,viewNum,qnCollectedNum,commentNum,thumbUp,thumbDown;
	private String reportTitle,summary,reportUrl,reportImg;
	private String pTime;

	// 推文相关
	private Integer tweetId;
	private String tweetTitle,author,tag,picUrl,tweetUrl;
	
	List<String> tags = new ArrayList<>();//进存放不为空的外标签
	
	
	public String getTagByIndex(int tagIndex){
		switch(tagIndex){
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
	
	public Integer getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Integer getQnId() {
		return qnId;
	}
	public void setQnId(Integer qnId) {
		this.qnId = qnId;
	}
	public Integer getQnType() {
		return qnType;
	}
	public void setQnType(Integer qnType) {
		this.qnType = qnType;
	}
	public Integer getIsTop() {
		return isTop;
	}
	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public Integer getCollectedNum() {
		return collectedNum;
	}
	public void setCollectedNum(Integer collectedNum) {
		this.collectedNum = collectedNum;
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
	public String getShowDes() {
		return showDes;
	}
	public void setShowDes(String showDes) {
		this.showDes = showDes;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public Integer getLotteryId() {
		return lotteryId;
	}
	public void setLotteryId(Integer lotteryId) {
		this.lotteryId = lotteryId;
	}
	public Integer getAwardId() {
		return awardId;
	}
	public void setAwardId(Integer awardId) {
		this.awardId = awardId;
	}
	public Integer getAwardNum() {
		return awardNum;
	}
	public void setAwardNum(Integer awardNum) {
		this.awardNum = awardNum;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getQnSummary() {
		return qnSummary;
	}
	public void setQnSummary(String qnSummary) {
		this.qnSummary = qnSummary;
	}
	public Integer getAdId() {
		return adId;
	}
	public void setAdId(Integer adId) {
		this.adId = adId;
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
	public Integer getAwardType() {
		return awardType;
	}
	public void setAwardType(Integer awardType) {
		this.awardType = awardType;
	}
	public String getAwardLink() {
		return awardLink;
	}
	public void setAwardLink(String awardLink) {
		this.awardLink = awardLink;
	}
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
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	public Integer getQnCollectedNum() {
		return qnCollectedNum;
	}
	public void setQnCollectedNum(Integer qnCollectedNum) {
		this.qnCollectedNum = qnCollectedNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getThumbUp() {
		return thumbUp;
	}
	public void setThumbUp(Integer thumbUp) {
		this.thumbUp = thumbUp;
	}
	public Integer getThumbDown() {
		return thumbDown;
	}
	public void setThumbDown(Integer thumbDown) {
		this.thumbDown = thumbDown;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getReportUrl() {
		return reportUrl;
	}
	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}
	public String getReportImg() {
		return reportImg;
	}
	public void setReportImg(String reportImg) {
		this.reportImg = reportImg;
	}
	public String getpTime() {
		return pTime;
	}
	public void setpTime(String pTime) {
		this.pTime = pTime;
	}
	public Integer getTweetId() {
		return tweetId;
	}
	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetTitle() {
		return tweetTitle;
	}
	public void setTweetTitle(String tweetTitle) {
		this.tweetTitle = tweetTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getTweetUrl() {
		return tweetUrl;
	}
	public void setTweetUrl(String tweetUrl) {
		this.tweetUrl = tweetUrl;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
