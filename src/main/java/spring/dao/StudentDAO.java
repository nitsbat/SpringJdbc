package spring.dao;

import spring.model.Student;

public interface StudentDAO {

    int insert(Student student);

    int change(Object key, Student updateStudent);

    int delete(Object key);
}
