package com.newins.dao;

import com.newins.model.Member;
import com.newins.model.PersonalProduct;

/**
 * 会员dao层
 * @author Zhangwenhao
 *
 */
public interface MemberDao {
	/**
	 * 开通会员
	 * @return
	 */
	int Membership(Member member);
	/**
	 * 是否为集体会员
	 * @return
	 */
	int IsCollectiveMember(int schoolId);
	/**
	 * 是否为个人会员
	 * @return
	 */
	int IsPersonalMember(int userId);
	/**
	 * 获取当前用户的学校id
	 * @param userId
	 * @return
	 */
	Integer getUserSchoolId(int userId);
	/**
	 * 给用户添加第一个产品包
	 * @return
	 */
	int insertFreePackage(PersonalProduct personalProduct);
	/**
	 * 判断用户是否已拥有免费的产品包
	 * @param user
	 * @param packageId
	 * @return
	 */
	int isHaveFreePackage(int user,int packageId);
}
