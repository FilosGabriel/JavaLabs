package com.company.commnands;

public class LoadCommand extends Command {
	public LoadCommand(String name){
		catalog.load(name);
	}
}
