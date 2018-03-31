package com.wy.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.test.dao.ObjectResponse;
import com.wy.test.dao.ResponseConstants;
import com.wy.test.dao.UserRequest;
import com.wy.test.service.UserService;
import com.wy.tests.util.UUIDUtils;

public class RegistServlet {
	
	@Resource
	private UserService userServcie;
	
	@RequestMapping(value="/createOrder.do", method = RequestMethod.POST)
 	@ResponseBody
    public ObjectResponse createOrder(HttpServletRequest request, @RequestBody UserRequest userRequest,HttpServletResponse response){
	     ObjectResponse resp = new ObjectResponse();
	  
	     resp.data = ResponseConstants.SUCCESS;
	     String code = UUIDUtils.getUUID();
	     userRequest.code = code;
	     userServcie.add(userRequest);
 		 return resp;
 	}
  

}
