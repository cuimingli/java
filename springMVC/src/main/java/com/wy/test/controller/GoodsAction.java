package com.wy.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wy.test.dao.GoodRequest;
import com.wy.test.dao.ObjectResponse;
import com.wy.test.dao.PageBaseRequest;
import com.wy.test.dao.PageCollectionResponse;
import com.wy.test.dao.ResponseConstants;
import com.wy.test.dao.UUIDBaseEntity;
import com.wy.test.dao.UpdateGood;
import com.wy.test.service.GoodService;

@Controller
@RequestMapping("/good")
public class GoodsAction {
	
   @Resource
   private GoodService goodService;
   
    @ResponseBody
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ObjectResponse addGood(@RequestBody GoodRequest goodRequest){
    	ObjectResponse response = new ObjectResponse();
	    goodService.add(goodRequest);
		response.data = ResponseConstants.SUCCESS;
		return response;
	}
   
    
    @ResponseBody
	@RequestMapping(value = "/get-info.do", method = RequestMethod.POST)
	public ObjectResponse getGoodInfo(@RequestBody UUIDBaseEntity refUUIDBaseEntity) {
		ObjectResponse response = new ObjectResponse();
	
		response.data = goodService.selectGoodInfo(refUUIDBaseEntity);
		return response;
	}
    
    
    @ResponseBody
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public ObjectResponse update(@RequestBody UpdateGood updateGood){
	    ObjectResponse response = new ObjectResponse();
	    goodService.update(updateGood);
		response.data = ResponseConstants.SUCCESS;
		return response;
	}
    
    @RequestMapping(value = "/get-all.do", method = RequestMethod.POST)
	@ResponseBody
	public PageCollectionResponse  getAllGoods(@RequestBody PageBaseRequest pageBaseRequest) {
    	PageCollectionResponse  response = new PageCollectionResponse ();
    	 response  = goodService.selectAllGood(pageBaseRequest);
		return response;
	}
   
}
