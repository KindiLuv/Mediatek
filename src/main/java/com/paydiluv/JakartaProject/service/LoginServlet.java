package com.paydiluv.JakartaProject.service;

import com.paydiluv.JakartaProject.persistant.MediatekData;
import mediatek2021.Mediatek;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    private Mediatek med;
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("titre");
        String password = request.getParameter("pwd");

        if(med.getUser(username, password) == null){
            this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }else {
            this.getServletContext().getRequestDispatcher("/AddForm.jsp").forward(request, response);
        }
    }
}
