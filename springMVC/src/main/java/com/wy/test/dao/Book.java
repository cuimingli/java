package com.wy.test.dao;

public class Book {
    private String id;
    
    private String name;

	public Book(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Book(){
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	
}
