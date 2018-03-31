package com.wy.tests.util;

public class StringAndByteUtils {
	/** 获取文件后缀 */
	public static String getFileSuffix(String refFileName) {
		String curRtn = "";
		int suffixPos = refFileName.lastIndexOf(".");
		if (suffixPos > 0) {
			curRtn = refFileName.substring(suffixPos + 1);
			if (curRtn.length() > 4)
				return "";
		}
		return curRtn;
	}

	/** 将字节数组转变为16进制字符（常用于MD5计算） */
	public static String byteArrayToHex(byte[] refByteArray) {
		String curRtn = ""; // 最终输出
		String tmpStr = "";
		for (int n = 0; n < refByteArray.length; n++) {
			tmpStr = (Integer.toHexString(refByteArray[n] & 0XFF));
			if (tmpStr.length() == 1) {
				curRtn = curRtn + "0" + tmpStr;
			} else {
				curRtn = curRtn + tmpStr;
			}
			if (n < refByteArray.length - 1) {
				curRtn = curRtn + "";
			}
		}
		return curRtn;
	}
	
	
	
}
