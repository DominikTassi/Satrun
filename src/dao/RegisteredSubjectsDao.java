package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import model.RegisteredSubjects;
import model.Student;

public class RegisteredSubjectsDao extends DataBaseInit {
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    
    public RegisteredSubjectsDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    public void RegisterSubjectToStudent(String subjectId, String studentId, String course) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO RegisteredSubjects (SubjectId, StudentId, Course) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subjectId);
            ps.setString(2, studentId);
            ps.setString(3, course);
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
    
    public void AddMarkToStudent(String studentId, String SubjectId, int mark) {
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "UPDATE RegisteredSubjects SET Mark = (?) WHERE SubjectId = (?) AND StudentId = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, mark);
            ps.setString(2, SubjectId);
            ps.setString(3, studentId);
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
    
    public double StudentGradepoint(String studentId) {
		double gradepoint = 0.0;
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT AVG(Mark) FROM RegisteredSubjects WHERE StudentId = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, studentId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	gradepoint = rs.getDouble("AVG(Mark)");
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
    	return gradepoint;
    }
    
    public double CourseGradepoint(String course) {
		double gradepoint = 0.0;
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT AVG(Mark) FROM RegisteredSubjects WHERE Course = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	gradepoint = rs.getDouble("AVG(Mark)");
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
    	return gradepoint;
    }
    
}
