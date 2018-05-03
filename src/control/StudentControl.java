package control;

import java.sql.SQLException;

import dao.StudentDao;
import model.Student;

public class StudentControl {
	private StudentDao studentDao = new StudentDao();

	public StudentControl(StudentDao studentDao) throws SQLException, ClassNotFoundException {
		super();
		this.studentDao = studentDao;
	}
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
}
