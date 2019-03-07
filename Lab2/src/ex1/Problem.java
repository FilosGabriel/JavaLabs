package  ex1;

import java.util.ArrayList;
import java.util.List;


/**
 * A class that represent a matching problem  between students and diffrent projects
 */
class Problem {
	/**
	 * A list of students for matching problem
	 */
	private Student[] studenti;
	/**
	 * A matrix representation of matching problem  in the form of a network flow
	 */
	private  boolean[][] matrixForNetworkFlow;

	/**
	 * Initialize the problem with students
	 * @param args Students
	 */
	public  void setStudenti(Student ... args){
		studenti=new Student[args.length];
		boolean uniqueStudent;
		for (int index = 0; index < args.length; index++)
		{
			uniqueStudent = true;
//			verify if it was been added previously
			for (int j=0; j<index; j++)
//				//verify that the students are different
				if (args[index].equals(args[j]))
				{
//					Set the uniqueStudent false if is the same student and print a notification about that
					uniqueStudent = false;
					System.out.println("!!!The student " + args[index].getName() + " is duplicated for problem " + args[index].getName() + ", so is ignored!!!");
				}
//			Add to Student list if it has been added
			if (uniqueStudent)
				studenti[index] = args[index];
		}
	}

	/**
	 * A method by which we get information about the problem
	 * @return  string that contain information about problem
	 */
	@Override
	public String toString(){
		StringBuffer ouput = new StringBuffer();
		ouput.append("\n\n+-----------------------------+\n|Student preferences          |\n+-----------------------------+\n");
		for (Student elev : studenti) {
			List<Project> preferinteStudent = elev.getPreferinte();
			ouput.append("|").append(elev.getName()).append(":(").append(preferinteStudent.get(0).getName());
			for (Project preferinta : preferinteStudent) {
				if (preferinta != null && preferinta!=preferinteStudent.get(0)) { //Am adaugat preferinta!=preferinteStudent[0] ca sa nu se afiseze de 2 ori primul proiect
					ouput.append(",").append( preferinta.getName());
				}
			}
			ouput.append(")\n+-----------------------------+\n");
		}
		return ouput.toString();
	}

	/**
	 * A method by which we get the list of projects associated with the matching problem
	 * @return A list of unique projects
	 */
	public List<Project> getProject() {
		List<Project> preferedProjects=new ArrayList<Project>();
		for (Student student:studenti) {
				if(student!=null){
					for (Project proiect:student.getPreferinte()) {
						boolean isDuplicate=false;
						for( int i=0;i<preferedProjects.size();i++){
							if(preferedProjects.get(i).equals(proiect)){
								isDuplicate=true;
								break;
							}
						}
						if(!isDuplicate){
							preferedProjects.add(proiect);
						}
					}
				}
			}
		return preferedProjects;
	}

	/**
	 * A method by which we get the list of students associated with the matching problem
	 * @return A list of students
	 */
	public  Student[] getStudenti(){
		return studenti;
	}


}
