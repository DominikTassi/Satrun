package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Instructor;

public class InstructorDao extends DataBaseInit{
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    
    public InstructorDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    
    public void addInstructor(Instructor instructor) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            for (int j = 0; j < instructor.getEducatedSubjects().size() ; j++) {
				String sql = "INSERT INTO Instructor (InstructorName, DepartmentName, EducatedSubjectsId) VALUES(?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, instructor.getName());
				ps.setString(2, instructor.getDepartmnet());
				ps.setString(3, instructor.getEducatedSubjects().get(j).getSubjectId());
				ps.executeUpdate();
			}
			connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }
}
