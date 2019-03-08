package ex1;

import java.util.*;

/**
 * A class that represent a Network Flow and solve that problem
 */
class NetworkFlow {
	/**
	 * Number of students
	 */
	private int numberOfStudents;
	/**
	 * Number of projects
	 */
	private int numberOfProjects;
	/**
	 * Some constants
	 */
	private final int NIL=0;
	private final int INF=Integer.MAX_VALUE;

	/**
	 * A list of adjacents of nods
	 */
	private List<List<Integer>> adj;
	/**
	 * Matching of the student with his project
	 */
	private List<Integer> pairStudent;
	/**
	 * Matching of the project with his student
	 */
	private List<Integer> pairProject;
	/**
	 * stores distance of left side vertices/students
	 */
	private List<Integer> dist;

	/**
	 * @param m1 Number of students
	 * @param n1 Number of projects
	 */
	NetworkFlow(int m1,int n1){
		this.numberOfStudents=m1;
		this.numberOfProjects=n1;
		adj=new ArrayList<List<Integer>>(numberOfStudents+1);
		for (int i=0;i<=numberOfStudents;i++){
			adj.add(i,new ArrayList<Integer>());
		}
		pairStudent=new ArrayList<>(Collections.nCopies(numberOfStudents+1,NIL));
		pairProject=new ArrayList<>(Collections.nCopies(numberOfProjects+1,NIL));
		dist=new ArrayList<>(Collections.nCopies(numberOfStudents+1,NIL));

	}

	/**
	 * Method that add a edge
	 * @param student A student
	 * @param project A project
	 */
	public void addEdge(int student,int project){
		adj.get(student).add(project);
	}

	/**
	 * @return  true if there is an augmenting path
	 */
	private  boolean bfs(){
		Queue<Integer> Q=new ArrayDeque<>();
		for(int u=1;u<=numberOfStudents;u++){
			if(pairStudent.get(u)==NIL){
				dist.set(u,0);
				Q.add(u);
			}
			else dist.set(u,INF);
		}
		dist.set(NIL,INF);
		while (!Q.isEmpty()){
			int u=Q.poll();
			if(dist.get(u)<dist.get(NIL)){
				for(Integer it:adj.get(u)){
					int v=it;
					if(dist.get(pairProject.get(v))==INF){
						dist.set(pairProject.get(v),dist.get(u)+1);
						Q.add(pairProject.get(v));
					}
				}
			}
		}
		return (dist.get(NIL)!=INF);
	}

	/**
	 * Adds augmenting path if there is one beginning with u
	 * @param u A student
	 * @return  true if there is an augmenting path
	 */
	private boolean dfs(int u){
		if(u!=NIL){
			for(Integer it:adj.get(u)){
				int v=it;
				if(dist.get(pairProject.get(v))==dist.get(u)+1){
					if(dfs(pairProject.get(v))==true){
						pairProject.set(v,u);
						pairStudent.set(u,v);
						return true;
					}
				}
			}
			dist.set(u,INF);
			return false;
		}
		return true;
	}


	/**
	 * @return Max matching for imput
	 */
	public int hopcroftKarp(){
		int result=0;
		while (bfs()){
			for(int u=1;u<=numberOfStudents;u++){
				if(pairStudent.get(u)==NIL && dfs(u)) {
					result++;
				}
			}
		}
//		System.out.println(pairStudent);
		return  result;
	}

	/**
	 * @return The list of students and his projects after matching
	 */
	public  List<Integer> getPairStudent(){
		return pairStudent;
	}
}
