package com.spring.demo.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ListResponseObject {

	
	private HttpStatus responseCode;
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	
	
	private String msg;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	private List<Object> data;
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public ListResponseObject(HttpStatus responseCode, String msg, List<Object> data) {
		super();
		this.responseCode = responseCode;
		this.msg = msg;
		this.data = data;
	}
	public ListResponseObject() {
		super();
	}
	

	
}
