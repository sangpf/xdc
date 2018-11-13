package com.newins.dao;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.ibatis.annotations.Param;

import com.newins.model.NiAdStatistics;

/**
 * @author lj
 * @Description : 广告统计表对应的dao
 * @time : 2016年7月28日 下午3:54:09
 */
public interface NiAdStatisticsMapper {
	
	/**
	 * @author lj
	 * @Description : 用户浏览广告后对广告统计表更新
	 * @time : 2016年7月28日 下午3:55:16
	 * @param HashMap
	 * @return int
	 */
	public int updateAdStatistics(HashMap<String, Object> hashMap);
	

	/**
	 * @author lj
	 * @Description : 根据id查询广告统计表
	 * @time : 2016年7月28日 下午8:09:06
	 * @param adId
	 * @return NiAdStatistics
	 */
	public NiAdStatistics selectListByPrimaryKey(@Param("adId") Integer adId);
	

	/**
	 * @author lj
	 * @Description : 用户点击一个广告之后对广告统计表更新
	 * @time : 2016年7月28日 下午11:45:08
	 * @param hashMap
	 * @return
	 */
	public int updateClickAdStatistics(HashMap<String, Object> hashMap);
	
	public int updateCarouselStatistics(List<JSONObject> carouselPosObjectList);
}
