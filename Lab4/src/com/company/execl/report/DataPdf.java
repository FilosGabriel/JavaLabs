package com.company.execl.report;

public class DataPdf {
	private  final String  name;
	private final String description;
	private  final String pathTgf;
	private final String pathImage;

	public DataPdf(String name, String description, String pathTgf, String pathImage) {
		this.name = name;
		this.description = description;
		this.pathTgf = pathTgf;
		this.pathImage = pathImage;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getPathTgf() {
		return pathTgf;
	}

	public String getPathImage() {
		return pathImage;
	}
}
