package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.Daily3UpdateItem;
import com.newins.model.page.DailyUpdate;

public interface Daily3UpdateDao {
	/**
	 *  加载每日三更list
	 */
	List<DailyUpdate> getDaily3UpdateList(Map<String,Object> dataMap);
	/**
	 * : 根据调查问卷id获取该调查在调查订单表里的答题人数和获奖人数
	 */
	/**
	 *  加载每日三更列表之——加载调查问卷
	 */
	List<Daily3UpdateItem> getSurveyList(String qnListCategory);
	
	/**
	 * @Description: 加载每日三更列表之——加载投票问卷
	 */
	List<Daily3UpdateItem> getVoteList(String qnListCategory);
	/**
	 * @Description: 加载每日三更列表之——加载测评问卷
	 */
	List<Daily3UpdateItem> getAssessList(String qnListCategory);
	
	/**
	 * @Discription:加载每日三更列表之——加载报告
	 */
	List<Daily3UpdateItem> getReportList(String qnListCategory);
	
	/**
	 * @Discription:加载每日三更列表之——加载文章
	 */
	List<Daily3UpdateItem> getTweetList(String qnListCategory);
	
	
	/**
	 * @Discription:查询调查问卷的获奖人数和答题人数
	 */
	List<Daily3UpdateItem> getSurveyOrderData();
	/**
	 * @Discription:查询测评问卷的获奖人数和答题人数
	 */
	List<Daily3UpdateItem> getAssessOrderData();
	/**
	 * @Discription:查询投票评问卷的获奖人数和答题人数
	 */
	List<Daily3UpdateItem> getVoteOrderData();
}
