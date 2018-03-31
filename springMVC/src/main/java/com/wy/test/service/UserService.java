package com.wy.test.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.wy.test.dao.UserRequest;
import com.wy.test.dao.UserResult;
import com.wy.test.mapper.UserMapper;

@Service
@Validated
public class UserService {
	
	@Resource
	private UserMapper userMapper;

	public boolean add(UserRequest userRequest) {
		// TODO Auto-generated method stub
		String code = UUID.randomUUID().toString().replaceAll("-", "");
		userRequest.code = code;
		try{
			if(userMapper.insert(userRequest)>0){
				 return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public UserResult select(UserRequest userRequest) {
		
		return userMapper.select(userRequest);
	}
	
	
	

	public UserResult selectUserByname(String userName) {
		return userMapper.selectByName(userName);
	}

	public UserResult findByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserCode(userCode);
	}
  
}
