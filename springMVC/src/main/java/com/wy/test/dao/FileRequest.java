package com.wy.test.dao;

public class FileRequest {
  
	public String name;
	/** */
	public String hash;
	/** */
	public String suffix;
	
	public FileRequest(String name, String hash, String suffix) {
		super();
		this.name = name;
		this.hash = hash;
		this.suffix = suffix;
	}

	public FileRequest() {
		super();
	}
	
}
