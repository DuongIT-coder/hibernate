package com.example.test_hibernate.service;

import com.example.test_hibernate.entity.Employee;

import java.util.List;

public interface IEmployee {
    void insert(Employee employee);
    List<Employee> getAll();
    Employee findById(long id);
    void deleteById(long id);
    void update(Employee employee);
}
