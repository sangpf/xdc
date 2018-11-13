package com.newins.service;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.newins.model.NiAdStatistics;

/**
 * @author lj
 * @Description : 广告统计对应的Service接口
 * @time : 2016年7月28日 下午3:57:20
 */
public interface NiAdStatisticsService {
	
	
	/**
	 * @author lj
	 * @Description : 用户浏览一个广告之后对广告统计表更新
	 * @time : 2016年7月28日 下午3:59:32
	 */
	public int updateAdStatistics(HashMap<String, Object> hashMap);
	

	/**
	 * @author lj
	 * @Description : 根据id查询广告统计表
	 * @time : 2016年7月28日 下午8:10:29
	 * @param adId
	 * @return NiAdStatistics
	 */
	public NiAdStatistics selectListByPrimaryKey(Integer adId);
	

	/**
	 * @author lj
	 * @Description : 用户点击一个广告之后对广告统计表更新
	 * @time : 2016年7月28日 下午11:46:23
	 * @param hashMap
	 * @return int
	 */
	public int updateClickAdStatistics(HashMap<String, Object> hashMap);
	
	/**
	 * @Title: updateCarouselStatistics  
	 * @Author: Guan
	 * @Description: TODO 统计轮播图加载数
	 * @param carouselAdList
	 * @return int
	 * @Time 2016年9月7日 下午12:03:33
	 */
	public int updateCarouselStatistics(List<JSONObject> carouselPosObjectList);
}
