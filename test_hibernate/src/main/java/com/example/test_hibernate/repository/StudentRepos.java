package com.example.test_hibernate.repository;

import com.example.test_hibernate.entity.Student;
import com.example.test_hibernate.entity.Teacher;
import com.example.test_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentRepos {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public List<Student> getAll(){
        List<Student> studentList = new ArrayList<>();
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction= session.beginTransaction();
            studentList =  session.createQuery("from Student ").getResultList();
            session.close();
            return studentList;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return studentList;
        }
    }
    public void insert(Student student){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public void update(Student student) {
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(student);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public Student findById(long id){
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Student student = session.get(Student.class, id);
            transaction.commit();
            session.close();
            return student;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteById(long id){
        Transaction transaction = null;
        HibernateUtil hibernateUtil = new HibernateUtil();
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Student student= session.find(Student.class,id);
            session.remove(student);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentRepos studentRepos = new StudentRepos();
       /* List<Student> studentList= studentRepos.getAll();
        for (int i = 0; i < studentList.size(); i++){
            System.out.println(studentList.indexOf(i));
        }
        */
        Student student= new Student();
        student.setName("duong");
        Teacher teacher= new Teacher("ict");
        Teacher teacher1= new Teacher("niit");
        Set<Teacher> teachers= new HashSet<>();
        teachers.add(teacher);
        teachers.add(teacher1);
        student.setTeachers(teachers);
        studentRepos.insert(student);
    }
}
