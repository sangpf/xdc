package com.newins.dao;
/**
 * 检查当前用户是否是临时用户数据库操作层
 * @author ZhangWenHao
 *
 */
public interface CheckUserIdTemporaryDao {
	
	/**
	 * 检查用户类型
	 * @param userId
	 * @return
	 */
	String checkUserType(int userId);
	
	/**
	 * 获取问卷的结果页显示类型
	 * @param qnId
	 * @return
	 */
	int getResultShowType(int qnId);
	
	/**
	 * 获取用户昵称
	 * @param userId
	 * @return
	 */
	String getNickName(int userId);
}
