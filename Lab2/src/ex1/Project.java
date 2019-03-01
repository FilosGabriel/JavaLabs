package ex1;

import java.time.LocalDate;
import java.util.Date;

public abstract class Project {
	protected String name;
	protected LocalDate deadline;

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

	public boolean equals(Project project) {
		if (!this.name.equals(project.name))
			return false;
		return !this.deadline.equals(project.deadline);

	}

}
