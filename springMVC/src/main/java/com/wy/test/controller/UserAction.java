package com.wy.test.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.test.dao.Email;
import com.wy.test.dao.ObjectResponse;
import com.wy.test.dao.ResponseConstants;
import com.wy.test.dao.UserRequest;
import com.wy.test.service.UserService;
import com.wy.tests.util.MailUtils;
import com.wy.tests.util.RealSendMail;
import com.wy.tests.util.WanYingAssert;

@Controller
@RequestMapping("/user")
public class UserAction {
    
	@Resource
	private UserService userServcie;
	
	@ResponseBody
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ObjectResponse addUser(HttpServletRequest request, @RequestBody UserRequest userRequest){
	    WanYingAssert.isTrue(StringUtils.hasText(userRequest.username), "100001", "请输入用户名");
		/*WanYingAssert.isNull(userServcie.selectUserByname(userRequest.username), "100001", "用户名已存在");*/
	    WanYingAssert.isTrue(StringUtils.hasText(userRequest.password), "100001", "请输入密码");
		WanYingAssert.isTrue(StringUtils.hasText(userRequest.comfimPassword), "100001", "请输入确认密码");
		WanYingAssert.isTrue(userRequest.password.equals(userRequest.comfimPassword), "100001", "密码不一致");
		System.out.println("添加用户");
		ObjectResponse response = new ObjectResponse();
		userServcie.add(userRequest);
		response.data = ResponseConstants.SUCCESS;
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value="/select.do", method = RequestMethod.POST)
	public ObjectResponse selectUser(HttpServletRequest request,@RequestBody UserRequest userRequest){
		WanYingAssert.isTrue(StringUtils.hasText(userRequest.username), "100001", "请输入用户名");
		WanYingAssert.isTrue(StringUtils.hasText(userRequest.password), "100001", "请输入密码");
		WanYingAssert.notNull(userServcie.select(userRequest), "100001", "用户或密码错误");
		 request.getSession(true).setAttribute("user", userServcie.select(userRequest));
		ObjectResponse response = new ObjectResponse("/index.html");
		if(userServcie.select(userRequest) != null){
			response.data = "/view/addGood.html";
		}
		
		return response;
		
	}
	
    @ResponseBody	
	@RequestMapping(value="/send.do", method = RequestMethod.POST)
	public ObjectResponse sendEmai(@RequestBody Email email){
		ObjectResponse response = new ObjectResponse();
		RealSendMail.sendEmail(email.email);
		response.data = ResponseConstants.SUCCESS;
		return response;
	}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response
    		) throws IOException{
    	response.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset = UTF-8");
    	HttpSession session = request.getSession();
    	//将数据存储到session中
    	session.setAttribute("data", "孤独苍狼");
    	//获取sessionId
    	String seesionId = session.getId();
    	//判断session是不是型创建的
    	if(session.isNew()){
    		response.getWriter().print("session创建成功,session的Id是:"+seesionId);
    	}else{
    		response.getWriter().print("服务器已近存在该session了,session的Id是:"+seesionId);
    	}
	}

	
}
