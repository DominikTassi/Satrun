package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import model.Seminar;
import model.Student;

public class SeminarDao extends DataBaseInit {
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;
    
    public SeminarDao() throws SQLException, ClassNotFoundException{
    	DataBaseInit.getInstance();
    }
    
    public Seminar getSeminarByName(String name) {
    	Seminar seminar = null;
    	String studentsList = "";
    	List<String> studentKeyList = new ArrayList<String>();
    	List<Student> students = new ArrayList<Student>();
    	
    	 try{
             Class.forName("org.sqlite.JDBC");
             connection = DriverManager.getConnection(url);
             connection.setAutoCommit(false);
             String sql = "SELECT * FROM Seminar WHERE SeminarName = (?)";
             PreparedStatement ps = connection.prepareStatement(sql);
             ps.setString(1,name);
             ResultSet rs = ps.executeQuery();
             if(rs.next()){
             	studentsList = rs.getString("Students");
             }
             StringTokenizer st = new StringTokenizer(studentsList, ",");
             while (st.hasMoreTokens()){
             	studentKeyList.add(st.nextToken());
             }
             
             for(int i = 0; i <= studentKeyList.size(); i++) {
            	 sql = "SELECT * FROM Student WHERE StudentId = (?)";
            	 PreparedStatement psStudent = connection.prepareStatement(sql);
                 ps.setString(1, studentKeyList.get(i));
                 ResultSet rsStudent = psStudent.executeQuery();
                 if(rsStudent.next()){
                 	//TODO
                 }
             }
            
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
    	return seminar;
    }
}
