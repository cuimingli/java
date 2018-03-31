package com.wy.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.wy.test.dao.Book;
import com.wy.test.dao.DB;

@Controller
public class IndexAction {
	
	public void getSession(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset = UTF-8");
		PrintWriter out = response.getWriter();
		request.getSession();
		out.write("本网站有如下书:<br/>");
		Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
		for(Map.Entry<String, Book> me :set){
			Book book = me.getValue();
			String url = request.getContextPath() + "/servlet/BuyServlet?id = " + book.getId();
			url = response.encodeUrl(url);
			out.println(book.getName() + "<a href = '"+url+"'></a><br/>");
		}
		
	}

}
