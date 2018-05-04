package dao;

import model.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataBaseInit dataBaseInit = new DataBaseInit();
        SubjectDao subjectDao = new SubjectDao();

        System.out.println("test");
        List<String> courses= new ArrayList<>();
        courses.add("elso");
        courses.add("masodik");
        
        Subject subject = new Subject("GEAIL-351B", "Operacios rendszerek", courses);
        subjectDao.addSubject(subject);
        
        
    }
}