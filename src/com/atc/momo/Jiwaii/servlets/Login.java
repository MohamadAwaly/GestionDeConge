package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.beans.Utilisateur;
import org.apache.log4j.Logger;
import org.apache.log4j.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

@WebServlet( name = "/Login" )
public class Login extends HttpServlet {

    public static final String emailUser      = "email";
    public static final String motDePasseUser = "pass";
    public static final String ATT_VALIDATION = "validation";
    public static final String ATT_USER       = "user";
    public static final String ATT_MESSAGE    = "message";
    public static final String VUE_LOGIN      = "/resources/view/connexion.jsp";
    public static final String VUE            = "/resources/view/accueil.jsp";

    final static Logger logger = Logger.getLogger( classname.Login );

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /**
         * Récupération des données saisie, envoyées en tant que paramètre de la requête Post
         * générer a la validation du formulaire
         */

        String email = request.getParameter( emailUser );
        String motDePasse = request.getParameter( motDePasseUser );
        boolean validation = true;
        String message;
        /**
         * Initialisation du message à afficher: si un des champs obligatoires
         * du formulaire n'est pas renseigné, alors on affiche un message d'erreur,
         * sinon on affiche un message de succès.
         */
        if ( email.trim().isEmpty() || motDePasse.trim().isEmpty() ) {
            message = "Erreur vous n'avez pas rempli tous les champs obligatoires .";
            validation = false;
        } else {
            message = "vous etes connectez en tant que " + email;
            validation = true;
        }
        /**
         * creation du bean utilisateur et initialisation avec les données récupérées
         */

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail( email );
        utilisateur.setMotDePasse( motDePasse );

        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.MONTH, Calendar.MAY );

        /* ajout du bean et du message à l'objet requête */
        request.setAttribute( ATT_USER, utilisateur );
        request.setAttribute( ATT_MESSAGE, message );
        request.setAttribute( ATT_VALIDATION, validation );
        request.setAttribute( "calendar", cal );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /**
         * Affchage de la page Login
         */
        this.getServletContext().getRequestDispatcher( VUE_LOGIN ).forward( request, response );

    }
}
