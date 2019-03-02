package ex1;

import java.util.Objects;

public class Student {
    private String name;
	private Project[] preferinte;
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

	//    the student's preferences are set
// <<<<<<< master
//     public  void setPreferinte(Project ... args){
//     	preferinte=new Project[args.length];
// 		boolean uniqueProject = true;
// 		for (int index = 0; index < args.length; index++) {
// 			uniqueProject = true;
// 			for (int j = 0; j < index; j++) {
// 				if (args[index].equals(args[j])) {
// 					uniqueProject = false;
// 					System.out.println("!!!The project " + args[index].getName() + " is duplicated for student " + args[index].getName() + ", so is ignored!!!");
// =======
    public  void setPreferinte(Project ... args) {
		if (args.length == 0) {
			System.out.println("Stuedent " + this.getName() + " has no preferences.");
		} else {
			preferinte = new Project[args.length];
			boolean uniqueProject = true;
			for (int index = 0; index < args.length; index++) {
				uniqueProject = true;
				for (int j = 0; j < index; j++) {
					if (args[index].equals(args[j])) {
						uniqueProject = false;
						System.out.println("!!!The project " + args[index].getName() + " is duplicated for student " + this.getName() + ", so is ignoreted!!!");
					}
// >>>>>>> master
				}
				if (uniqueProject) {

					preferinte[index] = args[index];
				}
			}
		}
	}
	public Project[] getPreferinte(){
        return preferinte;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }
// <<<<<<< master

    @Override
    public boolean equals(Object o) { //am generat-o cu alt+enter si i-am scos comparatia dintre preferinte
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfStudy == student.yearOfStudy &&
                Objects.equals(name, student.name);
    }
// =======
//     @Override
// 	public boolean equals(Object student){
// 		// If the object is compared with itself then return true
// 		if (student == this) {
// 			return true;
// 		}
// 		 /* Check if o is an instance of Project or not
//           "null instanceof [type]" also returns false */
// 		if (!(student instanceof Student)) {
// 			return false;
// 		}
// 		// typecast o to Complex so that we can compare data members
// 		Student project1 = (Student) student;
// 		// Compare the data members and return accordingly

// 		// Compare the data members and return accordingly
// 		return this.name.equals(project1.getName());
// 	}
// >>>>>>> master
}

