package com.servlet;

import com.dao.Daodemo;

import java.io.IOException;


public class ListStudentServlet extends javax.servlet.http.HttpServlet {
    private Daodemo dao=new Daodemo();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
                doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("students", dao.getAll());
      request.getRequestDispatcher("/Student.jsp").forward(request,response);

    }
}
