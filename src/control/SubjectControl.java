package control;

import java.sql.SQLException;
import dao.SubjectDao;
import model.Subject;

public class SubjectControl {
	private SubjectDao subjectDao = new SubjectDao();
	
	public SubjectControl(SubjectDao subjectDao) throws ClassNotFoundException, SQLException{
		super();
		this.subjectDao = subjectDao;
	}
	
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}
	
	public void addCourseById(String id, String course) {
		subjectDao.addCourseBySubjectId(id, course);
	}
	
	public void deleteCourseById(String id, String course) {
		subjectDao.deleteCourseBySubjectId(id, course);
	}
	
}
