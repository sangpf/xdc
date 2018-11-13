package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.KuRunDao;
import com.newins.model.KuRunGather;
import com.newins.model.KuRunSurvey;
import com.newins.service.KuRunService;

/**
 * 库润相关业务逻辑操作实现类
 * @author Zhangwenhao
 *
 */
@Service
public class KuRunServiceImp implements KuRunService {
	//自动绑定相关Dao层
	@Autowired
	private KuRunDao kuRunDao;
	/**
	 * 保存库润采集信息
	 */
	public int SaveGather(KuRunGather kuRunGather) {
		//无需进一步操作，直接调用Dao层的方法
		return kuRunDao.SaveGather(kuRunGather);
	}
	/**
	 * 查询用户是否已经填写过采集信息
	 */
	public int IsGather(int userId) {
		//无需进一步操作，直接调用Dao层的方法
		return kuRunDao.IsGather(userId);
	}
	@Override
	public KuRunGather getGather(int userId) {
		//无需进一步操作，直接调用Dao层的方法
		return kuRunDao.getGather(userId);
	}
	/**
	 * 查询当前库润问卷抽奖状态
	 * @param userId:用户Id
	 * @param deliveryId:库润问卷id
	 * @return
	 */
	public int checkKuRunAward(int userId, int deliveryId) {
		//无需进一步操作，直接调用Dao层的方法
		return kuRunDao.checkKuRunAward(userId, deliveryId);
	}
	/**
	 * 保存库润问卷答题结果信息
	 */
	public int SaveKuRunSurvey(KuRunSurvey kuRunSurvey) {
		//无需进一步操作，直接调用Dao层的方法
		return kuRunDao.SaveKuRunSurvey(kuRunSurvey);
	}

}
