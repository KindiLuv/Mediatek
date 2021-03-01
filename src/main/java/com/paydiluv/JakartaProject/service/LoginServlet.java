package com.paydiluv.JakartaProject.service;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("titre");
        String password = request.getParameter("pwd");

        //verification des donnees
        // if Mediatek.getUser(username, password);

        this.getServletContext().getRequestDispatcher("/AddForm.jsp").forward( request, response);
    }

    public void destroy() {
    }
}