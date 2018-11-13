package com.newins.dao;

import java.util.List;
import java.util.Map;

import com.newins.model.ActivityItem;

public interface ActivityDao {
	/**
	 * @Title: getActivityList
	 * @Author: Fanyuelin
	 * @Description: 加载活动list
	 * @return List<ActivityList>
	 * @Time May 15, 2016 12:21:33 PM
	 */
	List<ActivityItem> getActivityList(int activityType);
	/**
	 * @Title: getSurveyOrderData  
	 * @Author: Fanyuelin
	 * @Description: 根据调查问卷id获取该调查在调查订单表里的答题人数和获奖人数
	 * @param qnId 调查问卷id
	 * @return ActivityItem 
	 * @Time May 17, 2016 8:37:43 AM
	 */
	ActivityItem getOrderData(Map<String, Object> param) ;
	
	/**
	 * @Title: getSurveyList  
	 * @Author: Guan
	 * @Description: 加载活动页面之——加载调查问卷
	 * @return List<SuperSurvey>
	 * @Time 2016年10月14日 上午10:23:04
	 */
	List<ActivityItem> getSurveyList(int activityType);
	
	/**
	 * @Title: getVoteList  
	 * @Author: Guan
	 * @Description: 加载活动页面之——加载投票问卷
	 * @return List<SuperSurvey>
	 * @Time 2016年10月14日 上午10:23:52
	 */
	List<ActivityItem> getVoteList(int activityType);
	/**
	 * @Title: getAssessList  
	 * @Author: Guan
	 * @Description: 加载活动页面之——加载测评问卷
	 * @return List<Daily3UpdateItem>
	 * @Time 2016年10月14日 下午2:59:53
	 */
	List<ActivityItem> getAssessList(int activityType);

}
