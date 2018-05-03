package model;
import java.util.List;

public class Instructor {
	private int instructorId;
	private String name;
	private Department department;
	private List<Subject> educatedSubjects;
	
	public int getInstructorId() {
		return instructorId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Subject> getEducatedSubjects() {
		return educatedSubjects;
	}
	public void setEducatedSubjects(List<Subject> educatedSubjects) {
		this.educatedSubjects = educatedSubjects;
	}
	
	public void addEducatedSubject(Subject subject) {
		educatedSubjects.add(subject);
	}
	
	public void deleteEducatedSubject(Subject subject) {
		if(educatedSubjects.contains(subject)) {
			educatedSubjects.remove(subject);
		}else
			System.out.println("This subject is not educated by " + name );
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Instructor(String name, Department department, List<Subject> educatedSubjects) {
		super();
		this.name = name;
		this.department = department;
		this.educatedSubjects = educatedSubjects;
	}
	
	
	
}
