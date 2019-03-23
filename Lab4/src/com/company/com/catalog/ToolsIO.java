package com.company.com.catalog;

import com.company.MyException.FileNotExists;
import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;


import java.io.File;

import java.nio.file.Path;

/**
 * A class for utility
 */
public class ToolsIO {
	/**
	 * @param path A path to a image
	 */
	void isImage(String path)
	{
		Path path1=new File(path).toPath();
//		String mimeType=Files.probeContentType(path1);
	}

	/**
	 * @param path A path to a folder/file
	 * @throws InvalidPath throw if partition not exists
	 */
	  void existsPartition(String path) throws InvalidPath
	{
		if(!path.startsWith("c") && !path.startsWith("C"))
		{
			throw new InvalidPath(path);
		}
	}

	/**
	 * @param path A path to a folder
	 * @throws FolderNotExists throw if not exists  folder
	 */
	 void existsFolder(String path) throws FolderNotExists
	{
		File file=new File(path);
		if(!file.isDirectory())
		{
			throw  new FolderNotExists("Locatia nu exista "+path);
		}
	}

	/**
	 * @param file A pat to a file
	 * @throws FileNotExists throw if file not exists
	 */
	void fileExists(File file) throws FileNotExists
	{
		if(!file.exists())
		{
			throw new FileNotExists("Fisierul nu e gasit.",file.toString());
		}
	}

	/**
	 * @param path A path to a file
	 * @param nameFile Name of a file
	 * @throws FileNotExists
	 */
	 void fileExists(String path,String  nameFile) throws FileNotExists
	{
		File file=new File(path.toString()+"/"+nameFile);
		fileExists(file);

	}

//	protected  boolean isDuplicated()

}
