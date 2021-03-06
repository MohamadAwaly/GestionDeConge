package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoSociete;
import com.atc.momo.Jiwaii.dao.DaoSocietesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "/Sosietes" )
public class Sosietes extends HttpServlet {
    public static final String VUE              = "/resources/view/societe.jsp";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE_INDEX        = "/index.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        DaoSociete societe = new DaoSocietesImpl();
        try {
            request.setAttribute( "societe", societe.lister() );
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
