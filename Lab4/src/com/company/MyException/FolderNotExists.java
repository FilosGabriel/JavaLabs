package com.company.MyException;

public class FolderNotExists extends Exception{
	String path;
	public FolderNotExists(String path)
	{
		this.path=path;
	}

	@Override
	public void printStackTrace() {
		System.out.println("Folderul nu exista :"+path);
	}
}
