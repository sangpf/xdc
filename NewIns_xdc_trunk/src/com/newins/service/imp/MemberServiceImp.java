package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.MemberDao;
import com.newins.model.Member;
import com.newins.model.PersonalProduct;
import com.newins.service.MemberService;

/**
 * 会员业务逻辑实现层
 * @author Zhangwenhao
 *
 */
@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	private MemberDao memberDao;
	/**
	 * 开通会员
	 */
	public int Membership(Member member) {
		//直接调用dao层
		return memberDao.Membership(member);
	}

	/**
	 * 是否为集体会员
	 */
	public int IsCollectiveMember(int schoolId) {
		//直接调用dao层
		return memberDao.IsCollectiveMember(schoolId);
	}

	/**
	 * 是否为个人会员
	 */
	public int IsPersonalMember(int userId) {
		//直接调用dao层
		return memberDao.IsPersonalMember(userId);
	}

	@Override
	public Integer getUserSchoolId(int userId) {
		//直接调用dao层
		return memberDao.getUserSchoolId(userId);
	}

	@Override
	public int insertFreePackage(PersonalProduct personalProduct) {
		//直接调用dao层
		return memberDao.insertFreePackage(personalProduct);
	}

	/**
	 * 查询用户是否已经拥有开通会员赠送的产品包
	 */
	public int isHaveFreePackage(int user, int packageId) {
		//直接调用dao层
		return memberDao.isHaveFreePackage(user, packageId);
	}

}
