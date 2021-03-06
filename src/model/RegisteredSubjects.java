package model;

public class RegisteredSubjects {
	private int RegisteredSubjectId;
	private Subject subject;
	private int mark;
	private String course;
	
	
	public int getRegisteredSubjectId() {
		return RegisteredSubjectId;
	}
	public void setRegisteredSubjectId(int registeredSubjectId) {
		RegisteredSubjectId = registeredSubjectId;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public RegisteredSubjects(Subject subject, int mark, String course) {
		super();
		this.subject = subject;
		this.mark = mark;
		this.course = course;
	}
	
	
	
}
