package com.newins.dao;

import java.util.List;

import net.sf.json.JSONObject;

import com.newins.model.PackageList;
import com.newins.model.ProductColum;
import com.newins.model.ProductList;
import com.newins.model.ProductPageInfo;
import com.newins.model.Recommended;
import com.newins.model.UserPortrait;

/**
 * 产品包dao层
 * @author Zhangwenhao
 *
 */
public interface ProductDao {
	
	/**
	 * 获取产品包引导页信息
	 * @return
	 */
	ProductPageInfo getPageInfo(int productId);
	/**
	 * 获取产品包列表数据
	 * @return
	 */
	List<ProductList> getProductList(int channelId);
	/**
	 * 查询当前用户是否购买指定产品包了并且未到期(个人产品包)
	 * @param productId：产品包id
	 * @return
	 */
	int isBuyPersonalProduct(int userId,int packageId);
	/**
	 * 查询用户的学校是否购买了产品包并且未到期(集体产品包)
	 * @param schoolId:学校id
	 * @param packageId:产品包id
	 * @return
	 */
	int isBuySchoolProduct(int schoolId,int packageId);
	/**
	 * 获取产品包内容头部信息
	 * @return
	 */
	List<PackageList> getPackageHead(int packageId);
	/**
	 * 获取产品包内容推文列表
	 * @return
	 */
	List<PackageList> getPackageTweet(int packageId);
	/**
	 * 获取产品包内容测评问卷
	 * @param packageId:产品包id
	 * @return
	 */
	List<PackageList> getPackageAssess(int packageId);
	/**
	 * 获取产品包内容调查问卷
	 * @param packageId
	 * @return
	 */
	List<PackageList> getPackageSurvey(int packageId);
	/**
	 * 获取当前用户答过的指定投放的问卷结果概述
	 * @param deliveryId:投放id
	 * @param userId:用户id
	 * @return
	 */
	String getAssessResultSummary(int deliveryId,int userId);
	/**
	 * 根据问卷id获取简单测评模型问卷的全部结果概要
	 * @param qnId
	 * @return
	 */
	List getSimpleAllResult(int qnId);
	/**
	 * 获取指定投放关联的推荐秘籍
	 * @param delivery
	 * @return
	 */
	List<Recommended> getrecommendedList(int sourceId);
	/**
	 * 获取产品包内容页左侧入口的list
	 * @return
	 */
	List<ProductColum> getLeftColumList(int columId,int packageId);
	/**
	 * 获取产品包内容页右侧入口的list
	 * @return
	 */
	List<ProductColum> getRightColumList(int columId,int packageId);
	/**
	 * 判断当前用户是否答过当前测评问卷
	 * @param userId
	 * @param qnId
	 * @return
	 */
	int assessIsAnswered(int userId,int qnId);
	/**
	 * 判断当前用户是否答过当前调查问卷
	 * @param userId
	 * @param qnId
	 * @return
	 */
	int surveyIsAnswered(int userId,int qnId);
	/**
	 * 获取当前测评问卷的答题人数
	 * @return
	 */
	int assessAnsweredNum(int deliveryId,int qnId);
	/**
	 * 查询当前问卷是否有推荐秘籍
	 * @return
	 */
	int isRecommended(int source);
	/**
	 * 获取指定问卷的大五模型全部测评结果概述
	 * @param qnId
	 * @return
	 */
	List<String> assessBigFiveAllResult(int qnId);
	/**
	 * 获取指定问卷的多维度加总模型全部测评结果概述
	 * @param qnId
	 * @return
	 */
	List<String> assessMultiSumAllResult(int qnId);
	/**
	 * 获取指定问卷的MBTI模型全部测评结果概述
	 * @param qnId
	 * @return
	 */
	List<String> assessMBTIAllResult(int qnId);
	/**
	 * 获取指定问卷的多维加总联合输出全部测评结果概述
	 * @param qnId
	 * @return
	 */
	List<String> assessMultiSumRelationAllResult(int qnId);
	/**
	 * 获取指定问卷的MBTI组合输出全部测评结果概述
	 * @return
	 */
	List<String> assessMBTICombination(int qnId);
	/**
	 * 获取当前产品包的用户画像数据
	 * @param packageId
	 * @return
	 */
	List<UserPortrait> getUserPortrait(int packageId);
	/**
	 * 查询第一个产品包的产品包id
	 * @param channelId：渠道
	 * @return
	 */
	int SelectLimit1Product(int channelId);
	/**
	 * 查询产品包的参加测试人数
	 * @param packageId:产品包id
	 * @return
	 */
	Integer SelectAttendNum(int packageId);
	/**
	 * 更新产品包的参加测试人数
	 * @param score:参加测试人数
	 * @param packageId:产品包id
	 * @return
	 */
	int UpDateAttendNum(int score,int packageId);
	/**
	 * 获取产品包的价格
	 * @param packageId:产品包id
	 * @return
	 */
	double PackagePrice(int packageId);
}
