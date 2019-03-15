package com.company;

import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;

import java.nio.file.*;
import java.util.Map;
//import java.io.

public class Catalog extends  CatalogIO {
	Catalog(String path) throws InvalidPath, FolderNotExists
	{
		existsPartition(path);
		existsFolder(path);
		this.path=Paths.get(path);
	}
	public void add(Graph graph)
	{
		String key=graph.getName();
		catalog.put(graph.getName(),graph);

	}
	public void list()
	{
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




