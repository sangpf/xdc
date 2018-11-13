package com.newins.model.user;

import java.util.Date;

public class UserBase {

	private Integer userId,gender;  
	
	private String userName,phone;
	
	private Date userCTime;
	
	private String comment;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUserCTime() {
		return userCTime;
	}

	public void setUserCTime(Date userCTime) {
		this.userCTime = userCTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserBase [userId=" + userId + ", gender=" + gender
				+ ", userName=" + userName + ", phone=" + phone
				+ ", userCTime=" + userCTime + ", comment=" + comment + "]";
	}
	
}
