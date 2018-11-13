package com.newins.dao;

import java.util.ArrayList;
import java.util.List;

import com.newins.model.MysuperSuvey;

/**
 * 认知世界->我参与的调查板块数据加载数据库操作层
 * @author zhangwenhao
 *
 */
public interface MySuperSurveyDao {
	/**
	 * 查询我的投票
	 * @param userId:要查询的用户Id
	 * @return
	 */
	int getVoteTotal(int userId);
	/**
	 * 查询指定用户参与的投票和调查数据
	 * @return
	 */
	List<MysuperSuvey> getMysuperSuveyInfo(int userId);
	/**
	 * 匹配是否已经收藏
	 * @param userId
	 * @param reportId
	 * @return：返回1表示已收藏，返回0表示未收藏
	 */
	public int matchingIsFavorite(int userId,int reportId);
}
