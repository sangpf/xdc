package com.newins.model;
/**
 * 产品列表实体类
 * @author Zhang
 *
 */
public class ProductList {
	private int id;//产品包的序列id
	private String unlockpic;//产品包列表未解锁状态图片
	private String unlockedpic;//产品包列表解锁状态图片
	private String pendingOpenPic;//等待开放状态下显示的图片
	private double discount;//产品包的优惠价格
	private int userState;//用户是否购买了产品包
	private int packState;//当前产品包的状态:上架还是待上架
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnlockpic() {
		return unlockpic;
	}
	public void setUnlockpic(String unlockpic) {
		this.unlockpic = unlockpic;
	}
	public String getUnlockedpic() {
		return unlockedpic;
	}
	public void setUnlockedpic(String unlockedpic) {
		this.unlockedpic = unlockedpic;
	}
	
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getPackState() {
		return packState;
	}
	public void setPackState(int packState) {
		this.packState = packState;
	}
	
	public String getPendingOpenPic() {
		return pendingOpenPic;
	}
	public void setPendingOpenPic(String pendingOpenPic) {
		this.pendingOpenPic = pendingOpenPic;
	}
	
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	/**
	 * 空参构造
	 */
	public ProductList() {
		super();
	}
	
}
