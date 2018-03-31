package com.wy.test.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;

@Controller
public class ProductTimerTask extends TimerTask{
	
	private ServletContext application;
	
	public void setAppliaction(ServletContext appliaction){
		this.application = appliaction;
	}

	@Override
	public void run() {
		System.out.println("--run--");
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		application.setAttribute("aaa", list);
		
		
	}

}
