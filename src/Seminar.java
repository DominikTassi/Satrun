import java.util.List;

public class Seminar {
	private String name;
	private List<Student> students;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Seminar(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}
	
	public float gradePointAverage() {
		float sum = 0;
		for(int i = 0; i <= students.size(); i++) {
			float sumForStudent = 0;
			for (int j = 0; j < students.get(i).getMarks().size(); j++) {				
				sumForStudent += students.get(i).getMarks().get(j).getMark();
			}
			float avg = sumForStudent / students.get(i).getMarks().size();
			sum+=avg;
		}		
		return sum/students.size();
	}
	
	
}
