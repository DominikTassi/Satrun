package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import model.Subject;
public class SubjectDao extends DataBaseInit{
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    
    public SubjectDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    
    public void addSubject(Subject subject) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            for(int i = 0; i < subject.getCourses().size(); i++) {
            	String sql = "INSERT INTO Subject (SubjectId, SubjectName, Courses) VALUES(?, ?, ?)";
            	PreparedStatement ps = connection.prepareStatement(sql);
            	ps.setString(1, subject.getSubjectId());
            	ps.setString(2, subject.getName());
            	ps.setString(3, subject.getCourses().get(i));
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
