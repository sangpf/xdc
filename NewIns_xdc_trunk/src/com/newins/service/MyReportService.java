package com.newins.service;

import java.util.List;

import com.newins.model.CollectionFunction;
import com.newins.model.MyReport;

/**
 * 我的收藏相关功能业务逻辑层
 * @author zhangwenhao
 *
 */

public interface MyReportService  {
	
	/**
	 * 删除我收藏的报告
	 * @param favorite:收藏Id
	 * @return
	 */
	int deleteMyFavorites(int userId,int report);
	
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
