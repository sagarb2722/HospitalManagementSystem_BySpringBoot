package com.ty.hospital.hospitalmanagement_springboot.exception;

public class NoSuchIdFoundException extends RuntimeException{
	
	private String message="no such id found in database";
	
	
	
	

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		
	}

	@Override
	public String getMessage() {
		
		return message;
	}
	
}
