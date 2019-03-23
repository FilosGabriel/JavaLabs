package com.company.com.catalog;

import com.company.MyException.IllegalArgument;
import com.company.graph.Graph;
import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;

import java.nio.file.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.

/**
 * A class that represent a catalog
 */
public class Catalog extends CatalogIO {
	private final String PATERN_GRAPH="(add)( )+";
	/**
	 * @param path A path to a folder
	 * @throws InvalidPath A exception if a path is invalid
	 * @throws FolderNotExists A exception if  a folder not exists
	 */
	public Catalog(String path) throws InvalidPath, FolderNotExists
	{
		//verify if exists that partition
		existsPartition(path);
		//verify if folder exists
		existsFolder(path);
		this.path=Paths.get(path);
	}

	/**
	 * Add a graph to catalog
	 * @param graph A graph class
	 */
	public void add(Graph graph)
	{
		catalog.put(graph.getName(),graph);

	}
	public void add(String name ,String description,String pathTgf,String pathTgf2)  throws IllegalArgument {
		Graph graph=new Graph(name,pathTgf, pathTgf2,description);
		this.add(graph);
	}

	/**
	 * Print all graphs from catalog
	 */
	public void list()
	{
		System.out.println("\n");
		for (Map.Entry<String ,Graph> entry:catalog.entrySet()) {
			System.out.println("Nume :"+entry.getValue().getName());
			System.out.println("Definitia :"+entry.getValue().getPathDefinition());
			System.out.println("Locatie imagine :"+entry.getValue().getPathImage());
			if(entry.getValue().getDescription()!=null)
			{
				System.out.println("Descriere :"+entry.getValue().getDescription());
			}
			System.out.print("\n");
		}
	}
}







