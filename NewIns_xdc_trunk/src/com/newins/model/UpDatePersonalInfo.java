package com.newins.model;
/**
 * 更新用户信息用实体类
 * @author zhangwenhao
 *
 */
public class UpDatePersonalInfo {
	private int userId;//用户Id
	private String keyString;//修改的字段
	private Object valueString;//修改的列名对应的值
	//封装属性
	/**
	 * 空参构造
	 */
	public UpDatePersonalInfo() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	public Object getValueString() {
		return valueString;
	}
	public void setValueString(Object valueString) {
		this.valueString = valueString;
	}
	public UpDatePersonalInfo(int userId, String keyString, Object valueString) {
		super();
		this.userId = userId;
		this.keyString = keyString;
		this.valueString = valueString;
	}
	
}
