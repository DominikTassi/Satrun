
public class Subject {
	private String SubjectId;
	private String name;	
	private Course courses;
		
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSubjectId() {
		return SubjectId;
	}
	public void setSubjectId(String subjectId) {
		SubjectId = subjectId;
	}
	public Subject(String subjectId, String name, Course courses) {
		super();
		SubjectId = subjectId;
		this.name = name;
		this.courses = courses;
	}
	
	
}
