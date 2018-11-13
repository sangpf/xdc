package com.newins.model;
/**
 * 产品包引导页实体类
 * @author Zhang
 *
 */
public class ProductPageInfo {
	private String picurl;//置顶头图
	private String title;//标题
	private String subtitle;//副标题
	private double price;//原价
	private double discount;//优惠价格
	private String tag1;//标签1
	private String tag2;//标签2
	private String tag3;//标签3
	private String introduce;//产品介绍
	private int attendNum;//参加测试人数
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	public String getTag3() {
		return tag3;
	}
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	public int getAttendNum() {
		return attendNum;
	}
	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}
	/**
	 * 全参构造
	 * @param picurl
	 * @param title
	 * @param subtitle
	 * @param price
	 * @param discount
	 * @param tag1
	 * @param tag2
	 * @param tag3
	 * @param introduce
	 */
	public ProductPageInfo(String picurl, String title, String subtitle,
			double price, double discount, String tag1, String tag2,
			String tag3, String introduce) {
		super();
		this.picurl = picurl;
		this.title = title;
		this.subtitle = subtitle;
		this.price = price;
		this.discount = discount;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.introduce = introduce;
	}
	
	/**
	 * 空参构造
	 */
	public ProductPageInfo() {
		super();
	}
	
}
