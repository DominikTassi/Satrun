package control;

import java.sql.SQLException;

import dao.InstructorDao;
import model.Instructor;

public class InstructorControl {
	private InstructorDao instructorDao = new InstructorDao();

	public InstructorControl(InstructorDao instructorDao) throws SQLException, ClassNotFoundException{
		super();
		this.instructorDao = instructorDao;
	}
	
	public void addInstructor(Instructor instructor) {
		instructorDao.addInstructor(instructor);
	}
}
