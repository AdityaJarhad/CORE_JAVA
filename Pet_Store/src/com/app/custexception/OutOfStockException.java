package com.app.custexception;

@SuppressWarnings("serial")
public class OutOfStockException extends Exception {
	public OutOfStockException(String msg) {
		super(msg);
	}
}
