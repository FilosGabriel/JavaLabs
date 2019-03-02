package  ex1;

import java.util.ArrayList;
import java.util.List;

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

	public List<Project> getProject() {
		List<Project> preferedProjects=new ArrayList<Project>();
		for (Student student:studenti) {
				if(student!=null){
					System.out.println(student.getName());
					for (Project proiect:student.getPreferinte()) {
						boolean isDuplicate=false;
						for( int i=0;i<preferedProjects.size();i++){
							if(preferedProjects.get(i).equals(proiect)){
								isDuplicate=true;
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

	private List<Project> neightborOf(Student studentul1,Student student2){
		List<Project> projects=new ArrayList<Project>();
		for (Project proiect:studentul1.getPreferinte()) {
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

	public boolean isPossibleToAllocateProjects(){
		for (int i = 0; i <studenti.length ; i++) {
			if(studenti[i]!=null){
				for(int j=i+1;j<studenti.length;j++){
					if(2>neightborOf(studenti[i],studenti[j]).size()){
						return false;
					}
				}
			}

		}
		return  true;
	}

}
