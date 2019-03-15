package com.company;

import com.company.MyException.FileNotExists;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CatalogIO extends ToolsIO {
	protected Map<String, Graph> catalog=new HashMap<>();
	protected Path path;

	public boolean save(String nameFile) {


		File file=new File(path +"\\"+nameFile);
		if(file.exists())
		{
			System.out.println("Fisierul va fii suprascris.");
		}
		FileOutputStream fileOutputStream=null;
		ObjectOutputStream outFile=null;
		try {
			fileOutputStream = new FileOutputStream(path +"\\"+nameFile);
			outFile= new ObjectOutputStream(fileOutputStream);
			outFile.writeObject(catalog);
			outFile.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		finally
		{
			if(outFile!=null)
			{
				try {
					outFile.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			if(fileOutputStream!=null)
			{
				try {
					fileOutputStream.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			System.out.println("Fisierul a fost scris cu succes.");

		}
		return true;
	}

	public boolean load(String nameFile)  {

		FileInputStream fileInputStream=null;
		ObjectInputStream inputStream=null;
		try {
			File file=new File(path+"\\"+nameFile);
			if(!file.isFile()) throw new FileNotExists("Fisierul nu e gasit",file.toString());
			fileInputStream= new FileInputStream(nameFile);
			inputStream = new ObjectInputStream(fileInputStream);
			System.out.println(catalog.size());
			catalog = (Map<String, Graph>) inputStream.readObject();
			System.out.println(catalog.size());
			inputStream.close();
		}
		catch (IOException|ClassNotFoundException  ex) {
			System.out.println(ex.getMessage());
		}
		catch(FileNotExists ex)
		{
			ex.printStackTrace();
		}
		finally {
			if(inputStream!=null)
			{
				try {
					inputStream.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			if(fileInputStream!=null)
			{
				try {
					fileInputStream.close();
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
			System.out.println("Fisierul a fost importat cu succes.");
		}

		return true;
	}

	public void open(String name,boolean switchMod)  {
		File file;
		if(switchMod) file= new File(path.toString() + "/" + catalog.get(name).getPathImage());
		else file=new File(path.toString()+"\\"+catalog.get(name).getPathDefinition());

		try {
			fileExists(file);
			if(switchMod) Desktop.getDesktop().open(file);
			else Desktop.getDesktop().edit(file);
		}
		catch (FileNotExists ex)
		{
			ex.printStackTrace();
		}
		catch (IOException ex)
		{
			System.out.println(ex.getMessage());
		}


	}
	public void open(String name)
	{
		open(name,true);
	}

}
