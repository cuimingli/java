package com.wy.tests.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Base64 {

	 /* public static String getBase64(String str){
	  	byte[] b = null;
	  	String result = null;
	  	try{
	  		b = str.getBytes("utf-8");
		}catch (UnsupportedEncodingException e){
	  		e.printStackTrace();
		}
		if(b != null){
	  		result = new BASE64Encoder().encode(b);
		}
		return result;
	  }*/
      public static String getBase64(String str){
      	byte[] b = null;
      	String result = null;
      	try{
      		b = str.getBytes("utf-8");
		}catch (IOException e){
      		e.printStackTrace();
		}
		if( b != null){
      		result = new BASE64Encoder().encode(b);
		}

		return result;
	  }



/*	public static String getFromBase64(String s){
		byte[] b = null;
		String result = null;
		if(s != null){
			BASE64Decoder decoder = new BASE64Decoder();
			try{
				b = decoder.decodeBuffer(s);
				result = new String(b,"utf-8");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}*/

    public static String getFromBase64(String s){
    	byte[] b = null;
    	String result = null;
    	if(s != null){
    		BASE64Decoder decoder = new BASE64Decoder();
    		try{
    			b = decoder.decodeBuffer(s);
    			result = new String(b,"utf-8");
			}catch (Exception e){
    			e.printStackTrace();
			}
		}
		return  result;
	}
}
