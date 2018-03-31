package com.wy.test.dao;

import java.io.Serializable;

public class ObjectResponse implements Serializable {
	private static final long serialVersionUID = 4491270647520549380L;

	public Object data;

	public ObjectResponse(Object object) {
		this.data = object;
	}

	public ObjectResponse() {
	}
}
