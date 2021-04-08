package spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import spring.model.Student;

import java.util.List;

public class StudentDaoImpl implements StudentDAO {

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
        Student student = jdbcTemplate.queryForObject(query, new RowMapperImpl(), studentId);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        String query = "select * from student where city=?";
        List<Student> studentList = jdbcTemplate.query(query, new RowMapperImpl(), "Delhi");
        return studentList;
    }
}
