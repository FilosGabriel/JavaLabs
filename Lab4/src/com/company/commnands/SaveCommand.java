package com.company.commnands;

public class SaveCommand extends Command {
	public SaveCommand(String name){
		catalog.save(name);
	}
}
