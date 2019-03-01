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
//    se seteaza preferintele studentului
    public  void setPreferinte(Project ... args){
    	preferinte=new Project[args.length];
    	for(int i=0;i<args.length;i++){
    		preferinte[i]=args[i];
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

