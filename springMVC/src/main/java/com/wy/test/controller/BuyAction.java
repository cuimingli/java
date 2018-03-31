package com.wy.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wy.test.dao.Book;
import com.wy.test.dao.DB;

public class BuyAction {
	public void getBuy(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		Book book = DB.getAll().get(id);
		HttpSession session = request.getSession();
		List<Book> list = (List<Book>) session.getAttribute("list");
		if(list != null&& list.size() >0){
			list = new ArrayList<Book>();
			session.setAttribute("list", list);
		}
		list.add(book);
		String url = response.encodeRedirectURL(request.getContextPath() + "/servlet/ListCartServlet");
		System.out.println(url);
		response.sendRedirect(url);
	}

}
