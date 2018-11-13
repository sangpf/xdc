package com.newins.service.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MySuperSurveyDao;
import com.newins.model.MysuperSuvey;
import com.newins.service.MySuperSurveyService;
import com.newins.util.CommonComparator;
import com.newins.util.ErrorMessage;

/**
 * 认知世界->我参与的调查板块数据加载业务逻辑层实现类
 * @author zhangwenhao
 *
 */
@Service(value="MySuperSurveyService")
public class MySuperSurveyServiceImp implements MySuperSurveyService {
	/**
	 * 自动绑定相关Dao
	 */
	@Autowired
	private MySuperSurveyDao mySuperSurveyDao;
	/**
	 * 分页查询指定用户参与的调查和投票数据
	 */
	public Object getMysuperSuveyInfo(int userId, int page) {
				//实例化一个Json对象
				JSONObject jsonList=new JSONObject();
				//实例化一个List对象
				List<MysuperSuvey> list=new ArrayList<>();
				//调用相关Dao方法接收返回数据
				list=mySuperSurveyDao.getMysuperSuveyInfo(userId);
				//循环将数据中的isFavorite字段添加数据
				for (int i = 0; i < list.size(); i++) {
					//取出reportId对象
					int reportId=list.get(i).getReportId();
					//调用判断是否收藏方法
					int isFavorite=this.matchingIsFavorite(userId,reportId);
					//再将是否收藏变量添加到list中相应的对象中
					list.get(i).setIsFavorite(isFavorite);
				}
				//声明开始下标变量
				int bIndex=(page-1)*20;
				//声明结束下标变量
				int eIndex=(page-1)*20+19;
				//声明总页数变量
				int pageCount=0;
				//声明存放分页后的数据集合
				List<MysuperSuvey> supersuvey=new ArrayList<>();
				//判断list长度是否为0
				if(list.size()!=0){
					//进行分页查询
					//判断最后一页是否够20条数据
					if(list.size()%20 ==0){
						pageCount=list.size() / 20;
					}else{
						//不够20条就单独算1页
						pageCount=list.size() / 20+1;
					}
					//判断页数下标越界
					if(bIndex>list.size()-1){
						//说明下标越界，返回错误
						ErrorMessage error=new ErrorMessage();
						error.setErrInfo(" begin Index  out of bounds");
						error.setErrCode("002");
						error.setSuccess("false");
						return error;
					}
					//判断结束下标是否越界
					if(eIndex<list.size()-1){
						supersuvey=list.subList(bIndex,eIndex+1);
					}else{
						//将结束下标锁定在list的最后一个数据下标
						supersuvey=list.subList(bIndex, list.size());
					}
						//将分页后的数据封装成JSON格式
						JSONObject resultList=new JSONObject();
						resultList.put("success", true);
						resultList.put("totalPage", pageCount);
						resultList.put("mySuperList", supersuvey);
						return resultList;
				}else{
					//如果页数只够1页就将总页数定在1页
					JSONObject resultList=new JSONObject();
					resultList.put("success", true);
					resultList.put("totalPage", 1);
					resultList.put("mySuperList", supersuvey);
					
					return resultList;
				}
				
	}
	/**
	 * 匹配是否收藏
	 */
	public int matchingIsFavorite(int userId, int reportId) {
		//调用相关Dao方法
		return mySuperSurveyDao.matchingIsFavorite(userId, reportId);
	}
	

}
