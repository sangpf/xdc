package com.newins.model;


/**
 * @author lj
 * @Description : 广告统计model类
 * @time : 2016年7月28日 下午3:31:18
 */
public class NiAdStatistics {
	int adId,adChannel,adViewCount,adTapCount;
	String adPosCode,Comment;
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public int getAdChannel() {
		return adChannel;
	}
	public void setAdChannel(int adChannel) {
		this.adChannel = adChannel;
	}
	public int getAdViewCount() {
		return adViewCount;
	}
	public void setAdViewCount(int adViewCount) {
		this.adViewCount = adViewCount;
	}
	public int getAdTapCount() {
		return adTapCount;
	}
	public void setAdTapCount(int adTapCount) {
		this.adTapCount = adTapCount;
	}
	public String getAdPosCode() {
		return adPosCode;
	}
	public void setAdPosCode(String adPosCode) {
		this.adPosCode = adPosCode;
	}
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	@Override
	public String toString() {
		return "NiAdStatistics [adId=" + adId + ", adChannel=" + adChannel
				+ ", adViewCount=" + adViewCount + ", adTapCount=" + adTapCount
				+ ", adPosCode=" + adPosCode + ", Comment=" + Comment + "]";
	}
	
	
}
