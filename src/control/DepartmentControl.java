package control;

import java.sql.SQLException;

import dao.DepartmentDao;
import model.Department;

public class DepartmentControl{
	private DepartmentDao departmentDao = new DepartmentDao();

	public DepartmentControl(DepartmentDao departmentDao) throws ClassNotFoundException, SQLException {
		super();
		this.departmentDao = departmentDao;
	}

	public Department getDepartmentByName(String name) {
		return departmentDao.getDepartmentByName(name);
	}
	
}
