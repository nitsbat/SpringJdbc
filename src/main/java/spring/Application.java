package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.config.JavaConfiguration;
import spring.dao.StudentDAO;
import spring.dao.StudentDaoImpl;
import spring.model.Student;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentDAO studentDAO = context.getBean("studentDaoImpl", StudentDaoImpl.class);

        Student student = studentDAO.getStudent(113);
        System.out.println("Single Record - " + student);

        List<Student> studentList = studentDAO.getStudents();
        System.out.println("\nList of person belong to city delhi");
        studentList.forEach(System.out::println);

    }
}
