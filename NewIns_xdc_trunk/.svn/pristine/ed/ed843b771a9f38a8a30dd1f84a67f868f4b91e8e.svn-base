package com.newins.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wanx")
public class XinLangWbController {
	private static Logger log = Logger.getLogger(XinLangWbController.class);
	
	/**
	 * 新浪微博授权回掉地址
	 * @param request
	 * @throws WeiboException
	 */
//	@RequestMapping("/XinLangWeiBoAuthCallBack")
//	public void callBack(HttpServletRequest request,HttpServletResponse response) throws WeiboException{
//		
//		HttpSession session = request.getSession();
//		
//		String code = request.getParameter("code");
//		log.info("===============>>新浪微博临时 code :"+code);
//		
//		Oauth oauth = new Oauth();
//		//根据 code 获取token 对象
//		AccessToken accessTokenByCode = oauth.getAccessTokenByCode(code);
//		
//		String accessToken = accessTokenByCode.getAccessToken();
//		//将token存入session
//		session.setAttribute("wbaccess_Token", accessToken);
//		
//		log.info("=============>> token " + accessToken);
//		
//		//根据 token 获取当前用户 id
//		
//		Users users = new Users(accessToken);
//		
//		String userIdByToken = users.getUserIdByToken();
//		
//		log.info("================>>当前登陆用户id:"+userIdByToken);
//		
//		User showUserById = users.showUserById(userIdByToken);
//		
//		log.info("=============>>用户信息:"+showUserById.toString());
//		
//		//跳转到首页
//		try {
//			response.sendRedirect("http://101.200.166.221:8080/wanxSite/index.html?version=1.3");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	/**
	 * 请求新浪三方授权接口
	 * @throws WeiboException
	 */
//	@RequestMapping("/XinLangWeiBoLogin")
//	public AjaxResult wbOauth(HttpServletRequest request) throws WeiboException{
//		AjaxResult ajaxResult = new AjaxResult();
//		//从session中获取token,判断用户是否已经登陆
//		HttpSession session = request.getSession();
//		
//		String accessToken = (String) session.getAttribute("wbaccess_Token");
//		
//		if(accessToken!=null){
//			//用户已经登陆
//			ajaxResult.put("loggedin", true);
//			
//		}else{
//			//用户未登陆
//			
//			Oauth oauth = new Oauth();
//			// 封装请求路径 
//			String url = oauth.authorize("code");
//			// 请求用户授权Token 
//			BareBonesBrowserLaunch.openURL(url);
//			
//			ajaxResult.put("loggedin", false);
//			ajaxResult.put("locationUrl", url);
//			
//		}
//		
//		return ajaxResult;
//	}
	
}
