package ex1;

import java.time.LocalDate;

/**
 * A class that represent the base for aplication and essay class
 */
public abstract class Project {
	/**
	 * Name of the project
	 */
	protected String name;
	/**
	 * Deadline of the project
	 */
	protected LocalDate deadline;
	/**
	 * Id of the project
	 */

	/**
	 * Initialize the class project with his attributes
	 * @param name The name of the project
	 * @param deadline Deadline of the project
	 */
	public Project(String name, LocalDate deadline) {
		this.name = name;
		this.deadline = deadline;
	}

	/**
	 * A method by which we get the name of the project
	 * @return Name of the project
	 */
	public String getName() {
		return name;
	}

	/**
	 * A method by witch we set the name of the project
	 * @param name Name of the project
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * A method by wich we get the deadline of the project
	 * @return Deadline of the project
	 */
	public LocalDate getDeadline() {
		return deadline;
	}

	/**
	 * A method by witch we set the deadline of the project
	 * @param deadline  Deadline  of the project
	 */
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	/**
	 * A method that compare two object of type project
	 * @param project Another project class that we want to compare
	 * @return true if is the same project and false otherwise
	 */
	@Override
	public boolean equals(Object project) {
		// If the object is compared with itself then return true
		if (project == this) {
			return true;
		}
		 /* Check if o is an instance of Project or not
          "null instanceof Project" also returns false */
		if (!(project instanceof Project)) {
			return false;
		}
		// typecast o to Project so that we can compare data members
		Project project1 = (Project) project;
		// Compare the data members and return accordingly
		return this.name.equals(project1.getName());
	}

}
