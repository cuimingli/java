package com.wy.test.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.wy.test.dao.BuyerItem;

public class BuyerCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BuyerItem> items = new ArrayList<BuyerItem>();

}
