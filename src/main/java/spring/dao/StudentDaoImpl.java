package spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import spring.model.Student;

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
}
