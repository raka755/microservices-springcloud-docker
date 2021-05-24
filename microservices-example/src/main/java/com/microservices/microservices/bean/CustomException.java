package com.microservices.microservices.bean;

import java.util.Date;

public class CustomException {

	private String message;
	private String details;
	private Date timestamp;
	@Override
	public String toString() {
		return "CustomException [message=" + message + ", details=" + details + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public CustomException(String message, String details, Date timestamp) {
		super();
		this.message = message;
		this.details = details;
		this.timestamp = timestamp;
	}
	
	
	
	
}
