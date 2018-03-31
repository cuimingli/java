package com.wy.test.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wy.test.dao.FileRequest;
import com.wy.test.dao.FileResult;

@Repository
public interface FileMapper {
   
	FileResult selectOneByHash(@Param("hash") String hash);

	int insert(FileRequest fileRequest);
}
