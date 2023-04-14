package com.example.test_hibernate.controller;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.service.EmployeeService;
import com.example.test_hibernate.service.IEmployee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletEmployee", value = "/ServletEmployee")
public class ServletEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IEmployee iEmployee = new EmployeeService();
        List<Employee> employeeList= iEmployee.getAll();
        request.setAttribute("employee_list",employeeList);
        request.getRequestDispatcher("employee.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
