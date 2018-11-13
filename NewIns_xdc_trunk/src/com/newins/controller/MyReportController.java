package com.newins.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.CollectionFunction;
import com.newins.model.MyReport;
import com.newins.service.MyReportService;
import com.newins.util.ErrorMessage;

/**
 * 我的收藏相关功能controller
 * @author zhangwenhao
 *
 */
@Controller
@RequestMapping("/wanx")
public class MyReportController {
	//自动绑定相关Service
	@Autowired
	private MyReportService myReportService;
	private static Logger logger=Logger.getLogger(MyReportController.class);
	/**
	 * 删除我的收藏记录
	 * @return:返回数据库响应行数
	 */
	@RequestMapping(value="/deleteReportFavorite",method=RequestMethod.GET)
	@ResponseBody
	public Object DeleteMyFavoritesRecord(HttpServletRequest request){
		logger.info("this is controller : deleteMyFavoritesRecord");
		//获取session
		HttpSession session=request.getSession();
		//获取前端传来的userId和reportId
		Object userId=session.getAttribute("userId");
//		Object userId=Integer.parseInt(request.getParameter("userId").toString());
		Object reportId=request.getParameter("reportId");
		//判断favoriteId是否为空
		if(userId!=null&&reportId!=null){
			//不是空就调用Service相关方法
			int resultNum=myReportService.deleteMyFavorites(Integer.parseInt(userId.toString()),Integer.parseInt(reportId.toString()));
			//判断方法返回值是否大于0
			if(resultNum>0){
				//大于0说明有取消收藏成功
				JSONObject json=new JSONObject();
				json.put("success", "true");
				json.put("successInfo", "取消收藏成功");
				return json;
			}else{
				//进这里表示是0，返回错误信息
				JSONObject jsonl=new JSONObject();
				jsonl.put("success", "false");
				jsonl.put("errCode", "001");
				jsonl.put("errInfo", "取消收藏失败");
				return jsonl;
			}
		}else{
			//是空就记录错误信息
			ErrorMessage errorMessage=new ErrorMessage();
			errorMessage.setErrInfo(" userId or reportId is null");
			errorMessage.setErrCode("001");
			errorMessage.setSuccess("false");
			return errorMessage;
		}
	}
	
	/**
	 * 收藏报告
	 * @return:返回数据库影响行数或者返回错误信息
	 */
	@RequestMapping(value="/favoriteReport")
	@ResponseBody
	public Object StoreUp(HttpServletRequest request){
		logger.info("this is controller : storeUp");
		//获取session
		HttpSession session=request.getSession();
		//获取从前端获取到的报告信息数据
		int userId=Integer.parseInt(session.getAttribute("userId").toString());
//		int userId=Integer.parseInt(request.getParameter("userId").toString());
		int reportId=Integer.parseInt(request.getParameter("reportId").toString());
		//获取当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String favoriteTime=sdf.format(date);
		//将数据保存到实体中
		CollectionFunction collectionFunction=new CollectionFunction(userId, reportId, favoriteTime);
		//判断实体对象是否为空--if中不能直接写 myReport！=null,这样就是一个死代码，不用运行就能知道结果，因为把当前时间给了myReport所以他不是空的
		if(collectionFunction.getUserId()!=0 && collectionFunction.getReportId()!=0){
			//不是空的就调用Service相关方法返回数据库响应行数
			int resultNum=myReportService.storeup(collectionFunction);
			JSONObject json=new JSONObject();
			json.put("success", "true");
			json.put("successInfo", "收藏成功");
			return json;
		}else{
			//是空的就返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("001");
			error.setErrInfo(" myReport is null");
			error.setSuccess("false");
			return error;
		}
	}
	
	/**
	 * 加载我的收藏
	 * @return
	 */
	@RequestMapping(value="/myReport")
	@ResponseBody
	public Object LoadFavorites(HttpServletRequest request){
		logger.info("this is controller : storeUp");
		//获取session
		HttpSession session=request.getSession();
		//从session中获取userId
		Object userId=session.getAttribute("userId");
//		Object userId=request.getParameter("userId");
		//创建接收返回值的list
		List<MyReport> resultlist=new ArrayList<>();
		//判断userId是否为空
		if(userId!=null){
			//不等于空就调用Service的相关方法
			resultlist=myReportService.loadFavorites(Integer.parseInt(userId.toString()));
			//将方法返回的数据resultList装进JSON格式的对象中
			JSONObject jsonList=new JSONObject();
			jsonList.put("success", "true");
			jsonList.put("myReportList", resultlist);
			//将数据返回出去
			return jsonList;
		}else{
			//userId是空就返回错误信息
			ErrorMessage error=new ErrorMessage();
			error.setErrCode("002");
			error.setErrInfo("userId is null");
			error.setSuccess("false");
			return error;
		}
	}
}
