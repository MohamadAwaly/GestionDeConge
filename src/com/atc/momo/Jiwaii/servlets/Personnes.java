package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoPersonne;
import com.atc.momo.Jiwaii.dao.DaoPersonneImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "Personnes" )
public class Personnes extends HttpServlet {
    final static         Logger      logger           = Logger.getLogger( Personnes.class );
    private static final long        serialVersionUID = 1L;
    private              DaoPersonne personne;
    public static final  String      VUE              = "/resources/view/afficherPersonne.jsp";
    public static final  String      ATT_SESSION_USER = "sessionUtilisateur";
    public static final  String      VUE_INDEX        = "/index.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        DaoPersonne pers = new DaoPersonneImpl();

        try {
            request.setAttribute( "personnes", pers.lister() );
            request.setAttribute( "adresse", pers.laListeDeOufs() );
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
