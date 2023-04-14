package com.example.test_hibernate.controller;

import com.example.test_hibernate.service.EmployeeService;
import com.example.test_hibernate.service.IEmployee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteEmployee", value = "/ServletDeleteEmployee")
public class ServletDeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        IEmployee iEmployee= new EmployeeService();
        iEmployee.deleteById(id);
        response.sendRedirect("ServletEmployee");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
