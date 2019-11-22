package com.liuhe.common;

public class CmsAssert {

	public static void AssertTrue(boolean express,String msg){
		if(!express){
			throw new CmsException(msg);
		}
	}

	public static void AssertTrueHtml(boolean express, String msg) {
		// TODO Auto-generated method stub
		if(!express){
			throw new CmsExceptionHtml(msg);
		}
	}
	
}
