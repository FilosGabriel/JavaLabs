package com.company.commnands;

import com.company.MyException.IllegalArgument;
import com.company.graph.Graph;

public   class AddCommand extends Command {
	public AddCommand(String name ,String description, String pathTgf,String pathImage) throws IllegalArgument {
		catalog.add(new Graph(name,description,pathTgf,pathImage));
	}
}
