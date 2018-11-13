package com.newins.model;

import org.springframework.stereotype.Component;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年5月23日 下午2:58:56
 */
@Component(value = "BotAdvert")
public class BannerAdvert {
	String adId, adPosDes,adLink,adImg,adTitle;
	int adType;
	int replaceAdId;

	public String getAdId() {
		return adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}

	public String getAdPosDes() {
		return adPosDes;
	}

	public void setAdPosDes(String adPosDes) {
		this.adPosDes = adPosDes;
	}

	public String getAdLink() {
		return adLink;
	}

	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}

	public String getAdImg() {
		return adImg;
	}

	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public int getAdType() {
		return adType;
	}

	public void setAdType(int adType) {
		this.adType = adType;
	}

	public int getReplaceAdId() {
		return replaceAdId;
	}

	public void setReplaceAdId(int replaceAdId) {
		this.replaceAdId = replaceAdId;
	}

	

	
}
