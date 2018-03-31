package com.wy.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.wy.test.controller.BuyerCart;
import com.wy.test.dao.BuyerItem;

@Service
@Validated
public class CartService {

	
/*	//保存购物车到Redis
	public void insertBuyerCartToRedis(BuyerCart buyerCart,String name){
		List<BuyerItem> items = buyerCart.getItems();
		if(items.size() >0){
			Map<String,String> hash = new HashMap<String,String>();
			for(BuyerItem item : items){
				//判断是否有同款
				
				
				
			}
			
		}
	}*/
}
