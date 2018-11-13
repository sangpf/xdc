package com.newins.service;

import java.util.List;

import net.sf.json.JSONObject;

/**
 * 认知世界->我参与的调查板块数据加载业务逻辑层
 * @author zhangwenhao
 *
 */
public interface MySuperSurveyService {
	/**
	 * 分页查询指定用户参与的调查和投票数据
	 * @param userId:要查询的用户Id
	 * @param page:分页用，要第几页的数据
	 * @return
	 */
	Object getMysuperSuveyInfo(int userId,int page);
	
	/**
	 * 匹配是否收藏
	 * @param userId:用户Id
	 * @param reportId:报告Id
	 * @return
	 */
	int matchingIsFavorite(int userId,int reportId);
}
