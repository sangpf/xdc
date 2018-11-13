package com.newins.dao;

import com.newins.model.NiUserAwardStatistics;

/**
 * @author lj
 * @Description : 用户奖励统计的dao接口
 * @time : 2016年8月16日 下午1:58:19
 */
public interface NiUserAwardStatisticsMapper {

	/**
	 * @author lj
	 * @Description : 插入用户奖励记录
	 * @time : 2016年8月16日 下午2:05:50
	 * @param niUserAwardStatistics
	 * @return int
	 */
	public int insertUserAwardStatistics(NiUserAwardStatistics niUserAwardStatistics);
}
