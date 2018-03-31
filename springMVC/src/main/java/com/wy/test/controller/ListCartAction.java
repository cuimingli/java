package com.wy.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wy.test.dao.Book;

public class ListCartAction {
	
	public void getCart(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
	   PrintWriter out = response.getWriter();
	   HttpSession session = request.getSession();
	   @SuppressWarnings("unchecked")
	   List<Book> list = (List<Book>) session.getAttribute("list");
	   if(list == null || list.size() == 0){
		   out.write("对不起你还没有购买任何商品");
		   return;
	   }
	   //显示用户买过的商品
	   out.println("你买过如下商品:<br/>");
	   for(Book book : list){
		   out.write(book.getName() + "<br/>");
	   }
	}

}
