package dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseInit {
    protected static String url = "jdbc:sqlite:./database/" + "SaturnDB";
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
        File file = new File("./database/SaturnDB");
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
                String sql = "CREATE TABLE Department\n" +
                        "(\n" +
                        "    DepartmentId INT PRIMARY KEY NOT NULL AUTOINCREMENT,\n" +
                        "    DepartmentName VARCHAR(255) NOT NULL\n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Subject(" +
                        "   SubjectId VARCHAR(255) PRIMARY KEY," +
                        "   SubjectName VARCHAR(255)," +
                        "   Courses VARCHAR(255)\n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Mark(" +
                        "   MarkId INT NOT NULL AUTOINCREMENT," +
                        "   SubjectId INT NOT NULL \n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Instructor(" +
                        "   InstructorId INT NOT NULL AUTOINCREMENT," +
                        "   InstructorName VARCHAR(255)," +
                        "   DepartmentId INT NOT NULL," +
                        "   EducatedSubjects VARCHAR(255) \n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Student(" +
                        "   StudentId VARCHAR(255) PRIMARY KEY NOT NULL," +
                        "   StudentName VARCHAR(255) PRIMARY KEY NOT NULL" +
                        "   Subjects VARCHAR(255)," +
                        "   Marks VARCHAR(255) \n" +
                        ");";
                statement.execute(sql);

                sql = "CREATE TABLE Seminar(" +
                        "   SeminarId INT NOT NULL AUTOINCREMENT," +
                        "   SeminarName VARCHAR(255)," +
                        "   Students VARCHAR(255) \n" +
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