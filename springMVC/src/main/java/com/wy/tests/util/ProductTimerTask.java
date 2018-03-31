package com.wy.tests.util;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;

import com.wy.test.dao.UserResult;

@Controller
public class ProductTimerTask extends TimerTask {
    
	private ServletContext appliaction;
	
	public void setApplication(ServletContext appliaction){
		this.appliaction = appliaction;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("aaaaaa");
		UserResult userResult = new UserResult();
		appliaction.setAttribute("aaa",userResult);
	}

}
