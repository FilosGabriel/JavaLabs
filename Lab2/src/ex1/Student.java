package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
	private List<Project> preferinte=new ArrayList<Project>();
	private int  numberOfPreferinte=0;
    private int yearOfStudy;

    public Student(String name, int yearOfStudy) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

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
					numberOfPreferinte++;
				}
			}
		}
	}

	public List<Project> getPreferinte(){
        return preferinte  == null ? Collections.EMPTY_LIST : preferinte;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

    @Override
    public boolean equals(Object o) { //am generat-o cu alt+enter si i-am scos comparatia dintre preferinte
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name);
    }

}

