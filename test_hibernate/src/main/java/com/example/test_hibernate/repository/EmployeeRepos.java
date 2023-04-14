package com.example.test_hibernate.repository;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepos {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public void insert(Employee employee){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public void update(Employee employee){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction= session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }

    }
    public List<Employee> getAll(){
        List<Employee> employeeList = new ArrayList<>();
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction= session.beginTransaction();
            employeeList =  session.createQuery("from Employee").getResultList();
            session.close();
            return employeeList;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return employeeList;
        }
    }
    public Employee findById(long id){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            transaction.commit();
            session.close();
            return employee;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
   public void deleteById(long id) {
       Transaction transaction = null;
       Session session = hibernateUtil.getSessionFactory().openSession();
       try {
           transaction = session.beginTransaction();
           Employee employee = session.find(Employee.class, id);
           session.remove(employee);
           transaction.commit();
           session.close();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
}
