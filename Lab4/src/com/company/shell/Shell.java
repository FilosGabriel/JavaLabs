package com.company.shell;

import com.company.MyException.FolderNotExists;
import com.company.MyException.IllegalArgument;
import com.company.MyException.InvalidPath;
import com.company.com.catalog.Catalog;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shell {
	private String prompt;

	private List<String> splitArguments( String argumants){
		List<String> result=new ArrayList<>();
		String pattern = "(add)\\s+\"[a-zA-Z][a-zA-Z0-9 ]*\"\\s*,\\s+\"([a-zA-Z0-9]+| )+\"\\s*,\\s+\"[\\.a-zA-Z0-9/]+\"\\s*,\\s+\"[\\.a-zA-Z0-9/]+\"\\s*";
		String patternName="[a-zA-Z][a-zA-Z0-9 ]*";
		String patternDescripption=",\\s+\"([a-zA-Z0-9]+| )+\"\\s*";
		Pattern r = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher matcher =r.matcher(argumants);
		if(matcher.find()){
			result.add("add");
			Pattern name=Pattern.compile(patternName);
			Matcher matcher1 = name.matcher(argumants);
			result.add(matcher1.group(0).substring(1,matcher1.group(0).length()-2 ));
			name=Pattern.compile(patternDescripption);
			matcher1=name.matcher(argumants);
			result.add(matcher1.group(0).substring(1,matcher1.group(0).length()-2 ));
			result.add(matcher1.group(1).substring(1,matcher1.group(0).length()-2 ));
			result.add(matcher1.group(2).substring(1,matcher1.group(0).length()-2 ));
		}
		System.out.println(result);

//
//		String[] m=argumants.split(pattern);
//
//
//
//
//		result.add(m[0].split(" ")[1]) ;
//		result.add(m[0].split(" ")[2].split("\"")[1]);
//		System.out.println(result.get(1).split("\"")[1]);
////		System.out.println(result);
//		if(m.length==4){
//			result.add(m[1].replace("\"",""));
//			result.add(m[2].replace("\"","").replace(" ",""));
//			result.add(m[3].replace("\"","").replace(" ",""));
//		}

		return  result;
	}

	public void run() {
		String command;
		Method method;
		System.out.println(prompt);
		Scanner inputKeyboard = new Scanner(System.in);
		command = inputKeyboard.nextLine();
		List<String> result=new ArrayList<>();
		if (command.equals("exit")) System.out.println("Program terminat");
		while (!command.equals("exit")) {

			try {
				command=" add \"K4\", \"The complete graph with 4 vertices\", \"complete/k4.tgf\", \"complete/view/k4.png\"";
				result= splitArguments(command);
				System.out.println(result);
//
//				switch (result[0){
//					case (4):{
//							method=catalog.getClass().getMethod(result.get(0),type);
//							method.invoke(catalog,result.get(1),result.get(3),result.get(4),result.get(2));
//							break; }
//					case 2:{
//						method=catalog.getClass().getMethod(result.get(0),type2);
//						method.invoke(catalog,result.get(1),result.get(2));
//						break;
//					}
//					default:{
//						throw new IllegalArgument("Comanda invalida.");
//					}
//
//				}
//

			}

			catch (IllegalStateException ex){
				System.out.println("ceva");
			}
			command=inputKeyboard.nextLine();
		}

	}

}
