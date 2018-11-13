/**
 * 
 */
package com.newins.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @Description 与接口对应的question model
 * @author Guan
 * @time 2016年6月28日 下午7:56:43
 */
@Component(value = "SurveyQuestion")
public class SurveyQuestion {
	int sqId,questionNum, questionType, required, optionNum,optMinNum,optMaxNum, isSelfDefine;
	String sqTitle, correctAnswer,answerAnalysis,userAnswer,qImgUrl;
	List<SurveyQuestionOption> options;
	int decimalDigits;//小数点后面的位数
	int textMaxVal;//文本最大值
	int textMinVal;//文本最小值
	int textLength;//文本长度
	
	public int getDecimalDigits() {
		return decimalDigits;
	}

	public void setDecimalDigits(int decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public int getTextMaxVal() {
		return textMaxVal;
	}

	public void setTextMaxVal(int textMaxVal) {
		this.textMaxVal = textMaxVal;
	}

	public int getTextMinVal() {
		return textMinVal;
	}

	public void setTextMinVal(int textMinVal) {
		this.textMinVal = textMinVal;
	}

	public int getTextLength() {
		return textLength;
	}

	public void setTextLength(int textLength) {
		this.textLength = textLength;
	}

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

	public String getAnswerAnalysis() {
		return answerAnalysis;
	}

	public void setAnswerAnalysis(String answerAnalysis) {
		this.answerAnalysis = answerAnalysis;
	}

	public int getSqId() {
		return sqId;
	}

	public void setSqId(int sqId) {
		this.sqId = sqId;
	}

	public int getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}



	public int getOptMinNum() {
		return optMinNum;
	}

	public void setOptMinNum(int optMinNum) {
		this.optMinNum = optMinNum;
	}

	public int getOptMaxNum() {
		return optMaxNum;
	}

	public void setOptMaxNum(int optMaxNum) {
		this.optMaxNum = optMaxNum;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public int getRequired() {
		return required;
	}

	public void setRequired(int required) {
		this.required = required;
	}

	public int getOptionNum() {
		return optionNum;
	}

	public void setOptionNum(int optionNum) {
		this.optionNum = optionNum;
	}

	public int getIsSelfDefine() {
		return isSelfDefine;
	}

	public void setIsSelfDefine(int isSelfDefine) {
		this.isSelfDefine = isSelfDefine;
	}

	public String getSqTitle() {
		return sqTitle;
	}

	public void setSqTitle(String sqTitle) {
		this.sqTitle = sqTitle;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public List<SurveyQuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<SurveyQuestionOption> options) {
		this.options = options;
	}





}
