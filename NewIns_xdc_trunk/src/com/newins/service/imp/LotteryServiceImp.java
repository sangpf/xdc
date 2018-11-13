package com.newins.service.imp;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.newins.controller.LotteryController;
import com.newins.dao.LotteryDao;
import com.newins.model.LotteryBasicInfo;
import com.newins.model.LotteryDetailInfo;
import com.newins.model.SurveyOrder;
import com.newins.service.LotteryService;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.util.ErrorMessage;

/**@Description  抽奖对应Service
 * @author MaNia_chAng
 * @time 2016年5月24日 下午5:02:06
 */
@Service
public class LotteryServiceImp implements LotteryService{
	
	private static Logger log = Logger.getLogger(LotteryController.class); 
	
	
	@Autowired
	@Qualifier("LotteryDetailInfo")
	private LotteryDetailInfo lotteryDetailInfo; 
	
	@Autowired
	private LotteryDao lotteryDao;
	
	@Resource
	private NiUserAwardStatisticsService niUserAwardStatisticsService;

	public SurveyOrder getSequenceNumAndLotteryRank(Map<String, Object> retMap){
		log.info("this is service: getSequenceNumAndLotteryRank()");
		//从order表查询sequenceNum和lotteryRank。sequence主要用作从命运表查询是否中奖，lotteryRank主要用作判断是否中奖。
		//三种类型的Order model都有这两个字段，任意选择一个作为存放这两个值的Model
		SurveyOrder surveyOrder = lotteryDao.getSequenceNum(retMap);
		return surveyOrder;
	}
	
	
	//通过userId和deliveryId查询lotteryBasicInfo
		public LotteryBasicInfo getLotteryBasicInfo(Map<String, Object> retMap){
			log.info("this is service: getLotteryBasicInfo()");					
			String birthday = lotteryDao.getBithday(retMap);//从投放表查询投放创建日期
			String tableName = "ni_lottery_"+birthday.substring(0, 10).replaceAll("-", "");
			retMap.put("tableName", tableName);			
			LotteryBasicInfo lotteryBasicInfo = lotteryDao.getLotteryBasicInfo(retMap);
			return lotteryBasicInfo;
		}
	
	/**
	 * @Title: getLotteryDetailInfo  
	 * @Author: MaNia_chAng
	 * @Description: 根据awardRank和deliveryId查询lotteryDetailInfo
	 * @param awardRank
	 * @param deliveryId
	 * @return LotteryDetailInfo
	 * @Time 2016年6月3日 下午4:51:15
	 */
	public LotteryDetailInfo getLotteryDetailInfo(int awardRank,int lotteryId){
		
		log.info("this is service: getLotteryDetailInfo() ");	
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("awardRank", awardRank);
		hashMap.put("lotteryId", lotteryId);
		lotteryDetailInfo = lotteryDao.getLotteryDetailInfo(hashMap);
		lotteryDetailInfo.setAwardRank(awardRank);
		return lotteryDetailInfo;
	}
	

	/**
	 * @Title: updateOrderAwardId  
	 * @Author: MaNia_chAng
	 * @Description: 将awardId插入Order表。根据userId和deliveryId。
	 * @param userId
	 * @param deliveryId
	 * @param awardId void
	 * @Time 2016年6月3日 下午4:56:10
	 */
	public void updateOrderAwardId(Map<String, Object> hashMap){
		log.info("this is service: updateOrderAwardId()");
		lotteryDao.updateOrderAwardId(hashMap);
		
	}
	
	/**
	 * @Title: updateLotteryUserIdAndAwardTime  
	 * @Author: MaNia_chAng
	 * @Description: 将UserId和awardTime插入命运表。根据Order表的主键：deliveryId,qnType，channel,sequenceNum
	 * @param deliveryId
	 * @param qnType
	 * @param channel
	 * @param sequenceNum
	 * @param userId void
	 * @Time 2016年6月3日 下午4:52:19
	 */
	public void updateLotteryUserIdAndAwardTime(Map<String, Object> hashMap){
		log.info("this is service : updateLotteryUserId");
		lotteryDao.updateLotteryUserIdAndAwardTime(hashMap);
	}
	
	
	//判断是否中奖，中奖则返回中奖信息同时更新命运表和order表相关字段，没中奖则返回没中奖
	public Object verifyLotteryStatus(Map<String, Object> retMap){
		int sequenceNum=0;
		int awardRank=0;
		LotteryBasicInfo lotteryBasicInfo = (LotteryBasicInfo) retMap.get("lotteryBasicInfo");
		
		
		if(lotteryBasicInfo == null){
			//更新订单表
			retMap.put("awardId", 0);
			retMap.put("lotteryRank", -1);
			retMap.put("awardMethod", 2);
			updateOrderAwardId(retMap);
			//返回未中奖信息
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("很遗憾！未中奖！");
			return error;
		}		
		else{//中奖了
			//获取中奖的基本信息中的awardRank
			awardRank = lotteryBasicInfo.getAwardRank();
			int lotteryId = lotteryBasicInfo.getLotteryId();
			
			//获取中奖的详细信息
			LotteryDetailInfo lotteryDetailInfo = getLotteryDetailInfo(awardRank, lotteryId);		
			lotteryDetailInfo.setSuccess("true");
			int awardId = lotteryDetailInfo.getAwardId();
			sequenceNum = lotteryBasicInfo.getSequenceNum();
			
			//更新命运表中的userId,awardTime;更新Order表中的awardId,awardMethod,LotteryRank;用户奖励统计表添加记录
			//获取中奖时间
			Timestamp awardTime= new Timestamp(System.currentTimeMillis());			
			retMap.put("awardId", awardId);
			retMap.put("awardTime",awardTime);
			retMap.put("sequenceNum",sequenceNum);
			retMap.put("lotteryRank", awardRank);
			retMap.put("awardMethod", 2);
			updateOrderAwardId(retMap);//更新订单表
			updateLotteryUserIdAndAwardTime(retMap);//更新命运表中奖时间和用户ID
			log.info("successfully update userId and AwardId");
			//奖励统计插入记录
/*			int userId = Integer.parseInt(String.valueOf(retMap.get("userId")));
			NiUserAwardStatistics niUserAwardStatistics = new NiUserAwardStatistics();
			niUserAwardStatistics.setUserId(userId);
			niUserAwardStatistics.setAwardId(awardId);
			niUserAwardStatistics.setAwardMethod(2);//获奖方式 2表示抽奖
			niUserAwardStatistics.setAwardCause(1);//奖励原因 1表示答题
			niUserAwardStatistics.setDeliveryId(lotteryBasicInfo.getDeliveryId());
			niUserAwardStatistics.setQnType(lotteryBasicInfo.getQnType());
			niUserAwardStatistics.setQnChannel(lotteryBasicInfo.getChannel());
			niUserAwardStatistics.setLotteryRank(awardRank);
			niUserAwardStatistics.setAwardGetTime(awardTime);
			int insertAwardStatics = niUserAwardStatisticsService.insertUserAwardStatistics(niUserAwardStatistics);
			if(insertAwardStatics>0){
				log.info("successfully insert into userAwardStatics");
			}*/
			
			return lotteryDetailInfo;
		}
		
		
	}

}
