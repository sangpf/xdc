package com.newins.service.imp;
/**
 * 产品包业务逻辑层实现类
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.ProductDao;
import com.newins.model.PackageList;
import com.newins.model.ProductColum;
import com.newins.model.ProductList;
import com.newins.model.ProductPageInfo;
import com.newins.model.Recommended;
import com.newins.model.UserPortrait;
import com.newins.service.ProductService;
import com.newins.util.CommonComparator;
@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductDao productDao;
	/**
	 * 获取产品包引导页信息
	 */
	public ProductPageInfo getPageInfo(int productId) {
		//直接调用dao层
		return productDao.getPageInfo(productId);
	}
	/**
	 * 获取产品包列表数据
	 * @return
	 */
	public List<ProductList> getProductList(int channelId) {
		//直接调用dao层
		return productDao.getProductList(channelId);
	}
	/**
	 * 查询当前用户是否购买指定产品包了并且未到期(个人产品包)
	 * @param productId：产品包id
	 * @return
	 */
	public int isBuyPersonalProduct(int userId, int packageId) {
		//直接调用dao层
		return productDao.isBuyPersonalProduct(userId, packageId);
	}
	/**
	 * 查询用户的学习是否购买了产品包并且未到期(集体产品包)
	 * @param schoolId
	 * @param packageId
	 * @return
	 */
	public int isBuySchoolProduct(int schoolId, int packageId) {
		//直接调用dao层
		return productDao.isBuySchoolProduct(schoolId, packageId);
	}
	/**
	 * 获取产品包内容list
	 * @return
	 */
	public JSONObject PackageContentList(int packageId,int userId) {
		//实现思路:
				//前端需要头部置顶图片，两个栏目名称，包括推文，测评问卷在内的list
				//将头部置顶图片，两个栏目名称写在一个方法中，获取他们的数据包装到一个实体类中
				//将推文单独写在一个方法，包装到一个实体类
				//将测评问卷单独写在一个方法，包装到一个实体类中(和推文是一个实体类)
				//最后将这三个方法返回的数据放到json中返回给前端
		//=======================分割线================================
		JSONObject json=new JSONObject();
		//创建测评list实例
		List<PackageList> assess=new ArrayList<PackageList>();
		//创建调查list实例
		List<PackageList> survey=new ArrayList<PackageList>();
		//调用获取产品内容头部数据方法并插入到json中
		json.put("head", productDao.getPackageHead(packageId));
		//创建tweet实例
		List<PackageList> tweet=new ArrayList<PackageList>();
		//接收推文列表数据
		tweet= productDao.getPackageTweet(packageId);
		//调用获取产品推文列表数据方法并插入到json中
		json.put("tweet",tweet);
		//调用获取产品测评问卷列表数据方法
		assess=productDao.getPackageAssess(packageId);
		//循环取出deliveryId
		for(int i=0;i<assess.size();i++){
			int deliveryId=assess.get(i).getDeliveryId();
			//调用获取当前用户答过的指定投放的问卷结果概述方法并赋值给当前下标的属性
			String dbResultSummary=productDao.getAssessResultSummary(deliveryId, userId);
			//先判断当前下表的result是否为空
			if(dbResultSummary!=null){
				//进入这里表示不为空，将从数据库中获取到的插入到对应的问卷中
				assess.get(i).setResultSummary(dbResultSummary);
			}
			//取出当前下标的qnId
			int qnId=assess.get(i).getQnId();
			//调用dao层方法验证当前问卷是否有推荐秘籍
			int isRecommended=productDao.isRecommended(deliveryId);
			//判断返回值
			if(isRecommended!=0){
				//进入这里表示有推荐秘籍，设置当前问卷的属性
				assess.get(i).setIsRecommended(1);
			}else{
				//进入这里表示没有推荐秘籍
				assess.get(i).setIsRecommended(0);
			}
			//初始化是否未答过属性为0
			assess.get(i).setAnswered(0);
			//取出当前下标的问卷的qnType属性
			if(assess.get(i).getQnType()==2){
				//进入这里表示当前问卷是测评
				//调用dao层中查询当前用户是否答过当前问卷
				int answered=productDao.assessIsAnswered(userId, qnId);
				//设置给当前问卷的answered属性
				assess.get(i).setAnswered(answered);
			}
		}
		//调用查询调查问卷listdao方法
		survey=productDao.getPackageSurvey(packageId);
		//将调查问卷进行二次处理
		for(int i=0;i<survey.size();i++){
			//取出当前问卷的qnId
			int qnId=survey.get(i).getQnId();
			//调用dao方法查询当前用户是否答过当前调查问卷
			int answered=productDao.surveyIsAnswered(userId, qnId);
			//将返回的数据保存到当前调查问卷的属性中
			survey.get(i).setAnswered(answered);
		}
		//将测评和调查问卷放到一个list中
		List all=new ArrayList<>();
		all.addAll(assess);
		all.addAll(survey);
		//将处理好的测评问卷信息保存到json中
		//根据showorder字段进行升序排序
		Collections.sort(all, new Comparator<PackageList>() {

			//方法重载
			public int compare(PackageList o1, PackageList o2) {
				int temp=o1.getShowOrder()-o2.getShowOrder();
				return temp;
			}
		});
		//将list放进json
		json.put("qn", all);
		return json;
	}
	/**
	 * 获取产品包内容页左侧入口的list
	 * @return
	 */
	public List<ProductColum> getLeftColumList(int columId, int packageId) {
		//直接调用dao方法
		return productDao.getLeftColumList(columId, packageId);
	}
	/**
	 * 获取产品包内容页右侧入口的list
	 * @return
	 */
	public List<ProductColum> getRightColumList(int columId, int packageId) {
		//直接调用dao方法
		return productDao.getRightColumList(columId, packageId);
	}
	/**
	 * 判断当前用户是否答过当前测评问卷
	 * @param userId
	 * @param qnId
	 * @return
	 */
	public int assessIsAnswered(int userId, int qnId) {
		//直接调用dao层
		return productDao.assessIsAnswered(userId, qnId);
	}
	@Override
	public List<Recommended> getrecommendedList(int sourceId) {
		//直接调用dao层
		return productDao.getrecommendedList(sourceId);
	}
	@Override
	public int assessAnsweredNum(int deliveryId, int qnId) {
		//直接调用dao层
		return productDao.assessAnsweredNum(deliveryId, qnId);
	}
	/**
	 * 查询指定产品包的用户画像数据
	 */
	public List<UserPortrait> getUserPortrait(int userId,int packageId) {
		//创建list实例
		List<UserPortrait> list=new ArrayList<UserPortrait>();
		//调用相关dao方法
		list=productDao.getUserPortrait(packageId);
		//循环取出数据进行二次处理
		for(int i=0;i<list.size();i++){
			//===============公用变量=======================
			//取出当前下标的qnId
			int qnId=list.get(i).getQnId();
			//取出当前下标的deliveryId
			int deliveryId=list.get(i).getDeliveryId();
			//取出当前下标问卷的qnCategory
			int qnCategory=list.get(i).getQnCategory();
			//===============获取是否答题===================
			//调用dao方法获取是否已经答过题了
			int answered=productDao.assessIsAnswered(userId, qnId);
			//将方法返回的数据保存到当前下标的问卷属性中
			list.get(i).setAnswered(answered);
			//===============分割线=======================
			//调用dao方法获取用户答题结果概述
			String resultSummary=productDao.getAssessResultSummary(deliveryId, userId);
			//将方法返回的数据保存到当前下标的问卷属性中
			list.get(i).setResultSummary(resultSummary);
			//===============分割线=======================
			//判断当前下标问卷的qnCategory属性
			if(qnCategory==0){
				//进入这里表示当前问卷是简单测评模型
				//创建List实例
				List<String> simpleSummary=new ArrayList<String>();
				//请求dao方法获取当前问卷模型的测评结果概述
				simpleSummary=productDao.getSimpleAllResult(qnId);
				//将方法返回的数据保存到当前下标的问卷属性中
				list.get(i).setSimpleSummary(simpleSummary);
			}else if(qnCategory==1){
				//进入这里表示当前问卷是多维度加总型模型
				//创建List实例
				List<String> multiSum=new ArrayList<String>();
				List<String> multiSumRelation=new ArrayList<String>();
				List<String> multiSumAll=new ArrayList<String>();
				//请求dao方法获取当前问卷模型的测评结果概述
				multiSum=productDao.assessMultiSumAllResult(qnId);
				//请求方法获取当前问卷模型的多维度加总联合输出测评概述
				multiSumRelation=productDao.assessMultiSumRelationAllResult(qnId);
				//将两个方法返回的数据合并
				multiSumAll.addAll(multiSum);
				multiSumAll.addAll(multiSumRelation);
				//将合并后的数据保存到当前下标问卷的属性中
				list.get(i).setMultiSum(multiSumAll);
			}else if(qnCategory==2){
				//进入这里表示当前问卷是大五模型
				//创建List实例
				List<String> bigFive=new ArrayList<String>();
				//请求dao层方法获取当前问卷大五模型测评概述
				bigFive=productDao.assessBigFiveAllResult(qnId);
				//将返回的数据保存到当前问卷的属性中
				list.get(i).setBigFive(bigFive);
			}else if(qnCategory==3){
				//进入这里表示当前问卷的结果模型是MBTI模型
				//创建List实例
				List<String> MBTI=new ArrayList<String>();
				List<String> mbtiCombination=new ArrayList<String>();
				List<String> mbtiAll=new ArrayList<String>();
				//调用dao层方法取出当前问卷MBTI模型的输出结果概述
				MBTI=productDao.assessMBTIAllResult(qnId);
				//调用dao层方法取出当前问卷MBTI模型组合输出的结果概述
				mbtiCombination=productDao.assessMBTICombination(qnId);
				//将两个方法返回的数据合并到一起
				mbtiAll.addAll(MBTI);
				mbtiAll.addAll(mbtiCombination);
				//最后将合并的数据保存到当前问卷的属性中
				list.get(i).setMbti(mbtiAll);
			}
		}
		return list;
	}
	/**
	 * 查询第一个产品包的产品包id
	 */
	public int SelectLimit1Product(int channelId) {
		//直接调用dao
		return productDao.SelectLimit1Product(channelId);
	}
	/**
	 * 查询产品包的参加测试人数
	 * @param packageId:产品包id
	 * @return
	 */
	public Integer SelectAttendNum(int packageId) {
		//直接调用dao层
		return productDao.SelectAttendNum(packageId);
	}
	/**
	 * 更新产品包的参加测试人数
	 * @param score:参加测试人数
	 * @param packageId:产品包id
	 * @return
	 */
	public int UpDateAttendNum(int score, int packageId) {
		//直接调用dao层
		return productDao.UpDateAttendNum(score, packageId);
	}
	@Override
	public double PackagePrice(int packageId) {
		// 直接调用dao层
		return productDao.PackagePrice(packageId);
	}
	 
	
	
}
