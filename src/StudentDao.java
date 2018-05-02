import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StudentDao extends DataBaseInit{
	
	private Connection connection = openConnection();
    private String url = DataBaseInit.url;

    public StudentDao() throws SQLException, ClassNotFoundException {
        DataBaseInit.getInstance();
    }
    
    public Student getStudentById(String id) {
    	Student student = null;
    	String studentName = "";
    	String subjectList = "";
    	List<Subject> subjects = new ArrayList<Subject>();
    	String markList = "";
    	List<Mark> marks = new ArrayList<Mark>();
    	
    	try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(url);
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM Student WHERE StudentId = (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	studentName = rs.getString("StudentName");
            	subjectList = rs.getString("Subjects");
            	markList = rs.getString("Marks");
            }
            StringTokenizer stSubjects = new StringTokenizer(subjectList, ",");
            while (stSubjects.hasMoreTokens()){
            	String sqlSubject = "SELECT * FROM Subject WHERE SubjectId = (?)";
            	PreparedStatement psSubject = connection.prepareStatement(sqlSubject);
            	psSubject.setString(1,stSubjects.nextToken());
            	ResultSet rsSubject = psSubject.executeQuery();
            	
            	String subjectId = "";
            	String subjectName = "";
            	String coursesList = "";
            	List<String> courses = new ArrayList<String>();
            	
            	if(rs.next()) {
            		subjectId = rsSubject.getString("SubjectId");
            		subjectName = rsSubject.getString("SubjectName");
            		coursesList = rsSubject.getString("Courses");
            	}
            	StringTokenizer stCourses = new StringTokenizer(coursesList, ",");
                while (stCourses.hasMoreTokens()){
                	courses.add(stCourses.nextToken());
                }
                subjects.add(new Subject(subjectId, subjectName, courses));
            }
            
            StringTokenizer stMarks = new StringTokenizer(markList, ",");
            while(stMarks.hasMoreTokens()) {
            	String sqlMark = "SELECT * FROM Mark WHERE MarkId = (?)";
            	PreparedStatement psMark = connection.prepareStatement(sqlMark);
            	psMark.setString(1, stMarks.nextToken());
            	ResultSet rsMark = psMark.executeQuery();
            	
            	
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
    	
    	return student;
    }
}