package dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    protected static String url = "jdbc:sqlite:/home/dominik/eclipse-workspace/Saturn2/SaturnDB.db";
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
        File file = new File("/home/dominik/eclipse-workspace/Saturn2/SaturnDB.db");
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
                        "   SubjectId VARCHAR(255)," +
                        "   SubjectName VARCHAR(255)," +
                        "   Courses VARCHAR(255)" +
                        ");";
                statement.execute(sql);


                sql = "CREATE TABLE Instructor(" +
                        "   InstructorId INTEGER AUTOINCREMENT," +
                        "   InstructorName VARCHAR(255) NOT NULL," +
                        "   DepartmentName VARCHAR(255) NOT NULL," +
                        "   EducatedSubjectsId VARCHAR(255)" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Student(" +
                        "   StudentId VARCHAR(255)NOT NULL," +
                        "   StudentName VARCHAR(255) PRIMARY KEY NOT NULL," +
                        "	Seminar VARCHAR(255)" +
                        ");";
                statement.execute(sql);
                
                sql = "CREATE TABLE RegisteredSubjects(" +
                		"	RegisteredSubjectId INTEGER AUTOINCREMENT," +
                		"	StudentId VARCHAR(255) NOT NULL" +
                		"	SubjectId VARCHAR(255) NOT NULL," +
                		"	Mark INTEGER DEFAULT 1," +
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