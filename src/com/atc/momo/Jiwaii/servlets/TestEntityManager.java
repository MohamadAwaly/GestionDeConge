package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;
import org.eclipse.persistence.exceptions.EntityManagerSetupException;
import org.eclipse.persistence.exceptions.PersistenceUnitLoadingException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@WebServlet( name = "TestEntityManager" )
public class TestEntityManager extends HttpServlet implements Serializable {
    private static final long                    serialVersionUID = 1L;
    final static         org.apache.log4j.Logger logger           = org.apache.log4j.Logger
            .getLogger( TestEntityManager.class );
    public static final  String                  VUE              = "/resources/view/test.jsp";

    protected void doPost( HttpServletRequest request,
            HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( "gestiondeconge" );
            //entityManager = entityManagerFactory.createEntityManager();
            logger.log( Level.INFO, "Lecture de tout les personnes" );
            logger.log( Level.INFO, "Entity Manager " + entityManagerFactory );
            PersonnesEntity pers = entityManager.find( PersonnesEntity.class, 1 );
            logger.log( Level.INFO, "find: " + pers );
            List<PersonnesEntity> personnes = entityManager.createQuery( "select p from PersonnesEntity p " ).getResultList();
            for ( PersonnesEntity p : personnes ) {
                logger.log( Level.INFO, "personnes test" + p.getNom() );
                //request.setAttribute( "personnes", p );
            }

        } catch ( PersistenceUnitLoadingException e ) {
            logger.log( Level.INFO, "message d'erreur" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
            if ( entityManagerFactory != null )
                entityManagerFactory.close();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
