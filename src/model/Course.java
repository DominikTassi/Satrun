package model;
public class Course {
	private Subject subject;
	private String name;
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course(Subject subject, String name) {
		super();
		this.subject = subject;
		this.name = name;
	}
	
	
}
