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
    
    public void addStudent(Student student) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Subject (StudentId, StudentName, Seminar) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getSeminar());
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
