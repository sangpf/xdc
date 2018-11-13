package com.newins.service.imp;

import java.sql.Timestamp;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.newins.dao.SubmitVoteDao;
import com.newins.model.NiUserAwardStatistics;
import com.newins.model.VoteAnswer;
import com.newins.model.VoteDeliveryItem;
import com.newins.model.VoteOrder;
import com.newins.service.LoadVqnService;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.service.SubmitVoteService;
import com.newins.service.VoteOrderService;

/**@Description  提交投票结果Service的实现类
 * @author MaNia_chAng
 * @time 2016年6月20日 下午12:55:19
 */
@Service
public class SubmitVoteSerivceImp implements SubmitVoteService{
	
	@Autowired
	private VoteOrder voteOrder;
	@Autowired
	private SubmitVoteDao submitVoteDao;
	@Autowired
	private VoteOrderService voteOrderService;
	

	@Resource
	private NiUserAwardStatisticsService niUserAwardStatisticsService;
	@Resource
	private LoadVqnService loadVqnService;
			
	
	private static Logger log = Logger.getLogger(SubmitVoteSerivceImp.class); 
	
	//创建订单

	@Transactional
	public String createVoteOrder(int userId,int vqnId,int awardId,String answerBTime,int awardMethod,int deliveryId){
		
		String voteOrderCreated = null;//初始化订单创建状态
		VoteOrder voteOrderResult = new VoteOrder();
		
		try{
		voteOrderResult = voteOrderService.getVoteOrderById(userId, vqnId);//查询该用户在该投票是否已经提交过答案
		if(voteOrderResult == null){
			Timestamp orderCTime= new Timestamp(System.currentTimeMillis());//获取当前系统时间
			Timestamp answerETime= new Timestamp(System.currentTimeMillis());
			//设置订单属性值
			voteOrder.setUserId(userId);
			voteOrder.setDeliveryId(deliveryId);
			voteOrder.setVqnId(vqnId);
			voteOrder.setOrderCTime(orderCTime);
			voteOrder.setAnswerETime(answerETime);
			voteOrder.setOrderStatus(1);
			voteOrder.setAwardId(awardId);			
			voteOrder.setAwardMethod(awardMethod);
			
			voteOrder.setAnswerBTime(Timestamp.valueOf(answerBTime));
			//订单信息写入数据库，返回订单创建状态为成功
			submitVoteDao.createVoteOrder(voteOrder);
			voteOrderCreated = "success";
			}
		else{
			voteOrderCreated ="fail"; //订单已存在，创建失败
		}
		}
		catch(Exception e){
			log.info("create order failed");
			//throw e;
		}
		

		return voteOrderCreated;
	}
	
	//提交答案
	@Transactional
	public String submitVote(int userId,int vqnId,String answer,String voteOrderCreated){
		String submitStatus = null;
		//判断订单是否创建成功，再提交答案
		if(voteOrderCreated == "success"||"success".equals(voteOrderCreated)){
			VoteAnswer voteAnswer = new VoteAnswer();
			voteAnswer.setUserId(userId);
			voteAnswer.setVqnId(vqnId);
			voteAnswer.setChoice(answer);
			
			submitVoteDao.submitVote(voteAnswer);
			submitStatus = "success";
		}
		else
			submitStatus = "failed";		
		return submitStatus;
	}
	

	
//	@Transactional
	public synchronized String saveVoteAnswer(int userId,int vqnId,String answer,int awardId,String answerBTime,int deliveryId,int awardMethod){
		String voteOrderCreated = null;
		voteOrderCreated = createVoteOrder(userId,vqnId,awardId,answerBTime,awardMethod,deliveryId);
		String submitStatus = null;
		if(voteOrderCreated == "failed"||"failed".equals(voteOrderCreated)){
			submitStatus = "failed";
			return submitStatus;
		}
		
		//提交答案
		
		submitStatus=submitVote(userId,vqnId,answer,voteOrderCreated);
		System.out.println("submitStatus:"+submitStatus);
		
		//保存奖励统计信息
		if(awardId!=0 &&"success".equals(voteOrderCreated)){
			NiUserAwardStatistics niUserAwardStatistics = new NiUserAwardStatistics();

			niUserAwardStatistics.setUserId(userId);
			niUserAwardStatistics.setAwardId(awardId);
			niUserAwardStatistics.setAwardMethod(1);//获奖方式 1表示定奖
			niUserAwardStatistics.setAwardCause(1);//奖励原因 1表示答题
			niUserAwardStatistics.setDeliveryId(deliveryId);
			niUserAwardStatistics.setQnType(3);
			niUserAwardStatistics.setQnChannel(1);
			Timestamp awardTime= new Timestamp(System.currentTimeMillis());	
			niUserAwardStatistics.setAwardGetTime(awardTime);
			int insertAwardStatics = niUserAwardStatisticsService.insertUserAwardStatistics(niUserAwardStatistics);
			if(insertAwardStatics>0){
				log.info("successfully insert into userAwardStatics");
			}
		}
		return submitStatus;
	}

	//查询订单数量,判断问卷是否已经收满
//	@Transactional
	public String changeDeliveryStatus(int deliveryId){
		String deliveryStatus = "Delivery Status Unchange";
		VoteDeliveryItem voteDeliveryItem = new VoteDeliveryItem();
		voteDeliveryItem = submitVoteDao.getCollectAndCollectedNumById(deliveryId);
		if(voteDeliveryItem.getCollectNum() <= voteDeliveryItem.getCollectedNum()){
			submitVoteDao.changeDeliveryStatus(deliveryId);
			deliveryStatus = "Delivery Status Changed";
		}
		return deliveryStatus;
	}
	
}
