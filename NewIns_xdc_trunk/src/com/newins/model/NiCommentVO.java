package com.newins.model;

/**
 * 评论查询
 * @author 11409
 *
 */
public class NiCommentVO extends NiComment{
//	comNum,wanxHeadImg,wanxNickname;
//	private Integer comNum; //评论数量
	private String wanxHeadImg,wanxNickname,showTime,schoolName; //头像,昵称
	
//	public Integer getComNum() {
//		return comNum;
//	}
//	public void setComNum(Integer comNum) {
//		this.comNum = comNum;
//	}
	public String getWanxHeadImg() {
		return wanxHeadImg;
	}
	public void setWanxHeadImg(String wanxHeadImg) {
		this.wanxHeadImg = wanxHeadImg;
	}
	public String getWanxNickname() {
		return wanxNickname;
	}
	public void setWanxNickname(String wanxNickname) {
		this.wanxNickname = wanxNickname;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
}
