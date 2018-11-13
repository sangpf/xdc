package com.newins.model;

import java.io.Serializable;

/**
 * 我的资料实体类
 * @author zhangwenhao
 *
 */
public class MyInformation implements Serializable {
	private String wanxNickName;//玩笑的昵称
	private String wanxHeadImg;//玩笑的图片地址
	private String gender;//性别
	private String birthday;//生日
	private String career;//职业
	private String schoolName;//学校名称
	private String enrolDate;//入校时间
	private String college;//院系
	private String degree;//学历
	private String grade;//年级
	private String major;//专业
	private String starSign;//星座
	private String bloodType;//血型
	private String character;//性格
	private String moral;//品格
	private String loveCondition;//感情状况
	private String phone;//手机号
	private String email;//邮箱
	private boolean success=true;//指定为true
	/**
	 * 封装属性
	 * @return
	 */
	public String getWanxNickName() {
		return wanxNickName;
	}
	public void setWanxNickName(String wanxNickName) {
		this.wanxNickName = wanxNickName;
	}
	public String getWanxHeadImg() {
		return wanxHeadImg;
	}
	public void setWanxHeadImg(String wanxHeadImg) {
		this.wanxHeadImg = wanxHeadImg;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCareer() {
		return career;
	}
	public void setCareer(String career) {
		this.career = career;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getEnrolDate() {
		return enrolDate;
	}
	public void setEnrolDate(String enrolDate) {
		this.enrolDate = enrolDate;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getStarSign() {
		return starSign;
	}
	public void setStarSign(String starSign) {
		this.starSign = starSign;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getMoral() {
		return moral;
	}
	public void setMoral(String moral) {
		this.moral = moral;
	}
	public String getLoveCondition() {
		return loveCondition;
	}
	public void setLoveCondition(String loveCondition) {
		this.loveCondition = loveCondition;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * 全参构造
	 * @param wanxNickName
	 * @param wanxHeadImg
	 * @param gender
	 * @param birthday
	 * @param career
	 * @param schoolName
	 * @param enrolDate
	 * @param college
	 * @param degree
	 * @param grade
	 * @param major
	 * @param starSign
	 * @param bloodType
	 * @param character
	 * @param moral
	 * @param loveCondition
	 * @param phone
	 * @param email
	 * @param success
	 */
	public MyInformation(String wanxNickName, String wanxHeadImg,
			String gender, String birthday, String career, String schoolName,
			String enrolDate, String college, String degree, String grade,
			String major, String starSign, String bloodType, String character,
			String moral, String loveCondition, String phone, String email,
			boolean success) {
		super();
		this.wanxNickName = wanxNickName;
		this.wanxHeadImg = wanxHeadImg;
		this.gender = gender;
		this.birthday = birthday;
		this.career = career;
		this.schoolName = schoolName;
		this.enrolDate = enrolDate;
		this.college = college;
		this.degree = degree;
		this.grade = grade;
		this.major = major;
		this.starSign = starSign;
		this.bloodType = bloodType;
		this.character = character;
		this.moral = moral;
		this.loveCondition = loveCondition;
		this.phone = phone;
		this.email = email;
		this.success = success;
	}
	/**
	 * 空参构造
	 */
	public MyInformation() {
		super();
	}
	
	
}
