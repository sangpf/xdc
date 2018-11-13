package com.newins.service.imp;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newins.dao.GiveRedeemCodeDao;
import com.newins.model.NiUserAwardStatistics;
import com.newins.model.RedeemCode;
import com.newins.service.GiveRedeemCodeService;
import com.newins.service.NiUserAwardStatisticsService;

/**
 * 发放口粮兑换码业务逻辑层实现类
 * @author zhangwenhao
 *
 */
@Service
public class GiveRedeemCodeServiceImp implements GiveRedeemCodeService {
		//绑定相关Dao
		@Autowired
		private GiveRedeemCodeDao giveRedeemCodeDao;
		//绑定操作用户奖励流水表Service
		@Autowired 
		private NiUserAwardStatisticsService niUserAwardStatisticsService;
		@Transactional
		public JSONObject giveRedeemCode(int userId,
				String phoneNum,int awardId) {
			System.out.println("this is niUserAwardStatisticsService");
			//声明变量接受更新兑换码相关信息方法的返回值
			int updateRedeemCode=0;
			//声明JSON用于储存当前方法的所有操作结果
			JSONObject json=new JSONObject();
			//创建兑换码实体对象
			RedeemCode code=new RedeemCode();
			//调用相关Dao的查询口粮兑换码方法
			code=giveRedeemCodeDao.getRedeemInfo();
			//判断code实体对象中的redeemCode是否为空
			if(code!=null){
				//进入这里表示查询到了兑换码，更新当前兑换码的相关信息
				//将userId和phoneNum给兑换码实体
				code.setUserId(userId);
				code.setPhoneNum(phoneNum);
				code.setAwaedId(awardId);
				updateRedeemCode=giveRedeemCodeDao.updateRedeem(code);
//				//====给用户奖励流水表添加数据====
//				//1.给实体类添加数据
//				NiUserAwardStatistics niUserAwardStatistics=new NiUserAwardStatistics();
//				niUserAwardStatistics.setUserId(userId);//添加用户Id
//				niUserAwardStatistics.setAwardMethod(1);//设置获奖方式来自定奖
//				niUserAwardStatistics.setAwardCause(1);//设置奖励原因是答题
//				niUserAwardStatistics.setDeliveryId(deliveryId);//设置投放Id
//				niUserAwardStatistics.setQnChannel(1);//设置问卷渠道来自玩笑
//				niUserAwardStatistics.setQnType(qnType);//设置问卷类型
//				//2.获取当前时间
//				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date nowDate=new Date();
//				Timestamp formatNowDate=Timestamp.valueOf(sdf.format(nowDate));
//				niUserAwardStatistics.setAwardGetTime(formatNowDate);//设置添加的时间
//				niUserAwardStatistics.setUserId(userId);//设置用户Id
//				//调用Service的方法接收返回数据
//				niUserAwardStatisticsService.insertUserAwardStatistics(niUserAwardStatistics);
				//将实体保存到Json中
				json.put("success", "true");
				json.put("redeemCodeInfo",code);
			}else{
				json.put("success", "false");
				json.put("errCode", "001");
				json.put("errInfo", "口粮兑换码已发完");
			}
			return json;
		}
}
