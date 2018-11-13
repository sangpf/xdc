package com.newins.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newins.util.AjaxResult;

public interface NiCommentService {
	
	/**
	 * 添加评论
	 */
	AjaxResult addNiComment(HttpServletRequest request,HttpServletResponse response);
	
	//查询评论列表
	AjaxResult listNiComment(HttpServletRequest request);
	
	//点赞
	AjaxResult praiseComment(HttpServletRequest request);
	
}
