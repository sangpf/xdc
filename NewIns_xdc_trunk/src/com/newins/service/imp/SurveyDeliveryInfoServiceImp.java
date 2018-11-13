package com.newins.service.imp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.newcapec.campus.oauth2.client.request.WanxiaoContext;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.ConsumeDao;
import com.newins.dao.SurveyDeliveryInfoMapper;
import com.newins.model.Related;
import com.newins.model.SurveyDeliveryInfo;
import com.newins.model.SurveyOrder;
import com.newins.service.ConsumeService;
import com.newins.service.SurveyDeliveryInfoService;
import com.newins.service.SurveyOrderService;
import com.newins.util.StrUtils;

/**
 * @Description
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:39:56
 */
@Service
public class SurveyDeliveryInfoServiceImp implements SurveyDeliveryInfoService {
	private static Logger log = Logger.getLogger(SurveyDeliveryInfoServiceImp.class);
	@Resource
	private SurveyDeliveryInfoMapper surveyDeliveryInfoMapper;
	@Autowired
	private SurveyOrderService surveyOrderService;
	@Autowired
	private ConsumeDao consumeDao;

	public SurveyDeliveryInfo getDeliveryInfo(int userId, int deliveryId) {
		log.info("This is service:SurveyDeliveryInfo");
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("deliveryId", deliveryId);
		SurveyDeliveryInfo deliveryInfo = surveyDeliveryInfoMapper.getDeliveryInfo(hashMap);
		//1.调用查询打赏人数方法
		int donatePerson=consumeDao.getDonatePerson(deliveryId);
		//2.获得当前投放的被打赏的分数
		BigDecimal donateScore=consumeDao.getDeliveryScore(deliveryId);
		//3.将当前投放的打赏人数和当前用户的用户积分添加到deliveryInfo实体类对象中
		if(donateScore==null){
			deliveryInfo.setDonateScore(0);
		}else{
			deliveryInfo.setDonateScore(donateScore.intValue());
		}
		deliveryInfo.setDonatePerson(donatePerson);
		
		// 接受不为空的相关推荐
		try {
			List<Related> relatedList = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				String relatedStr = deliveryInfo.getRelatedStrByIndex(j + 1);
				String relatedUrl = deliveryInfo.getRelatedUrlByIndex(j + 1);
				if (relatedStr != null && !("".equals(relatedStr))
						&& relatedUrl != null && !("".equals(relatedUrl))) {
					Related relatedItem = new Related();
					relatedItem.setRelatedStr(relatedStr);
					relatedItem.setRelatedUrl(relatedUrl);
					relatedList.add(relatedItem);
				}
			}
			deliveryInfo.setRelatedList(relatedList);

			// 判断并设置awardMethod
			if (deliveryInfo.getAwardId() == 0
					&& deliveryInfo.getLotteryId() == null
					&& deliveryInfo.getEvaluateId() == null) {
				deliveryInfo.setAwardMethod(0);// 无奖
			} else if (deliveryInfo.getAwardId() != 0
					&& deliveryInfo.getLotteryId() == null
					&& deliveryInfo.getEvaluateId() == null) {
				deliveryInfo.setAwardMethod(1);// 定奖
			} else if (deliveryInfo.getAwardId() == 0
					&& deliveryInfo.getLotteryId() != null
					&& deliveryInfo.getEvaluateId() == null) {
				deliveryInfo.setAwardMethod(2);// 随机抽奖
			} else if (deliveryInfo.getAwardId() == 0
					&& deliveryInfo.getLotteryId() == null
					&& deliveryInfo.getEvaluateId() != null) {
				deliveryInfo.setAwardMethod(3);// 随机抽奖
			}

			// 判断并设置answered是否答过
			deliveryInfo.setAnswered(0);// 初始化设置未答过
			int qnId = deliveryInfo.getQnId();
			List<Integer> sqnIdList = new ArrayList<Integer>();
			List<SurveyOrder> surveyOrderList = new ArrayList<SurveyOrder>();
			sqnIdList.add(deliveryInfo.getQnId());
			surveyOrderList = surveyOrderService.searchOrderBySqnIdList(userId,
					sqnIdList);
			if (surveyOrderList != null) {
				for (int j = 0; j < surveyOrderList.size(); j++) {
					SurveyOrder surveyOrder = surveyOrderList.get(j);
					if (qnId == surveyOrder.getSqnId()) {
						deliveryInfo.setAnswered(1);
						break;
					}
				}
			}

			return deliveryInfo;
		} catch (Exception e) {
			throw e;
		}

	}
	/**
	 * 查询用户积分方法
	 * @param access_Token
	 * @return
	 */
	private int getUserScore(String access_Token){
		//1.实例化完校接口对象
		WanxiaoContext wanxiaoContext = null;
		if(access_Token!=null){
			wanxiaoContext = new WanxiaoContext((String) access_Token);
		}
		//2.调用查询用户积分方法
		//创建接受方法返回值变量
		String returnValue=null;
		returnValue=wanxiaoContext.getScore();
		System.out.println("用户的积分是:"+returnValue);
		JSONObject formatDate=null;
		if(StrUtils.isEmpty(returnValue)){
			formatDate=JSONObject.fromObject(returnValue);
		}
		int returnScore=-1;
		//3.取出完校接口返回的值
		if(formatDate!=null){
			returnScore=formatDate.getInt("grade");
		}
		return 0;
	}

}
