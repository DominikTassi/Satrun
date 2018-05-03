package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import model.Subject;


public class SubjectDao extends DataBaseInit{
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    
    public SubjectDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    public Subject getSubject(String name) {
        Subject subject = null;
        String subjectId = "";
        String subjectName = "";
        String coursesList = "";
        List<String> courses = new ArrayList<String>();

        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM Subject WHERE SubjectName = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	subjectId = rs.getString("SubjectId");
            	subjectName = rs.getString("SubjectName");
            	coursesList = rs.getString("Courses");
            }
            StringTokenizer st = new StringTokenizer(coursesList, ",");
            while (st.hasMoreTokens()){
            	courses.add(st.nextToken());
            }
            subject = new Subject(subjectId, subjectName, courses);
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
        return subject;
    }
    
    
    public void addSubject(String subjectId, String subjectName, List<String> courses){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "INSERT INTO Subject (SubjectId, SubjectName, Courses) VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, subjectId);
            ps.setString(2, subjectName);
            String coursesList = "";
            for(int i = 0; i <= courses.size(); i++) {
            	if(i < courses.size()) 
            		coursesList += courses.get(i) + ",";
            	
            	if(i == courses.size())
            		coursesList += courses.get(i);
            }
            ps.setString(3, coursesList);
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
    
    
    public void addCourseToSubject(String subjectName, String course){
    	String courses = "";
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            
            String sqlSelect = "SELECT * FROM Subject WHERE SubjectName = (?)";
            PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
            psSelect.setString(1, subjectName);
            
            ResultSet rsSelect = psSelect.executeQuery();
            if(rsSelect.next()){
            	courses = rsSelect.getString("Courses");
            }
            
            String sqlUpdate = "UPDATE Subject SET Courses = (?) WHERE SubjectName = (?)";
            PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate);
            psUpdate.setString(1, courses+","+course);
            psUpdate.setString(2, subjectName);
            psUpdate.executeUpdate();
           
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
    
    public void deleteCourseFromSubject(String subjectName, String course){
    	String courses = "";
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            
            String sqlSelect = "SELECT * FROM Subject WHERE SubjectName = (?)";
            PreparedStatement psSelect = connection.prepareStatement(sqlSelect);
            psSelect.setString(1, subjectName);
            
            ResultSet rsSelect = psSelect.executeQuery();
            if(rsSelect.next()){
            	courses = rsSelect.getString("Courses");
            }
            
            String coursesList = "";
            StringTokenizer st = new StringTokenizer(courses, ",");
            while (st.hasMoreTokens()){
            	if(!st.nextToken().equals(course))
            		coursesList += st.nextToken() + ",";
            }
            
            if(coursesList.endsWith(",")) {
            	coursesList.substring(coursesList.length()-1, coursesList.length());
            }
            
            
            String sqlUpdate = "UPDATE Subject SET Courses = (?) WHERE SubjectName = (?)";
            PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate);
            psUpdate.setString(1, courses+","+course);
            psUpdate.setString(2, subjectName);
            psUpdate.executeUpdate();
           
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
