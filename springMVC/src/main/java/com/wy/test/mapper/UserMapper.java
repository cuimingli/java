package com.wy.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wy.test.dao.UserRequest;
import com.wy.test.dao.UserResult;

@Repository
public interface UserMapper {
    /**
     * 添加用户
     * @param userRequest
     * @return
     */
	int insert(UserRequest userRequest);

	UserResult select(UserRequest userRequest);

	UserResult selectByName(@Param("name") String name);

	UserResult selectByUserCode(@Param("userCode") String userCode);

}
