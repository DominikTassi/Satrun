package control;


import java.sql.SQLException;

import dao.RegisteredSubjectsDao;
import dao.SubjectDao;
import model.RegisteredSubjects;

public class RegisteredSubjectsControl {
	private RegisteredSubjectsDao registeredSubjectsDao = new RegisteredSubjectsDao();

	public RegisteredSubjectsControl(RegisteredSubjectsDao registeredSubjectsDao) throws SQLException, ClassNotFoundException {
		super();
		this.registeredSubjectsDao = registeredSubjectsDao;
	}
	
	public void RegisterSubjectToStudent(String subjectId, String studentId, String course) {
		registeredSubjectsDao.RegisterSubjectToStudent(subjectId, studentId, course);
	}
	
	public void AddMarkToStudent(String studentId, String SubjectId, int mark) {
		registeredSubjectsDao.AddMarkToStudent(studentId, SubjectId, mark);
	}
	
	public double StudentGradepoint(String studentId) {
		return registeredSubjectsDao.StudentGradepoint(studentId);
	}
	
	
	 public double CourseGradepoint(String course) {
		 return registeredSubjectsDao.CourseGradepoint(course);
	 }
	
}
 