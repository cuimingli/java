package com.wy.test.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.test.dao.CreateOrderRequst;
import com.wy.test.dao.GoodInfo;
import com.wy.test.dao.ObjectResponse;
import com.wy.test.dao.PageCollectionResponse;
import com.wy.test.dao.ResponseConstants;
import com.wy.test.dao.SelectOrderRequest;
import com.wy.test.dao.UUIDBaseEntity;
import com.wy.test.dao.UserResult;
import com.wy.test.service.GoodService;
import com.wy.test.service.OrderService;
import com.wy.tests.util.WanYingAssert;

@Controller
@RequestMapping("/order")
public class OrderAction {
	
  @Resource
  private OrderService orderService;
  
  @Resource
  private GoodService goodService;
  
    
 	@RequestMapping(value="/createOrder.do", method = RequestMethod.POST)
 	@ResponseBody
    public ObjectResponse createOrder(HttpServletRequest request, @RequestBody CreateOrderRequst createOrderRequst){
	     ObjectResponse response = new ObjectResponse();
	     UserResult userResult = (UserResult) request.getSession(true).getAttribute("user");
	     createOrderRequst.orderNo =  String.valueOf(System.currentTimeMillis());
	     GoodInfo goodInfo =  goodService.selectGoodInfo(new UUIDBaseEntity(createOrderRequst.goodId));
	     WanYingAssert.isZero(goodInfo.inventory, "100001", "该商品已售完");
	     WanYingAssert.isTrue(createOrderRequst.num<goodInfo.inventory, "100001", "改商品仅有" +goodInfo.inventory +"件");
	     createOrderRequst.totalPrice = goodInfo.price * createOrderRequst.num;
	     createOrderRequst.userId = userResult.id;
	     WanYingAssert.isTrue(orderService.createOrder(createOrderRequst,goodInfo),"100001", "订单创建失败");
	     response.data = ResponseConstants.SUCCESS;
 		 return response;
 	}
  
  
    @RequestMapping(value = "/get-all.do", method = RequestMethod.POST)
	@ResponseBody
	public PageCollectionResponse getAllOrders(HttpServletRequest request,@RequestBody SelectOrderRequest selectOrderRequest) {
	    PageCollectionResponse  response = new PageCollectionResponse ();
    	UserResult userResult = (UserResult) request.getSession(true).getAttribute("user");
    	selectOrderRequest.id = userResult.id;
    	 response  = orderService.selectAllOrder(selectOrderRequest);
    	 response.userName = userResult.userName;
		return response;
	}
    
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
   	@ResponseBody
   	public ObjectResponse delete(@RequestBody UUIDBaseEntity refUUIDBaseEntity) {
    	ObjectResponse response = new ObjectResponse();
        orderService.delete(refUUIDBaseEntity);
		response.data = ResponseConstants.SUCCESS;
		return response;
   		
   	}
    
    @ResponseBody
	@RequestMapping(value = "/getUser-info.do", method = RequestMethod.POST)
	public ObjectResponse getGoodInfo(HttpServletRequest request) {
		ObjectResponse response = new ObjectResponse();
	    response.data =  (UserResult) request.getSession(true).getAttribute("user");;
		return response;
	}
    
}
