package com.example.employee.exception;

public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4175957506257054517L;

	public EmployeeNotFoundException(String exceptionMessage) {
	
		super(exceptionMessage);
	}
}
