
import java.util.List;

public class Course {
	private Subject subject;
	private List<String> courses;
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public List<String> getCourse() {
		return courses;
	}
	public void setCourse(List<String> course) {
		this.courses = course;
	}

	public Course(Subject subject, List<String> course) {
		super();
		this.subject = subject;
		this.courses = course;
	}
	
	public void addCourse(String course) {
		courses.add(course);
	}
	
	public void deleteCourse(String course) {
		if(courses.contains(course)) {
			courses.remove(course);
		}else
			System.out.println("Didn't find any course with this name:" + course);
	}
	
	
	
}
