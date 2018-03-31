package com.wy.tests.util;

import java.util.Timer;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wy.test.service.UserService;

public class InitServletContextListener implements ServletContextListener {
	
	@Resource
	private ProductTimerTask productTimerTask;

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		//得到Service的实例对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		UserService userService = (UserService) ac.getBean("userService");
		// TODO Auto-generated method stub
		//通过设置定时器，每个一段时间同步一次
		productTimerTask.setApplication(sce.getServletContext());
		new Timer(true).schedule(productTimerTask, 0, 2000);
		
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
