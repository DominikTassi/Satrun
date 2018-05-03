package model;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private List<RegisteredSubjects> subjects = new ArrayList<>();
	private String seminar;
	
	public String getSeminar() {
		return seminar;
	}
	public void setSeminar(String seminar) {
		this.seminar = seminar;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RegisteredSubjects> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<RegisteredSubjects> subjects) {
		this.subjects = subjects;
	}
	public Student(String id, String name, List<RegisteredSubjects> subjects, String seminar) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.seminar = seminar;
	}
	

	


	
	
}
