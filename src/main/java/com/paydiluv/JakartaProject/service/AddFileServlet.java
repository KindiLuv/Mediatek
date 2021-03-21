package com.paydiluv.JakartaProject.service;

import mediatek2021.Mediatek;
import mediatek2021.NewDocException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addFileServlet", value = "/add-file-servlet")
public class AddFileServlet extends HttpServlet {
    private static int fileId = 11;
    private Mediatek med;

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String title = request.getParameter("uname");
        String author = request.getParameter("auteur");
        int category = Integer.parseInt(request.getParameter("docCat"));

        //verification des donnees
        try {
            med.newDocument(category,title,author,fileId);
            fileId++;
        } catch (NewDocException e) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher("/AddForm.jsp").forward( request, response);
    }
}
