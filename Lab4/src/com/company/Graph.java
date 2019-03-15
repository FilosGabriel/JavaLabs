package com.company;

import com.company.MyException.IllegalArgument;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * A class that represent a graph
 */
public class Graph  implements Serializable {
	/**
	 * Name of a graph
	 */
	private  String name;
	/**
	 * Description of a graph
	 */
	private  String description;
	/**
	 * A path to  a image of graph
	 */
	private String pathImage;

	/**
	 * A path to definition of a graph
	 */
	private String pathDefinition;

	/**
	 * @return Name of graph
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name Name of graph
	 * @param pathDefinition  A path to definition of a graph
	 * @param pathImage A path to image of a graph
	 * @throws IllegalArgument Illegal argument for constructor
	 */
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
	/**
	 * @param name Name of graph
	 * @param pathDefinition  A path to definition of a graph
	 * @param pathImage A path to image of a graph
	 * @param  description Description of a graph
	 * @throws IllegalArgument Illegal argument for constructor
	 */
	public Graph(String name, String pathDefinition,  String pathImage,String description )  throws  IllegalArgument{
		this(name, pathDefinition, pathImage);
		this.description = description;
	}

	/**
	 * @return A path to a image
	 */
	public String getPathImage() {
		return pathImage;
	}

	/**
	 * @return A path to definition
	 */
	public String getPathDefinition() {
		return pathDefinition;
	}

	/**
	 * @return A string that contain description of graph
	 */
	public String getDescription() {
		return description;
	}
}
