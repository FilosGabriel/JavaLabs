package com.company;

import com.company.MyException.FileNotExists;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class CatalogIO extends ToolsIO {
	protected Map<String, Graph> catalog=new HashMap<>();
	protected Path path;

	public boolean save(String nameFile) {


		Path file= Paths.get(path +"\\"+nameFile);

		FileOutputStream fileOutputStream=null;
		ObjectOutputStream outFile=null;
		try {
			if(Files.exists(file))
			{
				System.out.println("Fisierul va fii suprascris.");
				Files.delete(file);
			}
			fileOutputStream = new FileOutputStream(path +"\\"+nameFile);
			outFile= new ObjectOutputStream(fileOutputStream);
			outFile.writeObject(catalog);
			outFile.flush();
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
			fileInputStream= new FileInputStream(path +"\\"+nameFile);
			inputStream = new ObjectInputStream(fileInputStream);
			catalog = new HashMap<String, Graph>(((Map) inputStream.readObject()));
			inputStream.close();
			System.out.println("Fisierul a fost importat cu succes.");
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

		}

		return true;
	}

	public void open(String name,boolean switchMod)  {
		File file=null;
//		int mod=switchMod?1:0;
		switch (switchMod?1:0)
		{
			case (1):{
				switch (catalog.get(name).getPathImage().startsWith("C:")?1:0)
				{
					case 1:file=new File(catalog.get(name).getPathImage()); break;
					case 0:file=new File(path.toString() + "/" + catalog.get(name).getPathImage()); break;
				} }
			case 0:{
				switch (catalog.get(name).getPathDefinition().startsWith("C:")?1:0)
				{
					case 1:file=new File(catalog.get(name).getPathDefinition()); break;
					case 0:file=new File(path.toString() + "/" + catalog.get(name).getPathImage()); break;
				}
			}
		}
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
