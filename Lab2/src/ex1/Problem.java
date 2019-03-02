package  ex1;

class Problem {
	private Student[] studenti;
	public  void setStudenti(Student ... args){
		studenti=new Student[args.length];
		System.arraycopy(args, 0, studenti, 0, args.length);
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
				if (preferinta != null) {
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
