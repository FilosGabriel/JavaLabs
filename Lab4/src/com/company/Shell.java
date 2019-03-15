package com.company;

import com.company.MyException.FolderNotExists;
import com.company.MyException.InvalidPath;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Shell {

	public  void run()
	{
		String command;
		Catalog catalog;
		Scanner inputKeyboard=new Scanner(System.in);
		command=inputKeyboard.nextLine();
		if(command.equals("exit")) System.out.println("Program terminat");
		else{
			try{
				catalog=new Catalog(command);
				command=inputKeyboard.nextLine();
				Method method;
				while (!command.equals("exit")){
					try {
						method=catalog.getClass().getMethod(command);

					}
					catch (NoSuchMethodException ex)
					{
						ex.printStackTrace();
					}
					command=inputKeyboard.nextLine();
				}
			}
			catch(FolderNotExists| InvalidPath ex)
			{
				ex.printStackTrace();
			}
		}


	}

}
