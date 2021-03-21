package com.paydiluv.JakartaProject.service;

import mediatek2021.Document;
import mediatek2021.Mediatek;
import mediatek2021.SuppressException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "removeFileServlet", value = "/remove-file-servlet")
public class RemoveDocServlet extends HttpServlet {
    private Mediatek med;

    public RemoveDocServlet(Mediatek med) {
        this.med = med;
    }

    public void init(){}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int idToDel = Integer.parseInt(request.getParameter("idToDel"));

        try {
            med.suppressDoc(idToDel);
        } catch (SuppressException e) {
            e.printStackTrace();
        }
        this.getServletContext().getRequestDispatcher("/AddForm.jsp").forward( request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        int category = Integer.parseInt(request.getParameter("docCat"));

        List<Document> l = med.catalogue(category);
        for (Document d: l) {
            try {
                response.getWriter().println("<b>" + Arrays.toString(d.data()) + "</br>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
