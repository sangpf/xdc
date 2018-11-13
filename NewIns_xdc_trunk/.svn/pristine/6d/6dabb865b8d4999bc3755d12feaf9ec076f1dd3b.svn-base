package com.newins.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.AdInfo;
import com.newins.model.Carousel;
import com.newins.model.MyModel;
import com.newins.service.BlackListService;
import com.newins.service.CarouselService;
import com.newins.service.LogPersonalInfoService;
import com.newins.service.NiAdStatisticsService;

//该controller负责响应url中包含/wanx的url
@Controller
@RequestMapping("/wanx")
public class CarouselController {
	// 日志
	private static Logger log = Logger.getLogger(CarouselController.class);
	private static final Logger login = Logger.getLogger("login");
	// 这是一个返回json的简单例子,响应的url请求格式为/NewIns/test/hello2
	@Autowired
	@Qualifier("MyModel")
	private MyModel mmData;
	@Autowired
	private CarouselService cs;
	@Autowired
	private NiAdStatisticsService niAdStatisticService;
	@Autowired
	private LogPersonalInfoService logPersonalInfoService;
	@Autowired
	private BlackListService blackListService;
	// 这是一个接收前端的简单例子,响应的url请求格式为/NewIns/test/submit
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@ResponseBody
	public boolean submit(HttpServletRequest request) {
		String id = request.getParameter("id").trim();
		String str1 = request.getParameter("str1").trim();
		String str2 = request.getParameter("str2").trim();
		// System.out.println(id + "  " + str1 + "  " + str2);
		log.info(id + "  " + str1 + "  " + str2);
		// System.out.println("this is submit controller");
		log.info("this is submit controller");

		mmData.setStr1(str1);
		mmData.setStr2(str2);
		// ms.submitService(mmData);
		return true;
	}

	// 加载玩校轮播图信息
	@RequestMapping(value = "/carousel", method = RequestMethod.GET)
	@ResponseBody
	public List<Carousel> getCarouselInfo(HttpServletRequest request,
			HttpServletResponse response) {
		log.info("this is controller: getCarouselInfo()");
		//从前端接口渠道号参数
		int channelId=Integer.parseInt(request.getParameter("channelId"));
		//调用service层，将渠道号作为参数
		List<Carousel> carouselList = cs.getCarousel(channelId);
		
		// 判断是否查询 轮播图
		log.info("==========================>>从数据库中查询 , 加载轮播图数据内容如下");
		if(carouselList != null && carouselList.size()>0){
			Iterator<Carousel> iterator = carouselList.iterator();
			while(iterator.hasNext()){
				Carousel next = iterator.next();
				
				log.info(next.toString());
			}
			
		}else{
			log.info("------------------->> 未查询到轮播图 !");
		}
		
		//System.out.println("进入1");
		List<Integer> carouselAdIdList = new ArrayList<Integer>();
		List<JSONObject> carouselPosObjectList= new ArrayList<JSONObject>();
		//将轮播位置存入List
		List<String> carouselPosList = new ArrayList<String>();
		carouselPosList.add("wanx_c1");
		carouselPosList.add("wanx_c2");
		carouselPosList.add("wanx_c3");
		carouselPosList.add("wanx_c4");
		
		for (int i = 0; i < carouselList.size(); i++) {
			int carouselAdId = carouselList.get(i).getAdId();
			carouselAdIdList.add(carouselAdId);//将轮播图Id存入list
		}
		//System.out.println("进入2");
		for(int j=0;j<carouselAdIdList.size();j++){
/*			HashMap<String, Object> carouselMap = new HashMap<String, Object>();
			carouselMap.put("adId", carouselAdIdList.get(j));
			carouselMap.put("adPosCode",carouselPosList.get(j));
			carouselPosMapList.add(carouselMap);	*/	
			JSONObject carouselJson = new JSONObject();
			carouselJson.put("adId", carouselAdIdList.get(j));
			carouselJson.put("adPosCode",carouselPosList.get(j));
			carouselPosObjectList.add(carouselJson);
		}
		//System.out.println("进入3");
		try {
			niAdStatisticService.updateCarouselStatistics(carouselPosObjectList);
		} catch (Exception e) {
			log.info("====================>>轮播图加载统计有误");
			System.out.println("进入4");
			System.out.print(e);
		}
		//System.out.println("进入5");
		//获取session
		HttpSession session=request.getSession();
		System.out.println("开始过滤学校黑名单广告");
		//获取session中的schoolId
		Object wanxSchoolId=session.getAttribute("schoolId");
		int newWanxSchoolId=0;
		if(wanxSchoolId!=null){
			newWanxSchoolId=Integer.parseInt(wanxSchoolId.toString());
		}
		log.info("首页轮播图广告黑名单过滤===========================");
		log.info("该用户完美校园学校id是:"+wanxSchoolId);
		//调用查询当前用户的学校id方法
		Integer schoolId=blackListService.userSchoolId(newWanxSchoolId);
		log.info("心发现学校字典表对应的学校id是:"+schoolId);
		//判断当前用户的学校id是否为null
		if(schoolId!=null){
			//进入这里表示当前用户的学校id查询到了，继续操作
			//循环操作数据
			for(int i=0;i<carouselList.size();i++){
				//取出当前下标的广告类型属性
				int adType=carouselList.get(i).getAdType();
				int num=i+1;
				//判断当前广告是否是商业广告
				if(adType==1){
					log.info("==第"+num+"个广告为商业广告==");
					//进入这里说明当前广告是商业广告，继续操作
					//取出当前下标广告的替换广告id属性
					int replaceAdId=carouselList.get(i).getReplaceAdId();
					//创建list实例
					List<Integer> blacklist=new ArrayList<>();
					//调用查询学校黑名单方法
					blacklist=blackListService.getSchoolBlackList();
					//循环对比当前用户的学校是否在黑名单中
					System.out.println("--用户学校id是:"+schoolId+"--");
					boolean temp=false;
					System.out.println("黑名单list的长度是:"+blacklist.size());
					for(int j=0;j<blacklist.size();j++){
						//判断当前下标的学校id是否与用户的学校id一致
						if(blacklist.get(j)==Integer.parseInt(schoolId.toString())){
							//进入这里表示相等,将temp变量设置为true
							temp=true;
							//退出循环
							break;
						}
						
					}
					//判断temp的值
					if(temp==true){
						log.info("--当前用户的学校id存在黑名单中--");
						//进入这里表示当前用户的学校在黑名单中
						//创建实体类对象
						AdInfo adinfo=new AdInfo();
						//使用替换广告id作为参数调用查询替换广告信息方法
						adinfo=blackListService.getReplaceAdInfo(replaceAdId);
						//判断替换广告是否为空
						if(adinfo!=null){
							log.info("替换的广告信息是:"+adinfo.toString());
							//进入这里表示不为空
							//再将查询到的数据替换到当前的广告属性中
							//设置广告id
							carouselList.get(i).setAdId(adinfo.getAdId());
							//设置图片地址
							carouselList.get(i).setAdImg(adinfo.getAdImg());
							//设置广告链接地址
							carouselList.get(i).setAdLink(adinfo.getAdLink());
							//设置广告标题
							carouselList.get(i).setAdTitle(adinfo.getAdTitle());
						}else{
							//进入这里表示为空
							//设置广告id
							carouselList.get(i).setAdId(0);
							//设置图片地址
							carouselList.get(i).setAdImg("");
							//设置广告链接地址
							carouselList.get(i).setAdLink("");
							//设置广告标题
							carouselList.get(i).setAdTitle("");
						}
					}else{
						log.info("当前用户的学校不存在黑名单中");
					}
				}
				log.info("第"+num+"个不是商业广告");
			}
		}else{
			//进入这里表示当前用户的学校id未查询到，不做操作
			//不做任何操作
			log.info("--未查询到当前用户shcoolId无需过滤黑名单--");
		}
		
		log.info("==========================>>加载轮播图, 返回给前端数据内容如下");
		if(carouselList != null && carouselList.size()>0){
			Iterator<Carousel> iterator = carouselList.iterator();
			while(iterator.hasNext()){
				Carousel next = iterator.next();
				
				log.info(next.toString());
			}
			
		}else{
			log.info("------------------->> 没有轮播图 !");
		}
		
		return carouselList;
	}


}
