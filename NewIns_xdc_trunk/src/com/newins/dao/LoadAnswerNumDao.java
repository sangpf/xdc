package com.newins.dao;
/**
 * 加载指定投放的答题人数数据库访问层
 * @author ZhangWenHao
 *
 */
public interface LoadAnswerNumDao {
	
	Integer ToDo(int deliveryId);
	
	int GetResultShowType(int aqnId);
}
