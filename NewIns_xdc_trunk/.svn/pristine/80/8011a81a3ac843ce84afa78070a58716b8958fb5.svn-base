package com.newins.dao;

import java.util.List;

import com.newins.model.CollectionFunction;
import com.newins.model.MyReport;

/**
 * 收藏相关功能数据库操作层
 * @author zhangwenhao
 *
 */
public interface MyReportDao {
	/**
	 * 删除我收藏的报告
	 * @param favorite:收藏Id
	 * @return
	 */
	int deleteMyFavorites(int userId,int reportId);
	
	/**
	 * 收藏报告
	 * @return
	 */
	int storeup(CollectionFunction collectionFunction);
	
	/**
	 * 加载我收藏的报告信息
	 * @param userId
	 * @return
	 */
	List<MyReport> loadFavorites(int userId);
	
}
