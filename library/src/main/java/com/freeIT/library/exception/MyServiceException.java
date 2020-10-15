package com.freeIT.library.exception;

@SuppressWarnings("serial")
public class MyServiceException extends RuntimeException {
	public MyServiceException(String message) {
		super(message);
	}
}