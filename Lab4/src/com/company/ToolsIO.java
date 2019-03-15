package com.company;

import com.company.MyException.FileNotExists;
import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;

public class ToolsIO {
	void isImage(String path)
	{
		Path path1=new File(path).toPath();
//		String mimeType=Files.probeContentType(path1);
	}

	  void existsPartition(String path) throws InvalidPath
	{
		if(!path.startsWith("c") && !path.startsWith("C"))
		{
			throw new InvalidPath(path);
		}
	}
	 void existsFolder(String path) throws FolderNotExists
	{
		File file=new File(path);
		if(!file.isDirectory())
		{
			throw  new FolderNotExists("Locatia nu exista "+path);
		}
	}
	void fileExists(File file) throws FileNotExists
	{
		if(!file.exists())
		{
			throw new FileNotExists("Fisierul nu e gasit.",file.toString());
		}
	}

	 void fileExists(String path,String  nameFile) throws FileNotExists
	{
		File file=new File(path.toString()+"/"+nameFile);
		fileExists(file);

	}

//	protected  boolean isDuplicated()

}
