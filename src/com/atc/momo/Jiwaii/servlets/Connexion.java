package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.beans.ConnexionForm;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import model.CalendarTools;
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
import java.time.LocalDate;
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

        DateFormatSymbols dfsFR = new DateFormatSymbols( Locale.FRANCE );
        String[] jourMois = dfsFR.getWeekdays();
        List<String> lsJour = new ArrayList<>();

        for ( int i = 1; i < jourMois.length; i++ ) {
            logger.log( Level.INFO, "Jourrrrr: " + jourMois[i] );
            request.setAttribute( "calendar", lsJour );
            lsJour.add( jourMois[i] );
        }


        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        int jour = calendar.get( Calendar.DAY_OF_MONTH );

        request.setAttribute("calendar",CalendarTools.getAWeek());
        logger.log( Level.INFO, "le jour est: " + jour );

        calendar.getFirstDayOfWeek();
        logger.log( Level.INFO,"Nombre des jours dans le mois courant : " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));




        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        PersonnesEntity utilisateur = null;
        try {
            utilisateur = form.connecterUtilisateur( request );
        } catch ( Exception e ) {
            e.printStackTrace();
        }

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
            this.getServletContext().getRequestDispatcher( VUE_ACCUEIL  ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
