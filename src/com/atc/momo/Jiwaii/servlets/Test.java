package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.AdresseDao;
import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoFactory;
import com.atc.momo.Jiwaii.dao.PersonneDao;
import com.atc.momo.Jiwaii.entities.AdressesEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import com.atc.momo.Jiwaii.dao.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@WebServlet( name = "/Test" )
public class Test extends HttpServlet {
    private static final long        serialVersionUID = 1L;
    private              PersonneDao personneDao;
    private              AdresseDao  adresseDao;
    public static final  String      VUE              = "/resources/view/ajoutPersonne.jsp";
    final static         Logger      logger           = Logger.getLogger( Test.class );

    //cree un nouvelle objet DAOFactory qui sera connecter et on va stocke l'objet personne DAO Dans une objet
    // qui permet d'applet les methode ajouter et lister
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.personneDao = daoFactory.getPersonneDao();
        this.adresseDao = daoFactory.getAdresseDao();
    }

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
           personnesEntity.setFkRole( Integer.parseInt( request.getParameter( "role" ) ) );
           personnesEntity.setFkAdresse( Integer.parseInt( request.getParameter( "selectAdresse" ) ) );

           logger.log( Level.INFO, "A regarder" );
           logger.log( Level.INFO, "l'adresse est :" + request.getParameter( "selectAdresse" ) );

           personneDao.ajouter( personnesEntity );
           request.setAttribute( "personnes", personneDao.lister() );
           request.setAttribute( "adresses", adresseDao.lister() );

        } catch ( Exception e ) {
            request.setAttribute( "erreur", e.getMessage() );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        try {
            request.setAttribute( "personnes", personneDao.lister() );
            request.setAttribute( "adresses", adresseDao.lister() );

        } catch ( DaoException e ) {
            request.setAttribute( "erreur", e.getMessage() );
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
