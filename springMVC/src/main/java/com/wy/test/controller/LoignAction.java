package com.wy.test.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.test.dao.ObjectResponse;

@Controller
public class LoignAction {

	   @ResponseBody
	   @RequestMapping(value = "/login.aspx" , method = RequestMethod.POST)  
	    public ObjectResponse showLoginForm(HttpServletRequest request) throws Exception {  
		    ObjectResponse response = new ObjectResponse();
	         try{
	        	String username = request.getParameter("username");
	      	    String password = request.getParameter("password");
	        	 UsernamePasswordToken token = new UsernamePasswordToken(username,password);
	        	 Subject currentUser = 	SecurityUtils.getSubject();
	        	 if(!currentUser.isAuthenticated()){
	        		 //使用shrio 来验证
	        		 token.setRememberMe(false);
	        		 currentUser.login(token);//验证角色和权限
	        	 }
	        	 
	        	 
	         }catch(Exception ex){
	        	 com.wy.tests.util.WanYingAssert.isTrue(false, "账号或密码错误");
	             com.wy.tests.util.WanYingAssert.throwErrorMessage(ex);
	    			
	         }
	         response.data =  "/view/addGood.html";
	         return response;  
	    }  
	  
	  
	  /* @RequestMapping("logout.aspx")
	    	public String loginOut(HttpServletResponse response,
				@CookieValue(value = "access_token", required = false) String fooCookie) {
			 SecurityUtils.getSubject().logout();
			if (!StringUtils.isEmpty(fooCookie)) {
				Cookie cookie = new Cookie("access_token", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "redirect:login.aspx";
		}*/
	   
	   @RequestMapping("logout.aspx")
	   public String loginOut(HttpServletResponse response,
			   @CookieValue(value = "access_token",required = false) String fooCookie){
		   SecurityUtils.getSubject().logout();
		   if(!StringUtils.isEmpty(fooCookie)){
			   Cookie cookie = new Cookie("access_token",null);
			   cookie.setMaxAge(0);
			   response.addCookie(cookie);
		   }
		   return "redirect:index.html";
	   }
	   
	   
	  
}
