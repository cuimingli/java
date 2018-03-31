package com.wy.test.dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class CollectionResponse implements Serializable {
	private static final long serialVersionUID = -6843693623083999596L;

	public List<Object> rows;

	public CollectionResponse() {
		this.rows = new LinkedList<Object>();
	}
}
