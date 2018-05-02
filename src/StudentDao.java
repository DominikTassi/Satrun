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
    	List<Subject> students = new ArrayList<Subject>();
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
    	
    	return student;
    }
}