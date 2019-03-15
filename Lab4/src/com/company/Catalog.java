package com.company;

import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;

import java.nio.file.*;
import java.util.Map;
//import java.io.

/**
 * A class that represent a catalog
 */
public class Catalog extends  CatalogIO {
	/**
	 * @param path A path to a folder
	 * @throws InvalidPath A exception if a path is invalid
	 * @throws FolderNotExists A exception if  a folder not exists
	 */
	Catalog(String path) throws InvalidPath, FolderNotExists
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




