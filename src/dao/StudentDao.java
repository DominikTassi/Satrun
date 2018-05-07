package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Student;

public class StudentDao extends DataBaseInit{
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    
    public StudentDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    public void addStudent(String studentId, String studentName, String seminar) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Subject (StudentId, StudentName, Seminar) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, seminar);
            ps.executeUpdate();
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
