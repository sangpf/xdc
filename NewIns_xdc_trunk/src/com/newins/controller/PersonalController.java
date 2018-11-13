package com.newins.controller;


import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.request.WanxiaoContext;
import net.newcapec.campus.oauth2.client.utils.SysProps;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.MyInformation;
import com.newins.model.NiUserAwardStatistics;
import com.newins.model.UpDatePersonalInfo;
import com.newins.service.NiUserAwardStatisticsService;
import com.newins.service.PersonalService;
import com.newins.service.imp.LotteryPreferServiceImp;
import com.newins.util.AjaxResult;
import com.newins.util.ErrorMessage;
import com.newins.util.StrUtils;

/**
 * 
 * @author zhangwenhao
 *
 */
@Controller
@RequestMapping(value="/wanx")
public class PersonalController {
	//绑定相关Service
	@Autowired
	private PersonalService personalService;
	@Autowired
	private NiUserAwardStatisticsService niUserAwardStatisticsService;
	private Logger logger=Logger.getLogger(PersonalController.class);
	/**
	 * 加载用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/LoadPersonalInfo",method=RequestMethod.GET)
	@ResponseBody
	public Object LoadPersonalInfo(HttpServletRequest request){
		logger.info("this is controller : LoadPersonalInfo");
		//获取session
		HttpSession session=request.getSession();
		//获取session传来的userId
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		//判断userId是否为空
		if(userId!=null){
			//不是空就调用Service方法
			return personalService.LoadPersonalInfo(Integer.parseInt(userId.toString()));
		}else{
			//返回错误信息
			ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrCode("002");
			errorMessage.setErrInfo(" userId is null");
			errorMessage.setSuccess("false");
			return errorMessage;
		}
		
	}
	/**
	 * 修改用户信息Controller
	 * @return
	 */
	@RequestMapping(value="/updadtePersonalInfo",method=RequestMethod.GET)
	@ResponseBody
	public Object updadtePersonalInfo(HttpServletRequest request,HttpServletResponse response){
		logger.info("this is controller : updadtePersonalInfo");
		//获取session
		HttpSession session=request.getSession();
		//设置前端传递的汉字编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset:utf-8");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//声明变量用于保存调用插入用户奖励记录方法的返回影响行数
		int lotteryNum=0;
		//1.获取token
		Object access_Token = session.getAttribute("access_Token");
		WanxiaoContext wanxiaoContext = null;
		//获取userId
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
//		int userId=Integer.parseInt(request.getParameter("userId").toString());
		//获取相应需要的参数
		String key=request.getParameter("key");
		Object value=request.getParameter("value");
		//===特别处理enrolDate字段==
		//enrolDate字段的时间格式是yyyy-mm,但是数据库的这个字段必须是yyyy-mm-dd格式
		//所以要给前端获取的yyyy-mm格式并接上 dd, 2015-01变成2015-01-00
		if(key.equals("enrolDate")){
			//进入这里说明修改的是enrolDate字段
			//1.将当前value拼接上-00
			StringBuffer buffer=new StringBuffer(value.toString());
			String day="-00";
			String newvalue=buffer.append(day).toString();
			//2.将拼接好的数据赋值给value变量
			value=newvalue;
		}
		//对value变量进行编码处理--utf-8
		try {
			String valueStr=new String(value.toString().getBytes("iso8859-1"),"utf-8");
			value=valueStr;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//获取前端传递的粮票数量
		int lpAwardNum=Integer.parseInt(request.getParameter("liangpiaoAwardNum").toString());
		//获取前端传递是否添加粮票
		int isAward=Integer.parseInt(request.getParameter("isAward").toString());
		//创建实体对象
		UpDatePersonalInfo udpi=new UpDatePersonalInfo(userId, key, value);
		int tag=0;
		int resultrownum=0;
		//判断实体是否为空
		if(userId!=0){
			//调用更新用户数据Dao方法接收返回影响行数
			resultrownum=personalService.updadtePersonalInfo(udpi);
			//调用玩笑提供的获取用户粮票方法
			//判断是否添加的粮票超过30个并且是否为0
			if(!(lpAwardNum>30)&&isAward!=0){
				//不大于30个就给用户添加粮票
				if(access_Token!=null){
					wanxiaoContext = new WanxiaoContext((String) access_Token);
				}
				
				//添加积分
				String scoreAdd = "";
				if(wanxiaoContext!=null){
					try {
						scoreAdd = wanxiaoContext.scoreAdd(lpAwardNum);
						//标示积分添加成功
						tag=1;
					} catch (Exception e) {
						e.printStackTrace();
						return AjaxResult.errorResult("给当前用户添加积分失败!");
					}
				}
				//==给积分信息表添加数据==
				//1.给实体类添加数据
				NiUserAwardStatistics niUserAwardStatistics=new NiUserAwardStatistics();
				niUserAwardStatistics.setUserId(userId);//添加用户Id
				niUserAwardStatistics.setAwardMethod(4);//设置获奖方式来自完善个人信息
				niUserAwardStatistics.setAwardCause(2);//设置奖励原因是完善个人信息
				niUserAwardStatistics.setDeliveryId(0);//设置投放Id，因为没有对应的投放，并且不能为空，所以给个0就可以了
				niUserAwardStatistics.setQnChannel(1);//设置问卷渠道来自玩笑
				//根据粮票多少判断awardId对应的数据
				if(lpAwardNum==5){
					niUserAwardStatistics.setAwardId(10055);
				}else if(lpAwardNum==10){
					niUserAwardStatistics.setAwardId(10056);
				}
				//2.获取当前时间
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date nowDate=new Date();
				Timestamp formatNowDate=Timestamp.valueOf(sdf.format(nowDate));
				niUserAwardStatistics.setAwardGetTime(formatNowDate);//设置添加添加的时间
				//调用Service的方法接收返回数据
				lotteryNum=niUserAwardStatisticsService.insertUserAwardStatistics(niUserAwardStatistics);
				
				
			}else if(lpAwardNum>30){
				ErrorMessage em=new ErrorMessage();
				//粮票大于30就返回错误信息
				em.setErrCode("001");
				em.setErrInfo(" liangppiaoAwardNum > 30 ,So Integral addition failed ");
				em.setSuccess("false");
				return em;
			}
			if(lpAwardNum==0){
				//如果积分为0，记录日志
				logger.info(" lpAwardNum Is 0,Did not add points to the user ，It is possible that the user has added more points");
			}
			if(resultrownum>0&&tag!=0&&lotteryNum!=0){
				JSONObject json=new JSONObject();
				json.put("success", true);
				json.put("successInfo", "用户信息更新成功,该用户粮票已增加,用户奖励记录已增加");
				return json;
			}else if(resultrownum>0&&tag==0){
				JSONObject json=new JSONObject();
				json.put("success", true);
				json.put("successInfo", "用户信息更新成功,该用户粮票未增加,用户奖励记录未增加");
				return json;
			}else{
				ErrorMessage errorMessage=new ErrorMessage();
				errorMessage.setErrCode("001");
				errorMessage.setErrInfo(" 用户信息更新失败， 该用户粮票未增加,,用户奖励记录未增加"
						+ "");
				errorMessage.setSuccess("false");
				return errorMessage;
			}
			
		}else{
			//创建错误信息对象
			ErrorMessage error=new ErrorMessage();
			//返回错误信息
			error.setErrCode("002");
			error.setErrInfo(" UpDatePersonalInfo is null");
			error.setSuccess("false");
			return error;
		}
	}
	
	
}
