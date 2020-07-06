package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoFactory;
import com.atc.momo.Jiwaii.dao.PersonneDao;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet( name = "/Test" )
public class Test extends HttpServlet {
    private static final long        serialVersionUID = 1L;
    private              PersonneDao personneDao;
    public static final  String      VUE              = "/resources/view/bonjour.jsp";
    final static         Logger      logger           = Logger.getLogger( Test.class );

    //cree un nouvelle objet DAOFactory qui sera connecter et on va stocke l'objet personne DAO Dans une objet
    // qui permet d'applet les methode ajouter et lister
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.personneDao = daoFactory.getPersonneDao();
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        PersonnesEntity personnesEntity = new PersonnesEntity();
        personnesEntity.setNom( request.getParameter( "nom" ) );
        personnesEntity.setPrenom( request.getParameter( "prenom" ) );
        personnesEntity.setDateDeNaissance( Date.valueOf( request.getParameter( "dateDeNaissance" ) ) );
        personnesEntity.setEmail( request.getParameter( "dateDeNaissance" ) );
        personnesEntity.setEmail( request.getParameter( "email" ) );
        personnesEntity.setMotDePasse( request.getParameter( "motDePasse" ) );
        personnesEntity.setFkRole( Integer.parseInt( request.getParameter( "role" ) ) );
        personnesEntity.setFkAdresse( Integer.parseInt( request.getParameter( "adresse" ) ) );
        logger.log( Level.INFO, "test" );
        logger.log( Level.INFO, "Nom: " + personnesEntity.getNom() );
        logger.log( Level.INFO, "dateDirect: " + request.getParameter( "dateDeNaissance" ) );
        logger.log( Level.INFO, "Date de naissance: " + personnesEntity.getDateDeNaissance() );

        request.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( "personnes", personneDao.lister() );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
