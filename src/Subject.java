import java.util.List;

public class Subject {
	private String SubjectId;
	private String name;	
	private List<String> courses;
	
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	public void addCourse(String course) {
		if(!courses.contains(course))
			courses.add(course);
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
	public Subject(String subjectId, String name, List<String> courses) {
		super();
		SubjectId = subjectId;
		this.name = name;
		this.courses = courses;
	}
	
	
}
