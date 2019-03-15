package com.company.MyException;

public class InvalidFormat extends  Exception {
	private String expectedFormat;
	private  String givenFormat;
	private  String location;

	public InvalidFormat(String expectedFormat, String givenFormat, String location) {
		this.expectedFormat = expectedFormat;
		this.givenFormat = givenFormat;
		this.location = location;
	}
	@Override
	public void  printStackTrace()
	{
		System.out.println("Fisier diferit de cel acceptat\nTip de fisier asteptat :"+expectedFormat+"\nFormat primit :"+givenFormat+"\nLocatie :"+location);
	}

}
