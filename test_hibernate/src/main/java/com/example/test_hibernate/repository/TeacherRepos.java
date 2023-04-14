package com.example.test_hibernate.repository;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.entity.Teacher;
import com.example.test_hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepos {
    HibernateUtil hibernateUtil = new HibernateUtil();
    public List<Teacher> getAll(){
        List<Teacher> teacherList = new ArrayList<>();
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction= session.beginTransaction();
            teacherList =  session.createQuery("from Teacher ").getResultList();
            session.close();
            return teacherList;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return teacherList;
        }
    }
    public void insert(Teacher teacher){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public void update(Teacher teacher) {
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(teacher);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
    }
    public Teacher findById(long id){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Teacher teacher = session.get(Teacher.class, id);
            transaction.commit();
            session.close();
            return teacher;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteById(long id){
        Transaction transaction = null;
        Session session = hibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Teacher teacher= session.find(Teacher.class,id);
            session.remove(teacher);
            transaction.commit();
            session.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    }
