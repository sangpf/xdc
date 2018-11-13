package com.newins.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @Description  调查核心题model
 * @author Guan
 * @time 2016年11月18日 上午11:21:24
 */
@Component(value = "SurveyKeyQuestionResult")
public class SurveyKeyQuestionResult {
	String success,comments,sqTitle,userAnswer,qImgUrl;
	int optionNum,totalAmount,participant,questionNum;
	List<SurveyKeyQuestionOptionData> SurveyKeyQuestionOptionData;
	List<String> optionDes;
	
	
	public String getqImgUrl() {
		return qImgUrl;
	}
	public void setqImgUrl(String qImgUrl) {
		this.qImgUrl = qImgUrl;
	}
	public String getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}
	public String getSqTitle() {
		return sqTitle;
	}
	public void setSqTitle(String sqTitle) {
		this.sqTitle = sqTitle;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public List<SurveyKeyQuestionOptionData> getSurveyKeyQuestionOptionData() {
		return SurveyKeyQuestionOptionData;
	}
	public void setSurveyKeyQuestionOptionData(
			List<SurveyKeyQuestionOptionData> surveyKeyQuestionOptionData) {
		SurveyKeyQuestionOptionData = surveyKeyQuestionOptionData;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getOptionNum() {
		return optionNum;
	}
	public void setOptionNum(int optionNum) {
		this.optionNum = optionNum;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<String> getOptionDes() {
		return optionDes;
	}
	public void setOptionDes(List<String> optionDes) {
		this.optionDes = optionDes;
	}
	public int getParticipant() {
		return participant;
	}
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	

	
	

}
