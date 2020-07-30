package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.*;
import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongeautorisetypedemandeEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
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
    public static final String      VUE      = "/resources/view/nouvellePersonne.jsp";
    public static final String      VUE_LIST = "/resources/view/afficherPersonne.jsp";
    final static        Logger      logger   = Logger.getLogger( NouvellePersonne.class );
    private             DaoPersonne newUSer  = new DaoPersonneImpl();
    private             DaoAdresse  adresse  = new DaoAdresseImpl();
    private             DaoRole     role     = new DaoRolesImpl();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            PersonnesEntity personnesEntity = new PersonnesEntity();

            personnesEntity.setNom( request.getParameter( "nom" ) );
            personnesEntity.setPrenom( request.getParameter( "prenom" ) );
            personnesEntity.setDateDeNaissance( Date.valueOf( request.getParameter( "dateDeNaissance" ) ) );
            personnesEntity.setEmail( request.getParameter( "dateDeNaissance" ) );
            personnesEntity.setEmail( request.getParameter( "email" ) );
            personnesEntity.setMotDePasse( request.getParameter( "motDePasse" ) );
            personnesEntity.setFkRole( Integer.parseInt( request.getParameter( "selectrole" ) ) );
            personnesEntity.setFkAdresse( Integer.parseInt( request.getParameter( "selectAdresse" ) ) );
            newUSer.ajouter( personnesEntity );

            int idPersonne = personnesEntity.getIdPersonne();
            logger.log( Level.INFO,"idPersonne : " + idPersonne );

            PersonnejourdecongeautorisetypedemandeEntity aDroit = new PersonnejourdecongeautorisetypedemandeEntity();
            //aDroit.setFkPersonne( idPersonne );
            aDroit.setFkJourCongeAutorise( Integer.parseInt( request.getParameter( "holiday" ) ) );
            aDroit.setDateDebut(Date.valueOf( request.getParameter( "dateDebut" ) )  );
            aDroit.setDateFin( Date.valueOf( request.getParameter( "dateFin" ) ) );
            //aDroit.setFkTypeDemandes(  );
            JourdecongeautoriseEntity holidays = new JourdecongeautoriseEntity();

            holidays.setNbrJourAutorise( Integer.parseInt( request.getParameter( "holiday" ) ) );


            //newUSer.dayHoliday( holidays );
            newUSer.ajouterdayOff( aDroit );
            //DaoPersonne pers = new DaoPersonneImpl();
            request.setAttribute( "personnes", newUSer.laListeDeOufs() );

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
            request.setAttribute( "holiday",newUSer.ListeHolidayAutorise() );
        } catch ( DaoException e ) {
            request.setAttribute( "erreur", e.getMessage() );
        }
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}
