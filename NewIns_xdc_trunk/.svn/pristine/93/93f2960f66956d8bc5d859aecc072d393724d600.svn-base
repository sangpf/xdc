package com.newins.service.imp;
/**
 * @author lj
 * @Description : 用户奖励统计的Service实现类
 * @time : 2016年8月16日 下午2:08:39
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newins.dao.NiUserAwardStatisticsMapper;
import com.newins.model.NiUserAwardStatistics;
import com.newins.service.NiUserAwardStatisticsService;
@Service
public class NiUserAwardStatisticsServiceImp implements
		NiUserAwardStatisticsService {

	@Resource
	private NiUserAwardStatisticsMapper niUserAwardStatisticsMapper;
	

	/**
	 * @author lj
	 * @Description : 插入用户奖励记录
	 * @time : 2016年8月16日 下午2:11:14
	 * @param niUserAwardStatistics
	 * @return int
	 */
	public int insertUserAwardStatistics(
			NiUserAwardStatistics niUserAwardStatistics) {
		// TODO Auto-generated method stub
		int insertUserAwardStatisticsRecord=niUserAwardStatisticsMapper.insertUserAwardStatistics(niUserAwardStatistics);
		return insertUserAwardStatisticsRecord;
	}

}
