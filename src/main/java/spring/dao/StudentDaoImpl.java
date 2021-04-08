package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.model.Student;

import java.util.List;

@Component
public class StudentDaoImpl implements StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student values(?,?,?)";
        return jdbcTemplate
                .update(query, student.getId(), student.getName(), student.getCity());
    }

    @Override
    public int change(Object key, Student updateStudent) {
        String query = "update student set name=? , city=? where id =?";
        return jdbcTemplate
                .update(query, updateStudent.getName(), updateStudent.getCity(), key);
    }

    @Override
    public int delete(Object key) {
        String query = "delete from student where id =?";
        return jdbcTemplate
                .update(query, key);
    }

    @Override
    public Student getStudent(int studentId) {
        String query = "select * from student where id=?";
        return jdbcTemplate.queryForObject(query, new RowMapperImpl(), studentId);
    }

    @Override
    public List<Student> getStudents() {
        String query = "select * from student where city=?";
        return jdbcTemplate.query(query, new RowMapperImpl(), "Delhi");
    }
}
