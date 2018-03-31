package com.wy.tests.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utils {

	private static final Log logger = LogFactory.getLog(Utils.class);
	
	@SuppressWarnings("null")
	public static String streamToMD5(InputStream refStream){
		String curRtn = null;
		if(refStream != null){
			DigestInputStream digestInputStream = null;
			int bufferSize = 262144;
			try{
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				digestInputStream = new DigestInputStream(refStream,messageDigest);
				byte[] buffer = new byte[bufferSize];
				while(digestInputStream.read(buffer)>0)
					;
				messageDigest = digestInputStream.getMessageDigest();
				byte[] resultByteArray = messageDigest.digest();
				curRtn = StringAndByteUtils.byteArrayToHex(resultByteArray);
				
			}catch(NoSuchAlgorithmException e){
				logger.error("本地加密方式错误或不支持加密方式");
				logger.error(e.getMessage());
				try{
					digestInputStream.close();
					digestInputStream = null;
				}catch(IOException e1){
					logger.error(e1.getMessage());
				}
			}catch(IOException e){
				logger.error(e.getMessage());
				try{
					digestInputStream.close();
					digestInputStream = null;
					
				}catch(IOException e2){
					logger.error(e2.getMessage());
				}
			}finally{
				try{
					digestInputStream.close();
					digestInputStream = null;
					
				}catch(IOException e){
					logger.error(e.getMessage());
				}
				
			}
		}
		
		return curRtn;
	}
}
