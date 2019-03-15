package com.company.MyException;

public class IllegalArgument extends Exception {
	private String cause;
	public IllegalArgument(String cause)
	{
		this.cause=cause;
	}

	@Override
	public void printStackTrace() {
		System.out.println(cause);
	}
}
