package dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    protected static String url = "jdbc:sqlite:/home/dominik/eclipse-workspace/Saturn2/Satrun/SaturnDB.db";
    private static DataBaseInit instance = null;

    public DataBaseInit(){
        createDataBase();
    }

    public static DataBaseInit getInstance() {
        if (instance == null) {
            synchronized (DataBaseInit.class) {
                if (instance == null) {
                    instance = new DataBaseInit();
                }
            }
        }
        return instance;
    }

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection(url);
        connection.setAutoCommit(false);
        return connection;
    }

    private static void createDataBase(){
        File file = new File("/home/dominik/eclipse-workspace/Saturn2/Satrun/SaturnDB.db");
        if (file.exists() && !file.isDirectory()) {
            System.out.println("Database already created");
            return;
        }
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /*
        Creating the database
         */

        try(Connection connection = DriverManager.getConnection(url)) {
            connection.setAutoCommit(false);
            if(connection != null){
                Statement statement = connection.createStatement();

                String sql = "CREATE TABLE Subject(" +
                        "   SubjectId CHAR(255)," +
                        "   SubjectName CHAR(255)," +
                        "   Course CHAR(255)" +
                        ");";
                statement.execute(sql);


                sql = "CREATE TABLE Instructor(" +
                        "   InstructorId INT," +
                        "   InstructorName CHAR(255) NOT NULL," +
                        "   DepartmentName CHAR(255) NOT NULL," +
                        "   EducatedSubjectsId CHAR(255)" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Student(" +
                        "   StudentId CHAR(255)NOT NULL," +
                        "   StudentName CHAR(255) NOT NULL," +
                        "	Seminar CHAR(255)" +
                        ");";
                statement.execute(sql);
                
                sql = "CREATE TABLE RegisteredSubjects(" +
                		"	RegisteredSubjectId INT," +
                		"	StudentId CHAR(255) NOT NULL," +
                		"	SubjectId CHAR(255) NOT NULL," +
                		"	Mark INT DEFAULT 1," +
                		"	Course VARCHAR(255) NOT NULL" +
                		");";
                statement.execute(sql);
                
                System.out.println("Database created");
                connection.commit();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getConnectionString(){
        return url;
    }
}