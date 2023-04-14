package com.example.test_hibernate.controller;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.service.EmployeeService;
import com.example.test_hibernate.service.IEmployee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAddNewEmployee", value = "/ServletAddNewEmployee")
public class ServletAddNewEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addNew.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        Employee employee= new Employee();
        employee.setName(name);
        employee.setAge(age);
        IEmployee iEmployee= new EmployeeService();
        iEmployee.insert(employee);
        response.sendRedirect("ServletEmployee");
    }
}
