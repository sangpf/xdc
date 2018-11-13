package com.newins.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 我的认知首页
 * @author 星仔
 * @time 2017年2月21日下午2:45:16
 */
public class MyCognitionModel {
	private String wanxNickName;
	private String wanxHeadImg;
	private int mySuperSurvey;
	private int myAssess;
	private int myFavoriteReport;
	private int myAwardLiangpiao;
	private String gender;
	private String loveCondition;
	private String starSign;
	private String character;
	private String moral;
	private String grade;
	private List<String> myTags;
//	public static void main(String[] args) {
//		MyCognitionModel cognitionModel = new MyCognitionModel();
//		List<String> list = new ArrayList<String>();
//		list.add(0,cognitionModel.getGender());
//		list.add(1,cognitionModel.getLoveCondition());
//		list.add(2,cognitionModel.getStarSign());
//		list.add(3,cognitionModel.getCharacter());
//		list.add(4,cognitionModel.getMoral());
//		list.add(5,cognitionModel.getGrade());
//		cognitionModel.setMyTags(list);
//	}
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
	public int getMySuperSurvey() {
		return mySuperSurvey;
	}
	public void setMySuperSurvey(int mySuperSurvey) {
		this.mySuperSurvey = mySuperSurvey;
	}
	public int getMyAssess() {
		return myAssess;
	}
	public void setMyAssess(int myAssess) {
		this.myAssess = myAssess;
	}
	public int getMyFavoriteReport() {
		return myFavoriteReport;
	}
	public void setMyFavoriteReport(int myFavoriteReport) {
		this.myFavoriteReport = myFavoriteReport;
	}
	public int getMyAwardLiangpiao() {
		return myAwardLiangpiao;
	}
	public void setMyAwardLiangpiao(int myAwardLiangpiao) {
		this.myAwardLiangpiao = myAwardLiangpiao;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLoveCondition() {
		return loveCondition;
	}
	public void setLoveCondition(String loveCondition) {
		this.loveCondition = loveCondition;
	}
	public String getStarSign() {
		return starSign;
	}
	public void setStarSign(String starSign) {
		this.starSign = starSign;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<String> getMyTags() {
		return myTags;
	}
	public void setMyTags(List<String> myTags) {
		this.myTags = myTags;
	}
	public MyCognitionModel(String wanxNickName, String wanxHeadImg,
			int mySuperSurvey, int myAssess, int myFavoriteReport,
			int myAwardLiangpiao, String gender, String loveCondition,
			String starSign, String character, String moral, String grade,
			List<String> myTags) {
		super();
		this.wanxNickName = wanxNickName;
		this.wanxHeadImg = wanxHeadImg;
		this.mySuperSurvey = mySuperSurvey;
		this.myAssess = myAssess;
		this.myFavoriteReport = myFavoriteReport;
		this.myAwardLiangpiao = myAwardLiangpiao;
		this.gender = gender;
		this.loveCondition = loveCondition;
		this.starSign = starSign;
		this.character = character;
		this.moral = moral;
		this.grade = grade;
		this.myTags = myTags;
	}
	public MyCognitionModel() {
		super();
	}
	@Override
	public String toString() {
		return "MyCognitionModel [wanxNickName=" + wanxNickName
				+ ", wanxHeadImg=" + wanxHeadImg + ", mySuperSurvey="
				+ mySuperSurvey + ", myAssess=" + myAssess
				+ ", myFavoriteReport=" + myFavoriteReport
				+ ", myAwardLiangpiao=" + myAwardLiangpiao + ", gender="
				+ gender + ", loveCondition=" + loveCondition + ", starSign="
				+ starSign + ", character=" + character + ", moral=" + moral
				+ ", grade=" + grade + ", myTags=" + myTags + "]";
	}
	
	
	
}
