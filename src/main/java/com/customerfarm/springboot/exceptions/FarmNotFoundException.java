package com.customerfarm.springboot.exceptions;

public class FarmNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Farm not found in the database";
	}

}
