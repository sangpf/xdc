package com.newins.service;


public interface ActivityService {
	/**
	 * @Title: getActivityList
	 * @Author: Fanyuelin
	 * @Description: 加载活动的列表
	 * @return List<ActivityList>
	 * @Time May 15, 2016 12:14:19 PM
	 */
	Object getActivityList(int userId,int activityType, int page);
	
}
