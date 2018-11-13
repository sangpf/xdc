package com.newins.service.imp;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.NiAdStatisticsMapper;
import com.newins.model.NiAdStatistics;
import com.newins.service.NiAdStatisticsService;

/**
 * @author lj
 * @Description : 广告统计对应的Service实现类
 * @time : 2016年7月28日 下午4:27:22
 */
@Service
public class NiAdStatisticsServiceImp implements NiAdStatisticsService {
	
	@Autowired
	private NiAdStatisticsMapper niAdStatisticsMapper;

	/**
	 * @author lj
	 * @Description : 用户浏览一个广告之后对广告统计表更新
	 * @time : 2016年7月28日 下午4:28:05
	 */
	public int updateAdStatistics(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		int updAdStatistics=niAdStatisticsMapper.updateAdStatistics(hashMap);
		return updAdStatistics;
	}


	/**
	 * @author lj
	 * @Description : 根据id查询广告统计表
	 * @time : 2016年7月28日 下午8:11:27
	 * @param adId
	 * @return NiAdStatistics
	 */
	public NiAdStatistics selectListByPrimaryKey(Integer adId) {
		// TODO Auto-generated method stub
		NiAdStatistics niAdStatistics=niAdStatisticsMapper.selectListByPrimaryKey(adId);
		return niAdStatistics;
	}


	/**
	 * @author lj
	 * @Description : 用户点击一个广告之后对广告统计表更新
	 * @time : 2016年7月28日 下午11:48:32
	 * @param adId
	 * @return NiAdStatistics
	 */
	public int updateClickAdStatistics(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		int updClickAdStatistics=niAdStatisticsMapper.updateClickAdStatistics(hashMap);
		return updClickAdStatistics;
	}
	
	/**
	 * 加载统计轮播图广告统计
	 */
	public int updateCarouselStatistics(List<JSONObject> carouselPosObjectList){
		int updCarouselStatistics = niAdStatisticsMapper.updateCarouselStatistics(carouselPosObjectList);
		return updCarouselStatistics;
	}

}
