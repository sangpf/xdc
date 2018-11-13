package com.newins.model;

import org.springframework.stereotype.Component;

/**@Description  报告列表中的model对象
 * @author MaNia_chAng
 * @time 2016年5月16日 下午4:17:05
 */
@Component(value = "ReportItem")
public class ReportItem {
	int reportId,viewNum,collectedNum,commentNum,thumbUp,thumbDown,isFavorite;
	String reportTitle,summary,publisher,pTime,reportUrl,reportImg,tag1Str,tag2Str,tag3Str,tag4Str;
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getCollectedNum() {
		return collectedNum;
	}
	public void setCollectedNum(int collectedNum) {
		this.collectedNum = collectedNum;
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
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getpTime() {
		return pTime;
	}
	public void setpTime(String pTime) {
		this.pTime = pTime;
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
	public int getIsFavorite() {
		return isFavorite;
	}
	public void setIsFavorite(int isFavorite) {
		this.isFavorite = isFavorite;
	}
	
	

}
