package control;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import dao.StudentDao;
import model.Student;



public class StudentControl {
	private StudentDao studentDao = new StudentDao();

	public StudentControl(StudentDao studentDao) throws SQLException, ClassNotFoundException {
		super();
		this.studentDao = studentDao;
	}
	
	
	
	public void addStudent(String studentId, String studentName, String seminar) {
		studentDao.addStudent(studentId, studentName, seminar);
	}
}