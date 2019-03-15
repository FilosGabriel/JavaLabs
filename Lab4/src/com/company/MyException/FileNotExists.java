package com.company.MyException;

public class FileNotExists extends Exception {
	private String error;
	private String location;
	public FileNotExists(String error,String location)
	{
		this.error=error;
		this.location=location;
	}
	@Override
	public void printStackTrace()
	{
		System.out.println("Eroare :"+error+"\nCauza :Fisierul nu exista sau nu se afla la aceasta locatie.\nLocatie :"+location+"\n");
	}

}

