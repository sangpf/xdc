/**
 * 
 */
package com.newins.util;

/**
 * @Description 接口失败输出返回内容 类
 * @author Guan
 * @time 2016年7月1日 上午10:33:50
 */

public class ErrorMessage {
	String success, errInfo;
	String errCode;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getErrInfo() {
		return errInfo;
	}

	public void setErrInfo(String errInfo) {
		this.errInfo = errInfo;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

}
