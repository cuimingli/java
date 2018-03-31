package com.wy.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.wy.test.dao.CreateOrderRequst;
import com.wy.test.dao.GoodInfo;
import com.wy.test.dao.OrederResult;
import com.wy.test.dao.PageCollectionResponse;
import com.wy.test.dao.SelectOrderRequest;
import com.wy.test.dao.UUIDBaseEntity;
import com.wy.test.dao.UpdateGoodNum;
import com.wy.test.mapper.GoodMapper;
import com.wy.test.mapper.OrderMapper;
import com.wy.tests.util.WanYingAssert;

@Service
@Validated
public class OrderService {
	
   @Resource
   private OrderMapper orderMaper;
   
   @Resource
   private GoodMapper goodMapper;
   
   
   @Transactional(rollbackFor = Exception.class)
   public boolean createOrder(CreateOrderRequst createOrderRequst ,GoodInfo goodInfo) {
	try{
		if(orderMaper.createOrder(createOrderRequst)>0){
			 WanYingAssert.isTrue(goodMapper.updateGoodNum(new UpdateGoodNum(createOrderRequst.goodId,goodInfo.inventory -createOrderRequst.num ))>0,"100001", "订单创建失败");
			  return true;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	    return false;
    }

   public PageCollectionResponse selectAllOrder(SelectOrderRequest selectOrderRequest) {
		PageCollectionResponse response = new PageCollectionResponse();
		response.total = orderMaper.slectOrderNum(selectOrderRequest);
		if (response.total == 0 || (selectOrderRequest.pageIndex - 1)
				* selectOrderRequest.pageSize >= response.total) {
			return response;
		}
		
		List<OrederResult> GoodInfos = orderMaper.serlectAllOrder(selectOrderRequest);
		response.rows.addAll(GoodInfos);
		return response;
  }

     public boolean delete(UUIDBaseEntity refUUIDBaseEntity) {
	   try{
		   if(orderMaper.delete(refUUIDBaseEntity)>0){
			   return true;
		   }
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	  return false;
   }
}
