package com.wy.test.dao;

public class SelectOrderRequest extends PageBaseRequest{
    public int id;

	public SelectOrderRequest(int id) {
		super();
		this.id = id;
	}

	public SelectOrderRequest() {
		super();
	}
    
}
