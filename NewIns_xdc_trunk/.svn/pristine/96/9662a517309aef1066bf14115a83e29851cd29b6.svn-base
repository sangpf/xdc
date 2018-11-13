package com.newins.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.Member;
import com.newins.service.MemberService;
import com.newins.service.ProductService;
import com.newins.util.ErrorMessage;

/**
 *会员Controller
 * @author Zhang
 *
 */
@Controller
@RequestMapping("/wanx")
public class MemberController {
	private static Logger log=Logger.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private ProductService productService;
	@RequestMapping(value="/membership",method=RequestMethod.GET)
	@ResponseBody
	/**
	 * 开通个人会员
	 * @param request
	 * @return
	 */
	public Object Membership(HttpServletRequest request){
		log.info("this is MemberController--开通个人会员接口");
		//获取session
		HttpSession session=request.getSession();
		//获取session中的userId
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		//创建会员实体类
		Member member=new Member();
		//判断userId是否为空
		if(userId!=null){
			//进入这里userId不为空，继续操作
			//获取当前时间
			Date date=new Date();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String bTime=df.format(date);
			//获取当前年份
			DateFormat df2=new SimpleDateFormat("yyyy");
			String yearStr=df2.format(new Date());
			//将当前年份加1
			int year=Integer.parseInt(yearStr)+1;
			//获取当前月-日 时:分:秒
			DateFormat df3=new SimpleDateFormat("MM-dd HH:mm:ss");
			String othordate=df3.format(new Date());
			//将处理过的年和月-日 时:分:秒拼接在一起获得会员到期时间
			String newETime=String.valueOf(year)+'-'+othordate;
			//给实体类设置属性
			member.setUserId(Integer.parseInt(userId.toString()));
			member.setbTime(bTime);
			member.seteTime(newETime);
//			//获取赠送的产品包id--参数为渠道id
//			int freePackageId=productService.SelectLimit1Product(1);
//			//查询用户是否已经拥有开通会员赠送的产品包
//			int isHave=memberService.isHaveFreePackage(Integer.parseInt(userId.toString()), freePackageId);
//			//判断返回值
//			if(isHave==0){
//				//进入这里表示当前用户是第一次开通会员，可以赠送免费产品包
//				//创建个人产品包实体类对象
//				PersonalProduct pp=new PersonalProduct();
//				//设置实体类属性
//				pp.setUserId(Integer.parseInt(userId.toString()));
//				pp.setPackageId(freePackageId);
//				pp.setStatus(1);
//				pp.setbTime(bTime);
//				pp.seteTime(newETime);
//				//调用赠送免费产品包方法
//				int resultnum=memberService.insertFreePackage(pp);
//				//判断返回值
//				if(resultnum>0){
//					//进入这里表示赠送成功
//					log.info("用户第一次开通会员，成功赠送第一个产品包");
//				}else{
//					//进入这里表示赠送失败
//					log.info("用户第一次开通会员，赠送第一个产品包失败");
//				}
//			}else{
//				//进入这里表示用户已经拥有免费产品包了
//				log.info("用户已经拥有免费产品包了");
//			}
			//调用Service中的相关方法
			try {
				memberService.Membership(member);
			} catch (Exception e) {
				return 0;
			}
			return 1;
		}else{
			//进入这里表示userId为空，返回错误信息
			ErrorMessage em=new ErrorMessage();
			em.setErrCode("001");
			em.setSuccess("false");
			em.setSuccess("userId is null");
			return em;
		}
	}
	
	/**
	 * 查询是否为个人会员或者集体会员
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/isMember",method=RequestMethod.GET)
	@ResponseBody
	public Object IsPersonalMember(HttpServletRequest request){
		log.info("this is MemberController--查询是否为个人会员或者集体会员");
		//获取session
		HttpSession session=request.getSession();
		//获取session中的userId
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		if(userId!=null){
			int newUserId=Integer.parseInt(userId.toString());
			//进入这里表示userid不是空的
			//调用相关service方法查询是否为个人会员
			int personalMember=memberService.IsPersonalMember(newUserId);
			//调用相关service方法查询用户的schoolId
			Integer schoolId=memberService.getUserSchoolId(newUserId);
			int collectiveMember;
			//判断schoolId是否为空
			if(schoolId!=null){
				//进入这里表示查到了用户的学校id
				//再根据schoolId作为参数查询当前用户的学校是否已购买会员服务
				collectiveMember=memberService.IsCollectiveMember(Integer.parseInt(schoolId.toString()));
			}else{
				//进入这里表示查询不到用户的学校id表示用户不是集体会员
				collectiveMember=0;
			}
			//判断用户属于哪个会员体系
			if(personalMember>0&&collectiveMember>0){
				//进入这里表示是集体会员也是个人会员
				log.info("用户是集体会员也是个人会员");
				return 3;
			}else if(personalMember>0){
				//进入这里表示是个人会员
				log.info("用户是个人会员");
				return 2;
			}else if(collectiveMember>0){
				//进入这里表示是集体会员
				log.info("用户是集体会员");
				return 1;
			}else{
				log.info("用户不是会员");
				//进入表示不是会员
				return 0;
			}
		}else{
			//进入这里表示userId是空的就返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setSuccess("false");
			error.setErrInfo("userId is null");
			return error;
		}
	}
}
