package com.wy.test.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.wy.test.service.CartService;

public class InitDataListener implements ServletContextListener {
	
	private ApplicationContext context;
	
	private ProductTimerTask productTimerTask;
	
	
	
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	/*ApplicationContext context = (ApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	cartService = (CartService) context.getBean("cartService");
	System.out.println("cartService:" + cartService);*/
		
		//3.解决方案3:通过工具类加载即可
		context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");
		//把内置对象交给 productTimerTask
		productTimerTask.setAppliaction(event.getServletContext());
		//通过设置定时器,让首页的时间每隔一小时同步一次(要配置为守护线程)
		new Timer(true).schedule(productTimerTask, 0, 2000);
		
	}

}
