package com.atc.momo.Jiwaii.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "/Login" )
public class Login extends HttpServlet {

    public static final String emailUser      = "email";
    public static final String motDePasseUser = "pass";
    public static final String VUE_LOGIN      = "/resources/view/connexion.jsp";
    public static final String VUE            = "/resources/view/accueil.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /**
         * Récupération des données saisie, envoyées en temt que paramètre de la requête Post
         * générer a la validation du formulaire
         */
       /* String email = request.getParameter( emailUser );
        String motDePasse = request.getParameter( motDePasseUser );*/

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /**
         * Affchage de la page Login
         */
        this.getServletContext().getRequestDispatcher( VUE_LOGIN ).forward( request, response );

    }
}
