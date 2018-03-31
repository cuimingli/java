package com.wy.tests.util;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestUtils {
	//获取CSessionID
	public static String getCSessionId(HttpServletRequest request,HttpServletResponse response){
		//1.从request中取Cookie
		Cookie[] cookies = request.getCookies();
		//2.从cookies数据中遍历查询，并取得CSessionID
		if(cookies != null && cookies.length >0){
			for(Cookie cookie : cookies){
				if("CSESSIONID".equals(cookie.getName())){
					//有 直接返回
					return cookie.getValue();
				}
			}
		}
		
		//没有则再会创建一个CSESSIONID,则会在创建一个 ，放在cookie里在返回浏览器，返回新CSessionID
		String cessionid = UUID.randomUUID().toString().replaceAll("-", "");
		//并且放到cookie
		Cookie cookie = new Cookie("CESSIONID",cessionid);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		return cessionid;
		
	}
	

}
