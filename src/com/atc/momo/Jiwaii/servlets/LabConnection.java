package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.beans.LabConnectionForm;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LabConnection")
public class LabConnection extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LabConnectionForm form = new LabConnectionForm();
        PersonnesEntity utilisateur = form.ConnecterUtilisateur(request);
        HttpSession session = request.getSession();

        request.setAttribute("form",form);
        request.setAttribute("utilisateur",utilisateur);

        this.getServletContext().getRequestDispatcher("/WEB-INF/LabConnection.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/WEB-INF/LabConnection.jsp" ).forward( request, response );
    }
}
