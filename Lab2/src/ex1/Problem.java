package  ex1;

class Problem {
	private Student[] studenti;
	public  void setStudenti(Student ... args){
		studenti=new Student[args.length];
		boolean uniqueStudent;
		for (int index = 0; index < args.length; index++)
		{
			uniqueStudent = true;
			for (int j=0; j<index; j++)
				if (args[index].equals(args[j])) //verific daca studentii sunt diferiti
				{
					uniqueStudent = false;
					System.out.println("!!!The student " + args[index].getName() + " is duplicated for problem " + args[index].getName() + ", so is ignored!!!");
				}
			if (uniqueStudent)
				studenti[index] = args[index];
		}
	}
	@Override
	public String toString(){
		StringBuffer ouput = new StringBuffer();
		ouput.append("\n\n+-----------------------------+\n|Student preferences          |\n+-----------------------------+\n");
		for (Student elev : studenti) {
			Project[] preferinteStudent;
			preferinteStudent = elev.getPreferinte();
			ouput.append("|").append(elev.getName()).append(":(").append(preferinteStudent[0].getName());
			for (Project preferinta : preferinteStudent) {
				if (preferinta != null && preferinta!=preferinteStudent[0]) { //Am adaugat preferinta!=preferinteStudent[0] ca sa nu se afiseze de 2 ori primul proiect
					ouput.append("," + preferinta.getName());
				}
			}
			ouput.append(")\n+-----------------------------+\n");
		}
		return ouput.toString();
	}

	public Project[] getProject() {
		String[] nameProjects=new String[100];
		Project [] preferedProjects=new Project[100];

		return preferedProjects;
	}
//	public Project[] getProjcts(){
//		Project [] proiecteUnice;
//		for (Student student:studenti) {
//			for (int j=0;i<student.l) {
//				for (int i = 0; i <proiect. ; i++) {
//
//				}
//			}
//
//		}
//	}

}
