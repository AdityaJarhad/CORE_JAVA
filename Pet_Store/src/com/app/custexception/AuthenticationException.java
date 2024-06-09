package com.app.custexception;

@SuppressWarnings("serial")
public class AuthenticationException extends Exception {
	public AuthenticationException(String msg) {
		super(msg);
	}
}
