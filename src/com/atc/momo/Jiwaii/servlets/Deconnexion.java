package com.atc.momo.Jiwaii.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet( name = "/Deconnexion" )
public class Deconnexion extends HttpServlet {
    public static final String URL_REDIRECTION = "/GestionDeConge_war_exploded/seconnecter";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Redirection vers la page de connexion ! */
        response.sendRedirect( URL_REDIRECTION );

    }
}
