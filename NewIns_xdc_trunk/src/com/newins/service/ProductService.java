package com.newins.service;
import java.util.List;

import net.sf.json.JSONObject;

import com.newins.model.PackageList;
import com.newins.model.ProductColum;
import com.newins.model.ProductList;
/**
 * 产品包业务逻辑层
 */
import com.newins.model.ProductPageInfo;
import com.newins.model.Recommended;
import com.newins.model.UserPortrait;

public interface ProductService {
	/**
	 * 获取产品包引导页信息
	 * @return
	 */
	ProductPageInfo getPageInfo(int productId);
	/**
	 * 获取产品包列表数据
	 * channelId:渠道id
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
	 * 查询用户的学习是否购买了产品包并且未到期(集体产品包)
	 * @param schoolId
	 * @param packageId
	 * @return
	 */
	int isBuySchoolProduct(int schoolId,int packageId);
	/**
	 * 获取产品包内容list
	 * @return
	 */
	JSONObject PackageContentList(int packageId,int userId);
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
	 * 获取指定投放关联的推荐秘籍
	 * @param delivery
	 * @return
	 */
	List<Recommended> getrecommendedList(int sourceId);
	/**
	 * 获取当前测评问卷的答题人数
	 * @return
	 */
	int assessAnsweredNum(int deliveryId,int qnId);
	/**
	 * 获取当前产品包的用户画像数据
	 * @param packageId
	 * @return
	 */
	List<UserPortrait> getUserPortrait(int userId,int packageId);
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
