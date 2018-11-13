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
import com.newins.dao.VoteDeliveryInfoMapper;
import com.newins.model.Related;
import com.newins.model.VoteDeliveryInfo;
import com.newins.model.VoteOrder;
import com.newins.service.VoteDeliveryInfoService;
import com.newins.service.VoteOrderService;
import com.newins.util.StrUtils;

/**
 * @Description
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:39:56
 */
@Service
public class VoteDeliveryInfoServiceImp implements VoteDeliveryInfoService {
	private static Logger log = Logger.getLogger(VoteDeliveryInfoServiceImp.class);
	@Resource
	private VoteDeliveryInfoMapper voteDeliveryInfoMapper;
	@Autowired
	private VoteOrderService voteOrderService;
	@Autowired
	private ConsumeDao consumeDao;
	
	public VoteDeliveryInfo getDeliveryInfo(int userId,int deliveryId) {
		log.info("This is service VoteDeliveryInfo");
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("deliveryId", deliveryId);
		VoteDeliveryInfo deliveryInfo = voteDeliveryInfoMapper
				.getDeliveryInfo(hashMap);
		//1.调用查询打赏人数方法
		int donatePerson=consumeDao.getDonatePerson(deliveryId);
		//2.获得当前用户积分
		BigDecimal donateScore=consumeDao.getDeliveryScore(deliveryId);
		//3.将当前投放的打赏人数和当前用户的用户积分添加到deliveryInfo实体类对象中
		deliveryInfo.setDonatePerson(donatePerson);
		if(donateScore==null){
			deliveryInfo.setDonateScore(0);
		}else{
			deliveryInfo.setDonateScore(donateScore.intValue());

		}
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
					&& deliveryInfo.getLotteryId() == null) {
				deliveryInfo.setAwardMethod(0);// 无奖
			} else if (deliveryInfo.getAwardId() != 0
					&& deliveryInfo.getLotteryId() == null) {
				deliveryInfo.setAwardMethod(1);// 定奖
			} else if (deliveryInfo.getAwardId() == 0
					&& deliveryInfo.getLotteryId() != null) {
				deliveryInfo.setAwardMethod(2);// 随机抽奖
			}

			// 判断并设置answered是否答过
			deliveryInfo.setAnswered(0);// 初始化设置未答过
			int qnId = deliveryInfo.getQnId();

			List<Integer> vqnIdList = new ArrayList<Integer>();
			List<VoteOrder> voteOrderList = new ArrayList<VoteOrder>();
			vqnIdList.add(deliveryInfo.getQnId());
			voteOrderList = voteOrderService.searchOrderByVqnIdList(userId,
					vqnIdList);
			for (int j = 0; j < voteOrderList.size(); j++) {
				VoteOrder voteOrder = voteOrderList.get(j);
				if (qnId == voteOrder.getVqnId()) {
					deliveryInfo.setAnswered(1);
					break;
				}
			}
			return deliveryInfo;
		} catch (Exception e) {
			throw e;
		}

	}
}
