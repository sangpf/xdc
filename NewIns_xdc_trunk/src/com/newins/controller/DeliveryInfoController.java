package com.newins.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.dao.NiUserEducationMapper;
import com.newins.dao.NiUserIdentiferMapper;
import com.newins.model.AdInfo;
import com.newins.model.AssessDeliveryInfo;
import com.newins.model.NiUserEducation;
import com.newins.model.NiUserIdentifer;
import com.newins.model.SurveyDeliveryInfo;
import com.newins.model.VoteDeliveryInfo;
import com.newins.model.user.UserBase;
import com.newins.service.AssessDeliveryInfoService;
import com.newins.service.BlackListService;
import com.newins.service.SurveyDeliveryInfoService;
import com.newins.service.VoteDeliveryInfoService;
import com.newins.service.user.UserBaseService;
import com.newins.util.ErrorMessage;

/**
 * @Description
 * @author MaNia_chAng
 * @time 2016年8月29日 下午4:24:47
 */
@Controller
@RequestMapping("/wanx")
public class DeliveryInfoController {

	private static Logger log = Logger.getLogger(DeliveryInfoController.class);
	@Resource
	private SurveyDeliveryInfoService surveyDeliveryInfoService;

	@Resource
	private AssessDeliveryInfoService assessDeliveryInfoService;

	@Resource
	private VoteDeliveryInfoService voteDeliveryInfoService;
	
	@Autowired
	private UserBaseService userBaseService;
	@Autowired
	private NiUserIdentiferMapper niUserIdentiferMapper;
	@Autowired
	private NiUserEducationMapper niUserEducationMapper;
	@Autowired
	private BlackListService blackListService;

	/**
	 * @Title: surveyDeliveryInfo
	 * @Author: Guan
	 * @Description: 调查投放信息接口
	 * @param request
	 * @return Object
	 * @Time 2017年1月6日 下午4:17:34
	 */
	@RequestMapping(value = "/surveyDeliveryInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object surveyDeliveryInfo(HttpServletRequest request) {

		log.info("This is controller:surveyDeliveryInfo");
		int userId = 0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
//		Object userIdObj = request.getParameter("userId");
		//Object userIdObj=946044;
		if (userIdObj == null) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}

	//	 String userIdStr = request.getParameter("userId").trim();
		// int userId = Integer.parseInt(userIdStr);

		String deliveryIdStr = request.getParameter("deliveryId").trim();
		int deliveryId = Integer.parseInt(deliveryIdStr);

		SurveyDeliveryInfo deliveryInfo = surveyDeliveryInfoService
				.getDeliveryInfo(userId, deliveryId);
		
		//二次处理votedeliveryInfo数据
		//获取session中的schoolId
		Object wanxSchoolId=session.getAttribute("schoolId");
		int newWanxSchoolId=0;
		if(wanxSchoolId!=null){
			newWanxSchoolId=Integer.parseInt(wanxSchoolId.toString());
		}
		//取出adType属性
		int adType=deliveryInfo.getAdType();
		//获取当前广告的替代广告id属性
		int replaceAdId=deliveryInfo.getReplaceAdId();
		boolean temp=false;
		//使用wanxSchoolId作为参数请求获取用户学校id方法
		Integer schoolId=blackListService.userSchoolId(newWanxSchoolId);
		if(schoolId!=null){
			//进入这里表示查到了学校id，继续操作
			//调用过滤黑名单内部方法接收返回值
			temp=this.filterBlackList(adType, Integer.parseInt(schoolId.toString()),replaceAdId);
			//判断temp的值
			if(temp==true){
				//创建广告信息实体类实例
				AdInfo adinfo=new AdInfo();
				//进入这里表示当前用户的学校在黑民单中
				//调用获取当前广告的替代广告id信息方法
				adinfo=blackListService.getReplaceAdInfo(replaceAdId);
				//判断是否为空
				if(adinfo!=null){
					//将替代广告信息替换到当前广告信息中
					//替换adId属性
					deliveryInfo.setAdId(adinfo.getAdId());
					//替换广告图片地址
					deliveryInfo.setAdImg(adinfo.getAdImg());;
					//替换广告链接
					deliveryInfo.setAdLink(adinfo.getAdLink());
				}else{
					//进入这里表示当前广告没有设置替换广告id
					deliveryInfo.setAdId(0);
					//替换广告图片地址
					deliveryInfo.setAdImg("");;
					//替换广告链接
					deliveryInfo.setAdLink("");
				}
						
			}	
		}else{
			//进入这里表示没有查到用户的学校id，不做任何操作
		}
		//收工
		return deliveryInfo;
		}

	/**
	 * @Title: assessDeliveryInfo
	 * @Author: Guan
	 * @Description: TODO
	 * @param request
	 * @return Object
	 * @Time 2017年1月6日 下午4:17:52
	 */
	@RequestMapping(value = "/assessDeliveryInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object assessDeliveryInfo(HttpServletRequest request) {

		log.info("This is controller:assessDeliveryInfo");
		int userId = 0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
//		Object userIdObj=946044;
		/**
		 * 注释 : 生成临时用户信息,适用于非登录用户   2017/02/26
		 * 
		 * 之前生成临时用户信息是在用户点击提交的时候,当时是出现了问题,非登录用户答多维度测评题会出错,结果页也无法加载
		 * 6 月25 日周日 开会讨论出结果, 分析问题的原因是 加载测评问卷的时候需要用户的id , 但是如果是临时未登录用户,用户的id此时还
		 * 未生成, 在点击提交的时候才会生成,简单测评模型题不会报错,是因为有个默认值 .
		 * 解决方案是未登录用户生存用户id放到加载测评问卷时, 而不是用户点击提交时
		 */
		if (userIdObj == null) {
			System.out.println("===游客进入===");
			// 先增加到用户标识信息表 , 然后才能将userid同步到其他表中 ,防止在其他表中添加用户的时候主键冲突
			
			// 添加到 ni_user_identifer  
			NiUserIdentifer niUserIdentifer = new NiUserIdentifer();
			niUserIdentifer.setWanxNickname("游客");
			niUserIdentiferMapper.insertSelective(niUserIdentifer);
			
			userId = niUserIdentifer.getUserId();
			
			session.setAttribute("userId", userId);
			session.setAttribute("userType", "tmpUser");
			//用户未登录,生成临时用户id
			
			UserBase userBase = new UserBase();
			userBase.setComment("tmpUser");
			userBase.setUserCTime(new Date());
			userBase.setUserId(userId);
			
			userBaseService.addUserBase(userBase);
			
			// 添加到 ni_user_education
			NiUserEducation niUserEducation = new NiUserEducation();
			niUserEducation.setUserid(userId);
			niUserEducation.setSchoolname("心发现VIP");
			niUserEducation.setSchoolid(0);
			//设置session中schoolId为0
			session.setAttribute("schoolId", 0);
			niUserEducationMapper.insertSelective(niUserEducation);
			
			log.info("===============>>游客登录===="+userBase.toString());
	
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
			session.setAttribute("userType", null);
		}

		// String userIdStr = request.getParameter("userId").trim();
		// int userId = Integer.parseInt(userIdStr);
		String deliveryIdStr = request.getParameter("deliveryId").trim();
		int deliveryId = Integer.parseInt(deliveryIdStr);

		AssessDeliveryInfo deliveryInfo = assessDeliveryInfoService.getDeliveryInfo(userId, deliveryId);
		//二次处理assessdeliveryInfo数据
		//取出adType属性
		int adType=deliveryInfo.getAdType();
		//获取session中的schoolId
		Object wanxSchoolIdObj=session.getAttribute("schoolId");
		System.out.println("session中的学校id是:"+wanxSchoolIdObj);
		//判断session中的schoolId是否为null
		if(wanxSchoolIdObj!=null){
			//进入这里表示不为空
			int wanxSchoolId=Integer.parseInt(wanxSchoolIdObj.toString());
			//获取当前广告的替代广告id属性
			int replaceAdId=deliveryInfo.getReplaceAdId();
			boolean temp=false;
			//使用wanxSchoolId作为参数请求获取用户学校id方法
			Integer schoolId=blackListService.userSchoolId(wanxSchoolId);
			//判断schoolId是否为0
			if(schoolId!=null){
				//进入这里表示查询到了学校id，继续操作
				//调用过滤黑名单内部方法接收返回值
				temp=this.filterBlackList(adType, Integer.parseInt(schoolId.toString()),replaceAdId);
				//判断temp的值
				if(temp==true){
					//创建广告信息实体类实例
					AdInfo adinfo=new AdInfo();
					//进入这里表示当前用户的学校在黑民单中
					//调用获取当前广告的替代广告id信息方法
					adinfo=blackListService.getReplaceAdInfo(replaceAdId);
					//判断是否为空
					if(adinfo!=null){
						//将替代广告信息替换到当前广告信息中
						//替换adId属性
						deliveryInfo.setAdId(adinfo.getAdId());
						//替换广告图片地址
						deliveryInfo.setAdImg(adinfo.getAdImg());;
						//替换广告链接
						deliveryInfo.setAdLink(adinfo.getAdLink());
					}else{
						//进入这里表示当前广告没有设置替换广告id
						deliveryInfo.setAdId(0);
						//替换广告图片地址
						deliveryInfo.setAdImg("");;
						//替换广告链接
						deliveryInfo.setAdLink("");
					}
					
				}	
			}else{
				//进入这里表示没有查询到学校id，不做操作
			}
		}
		//收工
		return deliveryInfo;
	}

	/**
	 * @Title: voteDeliveryInfo
	 * @Author: Guan
	 * @Description: 投票投放信息
	 * @param request
	 * @return Object
	 * @Time 2017年1月6日 下午4:19:44
	 */
	@RequestMapping(value = "/voteDeliveryInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object voteDeliveryInfo(HttpServletRequest request) {

		log.info("This is controller:voteDeliveryInfo");
		int userId = 0;
		HttpSession session = request.getSession(true);
		Object userIdObj = session.getAttribute("userId");
//		Object userIdObj = request.getParameter("userId");
		//Object userIdObj=946044;
		if (userIdObj == null) {
			ErrorMessage error = new ErrorMessage();
			error.setSuccess("false");
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			return error;
		} else {
			userId = Integer.parseInt(String.valueOf(userIdObj));
		}

		// String userIdStr = request.getParameter("userId").trim();
		// int userId = Integer.parseInt(userIdStr);
		String deliveryIdStr = request.getParameter("deliveryId").trim();
		int deliveryId = Integer.parseInt(deliveryIdStr);
		VoteDeliveryInfo deliveryInfo = voteDeliveryInfoService.getDeliveryInfo(userId,deliveryId);
		//二次处理votedeliveryInfo数据
		//取出adType属性
		int adType=deliveryInfo.getAdType();
		Object wanxSchoolId=session.getAttribute("schoolId");
		int newWanxSchoolId=0;
		if(wanxSchoolId!=null){
			newWanxSchoolId=Integer.parseInt(wanxSchoolId.toString());
		}
		//获取当前广告的替代广告id属性
		int replaceAdId=deliveryInfo.getReplaceAdId();
		boolean temp=false;
		//使用wanxSchoolId作为参数请求获取用户学校id方法
		Integer schoolId=blackListService.userSchoolId(newWanxSchoolId);
		//判断学校id是否为0
		if(schoolId!=null){
			//进入这里表示查询到了学校id，继续操作
			//调用过滤黑名单内部方法接收返回值
			temp=this.filterBlackList(adType, Integer.parseInt(schoolId.toString()),replaceAdId);
			//判断temp的值
			if(temp==true){
				//创建广告信息实体类实例
				AdInfo adinfo=new AdInfo();
				//进入这里表示当前用户的学校在黑民单中
				//调用获取当前广告的替代广告id信息方法
				adinfo=blackListService.getReplaceAdInfo(replaceAdId);
				//判断是否为空
				if(adinfo!=null){
					//将替代广告信息替换到当前广告信息中
					//替换adId属性
					deliveryInfo.setAdId(adinfo.getAdId());
					//替换广告图片地址
					deliveryInfo.setAdImg(adinfo.getAdImg());;
					//替换广告链接
					deliveryInfo.setAdLink(adinfo.getAdLink());
				}else{
					//进入这里表示当前广告没有设置替换广告id
					deliveryInfo.setAdId(0);
					//替换广告图片地址
					deliveryInfo.setAdImg("");;
					//替换广告链接
					deliveryInfo.setAdLink("");
				}
						
			}	
		}else{
			//进入这里表示没有查询到学校id，不做操作
		}
		//收工
		return deliveryInfo;
	}
	
	/**
	 * 过滤黑名单内部方法
	 * @param adType:广告类型
	 */
	private boolean filterBlackList(int adType,int schoolId,int replaceAdId){
				//初始化当前用户的学校是否为黑名单变量
				boolean temp=false;
				//创建广告信息实体类实例
				AdInfo adinfo=new AdInfo();
				//判断当前广告是否为商业广告
				if(adType==1){
					//进入这里表示当前的广告是商业广告
					//创建list实例
					List<Integer> blackList=new ArrayList<>();
					//调用获取学校黑名单方法
					blackList=blackListService.getSchoolBlackList();
					//获取黑名单list长度
					int listSize=blackList.size();
					//循环判断当前用户的学校是否为黑名单
					for(int i=0;i<listSize;i++){
						if(blackList.get(i)==schoolId){
							//将变量设置为true
							temp=true;
							//结束循环
							break;
						}
					}
					
				}
				return temp;
	}
}
