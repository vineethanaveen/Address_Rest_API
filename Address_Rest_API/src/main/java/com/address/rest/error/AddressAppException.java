
package com.address.rest.error;
public class  AddressAppException extends Exception {
	/**
	 *  Custom exception class 
	 */
	private static final long serialVersionUID = -5712599307362420049L;
	private String errorCode;
	
	

	public AddressAppException() {
		super();
	}

	public AddressAppException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
		
	}

	public AddressAppException(String message, String errorCode, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String getMessage() {
		return super.getMessage() ;
	}

	public String geterrorCode() {
		return errorCode;
	}
}
