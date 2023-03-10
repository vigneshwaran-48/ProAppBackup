package com.servlets;

import java.io.IOException;
import java.sql.Connection;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databasesdriver.AddTaskToDb;

@MultipartConfig
public class AddTask extends HttpServlet{

    @Override
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.getRequestDispatcher("/assets/html/404.html").forward(req,resp);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection con=(Connection)getServletContext().getAttribute("Connection");
        try {
            response.getWriter().print(new AddTaskToDb().taskAdd(con, request, response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
