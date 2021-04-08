package spring.dao;

import spring.model.Student;

import java.util.List;

public interface StudentDAO {

    int insert(Student student);

    int change(Object key, Student updateStudent);

    int delete(Object key);

    Student getStudent(int studentId);

    List<Student> getStudents();
}
