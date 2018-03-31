package com.wy.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wy.test.dao.GoodInfo;
import com.wy.test.dao.GoodRequest;
import com.wy.test.dao.PageBaseRequest;
import com.wy.test.dao.UUIDBaseEntity;
import com.wy.test.dao.UpdateGood;
import com.wy.test.dao.UpdateGoodNum;

@Repository
public interface GoodMapper {

	int insert(GoodRequest goodRequest);

	GoodInfo selectOneById(UUIDBaseEntity refUUIDBaseEntity);

	int update(UpdateGood updateGood);

	int slectGoodNum();

	List<GoodInfo> serlectAllGoods(PageBaseRequest pageBaseRequest);

	int updateGoodNum(UpdateGoodNum updateGoodNum);

}
