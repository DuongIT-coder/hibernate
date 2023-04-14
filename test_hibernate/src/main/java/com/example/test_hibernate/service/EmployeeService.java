package com.example.test_hibernate.service;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.repository.EmployeeRepos;

import java.util.List;

public class EmployeeService implements IEmployee{
    EmployeeRepos employeeRepos = new EmployeeRepos();
    @Override
    public void insert(Employee employee) {
        employeeRepos.insert(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepos.getAll();
    }

    @Override
    public Employee findById(long id) {
        return employeeRepos.findById(id);
    }

    @Override
    public void deleteById(long id) {
        employeeRepos.deleteById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeRepos.update(employee);
    }
}
