/**
 * 
 */
package com.newins.service.imp;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.LotteryPreferDao;
import com.newins.model.LotteryDetailInfo;
import com.newins.model.LotteryPreferBasicInfo;
import com.newins.model.SurveyOrder;
import com.newins.service.LotteryPreferService;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.util.ErrorMessage;

/**
 * @Description
 * @author Guan
 * @time 2016年12月21日 上午11:33:18
 */
@Service
public class LotteryPreferServiceImp implements LotteryPreferService {
	private static Logger log = Logger.getLogger(LotteryPreferServiceImp.class);
	@Autowired
	private LotteryPreferDao lotteryPreferDao;

	@Resource
	private NiUserAwardStatisticsService niUserAwardStatisticsService;

	/**
	 * 查order表中的lotteryRank 判断之前是否抽过奖
	 */
	public SurveyOrder getLotteryRank(Map<String, Object> retMap) {
		log.info("this is service: getLotteryRank()");
		// 从order表查询lotteryRank主要用作判断是否中奖。
		SurveyOrder surveyOrder = lotteryPreferDao.getLotteryRank(retMap);
		return surveyOrder;
	}

	/**
	 * 执行倾向抽奖过程
	 */
	public Object doLotteryPrefer(Map<String, Object> retMap) {
		// step2:根据投放Id将相应的倾向型字典表各个区间概率查出
		LotteryPreferBasicInfo lotteryPreferBasicInfo = getLotteryPreferBasicInfoByDeliveryId(retMap);
		// step3:根据用户Id和问卷Id查询用户的preferValue
		int userPreferValue = getUserPreferValue(retMap);
		// step4：根据用户得分，计算用户抽奖结果,执行倾向型抽奖算法过程
		retMap.put("userPreferValue", userPreferValue);
		retMap.put("lotteryPreferBasicInfo", lotteryPreferBasicInfo);
		Object lotteryPreferDetailInfo = preferLotteryProcedure(retMap);
		return lotteryPreferDetailInfo;
	}

	/**
	 * @Title: getLotteryPreferBasicInfoByDeliveryId
	 * @Author: Guan
	 * @Description: 根据投放Id 查询倾向型抽奖表基本信息
	 * @param retMap
	 * @return LotteryPreferBasicInfo
	 * @Time 2016年12月21日 下午5:05:55
	 */
	public LotteryPreferBasicInfo getLotteryPreferBasicInfoByDeliveryId(
			Map<String, Object> retMap) {
		return lotteryPreferDao.getLotteryPreferBasicInfoByDeliveryId(retMap);
	}

	/**
	 * @Title: getUserPreferValue
	 * @Author: Guan
	 * @Description: TODO 根据用户Id和问卷Id 查询用户的答题结果计算总倾向得分
	 * @param retMap
	 * @return int
	 * @Time 2016年12月26日 上午10:43:47
	 */

	public int getUserPreferValue(Map<String, Object> retMap) {
		int userPreferValue = 0;
		userPreferValue = lotteryPreferDao.getTotalPreferValue(retMap);
		return userPreferValue;
	}

	/**
	 * @Title: preferLotteryProcedure
	 * @Author: Guan
	 * @Description: TODO 根据倾向型抽奖字典，和用户的倾向得分，计算用户是否中奖。倾向型抽奖执行抽奖过程算法
	 * @param userPreferValue
	 * @param lotteryPreferBasicInfo
	 * @return LotteryDetailInfo
	 * @Time 2016年12月26日 下午1:15:37
	 */
	public synchronized Object preferLotteryProcedure(Map<String, Object> retMap) {
		log.info("this is service: preferLotteryProcedure()");
		int deliveryId = (int) retMap.get("deliveryId");
		int userPreferValue = (int) retMap.get("userPreferValue");
		LotteryPreferBasicInfo lotteryPreferBasicInfo = (LotteryPreferBasicInfo) retMap
				.get("lotteryPreferBasicInfo");
		LotteryDetailInfo lotteryPreferDetailInfo = new LotteryDetailInfo();
		// step4.1 判断用户总分所在区间
		int highBegin = lotteryPreferBasicInfo.getHighBegin();
		int highEnd = lotteryPreferBasicInfo.getHighEnd();
		int midBegin = lotteryPreferBasicInfo.getMidBegin();
		int midEnd = lotteryPreferBasicInfo.getMidEnd();
		int lowBegin = lotteryPreferBasicInfo.getLowBegin();
		int lowEnd = lotteryPreferBasicInfo.getLowEnd();

		// 判断各区间有没有重叠
		if (lowBegin >= lowEnd || lowEnd >= midBegin || midBegin >= midEnd
				|| midEnd >= highBegin || highBegin >= highEnd) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("003");
			error.setErrInfo("抽奖区间有重叠");
			log.info("抽奖区间有重叠");
			return error;
		} else {// 判断用户得分落在哪个区间
			if (userPreferValue >= highBegin && userPreferValue <= highEnd) {// 用户得分落在高区间
				// 执行高区间一等奖抽奖
				float highRate = lotteryPreferBasicInfo.getHighRate();
				int highAwardLeft = lotteryPreferBasicInfo.getHighAwardLeft();// 查询1等奖剩余奖品数量
				if (highAwardLeft > 0 && veryfyLottery(highRate)) {// 中一等奖
					int awardId = lotteryPreferBasicInfo.getHighAwardId();
					// step4.2 根据awardId 去奖品表查询详细信息
					lotteryPreferDetailInfo = lotteryPreferDao
							.getAwardDetailById(awardId);
					lotteryPreferDetailInfo.setSuccess("true");
					// lotteryPreferDetailInfo.setAwardId(awardId);
					lotteryPreferDetailInfo.setAwardName(lotteryPreferBasicInfo
							.getHighAwardName());
					lotteryPreferDetailInfo.setAwardRank(1);
					// step4.3 在抽奖字典表中更新奖品剩余量
					Map<String, Object> awardMap = new HashMap<String, Object>();
					awardMap.put("lotteryRank", 1);
					awardMap.put("awardLeft", highAwardLeft - 1);
					awardMap.put("deliveryId", deliveryId);
					int updateAwardLeft = updateAwardLeft(awardMap);// 更新剩余库存
					if (updateAwardLeft > 0) {
						log.info("highAwardLeft is updated");
						// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
						Timestamp awardTime = new Timestamp(
								System.currentTimeMillis());
						retMap.put("awardId", awardId);
						retMap.put("awardTime", awardTime);
						retMap.put("lotteryRank", 1);
						retMap.put("awardMethod", 3);
						updateOrderAwardId(retMap);// 更新订单表
						// 4.5 在奖励统计表中插入一条记录
						//insertAwardStatistics(retMap);
						return lotteryPreferDetailInfo;
					} else {
						ErrorMessage error = new ErrorMessage();
						error.setSuccess("false");
						error.setErrCode("004");
						error.setErrInfo("一等奖奖品剩余数量更新失败");
						log.info("一等奖奖品剩余数量更新失败");
						return error;
					}

				} else {// 没中一等奖
					// 向下执行高区间二等奖抽奖过程
					float midRate = lotteryPreferBasicInfo.getMidRate();
					int midAwardLeft = lotteryPreferBasicInfo.getMidAwardLeft();// 查询2等奖剩余奖品数量
					if (midAwardLeft > 0 && veryfyLottery(midRate)) {// 中了二等奖
						int awardId = lotteryPreferBasicInfo.getMidAwardId();
						// 根据awardId 去奖品表查询详细信息
						lotteryPreferDetailInfo = lotteryPreferDao
								.getAwardDetailById(awardId);
						lotteryPreferDetailInfo.setSuccess("true");
						// lotteryPreferDetailInfo.setAwardId(awardId);
						lotteryPreferDetailInfo
								.setAwardName(lotteryPreferBasicInfo
										.getMidAwardName());
						lotteryPreferDetailInfo.setAwardRank(2);
						// 在抽奖字典表中更新奖品剩余量
						Map<String, Object> awardMap = new HashMap<String, Object>();
						awardMap.put("lotteryRank", 2);
						awardMap.put("awardLeft", midAwardLeft - 1);
						awardMap.put("deliveryId", deliveryId);
						int updateAwardLeft = updateAwardLeft(awardMap);// 更新二等奖剩余库存
						if (updateAwardLeft > 0) {
							log.info("midAwardLeft is updated");
							// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
							Timestamp awardTime = new Timestamp(
									System.currentTimeMillis());
							retMap.put("awardId", awardId);
							retMap.put("awardTime", awardTime);
							retMap.put("lotteryRank", 2);
							retMap.put("awardMethod", 3);
							updateOrderAwardId(retMap);// 更新订单表
							// 4.5 在奖励统计表中插入一条记录
							//insertAwardStatistics(retMap);
							return lotteryPreferDetailInfo;
						} else {
							ErrorMessage error = new ErrorMessage();
							error.setSuccess("false");
							error.setErrCode("005");
							error.setErrInfo("二等奖奖品剩余数量更新失败");
							log.info("二等奖奖品剩余数量更新失败");
							return error;
						}
					} else {// 没中二等奖，太倒霉，但是为了奖励倾向性高的用户，直接发个三等奖
						int lowAwardLeft = lotteryPreferBasicInfo
								.getLowAwardLeft();// 查询3等奖剩余奖品数量
						if (lowAwardLeft > 0) {// 如果三等奖有剩余，则发三等奖
							int awardId = lotteryPreferBasicInfo
									.getLowAwardId();
							// 根据awardId 去奖品表查询详细信息
							lotteryPreferDetailInfo = lotteryPreferDao
									.getAwardDetailById(awardId);
							lotteryPreferDetailInfo.setSuccess("true");
							// lotteryPreferDetailInfo.setAwardId(awardId);
							lotteryPreferDetailInfo
									.setAwardName(lotteryPreferBasicInfo
											.getLowAwardName());
							lotteryPreferDetailInfo.setAwardRank(3);
							// 在抽奖字典表中更新奖品剩余量
							Map<String, Object> awardMap = new HashMap<String, Object>();
							awardMap.put("lotteryRank", 3);
							awardMap.put("awardLeft", lowAwardLeft - 1);
							awardMap.put("deliveryId", deliveryId);
							int updateAwardLeft = updateAwardLeft(awardMap);
							if (updateAwardLeft > 0) {
								log.info("lowAwardLeft is updated");
								// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
								Timestamp awardTime = new Timestamp(
										System.currentTimeMillis());
								retMap.put("awardId", awardId);
								retMap.put("awardTime", awardTime);
								retMap.put("lotteryRank", 3);
								retMap.put("awardMethod", 3);
								updateOrderAwardId(retMap);// 更新订单表
								// 4.5 在奖励统计表中插入一条记录
								//insertAwardStatistics(retMap);
								return lotteryPreferDetailInfo;
							} else {
								ErrorMessage error = new ErrorMessage();
								error.setSuccess("false");
								error.setErrCode("006");
								error.setErrInfo("三等奖奖品剩余数量更新失败");
								log.info("三等奖奖品剩余数量更新失败");
								return error;
							}
						} else {// 三等奖也没了那你太倒霉了，只能不给你发奖了，虽然你的倾向值很高
							ErrorMessage error = new ErrorMessage();
							error.setSuccess("false");
							error.setErrCode("001");
							error.setErrInfo("很遗憾，未能中奖");
							retMap.put("awardId", 0);
							retMap.put("lotteryRank", -1);
							retMap.put("awardMethod", 3);
							updateOrderAwardId(retMap);// 更新订单表
							return error;

						}
					}
				}

			} else if (userPreferValue >= midBegin && userPreferValue <= midEnd) {// 用户得分落在中区间
				// 向下执行高区间二等奖抽奖过程
				float midRate = lotteryPreferBasicInfo.getMidRate();
				int midAwardLeft = lotteryPreferBasicInfo.getMidAwardLeft();// 查询2等奖剩余奖品数量
				if (midAwardLeft > 0 && veryfyLottery(midRate)) {// 中了二等奖
					int awardId = lotteryPreferBasicInfo.getMidAwardId();
					// 根据awardId 去奖品表查询详细信息
					lotteryPreferDetailInfo = lotteryPreferDao
							.getAwardDetailById(awardId);
					lotteryPreferDetailInfo.setSuccess("true");
					// lotteryPreferDetailInfo.setAwardId(awardId);
					lotteryPreferDetailInfo.setAwardName(lotteryPreferBasicInfo
							.getMidAwardName());
					lotteryPreferDetailInfo.setAwardRank(2);
					// 在抽奖字典表中更新奖品剩余量
					Map<String, Object> awardMap = new HashMap<String, Object>();
					awardMap.put("lotteryRank", 2);
					awardMap.put("awardLeft", midAwardLeft - 1);
					awardMap.put("deliveryId", deliveryId);
					int updateAwardLeft = updateAwardLeft(awardMap);// 更新二等奖剩余库存
					if (updateAwardLeft > 0) {
						log.info("midAwardLeft is updated");
						// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
						Timestamp awardTime = new Timestamp(
								System.currentTimeMillis());
						retMap.put("awardId", awardId);
						retMap.put("awardTime", awardTime);
						retMap.put("lotteryRank", 2);
						retMap.put("awardMethod", 3);
						updateOrderAwardId(retMap);// 更新订单表
						// 4.5 在奖励统计表中插入一条记录
						//insertAwardStatistics(retMap);
						return lotteryPreferDetailInfo;
					} else {
						ErrorMessage error = new ErrorMessage();
						error.setSuccess("false");
						error.setErrCode("005");
						error.setErrInfo("二等奖奖品剩余数量更新失败");
						log.info("二等奖奖品剩余数量更新失败");
						return error;
					}
				} else {// 没中二等奖，太倒霉，但是为了奖励倾向性高的用户，直接发个三等奖
					int lowAwardLeft = lotteryPreferBasicInfo.getLowAwardLeft();// 查询3等奖剩余奖品数量
					if (lowAwardLeft > 0) {// 如果三等奖有剩余，则发三等奖
						int awardId = lotteryPreferBasicInfo.getLowAwardId();
						// 根据awardId 去奖品表查询详细信息
						lotteryPreferDetailInfo = lotteryPreferDao
								.getAwardDetailById(awardId);
						lotteryPreferDetailInfo.setSuccess("true");
						// lotteryPreferDetailInfo.setAwardId(awardId);
						lotteryPreferDetailInfo
								.setAwardName(lotteryPreferBasicInfo
										.getLowAwardName());
						lotteryPreferDetailInfo.setAwardRank(3);
						// 在抽奖字典表中更新奖品剩余量
						Map<String, Object> awardMap = new HashMap<String, Object>();
						awardMap.put("lotteryRank", 3);
						awardMap.put("awardLeft", lowAwardLeft - 1);
						awardMap.put("deliveryId", deliveryId);
						int updateAwardLeft = updateAwardLeft(awardMap);
						if (updateAwardLeft > 0) {
							log.info("lowAwardLeft is updated");
							// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
							Timestamp awardTime = new Timestamp(
									System.currentTimeMillis());
							retMap.put("awardId", awardId);
							retMap.put("awardTime", awardTime);
							retMap.put("lotteryRank", 3);
							retMap.put("awardMethod", 3);
							updateOrderAwardId(retMap);// 更新订单表
							// 4.5 在奖励统计表中插入一条记录
							//insertAwardStatistics(retMap);
							return lotteryPreferDetailInfo;
						} else {
							ErrorMessage error = new ErrorMessage();
							error.setSuccess("false");
							error.setErrCode("006");
							error.setErrInfo("三等奖奖品剩余数量更新失败");
							log.info("三等奖奖品剩余数量更新失败");
							return error;
						}
					} else {// 三等奖也没了那你太倒霉了，只能不给你发奖了，虽然你的倾向值很高
						ErrorMessage error = new ErrorMessage();
						error.setSuccess("false");
						error.setErrCode("001");
						error.setErrInfo("很遗憾，未能中奖");
						retMap.put("awardId", 0);
						retMap.put("lotteryRank", -1);
						retMap.put("awardMethod", 3);
						updateOrderAwardId(retMap);// 更新订单表
						return error;

					}
				}
			} else if (userPreferValue >= lowBegin && userPreferValue <= lowEnd) {// 用户得分落在低区间
				// 你的倾向性太弱了，没法直接给你发奖，只能按照概率抽个三等奖，中不中看概率
				float lowRate = lotteryPreferBasicInfo.getLowRate();
				int lowAwardLeft = lotteryPreferBasicInfo.getLowAwardLeft();// 查询3等奖剩余奖品数量
				if (lowAwardLeft > 0 && veryfyLottery(lowRate)) {// 如果三等奖有剩余，则发三等奖
					int awardId = lotteryPreferBasicInfo.getLowAwardId();
					// 根据awardId 去奖品表查询详细信息
					lotteryPreferDetailInfo = lotteryPreferDao
							.getAwardDetailById(awardId);
					lotteryPreferDetailInfo.setSuccess("true");
					// lotteryPreferDetailInfo.setAwardId(awardId);
					lotteryPreferDetailInfo.setAwardName(lotteryPreferBasicInfo
							.getLowAwardName());
					lotteryPreferDetailInfo.setAwardRank(3);
					// 在抽奖字典表中更新奖品剩余量
					Map<String, Object> awardMap = new HashMap<String, Object>();
					awardMap.put("lotteryRank", 3);
					awardMap.put("awardLeft", lowAwardLeft - 1);
					awardMap.put("deliveryId", deliveryId);
					int updateAwardLeft = updateAwardLeft(awardMap);
					if (updateAwardLeft > 0) {
						log.info("lowAwardLeft is updated");
						// 4.4 更新Order表中的awardId,awardMethod,LotteryRank
						Timestamp awardTime = new Timestamp(
								System.currentTimeMillis());
						retMap.put("awardId", awardId);
						retMap.put("awardTime", awardTime);
						retMap.put("lotteryRank", 3);
						retMap.put("awardMethod", 3);
						updateOrderAwardId(retMap);// 更新订单表
						// 4.5 在奖励统计表中插入一条记录
						//insertAwardStatistics(retMap);
						return lotteryPreferDetailInfo;
					} else {
						ErrorMessage error = new ErrorMessage();
						error.setSuccess("false");
						error.setErrCode("006");
						error.setErrInfo("三等奖奖品剩余数量更新失败");
						log.info("三等奖奖品剩余数量更新失败");
						return error;
					}
				} else {// 三等奖也没了那你太倒霉了，只能不给你发奖了，虽然你的倾向值很高
					ErrorMessage error = new ErrorMessage();
					error.setSuccess("false");
					error.setErrCode("001");
					error.setErrInfo("很遗憾，未能中奖");
					retMap.put("awardId", 0);
					retMap.put("lotteryRank", -1);
					retMap.put("awardMethod", 3);
					updateOrderAwardId(retMap);// 更新订单表
					return error;

				}
			} else {
				ErrorMessage error = new ErrorMessage();
				error.setSuccess("false");
				error.setErrCode("004");
				error.setErrInfo("用户得分不在任何区间，区间或题目分值配置错误");
				return error;
			}

		}

	}

	/**
	 * @Title: veryfyLottery
	 * @Author: Guan
	 * @Description: 根据给定抽奖概率判断是否中奖
	 * @param lotteryRate
	 * @return boolean
	 * @Time 2016年12月26日 下午3:32:12
	 */
	public boolean veryfyLottery(float lotteryRate) {
		float randomNum = (float) Math.random();// 产生一个0-1的随机数
		if (randomNum >= 0 && randomNum <= lotteryRate) {// 中奖了
			return true;
		} else
			return false;
	}

	/**
	 * @Title: updateAwardLeft
	 * @Author: Guan
	 * @Description: 根据lotteryRank和奖品剩余数量更新倾向型抽奖字典表
	 * @param retMap
	 * @return int
	 * @Time 2016年12月27日 下午2:17:07
	 */
	public int updateAwardLeft(Map<String, Object> retMap) {
		return lotteryPreferDao.updateAwardLeft(retMap);
	}

	/**
	 * @Title: updateOrderAwardId
	 * @Author: Guan
	 * @Description: 更新订单表中获奖情况
	 * @param hashMap
	 *            void
	 * @Time 2016年12月27日 下午4:42:30
	 */
	public void updateOrderAwardId(Map<String, Object> hashMap) {
		log.info("this is service: updateOrderAwardId()");
		lotteryPreferDao.updateOrderAwardId(hashMap);

	}

/*	public void insertAwardStatistics(Map<String, Object> retMap) {
		// 奖励统计插入记录
		int userId = Integer.parseInt(String.valueOf(retMap.get("userId")));
		int awardId = Integer.parseInt(String.valueOf(retMap.get("awardId")));
		int deliveryId = Integer.parseInt(String.valueOf(retMap
				.get("deliveryId")));
		int lotteryRank = Integer.parseInt(String.valueOf(retMap
				.get("lotteryRank")));
		int awardMethod = Integer.parseInt(String.valueOf(retMap
				.get("awardMethod")));
		Timestamp awardTime = (Timestamp) retMap.get("awardTime");
		NiUserAwardStatistics niUserAwardStatistics = new NiUserAwardStatistics();
		niUserAwardStatistics.setUserId(userId);
		niUserAwardStatistics.setAwardId(awardId);
		niUserAwardStatistics.setAwardMethod(awardMethod);// 获奖方式 2表示抽奖
		niUserAwardStatistics.setAwardCause(1);// 奖励原因 1表示答题
		niUserAwardStatistics.setDeliveryId(deliveryId);
		niUserAwardStatistics.setQnType(1);
		niUserAwardStatistics.setQnChannel(1);
		niUserAwardStatistics.setLotteryRank(lotteryRank);
		niUserAwardStatistics.setAwardGetTime(awardTime);
		int insertAwardStatics = niUserAwardStatisticsService
				.insertUserAwardStatistics(niUserAwardStatistics);
		if (insertAwardStatics > 0) {
			log.info("successfully insert into userAwardStatics");
		}
	}*/
}
