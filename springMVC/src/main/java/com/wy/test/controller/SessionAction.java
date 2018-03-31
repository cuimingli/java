package com.wy.test.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionAction {
	
	@ResponseBody
	@RequestMapping("/session.php")
	public void getSession(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF=8");
		response.setContentType("text/tml;charset = UTF-8");
		HttpSession session = request.getSession();
		//将数据存储到session中
		session.setAttribute("data", "孤傲产量");
		//获取session的Id
		String sessionId = session.getId();
		//判断session 是不是新创建的
		if(session.isNew()){
			response.getWriter().print("session创建成功，session的id是："+sessionId);
		}else{
			response.getWriter().print("服务器已存在该session了，session的id是:" + sessionId);
		}
	}

}
