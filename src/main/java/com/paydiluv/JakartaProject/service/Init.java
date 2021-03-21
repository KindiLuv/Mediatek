package com.paydiluv.JakartaProject.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(value="/initializeResources", loadOnStartup=1)
public class Init extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("persistance.MediatekData");
            this.getServletContext().getRequestDispatcher("/login.jsp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}