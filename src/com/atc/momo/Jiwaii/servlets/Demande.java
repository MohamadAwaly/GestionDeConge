package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoJourDeConge;
import com.atc.momo.Jiwaii.dao.DaoJourDeCongeImpl;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet( name = "Demande" )
public class Demande extends HttpServlet {
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    final static        Logger logger           = Logger.getLogger( Connexion.class );
    public static final String VUE              = "/resources/view/demande.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());

        PersonnesEntity pers = new PersonnesEntity();
        pers = (PersonnesEntity) request.getSession().getAttribute( ATT_SESSION_USER );
        int idPersonne = pers.getIdPersonne();
        PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity = new PersonnejourdecongetypedemandeEntity();
        personnejourdecongetypedemandeEntity.setFkPersonne( idPersonne );
        personnejourdecongetypedemandeEntity.setFkTypeDemande(1);
        personnejourdecongetypedemandeEntity.setDateDemande( java.sql.Date.valueOf(date));
        personnejourdecongetypedemandeEntity.setDatedebut( (java.sql.Date) request.getAttribute( "dateDebut" ) );
        personnejourdecongetypedemandeEntity.setDatefin((java.sql.Date) request.getAttribute( "dateFin" ));

        DaoJourDeConge daoJourDeConge = new DaoJourDeCongeImpl();
        try {
            daoJourDeConge.insertDemande( personnejourdecongetypedemandeEntity );
        } catch ( DaoException e ) {
            e.getMessage();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
