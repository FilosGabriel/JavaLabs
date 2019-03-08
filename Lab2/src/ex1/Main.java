package ex1;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {
	public static void main(String[] args) {
//		Students
		Student s1 = new Student("S1", 2);
		Student s2 = new Student("S2", 1);
		Student s3 = new Student("S3", 2);
		Student s4 = new Student("S4", 1);

		//Projects and essay
		Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Languages.JAVA);
		Application a2 = new Application("A2", LocalDate.of(2019, Month.JUNE, 1), Languages.JAVA);
		Application a3 = new Application("A3", LocalDate.of(2019, Month.JUNE, 1), Languages.JAVA);
		Essay e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Topics.ALGORITHMS);

//		Setting the preferences of the students
		s1.setPreferinte(a1,a3);
		s2.setPreferinte(a1,e1);
		s3.setPreferinte(a1,a2);
		s4.setPreferinte(a1);

		// Initialize a problem  with the students and his preferences
		Problem problem = new Problem();
		problem.setStudenti(s1, s2, s3,s4);
//		Print the problem
		System.out.println(problem);

//      Initialize a Solver class that solve the matching problem
		Solver solver=new Solver(problem);
		System.out.println("\n\nHall's Theorem :"+solver.isPossibleToAllocateProjects()+"\n");
		System.out.println( "Solution using HopcroftKarp:" +solver.hopcroftKarp()+"\n");
		System.out.println("Solution using Greeady Alghoritm :"+solver.greadySolver()+"\n");

//		Print the list of preferences of a student
		List<Project> proj = s1.getPreferinte();
		for (int i=0; i<proj.size(); i++)
			System.out.println(proj.get(i).getName()+' '+proj.get(i).getDeadline());
	}
}
