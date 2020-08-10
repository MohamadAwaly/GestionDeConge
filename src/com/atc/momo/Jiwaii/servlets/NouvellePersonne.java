package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.*;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet( name = "NouvellePersonne" )
public class NouvellePersonne extends HttpServlet {
    public static final String      VUE              = "/resources/view/nouvellePersonne.jsp";
    public static final String      VUE_LIST         = "/resources/view/afficherPersonne.jsp";
    public static final String      ATT_SESSION_USER = "sessionUtilisateur";
    public static final String      VUE_INDEX        = "/index.jsp";
    final static        Logger      logger           = Logger.getLogger( NouvellePersonne.class );
    private             DaoPersonne newUSer          = new DaoPersonneImpl();
    private             DaoAdresse  adresse          = new DaoAdresseImpl();
    private             DaoRole     role             = new DaoRolesImpl();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {

            PersonnesEntity personnesEntity = new PersonnesEntity();

            personnesEntity.setNom( request.getParameter( "nom" ) );
            personnesEntity.setPrenom( request.getParameter( "prenom" ) );
            personnesEntity.setDateDeNaissance( Date.valueOf( request.getParameter( "dateDeNaissance" ) ) );
            personnesEntity.setEmail( request.getParameter( "email" ) );
            personnesEntity.setMotDePasse( request.getParameter( "motDePasse" ) );
            personnesEntity.setFkRole( Integer.parseInt( request.getParameter( "selectrole" ) ) );
            personnesEntity.setFkAdresse( Integer.parseInt( request.getParameter( "selectAdresse" ) ) );

            int idJourAutorise = Integer.parseInt( request.getParameter( "holiday" ) );
            String email = request.getParameter( "email" );
            Date dateDebut = ( Date.valueOf( request.getParameter( "dateDebut" ) ) );
            Date dateFin = ( Date.valueOf( request.getParameter( "dateFin" ) ) );

            newUSer.ajouter( personnesEntity );
            newUSer.ajouterdayOff( idJourAutorise, email, dateDebut, dateFin );

            request.setAttribute( "adresse", newUSer.laListeDeOufs() );

        } catch ( Exception e ) {
            request.setAttribute( "erreur", e.getMessage() );
        }

        this.getServletContext().getRequestDispatcher( VUE_LIST ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            request.setAttribute( "adresses", adresse.lister() );
            request.setAttribute( "role", role.lister() );
            request.setAttribute( "holiday", newUSer.ListeHolidayAutorise() );
        } catch ( DaoException e ) {
            request.setAttribute( "erreur", e.getMessage() );
        }
        if ( request.getSession().getAttribute( ATT_SESSION_USER ) == null ) {
            this.getServletContext().getRequestDispatcher( VUE_INDEX ).forward( request, response );

        } else {
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }
    }
}
