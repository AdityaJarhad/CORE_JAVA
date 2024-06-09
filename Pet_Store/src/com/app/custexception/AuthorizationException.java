package com.app.custexception;

@SuppressWarnings("serial")
public class AuthorizationException extends Exception {
	public AuthorizationException(String msg) {
		super(msg);
	}
}
