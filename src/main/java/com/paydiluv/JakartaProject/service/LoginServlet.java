package com.paydiluv.JakartaProject.service;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("uname");
        String password = request.getParameter("pwd");

        //verification des donnees
        // if Madiatek.getUser(username, password);

        PrintWriter writer = response.getWriter();
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: " + username + "</h2>";
        htmlRespone += "</html>";

        writer.println(htmlRespone);
    }

    public void destroy() {
    }
}