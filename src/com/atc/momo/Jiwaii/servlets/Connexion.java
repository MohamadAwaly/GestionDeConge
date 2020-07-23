package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.beans.ConnexionForm;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet( name = "Connexion" )
public class Connexion extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/index.jsp";
    public static final String VUE_ACCUEIL      = "/resources/view/accueil.jsp";
    final static        Logger logger           = Logger.getLogger( Connexion.class );

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        Calendar calendar = Calendar.getInstance();
        logger.log( Level.INFO, "Calendarrrrrrrrrrrr:" + calendar.getTime() );
        DateFormatSymbols dfsFR = new DateFormatSymbols( Locale.FRANCE );
        String[] JourMois = dfsFR.getWeekdays();
        List<String> lsJour = new ArrayList<>();

        for ( int i = 1; i < JourMois.length; i++ ) {
            logger.log( Level.INFO, "Jourrrrr: " + JourMois[i] );
            request.setAttribute( "calendar", lsJour );
            lsJour.add( JourMois[i] );
        }
        request.setAttribute( "calendar", lsJour );

        Date date = new Date();
        // for ( int i = 0; i< 30; i++  ){
        //     date += i;

        //     DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //     String monthNow = dateFormat.format( date );
        //     request.setAttribute( "calendar",monthNow);
        // }






        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        PersonnesEntity utilisateur = form.connecterUtilisateur( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );

        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );

        if ( form.getErreurs().isEmpty() ) {
            this.getServletContext().getRequestDispatcher( VUE_ACCUEIL ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
