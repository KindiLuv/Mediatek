package com.paydiluv.JakartaProject.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addFileServlet", value = "/add-file-servlet")
public class AddFileServlet extends HttpServlet {
    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String title = request.getParameter("uname");
        String author = request.getParameter("auteur");
        Integer category = Integer.parseInt(request.getParameter("docCat"));

        //verification des donnees
        // if Mediatek.getUser(username, password);

        this.getServletContext().getRequestDispatcher("/AddForm.jsp").forward( request, response);
    }
}
