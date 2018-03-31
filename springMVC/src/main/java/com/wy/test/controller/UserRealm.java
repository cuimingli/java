package com.wy.test.controller;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

import com.wy.test.dao.UserResult;
import com.wy.test.service.UserService;
import com.wy.tests.util.WanYingAssert;


public class UserRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;
	
	// 设置realm的名称
	/*	@Override
		public void setName(String name) {
			super.setName("userRealm");
		}*/
	
	//验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		   UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		   String username = (String)token1.getPrincipal();   
		   UserResult userResult = userService.findByUserCode(username);
		   WanYingAssert.notNull( userService.findByUserCode(username), "100001", "用户不存在");  
		   return new SimpleAuthenticationInfo(userResult,userResult.passWord,this.getName());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
