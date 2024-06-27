package com.spring.demo.model;

import org.springframework.http.HttpStatus;

public class ResponseObject {
	
	private HttpStatus responseCode;
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return data;
	}
	public void setObj(Object data) {
		this.data = data;
	}
	
	private String msg;	
	private Object data;
	public ResponseObject(HttpStatus responseCode, String msg, Object data) {
		super();
		this.responseCode = responseCode;
		this.msg = msg;
		this.data = data;
	}
	
	
}

