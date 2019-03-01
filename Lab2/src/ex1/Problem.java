package  ex1;
public  class  Problem {
	Student[] studenti;
	public  void setStudenti(Student ... args){
		studenti=new Student[args.length];
		for(int i=0;i<args.length;i++){
			studenti[i]=args[i];
		}
	}
	@Override
	public String toString(){
		String afisare=new String();
		afisare="+-----------------------------+\n|Student preferences          |\n+-----------------------------+\n";
		for(int i =0;i<studenti.length;i++){
			Project [] preferinteStudent=new Project[studenti[i].getPreferinte().length];
			preferinteStudent=studenti[i].getPreferinte();
			afisare+="|"+studenti[i].getName()+":(";
			afisare+=preferinteStudent[0].getName();
			for(int j=1;j<preferinteStudent.length;j++){
				afisare+=","+preferinteStudent[j].getName();
			}
		afisare+=")\n";
			afisare+="+-----------------------------+\n";
		}
		return afisare;
	}

	public Project[] getProject() {
		String[] nameProjects=new String[100];
		Project [] preferedProjects=new Project[100];

		return preferedProjects;
	}
}
