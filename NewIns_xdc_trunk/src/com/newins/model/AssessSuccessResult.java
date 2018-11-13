/**
 * 
 */
package com.newins.model;

/**@Description  测评成功返回结果对象
 * @author Guan
 * @time 2016年11月23日 上午10:18:44
 */

public class AssessSuccessResult {
	String resultSummary, resultDetail,comments,success;

	public String getResultSummary() {
		return resultSummary;
	}

	public void setResultSummary(String resultSummary) {
		this.resultSummary = resultSummary;
	}

	public String getResultDetail() {
		return resultDetail;
	}

	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
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
	
}
