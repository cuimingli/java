package com.wy.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.wy.test.dao.GoodInfo;
import com.wy.test.dao.GoodRequest;
import com.wy.test.dao.PageBaseRequest;
import com.wy.test.dao.PageCollectionResponse;
import com.wy.test.dao.UUIDBaseEntity;
import com.wy.test.dao.UpdateGood;
import com.wy.test.dao.UpdateGoodNum;
import com.wy.test.mapper.GoodMapper;

@Service
@Validated
public class GoodService {
  @Resource
  private GoodMapper goodMapper;

  public boolean add(GoodRequest goodRequest) {
	  try{
		  if(goodMapper.insert(goodRequest)>0){
			  System.out.println(goodRequest.goodName);
			  return true;
		  }
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	 return false;
   }

    public GoodInfo selectGoodInfo(UUIDBaseEntity refUUIDBaseEntity) {
    	
	   return  goodMapper.selectOneById(refUUIDBaseEntity);
	   
    }

	public boolean update(UpdateGood updateGood) {
		try{
			if(goodMapper.update(updateGood) >0){
				return true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public PageCollectionResponse selectAllGood(PageBaseRequest pageBaseRequest) {
		PageCollectionResponse response = new PageCollectionResponse();
		response.total = goodMapper.slectGoodNum();
		if (response.total == 0 || (pageBaseRequest.pageIndex - 1)
				* pageBaseRequest.pageSize >= response.total) {
			return response;
		}
		
		List<GoodInfo> GoodInfos = goodMapper.serlectAllGoods(pageBaseRequest);
		response.rows.addAll(GoodInfos);
		return response;
		
	}
	
	public boolean updateGoodNum(UpdateGoodNum updateGoodNum){
		try{
			if(goodMapper.updateGoodNum(updateGoodNum)>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


}
