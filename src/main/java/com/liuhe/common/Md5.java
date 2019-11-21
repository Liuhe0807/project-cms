package com.liuhe.common;

import org.apache.commons.codec.digest.DigestUtils;
//加密的工具类
public class Md5 {
	
	public static String password(String password,String salt){
		
		
		return DigestUtils.md5Hex(password + ":::" +salt);
		
	}
}
