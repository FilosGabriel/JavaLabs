package ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represent a solution for the matching problem
 */
public class Solution {

	/**
	 * A list of students and a list of projects that represent a student and his project allocated
	 */
	private List<Student> students =new ArrayList<Student>();
	private List<Project> projects=new ArrayList<Project>();

	/**
	 * Type of solution greedy or ford
	 */
	private String typeSolution;

	/**
	 * Initialize solution with his type
	 * @param solutionType type of solution
	 */
//
	public Solution(String solutionType){typeSolution=solutionType;}



	/**
	 * Add a student and his project to solution
	 * @param student A student
	 * @param proiect The project allocated for the student
	 */
	public  void addToSolution(Student student,Project proiect){
		students.add(student);
		projects.add(proiect);
	}


	/**
	 * @return A string that contain the solutin
	 */
	@Override
	public  String toString(){
		StringBuffer result=new StringBuffer();
		result.append(typeSolution);
		result.append(" solution for problem is:\n[");
		for(int i=0;i<students.size();i++){
			result.append("(").append(students.get(i).getName()).append(",").append(projects.get(i).getName()).append("),");
		}
		result.append("]");
		return result.toString();
	}


}
