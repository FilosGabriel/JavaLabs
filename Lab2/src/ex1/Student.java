package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A class that represent a student with his attdributes and his preferred projects
 */
public class Student {
	/**
	 * Name of the student
	 */
    private String name;
	/**
	 * A list of his preferences of projects
	 */
	private List<Project> preferinte=new ArrayList<Project>();

	/**
	 * Student's study year
	 */
    private int yearOfStudy;


	/**
	 *
	 * @param name Name of student
	 * @param yearOfStudy Student's study year
	 */
    public Student(String name, int yearOfStudy) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

	/**
	 * @return Name of the student
	 */
    public String getName() {
        return name;
    }

	/**
	 * A method that set the name of the student
	 * @param name Name of the student
	 */
    public void setName(String name) {
        this.name = name;
    }

	/**
	 * @return Student's study year
	 */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

	/**
	 * A method that set the student's study year
	 * @param yearOfStudy  Student's study year
	 */
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

	/**
	 * @param args List of projects that he like to work
	 */
    public  void setPreferinte(Project ... args) {
		if (args.length == 0) {
			System.out.println("Stuedent " + this.getName() + " has no preferences.");
		} else {
			boolean uniqueProject = true;
			for (int index = 0; index < args.length; index++) {
				uniqueProject = true;
				for (int j = 0; j < index; j++) {
					if (args[index].equals(args[j])) {
						uniqueProject = false;
						System.out.println("!!!The project " + args[index].getName() + " is duplicated for student " + this.getName() + ", so is ignoreted!!!");
					}
				}
				if (uniqueProject) {
					preferinte.add(args[index]);
				}
			}
		}
	}

	/**
	 * @return List of projects that the student like
	 */
	public List<Project> getPreferinte(){
        return preferinte  == null ? Collections.EMPTY_LIST : preferinte;
    }

	/**
	 * 	 * A method by which we get information about the student
	 * @return A string that contain info about student
	 */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

	/**
	 * A method that compare two object of type student
	 * @param o Another student class that we want to compare
	 * @return  True if is the same project and false otherwise
	 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name);
    }

}

