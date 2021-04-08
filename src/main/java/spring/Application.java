package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);

        System.out.println("Successful");

        String query = "insert into student values(?,?,?)";

        int update = jdbcTemplate.update(query, 116, "Pragya", "Goa");
        System.out.println("Inserted record " + update + " row added");
    }
}
