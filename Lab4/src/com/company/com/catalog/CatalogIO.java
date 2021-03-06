package com.company.com.catalog;

import com.company.execl.report.WriterExcel;
import com.company.graph.Graph;
import com.company.MyException.FileNotExists;
import com.company.html.report.templates.WriterHtml;
import com.company.pdf.report.WriterPdf;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * A class that represent IO of catalog
 */
public class CatalogIO extends ToolsIO {
	/**
	 * A hashMap that contain  graphs
	 */
	protected Map<String, Graph> catalog=new HashMap<>();

	/**
	 * A path
	 */
	protected Path path;

	/**
	 * A function that save catalog
	 * @param nameFile Name of  a file
	 */
	public void save(String nameFile) {


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

	}

	/**
	 * A function that load catalog from a file
	 * @param nameFile Name of a file
	 */
	public void load(String nameFile)  {

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

	}

	/**
	 * A function that open description or image of a graph
	 * @param name Name of a graph
	 * @param switchMod 1 for photo and 0 for text file
	 */
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

	/**
	 * @param name Name of a graph
	 */
	public void open(String name)
	{
		open(name,true);
	}
	public void writeToHtml(){
		WriterHtml writer=new WriterHtml();
		writer.writeHtml(catalog);
	}

	public void writePdf(){
		WriterPdf writer=new WriterPdf();
		writer.run(catalog);
	}
	public  void writeExcel(){
		WriterExcel writerExcel=new WriterExcel(catalog);
		writerExcel.run();
	}
}
