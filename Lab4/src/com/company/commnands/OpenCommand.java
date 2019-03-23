package com.company.commnands;

public class OpenCommand extends Command {
	public  OpenCommand(String name){
		catalog.open(name);
	}
}
