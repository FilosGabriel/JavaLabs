package ex1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<Student> students =new ArrayList<Student>();
	private List<Project> projects=new ArrayList<Project>();
	private String typeSolution;
	public Solution(String solutionType){typeSolution=solutionType;}
	public  void addToSolution(Student student,Project proiect){
		students.add(student);
		projects.add(proiect);
	}
	@Override
	public  String toString(){
		StringBuffer result=new StringBuffer();
		result.append(typeSolution);
		result.append(" solution for prob lem is:\n[");
		for(int i=0;i<students.size();i++){
			result.append("(").append(students.get(i).getName()).append(",").append(projects.get(i).getName()).append("),");
		}
		result.append("]");
		return result.toString();
	}


}
