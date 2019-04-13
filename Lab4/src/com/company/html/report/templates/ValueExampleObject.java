package com.company.html.report.templates;

public class ValueExampleObject {

	private String name;
	private String describe;
	private String caleImage;
	private String caleTgf;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getCaleImage() {
		return caleImage;
	}

	public void setCaleImage(String caleImage) {
		this.caleImage = caleImage;
	}

	public String getCaleTgf() {
		return caleTgf;
	}

	public void setCaleTgf(String caleTgf) {
		this.caleTgf = caleTgf;
	}

	public ValueExampleObject(String name, String describe, String caleImage, String caleTgf) {
		this.name = name;
		this.describe = describe;
		this.caleImage = caleImage;
		this.caleTgf = caleTgf;
	}
}