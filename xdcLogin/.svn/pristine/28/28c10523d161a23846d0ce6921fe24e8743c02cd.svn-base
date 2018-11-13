package cn.xdc.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CustomInterceptor1 ： 页面渲染之后");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("CustomInterceptor1 ： Handler之后");
		
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//去登陆页面  /login.do  不拦截
		//http://localhost:8080/sfdsafsa.do
		///sfdsfsdfs.do
		String requestURI = request.getRequestURI();
		if(requestURI.indexOf("login") != -1){
			//放行
			return true;
		}else{
			//判断用户是否已经登陆
			Object username = request.getSession().getAttribute("USER_NAME");
			if(null != username){
				return true;
			}else{
				//重定向到登陆页面
				response.sendRedirect(request.getContextPath() +  "/item/login.do");
				return false;
			}
		}
		
		
	}

}
