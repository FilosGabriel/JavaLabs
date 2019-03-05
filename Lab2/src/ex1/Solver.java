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
	private  int numberOfStudents;
	private List<Integer> match;
	private List<Integer> seenGreedy;

	/**
	 * @param inputProblem The problem class that contain students and projects
	 */
	Solver(Problem inputProblem){
		problema=inputProblem;
		listOfProjects=problema.getProject();
		seen=new ArrayList<Boolean>(Collections.nCopies(listOfProjects.size(),false));
		numberOfStudents=problema.getStudenti().length;
		matrixNetwork=new ArrayList<>(Collections.nCopies(numberOfStudents*listOfProjects.size(),false));
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


	/**
	 * @param project A Project class
	 * @return
	 */
	private int getIndexProjrct(Project project) {
		int index = 0;
		for (Project project2 : listOfProjects){
			if (project.equals(project2)) {
//				System.out.println(index);
				return index;
			}
		index++;
	}
	return  -1;
	}

	private void transformToNetworkFlow(){
		int indexStudent=0;
		for (Student student :problema.getStudenti()) {
			for(Project project:student.getPreferinte()){
			matrixNetwork.set(indexStudent*numberOfStudents+getIndexProjrct(project),true);
			}
			indexStudent++;
		}
	}

	private boolean isPossibleAMatching(int student){
		for (int project=0;project<listOfProjects.size();project++){
			if(matrixNetwork.get(student*numberOfStudents+project) && !seen.get(project)  ) {
				seen.set(project,true);
				if(match.get(project)<0 ||  isPossibleAMatching(match.get(project)) ){
					match.set(project,student);
					return true;
				}
			}
		}
		return  false;
	}



	public  Solution fordFulkersonSolver(){
		Solution solution=new Solution("fordFulkersonSolver");
		int result=1;
		transformToNetworkFlow();
		System.out.println(listOfProjects);
		System.out.println(matrixNetwork);

		match=new ArrayList<Integer>(Collections.nCopies(listOfProjects.size(),-1));
		for(int student=0;student<numberOfStudents;student++){
			if(isPossibleAMatching(student)){
				result++;
			}
		}
		System.out.println(result);
		System.out.println(match);
		return solution;
	}






	public Solution greadySolver(){
		Solution solution=new Solution("GreadySolver");
		seenGreedy=new ArrayList<Integer>(Collections.nCopies(listOfProjects.size(),-1));
		int i=1;
		for (Student student:problema.getStudenti()) {
			for(Project project:student.getPreferinte()){
				if(seenGreedy.get(getIndexProjrct(project))<0){
					seenGreedy.set(getIndexProjrct(project),i);
					solution.addToSolution(student,project);
					break;
				}
			}
			i++;
		}
//		System.out.println(seenGreedy);
		return  solution;
	}

}
