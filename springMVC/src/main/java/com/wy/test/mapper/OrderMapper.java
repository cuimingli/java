package com.wy.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wy.test.dao.CreateOrderRequst;
import com.wy.test.dao.OrederResult;
import com.wy.test.dao.SelectOrderRequest;
import com.wy.test.dao.UUIDBaseEntity;

@Repository
public interface OrderMapper {

	int createOrder(CreateOrderRequst createOrderRequst);

	int slectOrderNum(SelectOrderRequest selectOrderRequest);

	List<OrederResult> serlectAllOrder(SelectOrderRequest selectOrderRequest);

	int delete(UUIDBaseEntity refUUIDBaseEntity);

}
