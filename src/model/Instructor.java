package model;
import java.util.List;

public class Instructor {
	private int instructorId;
	private String name;
	private List<Subject> educatedSubjects;
	private String departmnet;
	
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

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getDepartmnet() {
		return departmnet;
	}

	public void setDepartmnet(String departmnet) {
		this.departmnet = departmnet;
	}

	public Instructor(int instructorId, String name, List<Subject> educatedSubjects, String departmnet) {
		super();
		this.instructorId = instructorId;
		this.name = name;
		this.educatedSubjects = educatedSubjects;
		this.departmnet = departmnet;
	}


	
	
	
	
}
