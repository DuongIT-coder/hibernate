package com.example.test_hibernate.controller;

import com.example.test_hibernate.entity.Employee;
import com.example.test_hibernate.service.EmployeeService;
import com.example.test_hibernate.service.IEmployee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUpdateEmployee", value = "/ServletUpdateEmployee")
public class ServletUpdateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("id"));
        IEmployee iEmployee= new EmployeeService();
        Employee employee= iEmployee.findById(id);
        request.setAttribute("employee",employee);
        request.getRequestDispatcher("updateEmployee.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String name=request.getParameter("name");
        int age= Integer.parseInt(request.getParameter("age"));
        IEmployee iEmployee = new EmployeeService();
        Employee employee= new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        iEmployee.update(employee);
        response.sendRedirect("ServletEmployee");
    }
}
