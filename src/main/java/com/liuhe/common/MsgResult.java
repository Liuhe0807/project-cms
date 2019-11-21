package com.liuhe.common;

import java.io.Serializable;

//用于前后端交互的协议
public class MsgResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3512035365224594778L;
	
	int result;
	String errorMsg;
	Object data;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	public MsgResult() {
		super();
	}
	
	
}
