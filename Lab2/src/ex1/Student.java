package ex1;

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
    public  void setPreferinte(Project ... args){
    	preferinte=new Project[args.length];
		boolean uniqueProject = true;
		for (int index = 0; index < args.length; index++) {
			uniqueProject = true;
			for (int j = 0; j < index; j++) {
				if (args[index].equals(args[j])) {
					uniqueProject = false;
					System.out.println("!!!The project " + args[index].getName() + " is duplicated for student " + args[index].getName() + ", so is ignoreted!!!");
				}
			}
			if (uniqueProject) {

				preferinte[index] = args[index];
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
}

