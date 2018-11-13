package com.newins.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年6月28日 下午4:25:53
 */
@Component(value = "VqnItem")
public class VqnItem {
	int questionQty,questionType,required,optionNum,optMaxNum,optMinNum,isSelfDefine;
	String success,vqnName,publisherName,vqnClassName,vqnSummary,perface,epilogue,comment,vqTitle,correctAnswer,picPath,qImgUrl;
	List<VqnOption> Options;
	
	public String getqImgUrl() {
		return qImgUrl;
	}
	public void setqImgUrl(String qImgUrl) {
		this.qImgUrl = qImgUrl;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public int getQuestionQty() {
		return questionQty;
	}
	public void setQuestionQty(int questionQty) {
		this.questionQty = questionQty;
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
	public int getOptMaxNum() {
		return optMaxNum;
	}
	public void setOptMaxNum(int optMaxNum) {
		this.optMaxNum = optMaxNum;
	}
	public int getOptMinNum() {
		return optMinNum;
	}
	public void setOptMinNum(int optMinNum) {
		this.optMinNum = optMinNum;
	}
	public int getIsSelfDefine() {
		return isSelfDefine;
	}
	public void setIsSelfDefine(int isSelfDefine) {
		this.isSelfDefine = isSelfDefine;
	}
	public String getVqnName() {
		return vqnName;
	}
	public void setVqnName(String vqnName) {
		this.vqnName = vqnName;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public String getVqnClassName() {
		return vqnClassName;
	}
	public void setVqnClassName(String vqnClassName) {
		this.vqnClassName = vqnClassName;
	}
	public String getVqnSummary() {
		return vqnSummary;
	}
	public void setVqnSummary(String vqnSummary) {
		this.vqnSummary = vqnSummary;
	}
	public String getPerface() {
		return perface;
	}
	public void setPerface(String perface) {
		this.perface = perface;
	}
	public String getEpilogue() {
		return epilogue;
	}
	public void setEpilogue(String epilogue) {
		this.epilogue = epilogue;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getVqTitle() {
		return vqTitle;
	}
	public void setVqTitle(String vqTitle) {
		this.vqTitle = vqTitle;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public List<VqnOption> getOptions() {
		return Options;
	}
	public void setOptions(List<VqnOption> options) {
		Options = options;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	
}
