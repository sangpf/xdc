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

import com.newins.dao.AssessDeliveryInfoMapper;
import com.newins.dao.ConsumeDao;
import com.newins.model.AssessDeliveryInfo;
import com.newins.model.AssessOrder;
import com.newins.model.Related;
import com.newins.service.AssessDeliveryInfoService;
import com.newins.service.AssessOrderService;
import com.newins.util.StrUtils;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:39:56
 */
@Service
public class AssessDeliveryInfoServiceImp implements AssessDeliveryInfoService{
	private static Logger log = Logger.getLogger(AssessDeliveryInfoServiceImp.class);
	@Resource
	private AssessDeliveryInfoMapper assessDeliveryInfoMapper;
	@Autowired
	private AssessOrderService assessOrderService;
	@Autowired
	private ConsumeDao consumeDao;
	public AssessDeliveryInfo getDeliveryInfo(int userId,int deliveryId){
		log.info("This is service:DeliveryInfoController");
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("deliveryId", deliveryId);
		
		AssessDeliveryInfo deliveryInfo = assessDeliveryInfoMapper.getDeliveryInfo(hashMap);
		//1.调用查询打赏人数方法
		int donatePerson=consumeDao.getDonatePerson(deliveryId);
		//2.获得当前用户积分
		BigDecimal donateScore=consumeDao.getDeliveryScore(deliveryId);
		//3.将当前投放的打赏人数和当前用户的用户积分添加到deliveryInfo实体类对象中
		
		if(deliveryInfo != null){
			
			deliveryInfo.setDonatePerson(donatePerson);
			if(donateScore==null){
				deliveryInfo.setDonateScore(0);
			}else{
				deliveryInfo.setDonateScore(donateScore.intValue());
			}
			
			//接受不为空的相关推荐
			try{
				List<Related> relatedList= new ArrayList<>();				
				for(int j=0;j<3;j++){
					String relatedStr = deliveryInfo.getRelatedStrByIndex(j+1);
					String relatedUrl = deliveryInfo.getRelatedUrlByIndex(j+1);
					if(relatedStr!=null && !("".equals(relatedStr)) &&   relatedUrl!=null && !("".equals(relatedUrl)) ){
						Related relatedItem = new Related();
						relatedItem.setRelatedStr(relatedStr);
						relatedItem.setRelatedUrl(relatedUrl);
						relatedList.add(relatedItem);
					}
				}
				deliveryInfo.setRelatedList(relatedList);
				
				
				
				//判断并设置awardMethod
				if(deliveryInfo.getAwardId()==0 && deliveryInfo.getLotteryId()==null){
					deliveryInfo.setAwardMethod(0);//无奖
				}else if(deliveryInfo.getAwardId()!=0 && deliveryInfo.getLotteryId()==null){
					deliveryInfo.setAwardMethod(1);//定奖
				}else if(deliveryInfo.getAwardId()==0 && deliveryInfo.getLotteryId()!=null){
					deliveryInfo.setAwardMethod(2);//随机抽奖
				}
				
				//判断并设置answered是否答过
				deliveryInfo.setAnswered(0);//初始化设置未答过
				int qnId = deliveryInfo.getQnId();
		
					List<Integer> aqnIdList = new ArrayList<Integer>();
					List<AssessOrder> assessOrderList = new ArrayList<AssessOrder>();
					aqnIdList.add(deliveryInfo.getQnId());
					assessOrderList= assessOrderService.searchOrderByAqnIdList(userId, aqnIdList);
					if(assessOrderList!=null){
						for(int j=0;j<assessOrderList.size();j++){
							AssessOrder assessOrder = assessOrderList.get(j);
							if(qnId ==assessOrder.getAqnId()){
								deliveryInfo.setAnswered(1);
								break;
							}
						}
					}			
		
		
				return deliveryInfo;
			}
			catch(Exception e){
				throw e;
			}
			
		}
		
		return deliveryInfo;
	}
	

}
