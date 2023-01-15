package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

	private String messege;
	private boolean status;
	
	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String messege) {
		super(messege);
		
	}

	

	

}
