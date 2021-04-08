package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import spring.dao.StudentDAO;
import spring.dao.StudentDaoImpl;

import javax.sql.DataSource;

@Configuration
public class JavaConfiguration {

    @Bean(name = {"jdbcTemplate"})
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }

    @Bean(name = {"ds"})
    public DataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/springjdbc?useSSL=false");
        source.setUsername("root");
        source.setPassword("root");
        return source;
    }

    @Bean(name = "studentDao")
    public StudentDAO getStudentDao() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setJdbcTemplate(getJdbcTemplate());
        return studentDao;
    }
}
