package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import model.Department;

public class DepartmentDao extends DataBaseInit{
	
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    
    public DepartmentDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    public Department getDepartmentByName(String name) {
    	Department department = null;
    	int departmentId = 0;
    	String departmentName = "";
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM Department WHERE DepartmentName = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	departmentId = rs.getInt("DepartmentId");
            	departmentName = rs.getString("DepartmentName");
            }
            department = new Department(departmentName);
            department.setDepartmentId(departmentId);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    	return department;
    }
    
}
