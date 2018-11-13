
package com.newins.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.BannerAdDao;
import com.newins.model.BannerAdvert;
import com.newins.service.BannerAdService;

/**@Description  底部广告的Service
 * @author MaNia_chAng
 * @time 2016年5月23日 下午2:40:16
 */

@Service
public class BannerAdServiceImp implements BannerAdService{

	@Autowired
	private BannerAdDao bannerAdDao;
	/**
	 * 	@Title: getBotAd  
	 * @Author: MaNia_chAng
	 * @Description: 加载玩笑首屏底部广告Service
	 * @return BotAdvert
	 * @Time 2016年5月23日 下午3:37:13
	 */
/*	public BotAdvert getBotAd(){
		System.out.println("This is Servie:getBotAd()");
		return botAdDao.getBotAd();
		
	}*/

	@Override
	public BannerAdvert getBannerAd(int adPos) {
		BannerAdvert bannerAd = bannerAdDao.getBannerAd(adPos);
		return bannerAd;
	}

}
