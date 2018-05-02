import java.util.List;

public class Subject {
	private String SubjectId;
	private String name;	
	private List<Course> courses;
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public Course getCourseByName(String name) {
		boolean con = true;
		int i = 0;
		while (con) {
			if(courses.get(i).getName().equals(name)) {
				return courses.get(i);
			}
			i++;
		}
		return null;
	}
	
	public void addCourse(String course) {
		if(!courses.contains(getCourseByName(course)));
			courses.add(new Course(course));
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
	public Subject(String subjectId, String name, List<Course> courses) {
		super();
		SubjectId = subjectId;
		this.name = name;
		this.courses = courses;
	}
	
	
}
