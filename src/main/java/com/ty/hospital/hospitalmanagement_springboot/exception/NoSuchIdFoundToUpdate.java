package com.ty.hospital.hospitalmanagement_springboot.exception;

public class NoSuchIdFoundToUpdate extends RuntimeException{
	
	private String message="No such id found to update in database";
	
	
	

	public NoSuchIdFoundToUpdate(String message) {
		super();
		this.message = message;
	}




	public NoSuchIdFoundToUpdate() {
	
	}

	@Override
	public String getMessage() {

		return message;
	}
	
	
	

}
