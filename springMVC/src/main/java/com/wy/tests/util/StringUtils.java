package com.wy.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtils {

	private static final Log logger = LogFactory.getLog(StringUtils.class);
	
	@SuppressWarnings("null")
	public static String streamToMD5(InputStream refStream){
		String curRtn = null;
		if(refStream != null){
			DigestInputStream digestIputStream = null;
			int bufferSie = 262144;
			try{
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				digestIputStream = new DigestInputStream(refStream,messageDigest);
				byte[] buffer = new byte[bufferSie];
				while(digestIputStream.read(buffer)>0)
					;
				messageDigest = digestIputStream.getMessageDigest();
				byte[] resultByteArray = messageDigest.digest();
				curRtn = StringAndByteUtils.byteArrayToHex(resultByteArray);
				
			}catch(NoSuchAlgorithmException e){
				logger.error("本地加密方式错误");
				logger.error(e.getMessage());
				try{
					digestIputStream.close();
					digestIputStream = null;
				}catch(IOException e1){
					logger.error(e1.getMessage());
				}
			}catch(IOException e){
				logger.error(e.getMessage());
				try{
					digestIputStream.close();
					digestIputStream = null;
				}catch(IOException e2){
					logger.error(e2.getMessage());
				}
			}finally{
				try{
					digestIputStream.close();
					digestIputStream = null;
				}catch(IOException e){
					logger.error(e.getMessage());
				}
			}
			
		}
		return curRtn;
	}
}
