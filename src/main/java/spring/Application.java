package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.dao.StudentDAO;
import spring.dao.StudentDaoImpl;
import spring.model.Student;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        StudentDAO studentDAO = context.getBean("studentDao", StudentDaoImpl.class);

        Student student = new Student(33, "Nits", "Pune");

        int status = studentDAO.insert(student);
        System.out.println("Inserted record " + status + " row added");
    }
}
