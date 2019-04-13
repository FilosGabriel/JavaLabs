package com.company;

public class Student  implements  Comparable{
	private  final int age;
	private final String name;
	Student(){age=1;name="gaby";};

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	@Override
	public  int compareTo(Object s1){
		return 1;
	}

}
