package ex1;

import java.time.LocalDate;
import java.time.Month;

public class Main {
	public static void main(String[] args) {
//		Students
		Student s1 = new Student("S1", 2);
		Student s2 = new Student("S2", 1);
		Student s3 = new Student("S3", 2);
		Student s4 = new Student("S4", 1);

		//projects and essay
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
		System.out.println(problem);

//		problem.setStudenti(s1, s1);
//		for (Project p:problem.getProject()) {
//			System.out.print(p.getName()+" ");
//		}

		Solver solver=new Solver(problem);
//		System.out.println(solver.isPossibleToAllocateProjects());
//		Solver solver1=new Solver(problem);
		System.out.println( solver.HopcroftKarp());
//		Solution solution=solver.greadySolver();
//		System.out.println( solution);

		//System.out.println(problem); - da eroare cand afisezi o problema cu acelasi student de mai multe ori
//		Project[] proj = s1.getPreferinte();
		//for (int i=0; i<proj.length; i++)
			//System.out.println(proj[i].getName()+' '+proj[i].getDeadline()); - da eroare cand afisezi preferintele unui student cu aceasi preferinta de 2 ori
	}
}
