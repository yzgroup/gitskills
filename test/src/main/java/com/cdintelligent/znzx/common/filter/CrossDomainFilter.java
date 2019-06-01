package com.cdintelligent.znzx.common.filter;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossDomainFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

//		HttpServletRequest httpRequest=(HttpServletRequest)request;
//		HttpServletResponse rep = (HttpServletResponse) response;
//		Object user = httpRequest.getSession().getAttribute("loginUser");
//		// 当前请求的路径
//		String url = String.valueOf(httpRequest.getRequestURL());
//
//		if (url.indexOf(".html") > -1) {
//			if(url.indexOf("login.html")>-1){
//				//标识跳转到登陆页面，不进行判断
//			}else if(null==user){
//				rep.sendRedirect(httpRequest.getContextPath() + "/login.html");
//			}
//		}

//		HttpServletRequest httpRequest = (HttpServletRequest)request;
//
//		String url = httpRequest.getRequestURI();
//
//		if(url.indexOf("/user/session") < 0 && url.indexOf("/user/login") < 0
//				&& !url.equals("/mcs/") && !url.equals("/")){
//			long sessionTimeout = httpRequest.getSession().getMaxInactiveInterval();
//			sessionTimeout = sessionTimeout * 1000 + (new Date()).getTime();
//			httpRequest.getSession().setAttribute(CommonConstant.SESSION_TIMEOUT, sessionTimeout);
//		}


        chain.doFilter(request, response);
    }

    @Override
    public void destroy()
    {
        // TODO Auto-generated method stub

    }

}
