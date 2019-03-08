package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class than implements some methods for solving matching problem
 */
public class Solver {
	/**
	 * A class that represent problem
	 */
	private Problem problema;
	/**
	 * A list of projects from problem
	 */
	private  List<Project> listOfProjects=new ArrayList<Project>();
	/**
	 * A list of project that we use for the greedy  algorithm
	 */
	private List<Integer> seenGreedy;
	/**
	 * Number of students
	 */
	private  int numberOfStudents;
	/**
	 * Number of project
	 */
	private  int numberProjects;
	/**
	 * @param inputProblem The problem class that contain students and projects
	 */
	Solver(Problem inputProblem){
		problema=inputProblem;
		numberOfStudents=inputProblem.getStudenti().length;
		numberProjects=inputProblem.getProjects().size();
		listOfProjects=problema.getProjects();
	}

	/**
	 * @param student1 The Student class that contain a student name with his prefernce
	 * @param student2 The Student class that contain a student name with his prefernce
	 * @return List of project of the students
	 */
	private List<Project> projectsOf(Student student1, Student student2){
		List<Project> projects=new ArrayList<Project>();
		for (Project proiect:student1.getPreferinte()) {
			projects.add(proiect);
		}
		for (Project proiect:student2.getPreferinte()) {
			boolean isDuplicate=false;
			for (int i = 0; i <projects.size() ; i++) {
				if(proiect.equals(projects.get(i))){
					isDuplicate=true;
					break;
				}
			}
			if(!isDuplicate){
				projects.add(proiect);
			}
		}
		return projects;
	}

	/**
	 * Hall's Theorem applicated to verify if is possible to allocate all projects to students
	 * @return True if  can be allocated all project else false
	 */
	public boolean isPossibleToAllocateProjects(){
		Student[] studenti=problema.getStudenti();
		for (int i = 0; i <studenti.length ; i++) {
			if(studenti[i]!=null){
				for(int j=i+1;j<studenti.length;j++){
					if(2>projectsOf(studenti[i],studenti[j]).size()){
						return false;
					}
				}
			}

		}
		return  true;
	}

	/**
	 * @param project A project from the list of projects of the problem
	 * @return position in that  list
	 */
	private int getIndexProject(Project project) {
		int index = 0;
		for (Project project2 : listOfProjects){
			if (project.equals(project2)) {
//				System.out.println(index);
				return index;
			}

			index++;
		}
		return  index;
	}

	/**
	 * A  algorithm that solve the matching problem using greedy method
	 * @return A solution for that problem
	 */
	public Solution greadySolver(){
		Solution solution=new Solution("GreadySolver");
		seenGreedy=new ArrayList<Integer>(Collections.nCopies(listOfProjects.size(),-1));
		int i=1;
		for (Student student:problema.getStudenti()) {
			for(Project project:student.getPreferinte()){
				if(seenGreedy.get(getIndexProject(project))<0){
					seenGreedy.set(getIndexProject(project),i);
					solution.addToSolution(student,project);
					break;
				}
			}
			i++;
		}
		return  solution;

	};

	/**
	 * @param list a list of projects
	 * @return A solution class from the list
	 */
	private  Solution transformToSolution(List<Integer> list){
		Solution solution=new Solution("HopcroftKarp");
		int numberStudent=0;
		for(Student student:problema.getStudenti()){
			numberStudent++;
			solution.addToSolution(student,listOfProjects.get(list.get(numberStudent)));
		}
		return solution;
	}


	/**
	 * This function transform a matching problem in a network flow problem
	 * @return A solution for the matching problem
	 */
	public Solution hopcroftKarp(){
		NetworkFlow flow = new NetworkFlow(numberOfStudents,numberProjects);
		int numberStudent=0;
//
		for(Student student:problema.getStudenti()){
			numberStudent++;
			for (Project project: student.getPreferinte()){
				flow.addEdge(numberStudent,getIndexProject(project));
			}
		}
		flow.hopcroftKarp();

		return  transformToSolution(flow.getPairStudent());
	}
}
