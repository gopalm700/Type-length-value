package com.gopal.main.exception;

public class WrongTypeException extends Exception {
	private static final long serialVersionUID = 7881023466988829271L;

	public WrongTypeException() {
	}

	public WrongTypeException(String message) {
		super(message);
	}

	public WrongTypeException(Throwable throwable) {
		super(throwable);
	}

	public WrongTypeException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
