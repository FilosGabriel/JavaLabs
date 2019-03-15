package com.company;

import com.company.MyException.IllegalArgument;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Graph  implements Serializable {
	private  String name;
	private  String description;
	private String pathImage;
	private String pathDefinition;

	public String getName() {
		return name;
	}

	public Graph(String name, String pathDefinition,  String pathImage) throws IllegalArgument {
		if(name.startsWith(" ") || name.length()==0)
		{
			throw new IllegalArgument("Numele unui graph nu poate fii null sau sa inceapa cu spatiu");
		}
//		fileExists()

		this.name = name;
		this.pathImage =  pathImage;
		this.pathDefinition = pathDefinition;
		this.description=null;
	}
	public Graph(String name, String pathDefinition,  String pathImage,String description )  throws  IllegalArgument{
		this(name, pathDefinition, pathImage);
		this.description = description;
	}

	public String getPathImage() {
		return pathImage;
	}

	public String getPathDefinition() {
		return pathDefinition;
	}

	public String getDescription() {
		return description;
	}
}
