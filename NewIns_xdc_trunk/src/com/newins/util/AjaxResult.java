package com.newins.util;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object>{

	private static final long serialVersionUID = 1L;

	/**
	 * 成功并返回信息
	 */
	public static AjaxResult successResult(String successMsg){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", true);
		ajaxResult.put("msg", successMsg);
		return ajaxResult;
	}
	
	/**
	 * 错误并返回信息
	 */
	public static AjaxResult errorResult(String errorMsg){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", false);
		ajaxResult.put("error", errorMsg);
		return ajaxResult;
	}
	
	/**
	 * 错误并返回信息
	 */
	public static AjaxResult errorCode(String errorMsg,String errorCode){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", false);
		ajaxResult.put("error", errorMsg);
		ajaxResult.put("errorCode", errorCode);
		return ajaxResult;
	}
	
	/**
	 * 错误并返回信息
	 */
	public static AjaxResult errorCodeInfo(String success,String errorMsg,String errorCode){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", success);
		ajaxResult.put("errInfo", errorMsg);
		ajaxResult.put("errCode", errorCode);
		return ajaxResult;
	}
	
	/**
	 * 成功并返回信息
	 * @param errorMsg
	 * @return
	 */
	public static AjaxResult successInfo(String success,String comments){
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.put("success", success);
		ajaxResult.put("comments", comments);
		return ajaxResult;
	}
}