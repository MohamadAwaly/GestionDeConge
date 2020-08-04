package com.atc.momo.Jiwaii.servlets;

import model.CalendarTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "Accueil" )
public class Accueil extends HttpServlet {
    public static final String VUE = "/resources/view/accueil.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        request.setAttribute("calendar", CalendarTools.getAWeek());
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
