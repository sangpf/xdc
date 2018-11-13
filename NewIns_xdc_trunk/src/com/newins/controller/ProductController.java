package com.newins.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Array;
import com.newins.model.PackageList;
import com.newins.model.ProductColum;
import com.newins.model.ProductList;
import com.newins.model.ProductPageInfo;
import com.newins.model.Recommended;
import com.newins.model.UserPortrait;
import com.newins.service.MemberService;
import com.newins.service.ProductService;
import com.newins.util.ErrorMessage;


/**
 * 产品包业务Controller
 * @author Zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private MemberService memberService;
	/**
	 * 获取产品包引导页信息
	 * @return
	 */
	@RequestMapping(value="/getPageInfo",method=RequestMethod.GET)
	@ResponseBody
	public Object getPageInfo(HttpServletRequest request){
		//获取前端传递的productId参数
		int productId=Integer.parseInt(request.getParameter("productId").toString());
		//创建实体类
		ProductPageInfo ppi=new ProductPageInfo();
		//调用相关service
		ppi=productService.getPageInfo(productId);
		//========因为产品包刚刚上线没有什么人购买产品包，为了
		//美化，让参加测试的人看起来很多。为此对参加测试的人数进行特殊处理
		
		//调用查询产品包的参加测试人数方法
		Integer  attendNum=productService.SelectAttendNum(productId);
		//判断参加测试人数是否为空
		if(attendNum==null){
			//进入这里表示参加测试人数为0人，把参加测试人数设置为1123
			attendNum=1123;
		}
		//生产1-5的随机数
		Random ran=new Random();
		int randomNum=ran.nextInt(5);
		//设置新的参与测试人数--数据库保存的人数加上生成的随机数等于最新的参加测试人数
		int newAttendNum=attendNum+randomNum;
		//将最新的参加测试人数保存到数据库中
		productService.UpDateAttendNum(newAttendNum, productId);
		//将最新的参加测试人数保存到实体类中
		ppi.setAttendNum(newAttendNum);
		//返回数据
		return ppi;
	}
	/**
	 * 获取产品包列表数据
	 * @return
	 */
	@RequestMapping(value="/getProductList",method=RequestMethod.GET)
	@ResponseBody
	public Object getProductList(HttpServletRequest request){
		//获取前端传递的参数
		int channelId=Integer.parseInt(request.getParameter("channelId"));
		//获取session
		HttpSession session=request.getSession();
		//获取userId
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		List<ProductList> productList=new ArrayList<ProductList>();
		//判断userId是否为空
		if(userId!=null){
			int newUserId=Integer.parseInt(userId.toString());
			//进入这里表示userId不为空，继续操作
			//调用相关service,获取产品包列表
			productList=productService.getProductList(channelId);
			//循环产品包列表
			for(int i=0;i<productList.size();i++){
				//取出当前下边的id属性
				int packageId=productList.get(i).getId();
				//调用查询用户是否个人购买了当前id的产品包
				int personal=productService.isBuyPersonalProduct(newUserId, packageId);
				//查询当前用户的学校id
				Integer schoolId=memberService.getUserSchoolId(newUserId);
				int school;
				//判断schoolId是否为空
				if(schoolId!=null){
					//进入这里表示查询到了用户的学校id
					//调用查询用户的学校是否购买了当前id的产品包
					school=productService.isBuySchoolProduct(Integer.parseInt(schoolId.toString()), packageId);
				}else{
					//进入这里表示没有查询到用户的学校id
					//表示当前用户学校没有购买产品包
					school=0;
				}
				//判断查询结果返回的数值
				if(personal>0){
					System.out.println("当前用户个人购买了产品包"+packageId);
					//进入这里表示用户个人购买了当前id的产品包
					//将产品包列表中的state属性设置为1
					productList.get(i).setUserState(1);
				}else if(school>0){
					System.out.println("当前用户学校购买了产品包"+packageId);
					//进入这里表示用户的学校购买了当前id的产品包
					//将产品包列表中的state属性设置为1
					productList.get(i).setUserState(1);
				}else{
					System.out.println("当前用户没有购买产品包"+packageId);
					//进入这里表示没有购买
					productList.get(i).setUserState(0);
				}
				//调用查询产品包价格方法
				double discount=productService.PackagePrice(packageId);
				System.out.println("产品包id为"+packageId+"的产品包价格是:"+discount);
				//将当前产品包的价格保存到实体属性中
				productList.get(i).setDiscount(discount);
			}
			return productList;
		}else{
			//进入这里表示userId是空的，返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setErrInfo("userId is null ");
			error.setSuccess("false");
			return error;
		}
	}
	/**
	 * 获取指定产品包的内容列表
	 * @return
	 */
	@RequestMapping(value="/getProductContentList",method=RequestMethod.GET)
	@ResponseBody
	public Object PackageContentList(HttpServletRequest request){
		//获取前端传递的参数
		int packageId=Integer.parseInt(request.getParameter("packageId").toString());
		int columId=Integer.parseInt(request.getParameter("columId").toString());
		JSONObject json=new JSONObject();
		//获取session
		HttpSession session=request.getSession();
		//获取userId
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		if(userId!=null){
			//进入这里表示userId不是空的
			//根据columId的值请求不同Service的方法
			if(columId==1){
				//进入这里表示要请求首页数据
				//调用请求首页数据方法
				json=productService.PackageContentList(packageId, Integer.parseInt(userId.toString()));
				return json;
			}else if(columId==2){
				//进入这里表示请求的是产品包内容页顶部左侧入口list
				List<ProductColum> left=new ArrayList<ProductColum>();
				left=productService.getLeftColumList(columId, packageId);
				//循环
				for(int i=0;i<left.size();i++){
					//取出当前下标的qnId
					int qnId=left.get(i).getQnId();
					//请求service中验证是否答过当前问卷方法
					int answered=productService.assessIsAnswered(Integer.parseInt(userId.toString()), qnId);
					//将返回值设置给当前问卷的Answered属性
					left.get(i).setAnswered(answered);
					//取出当前问卷的deliveryId属性
					int deliveryId=left.get(i).getDeliveryId();
					//调用方法算出当前问卷作答人数
					int answeredNum=productService.assessAnsweredNum(deliveryId, qnId);
					//将作答人数设置到当前问卷的属性中
					left.get(i).setAnsweredNum(answeredNum);
				}
				return left;
			}else if(columId==3){
				//进入这里表示请求的是产品包内容页顶部右侧入口list
				return productService.getRightColumList(columId, packageId);
			}else{
				return "columId !== 1,columId !== 2,columId !== 3";
			}
		}else{
			//进入这里表示userId是空的返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setErrInfo("userId is null");
			error.setSuccess("false");
			return error;
		}
	}
	/**
	 * 查询推荐秘籍
	 * @return
	 */
	@RequestMapping(value="/getrecommendedList",method=RequestMethod.GET)
	@ResponseBody
	public Object getrecommendedList(HttpServletRequest request){
		//获取前端传递的参数
		int sourceId=Integer.parseInt(request.getParameter("sourceId").toString());
		//创建推荐秘籍实体list实例
		List<Recommended> recommended=new ArrayList<Recommended>();
		//调用service方法
		recommended=productService.getrecommendedList(sourceId);
		return recommended;
	}
	/**
	 * 查询当前用户是否购买指定产品包
	 * @return
	 */
	@RequestMapping(value="/isPayProduct",method=RequestMethod.GET)
	@ResponseBody
	public Object isPayProduct(HttpServletRequest request){
		//获取前端传递的参数
		int packageId=Integer.parseInt(request.getParameter("packageId"));
		//获取session
		HttpSession session=request.getSession();
		//获取userId
		Object userId=session.getAttribute("userId");
		//Object userId=946044;
		//判断userId是否为空
		if(userId!=null){
			//进入这里表示userId不为空
			//调用service方法
			int result=productService.isBuyPersonalProduct(Integer.parseInt(userId.toString()), packageId);
			return result;
		}else{
			ErrorMessage em=new ErrorMessage();
			em.setErrCode("001");
			em.setErrInfo("userId is null");
			em.setSuccess("false");
			return em;
		}
		
	}
	/**
	 * 获取指定产品包的用户画像数据
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getUserPortrait",method=RequestMethod.GET)
	@ResponseBody
	public Object getUserPortrait(HttpServletRequest request){
		//获取session
		HttpSession session=request.getSession();
		//获取userId
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
		//int userId=946044;
		//获取前端传递的参数
		int packageId=Integer.parseInt(request.getParameter("packageId").toString());
		//创建list实例
		List<UserPortrait> list=new ArrayList<UserPortrait>();
		//调用service方法
		list=productService.getUserPortrait(userId,packageId);
		return list;
	}
}
