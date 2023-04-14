package com.example.test_hibernate.util;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.entity.Student;
import com.example.test_hibernate.entity.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory(){
        try{
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
            properties.put(Environment.URL,"jdbc:mysql://localhost:3306/test_hibernate?useSSL=false");
            properties.put(Environment.USER,"root");
            properties.put(Environment.PASS,"duongbarber1");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
            properties.put(Environment.SHOW_SQL,"true");
            properties.put(Environment.HBM2DDL_AUTO,"update");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Student.class);
            ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory= configuration.buildSessionFactory(registry);
            return sessionFactory;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
