package com.newins.auth;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.newcapec.campus.oauth2.client.auth.Oauth;
import net.newcapec.campus.oauth2.client.exception.OpenCampusException;
import net.newcapec.campus.oauth2.client.model.AccessToken;
import net.newcapec.campus.oauth2.client.request.UserContext;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class OAuthTools {
	private static Logger log = Logger.getLogger(OAuthTools.class); 
	/**
	 * 請求三方平台
	 * @param request
	 * @param response
	 * @throws OpenCampusException 
	 */
	public static void sendRequest(HttpServletRequest request) throws OpenCampusException{
		CloseableHttpClient httpclient = HttpClients.createDefault();  
        try {
        	String authorizeURL = Oauth.getAuthorizeURL();
            // 创建httpGet    
            HttpGet httpget = new HttpGet(authorizeURL);  
            log.info("------------ executing request " + httpget.getURI());
            // 执行get请求.    
            CloseableHttpResponse htpresponse = httpclient.execute(httpget);  
            try {  
                // 获取响应实体    
                HttpEntity entity = htpresponse.getEntity();  
                log.info("--------------------------------------");
                // 打印响应状态    
                System.out.println(htpresponse.getStatusLine());  
                if (entity != null) {  
                    // 打印响应内容长度    
                    log.info("Response content length: " + entity.getContentLength());
                    // 打印响应内容    
                    log.info("Response content: " + EntityUtils.toString(entity));
                }  
                log.info("--------------------------------------");
            } finally {  
            	htpresponse.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
	}
	
	/**
	 * 獲取信息
	 * @param request
	 * @param resp
	 * @throws IOException
	 */
	public static void getMessage(HttpServletRequest request,HttpServletResponse resp) throws IOException{
		
		//先从session中获取 token 
		HttpSession session = request.getSession();
		AccessToken accessToken = (AccessToken) session.getAttribute("access_Token");
		//用户信息
		UserContext userContext = null;
		if(accessToken!=null){    //用户已经登录
			//在定义的50分钟之内,session与token均未失效,只要能够从session中获取token,则token可以使用
			userContext = new UserContext(accessToken.getAccessToken());
			
			
		}else{		 //新登录用户
			//当超出session定义的时间,session失效,存储的token也失效,未获取到token,则使用临时码code重新获取token
			//获取临时码code
			String code = request.getParameter("code");
			log.info("=====================>> temp code is: " + code);
			if ((code == null) || (code.trim().length() <= 0)) {
				resp.setContentType("text/plain; charset=utf-8");
				log.info("用户取消授权,请做相应处理。");
				return;
			}
			// 使用临时码 code 获取 accessToken用户临时授权令牌
			try {
				accessToken = Oauth.getAccessTokenByCode(code);
			} catch (OpenCampusException e) {
				e.printStackTrace();
			}
			if(accessToken!=null){
				log.info("============>>使用临时码获取新的 token为 :"+accessToken.getAccessToken());
			}
			
			//获取新的session
			HttpSession newSession = request.getSession();
			newSession.setAttribute("access_Token", accessToken);
			
			//获取用户信息
			userContext = new UserContext(accessToken.getAccessToken());
			
		}	
		if(userContext!=null){
			log.info("==============>>用户信息 :"+userContext.getUserInfo());
		}
	}
	
}
