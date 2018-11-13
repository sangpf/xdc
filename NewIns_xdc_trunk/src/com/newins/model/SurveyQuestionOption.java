/**
 * 
 */
package com.newins.model;

/**
 * @Description 与接口对应的问题选项model
 * @author Guan
 * @time 2016年6月30日 下午2:45:03
 */

public class SurveyQuestionOption {
	int optionOrder, optionLink;
	String optionDes, optionFeedback;

	public int getOptionOrder() {
		return optionOrder;
	}

	public void setOptionOrder(int optionOrder) {
		this.optionOrder = optionOrder;
	}

	public int getOptionLink() {
		return optionLink;
	}

	public void setOptionLink(int optionLink) {
		this.optionLink = optionLink;
	}

	public String getOptionDes() {
		return optionDes;
	}

	public void setOptionDes(String optionDes) {
		this.optionDes = optionDes;
	}

	public String getOptionFeedback() {
		return optionFeedback;
	}

	public void setOptionFeedback(String optionFeedback) {
		this.optionFeedback = optionFeedback;
	}

}
