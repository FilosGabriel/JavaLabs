package com.company.shell;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ShellMain {
	public static void main(String [] args){
		try {
			Shell shell=new Shell();
			shell.run();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}

	}
}
