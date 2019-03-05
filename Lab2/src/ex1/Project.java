package ex1;

import java.time.LocalDate;

public abstract class Project {
	protected String name;
	protected LocalDate deadline;
	protected int id;
	protected static int idProject=0;
	public Project(String name, LocalDate deadline) {
		this.name = name;
		this.deadline = deadline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
	protected int getIdProject(){return idProject;}

	//Overriding equals() to compare two Complex objects
	@Override
	public boolean equals(Object project) {
		// If the object is compared with itself then return true
		if (project == this) {
			return true;
		}
		 /* Check if o is an instance of Project or not
          "null instanceof [type]" also returns false */
		if (!(project instanceof Project)) {
			return false;
		}
		// typecast o to Complex so that we can compare data members
		Project project1 = (Project) project;
		// Compare the data members and return accordingly
		return this.name.equals(project1.getName());
	}

}
