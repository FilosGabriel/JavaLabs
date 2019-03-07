package ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {
	private Problem problema;
	static  int n = 0;
	private  List<Project> listOfProjects=new ArrayList<Project>();
	private  List<Boolean> seen;
//	private  boolean[][] matrixNetwork;
	private  List<Boolean> matrixNetwork;
	private List<Integer> match;

	
	private List<Integer> seenGreedy;
	private  int numberOfStudents;
	private  int numberProjects;
	/**
	 * @param inputProblem The problem class that contain students and projects
	 */
	Solver(Problem inputProblem){
		problema=inputProblem;
		numberOfStudents=inputProblem.getStudenti().length;
		numberProjects=inputProblem.getProject().size();
		listOfProjects=problema.getProject();
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
//		System.out.println(seenGreedy);
		return  solution;
	};
	private  Solution transformToSolution(List<Integer> list){
		Solution solution=new Solution("HopcroftKarp");
		int numberStudent=0;
		for(Student student:problema.getStudenti()){
			numberStudent++;
			solution.addToSolution(student,listOfProjects.get(list.get(numberStudent)));
		}
		return solution;
	}

	public Solution HopcroftKarp(){
		NetworkFlow flow = new NetworkFlow(numberOfStudents,numberProjects);
		int id=0;
		for(Student student:problema.getStudenti()){
			id++;
			for (Project project: student.getPreferinte()){
				flow.addEdge(id,getIndexProject(project));
			}
		}
		flow.hopcroftKarp();

		return  transformToSolution(flow.getPairU());
	}
}
