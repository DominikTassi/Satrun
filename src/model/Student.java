package model;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private List<Subject> subjects;
	private List<Mark> marks;
	private List<Course> courses;
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
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
	public List<Mark> getMarks() {
		return marks;
	}
	public void setMarks(List<Mark> marks) {
		this.marks = marks;
	}
	
	
	public void addMarkBySubjectname(String subjectName, int mark) {
		for (int i = 0; i < subjects.size(); i++) {
			if(subjects.get(i).getName().equals(subjectName)) {
				marks.add(new Mark(subjects.get(i), mark));
			}
		}
	}
	public Student(String id, String name, List<Subject> subjects, List<Mark> marks, List<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.subjects = subjects;
		this.marks = marks;
		this.courses = courses;
	}
	
	


	
	
}
