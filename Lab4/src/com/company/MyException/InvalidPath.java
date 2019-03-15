package com.company.MyException;

public class InvalidPath extends Exception{
	private String path;
	public InvalidPath(String path)
	{
		this.path=path;
	}
	@Override
	public  void printStackTrace()
	{
		System.out.println("Calea nu exista :"+path);
	}


}
