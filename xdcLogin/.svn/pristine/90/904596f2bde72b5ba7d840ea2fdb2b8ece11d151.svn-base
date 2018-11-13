package cn.xdc.login.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.auth.Oauth;
import net.newcapec.campus.oauth2.client.exception.OpenCampusException;
import net.newcapec.campus.oauth2.client.model.AccessToken;
import net.newcapec.campus.oauth2.client.request.UserContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.xdc.common.util.StrUtils;
import cn.xdc.login.service.NiUserIdentiferService;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/login")
public class WanxLoginController {

	private static Logger log = Logger.getLogger(WanxLoginController.class);

	@Autowired
	private NiUserIdentiferService niUserIdentiferService;

	@RequestMapping("/test_session_add.do")
	public void test_session_add(HttpServletRequest request){
		
		log.info("------------------------>> 测试 session 接口 -----set---> ");
		
		HttpSession session = request.getSession();
		
		long currentTimeMillis = System.currentTimeMillis();
		
		session.setAttribute("wangfei", "王菲在唱歌"+currentTimeMillis);
	}
	
	@RequestMapping("/test_session_get.do")
	public String test_session_get(HttpServletRequest request,Model model){
		log.info("------------------------>> 测试 session 接口 -- get --->> ");
		
		HttpSession session = request.getSession();
		
		Object userName = session.getAttribute("wangfei");
		System.out.println("--------------------- "+userName);
		
		model.addAttribute("userName", userName);
		
		return "user";
	}
	
	/**
	 * 玩校平台回调地址
	 */
	@RequestMapping(value = "/wanxLogin_callback.do")
	public void getUserInfo(HttpServletRequest request, HttpServletResponse resp)
			throws OpenCampusException, IOException {
		
		log.info("------- 登录服务器 ---- 玩校  ----用户登录过程, 开始执行callback()方法...........-----------------");
		
		// long time0 = System.currentTimeMillis();
		AccessToken accessToken = null;
		UserContext userContext = null;
		// 获取临时码code
		String code = request.getParameter("code");
		String flag = request.getParameter("flag"); // 1 首页 , 2,问卷页
		String contentUrl = request.getParameter("contentUrl"); // 问卷内容页地址
		String deliveryId = request.getParameter("deliveryId"); // 投放id
		String id = request.getParameter("id");

		// long time1 = System.currentTimeMillis();
		// log.info("----从HttpServletRequest请求中获取code临时码等参数需要时间:"+(time1-time0));

		log.info("=====================>> 获取临时码  : " + code);
		if ((code == null) || (code.trim().length() <= 0)) {
			resp.setContentType("text/plain; charset=utf-8");
			log.info("用户取消授权,请做相应处理。");
		}
		// 使用临时码 code 获取 accessToken用户临时授权令牌
		 try {
			 accessToken = Oauth.getAccessTokenByCode(code);
		 } catch (OpenCampusException e) {
			 e.printStackTrace();
		 }

		// long time2 = System.currentTimeMillis();
		// log.info("----通过临时码code获取AccessToken 对象 需要时间:"+(time2-time1));

		// 获取session
		HttpSession newSession = request.getSession(true);
		
		// 测试 session
		Object attribute = newSession.getAttribute("wangfei");
		System.out.println("------测试 session 获取 , 登录服务器 --------- ------ "+attribute);
		
		
		if (accessToken != null) {
			String accessTokenStr = accessToken.getAccessToken();
			log.info("=====================>>获取access_Token  放入 session 中 : "
					+ accessTokenStr);
			newSession.setAttribute("access_Token", accessTokenStr);
			// 获取用户信息
			userContext = new UserContext(accessTokenStr);
		}

		// long time3 = System.currentTimeMillis();
		// log.info("----通过AccessToken对象获取用户信息对象UserContext 需要时间:"+(time3-time2));

		Integer user_id = null;
		if (userContext != null) {
			// 调用base接口
			String userInfo = userContext.getUserInfo();

			JSONObject parseObject = JSONObject.parseObject(userInfo);

			Object headimg = "";
			Object cityId = "";
			if (parseObject != null) {
				headimg = parseObject.get("headimg").toString();
				cityId = parseObject.get("city_id");
			}
			newSession.setAttribute("headimg", headimg);
			newSession.setAttribute("cityId", cityId);
			
			// 调用super接口
			String detailUserInfo = userContext.getDetailUserInfo();

			// long time4 = System.currentTimeMillis();
			// log.info("----通过用户信息对象UserContext调用super接口获取用户detailUserInfo信息 需要时间:"+(time4-time3));

			// 调用senior接口
			// String userSenior = userContext.getUserSenior();

			JSONObject fromObject = JSONObject.parseObject(detailUserInfo);

			if (fromObject.toString().contains("errorCode")) {
				log.info("==============>>当前登录的用户,我们没有权限获取详细信息,所以无法获取用户的 userid");
			} else {
				// 拿到玩校userId,到新洞察数据库进行匹配
				long time5 = System.currentTimeMillis();

				// -------------------------- 更新用户信息  在这里 ---------------------------
				user_id = niUserIdentiferService.mapUser(detailUserInfo,
						userContext, newSession, request);
				// -------------------------- 更新用户信息  在这里 ---------------------------

				long time6 = System.currentTimeMillis();
				log.info("----通过用户detailUserInfo信息 匹配新洞察数据库更新用户标识信息表,基础信息表,在线教育信息表,教育背景表 需要时间:"
						+ (time6 - time5));

				newSession.setAttribute("detailUserInfo", detailUserInfo);

			}
		}
		// 读取配置文件,获取重定向到首页的地址
		Properties properties = new Properties();
		InputStream in = getClass().getResourceAsStream("/wx-config.properties");
		
		properties.load(in);
		// 首页地址
		String callbackUrl = properties.getProperty("wanxSiteindexUrl").trim();
		
		log.info("------------------玩校回调地址接口, 更新用户信息后,重定向到的首页地址为 : "+callbackUrl);

		// 判断flag标记, 如果是2,测重定向到问卷内容页
		if (StrUtils.isNotEmpty(deliveryId) && StrUtils.isNotEmpty(id)) {

			if (StrUtils.isNotEmpty(flag)) {
				if (flag.trim().equals("2")) {
					// 最初的页面地址为
					// http://101.200.169.159:8080/wanxSite/survey_content.html?id=1621280926&deliveryId=407
					// 需要拼接&后的deliveryId=407
					// resp.sendRedirect(contentUrl+"&deliveryId="+deliveryId);
					// 目前页面地址为
					// http://101.200.169.159:8080/wanxSite/survey_content.html?version=1.5&id=1621280926&deliveryId=407
					// 多了一个参数, 参数之间有&符合的话, 返回的contentUrl将不包含&后的参数内容, 所以需要手动拼接
					// &id=1621280926&deliveryId=407
					resp.sendRedirect(contentUrl + "&id=" + id + "&deliveryId="
							+ deliveryId);
					return;
				}
			}

		} else {
			log.info("老接口,跳转到首页");
		}
		
		
		String accessToken_test = (String) newSession.getAttribute("access_Token");
		Object userId_test = newSession.getAttribute("userId");
		
		System.out.println("--------------登录服务器---从 session中获取 数据  , accessToken_test : "+accessToken_test+"... userId_test : "+userId_test);

		resp.sendRedirect(callbackUrl + "?userId=" + user_id);
		
	}

}
