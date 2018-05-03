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
}
