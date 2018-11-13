package com.newins.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MyReportDao;
import com.newins.model.CollectionFunction;
import com.newins.model.MyReport;
import com.newins.service.MyReportService;

/**
 * 我的收藏功能业务逻辑层实现类
 * @author zhangwenhao
 *
 */
@Service(value="MyReportService")
public class MyReportServiceImp implements MyReportService{
	//绑定相关DAO
	@Autowired
	private MyReportDao myReportDao;
	/**
	 * 取消收藏
	 */
	public int deleteMyFavorites(int userId,int reportId) {
		//调用相关Dao方法
		return myReportDao.deleteMyFavorites(userId,reportId);
	}

	/**
	 * 收藏报告
	 */
	public int storeup(CollectionFunction collectionFunction) {
		//调用相关Dao方法
		return myReportDao.storeup(collectionFunction);
	}

	/**
	 * 加载我收藏的报告信息
	 */
	public List<MyReport> loadFavorites(int userId) {
		//调用Dao相关方法
		return myReportDao.loadFavorites(userId);
	}	
	
	
}
