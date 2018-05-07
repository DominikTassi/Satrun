package dao;

import model.RegisteredSubjects;
import model.Student;
import model.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataBaseInit dataBaseInit = new DataBaseInit();
        SubjectDao subjectDao = new SubjectDao();
        StudentDao studentDao = new StudentDao();
        RegisteredSubjectsDao registeredSubjectsDao = new RegisteredSubjectsDao();
        
        System.out.println("test");
        List<String> courses= new ArrayList<>();
        courses.add("elso");
        courses.add("masodik");
        
        Subject subject = new Subject("GEAIL-351B", "Operacios rendszerek", courses);
        subjectDao.addSubject(subject);
        
        
        Subject subject2 = new Subject("GEAIL-123C", "Java", courses);
        
        subjectDao.addSubject(subject2);
        
        RegisteredSubjects felvett1 = new RegisteredSubjects(subject, 2, "elso");
        RegisteredSubjects felvett2 = new RegisteredSubjects(subject2, 5, "masodik");
        
        
        
        List<RegisteredSubjects> registered = new ArrayList<>();
        registered.add(felvett1);
        registered.add(felvett2);
        
        
        
        
        Student student = new Student("QLNW5K", "Tassi Dominik",registered ,"BI3");
        
        studentDao.addStudent(student.getId(), student.getName(), student.getSeminar());
        
        
        registeredSubjectsDao.RegisterSubjectToStudent(subject.getSubjectId(), student.getId(), felvett1.getCourse());
        registeredSubjectsDao.RegisterSubjectToStudent(subject2.getSubjectId(), student.getId(), felvett1.getCourse());
        
        registeredSubjectsDao.AddMarkToStudent(student.getId(), subject.getSubjectId(), 2);

        registeredSubjectsDao.AddMarkToStudent(student.getId(), subject2.getSubjectId(), 5);
        System.out.println(registeredSubjectsDao.StudentGradepoint("QLNW5K"));
        
        
        
    }
}