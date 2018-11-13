package com.newins.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.AdInfo;
import com.newins.model.BannerAdvert;
import com.newins.service.BannerAdService;
import com.newins.service.BlackListService;
import com.newins.service.NiAdStatisticsService;

/**@Description  Banner广告的controller,相应的Url为/wanx
 * @author MaNia_chAng
 * @time 2016年5月23日 下午2:27:34
 */

@Controller
@RequestMapping("/wanx")
public class BannerAdController {
	private static Logger log = Logger.getLogger(BannerAdController.class);
	@Autowired
	private BannerAdService bannerAdService;
	@Autowired
	private NiAdStatisticsService niAdStatisticsService;
	@Autowired
	private BlackListService blackListService;
	/**
	 * @Title: getBannerAd  
	 * @Author: MaNia_chAng
	 * @Description: 加载玩笑首屏底部广告，相应url为/wanx/botAd
	 * @return BotAdvert
	 * @Time 2016年5月23日 下午3:34:51
	 */
	@RequestMapping(value = "/bannerAd",method = RequestMethod.GET)
	@ResponseBody
	public BannerAdvert getBannerAd(HttpServletRequest request){
		String adPosStr = request.getParameter("adPos");
		int adPos= Integer.parseInt(adPosStr);
		String adPosCode = request.getParameter("adPosCode");
		BannerAdvert bannerAd = bannerAdService.getBannerAd(adPos);
		String adIdStr = bannerAd.getAdId();
		int adId = Integer.valueOf(adIdStr);
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("adId", adId);
		hashMap.put("adPosCode", adPosCode);
		try{
			niAdStatisticsService.updateAdStatistics(hashMap);
		}catch(Exception e){
			log.info("banner广告统计有误");
		}
		//获取session
		HttpSession session=request.getSession();
		//获取session中的schoolId
		Object wanxSchoolIdObj=session.getAttribute("schoolId");
		int wanxSchoolId=0;
		//判断session中的schoolId是否为null
		if(wanxSchoolIdObj!=null){
			//进入这里表示不是空的转为int类型
			wanxSchoolId=Integer.parseInt(wanxSchoolIdObj.toString());
		}
		//获取广告的adType属性
		int adType=bannerAd.getAdType();
		//获取当前广告的替代广告id属性
		int replaceAdId=bannerAd.getReplaceAdId();
		//初始化当前用户的学校是否为黑名单变量
		boolean temp=false;
		//创建广告信息实体类实例
		AdInfo adinfo=new AdInfo();
		//使用wanxSchoolId作为参数请求获取用户学校id方法
		Integer schoolId=blackListService.userSchoolId(wanxSchoolId);
		//判断学校id是否查询到了
		if(schoolId!=null){
			//进入这里表示查询到了当前用户的学校id继续操作
			//判断当前广告是否为商业广告
			if(adType==1){
				//进入这里表示当前的广告是商业广告
				//创建list实例
				List<Integer> blackList=new ArrayList<>();
				//调用获取学校黑名单方法
				blackList=blackListService.getSchoolBlackList();
				//获取黑名单list长度
				int listSize=blackList.size();
				//循环判断当前用户的学校是否为黑名单
				for(int i=0;i<listSize;i++){
					if(blackList.get(i)==Integer.parseInt(schoolId.toString())){
						//将变量设置为true
						temp=true;
			
						//结束循环
						break;
					}
				}
				//判断temp的值
				if(temp==true){
					//进入这里表示当前用户的学校在黑民单中
					//调用获取当前广告的替代广告id信息方法
					adinfo=blackListService.getReplaceAdInfo(replaceAdId);
					//判断替换广告信息是否有数据
					if(adinfo!=null){
						//将替代广告信息替换到当前广告信息中
						//替换adId属性
						bannerAd.setAdId(Integer.toString(adinfo.getAdId()));
						//替换广告图片地址
						bannerAd.setAdImg(adinfo.getAdImg());;
						//替换广告链接
						bannerAd.setAdLink(adinfo.getAdLink());
						//替换标题
						bannerAd.setAdTitle(adinfo.getAdTitle());
					}else{
						//替换adId属性
						bannerAd.setAdId("");
						//替换广告图片地址
						bannerAd.setAdImg("");;
						//替换广告链接
						bannerAd.setAdLink("");
						//替换标题
						bannerAd.setAdTitle("");
					}
				}
				//收工
			}
		}
		return bannerAd;
	}

}
