package com.founder.pojo;

public class ResponseState {
	//状态码
	int code;
	//是否成功
	String state;
	//状态信息
	String message;
	
	public ResponseState(){
		this(200, "success", "");
	}
	
	public ResponseState(int code, String state, String message){
		this.code = code;
		this.state = state;
		this.message = message;
	}
	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
