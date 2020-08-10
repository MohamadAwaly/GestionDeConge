package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoJourDeConge;
import com.atc.momo.Jiwaii.dao.DaoJourDeCongeImpl;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "listeDemandeEmploye" )
public class listeDemandeEmploye extends HttpServlet {
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/resources/view/listeDemandeEmploye.jsp";

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        DaoJourDeConge daoJourDeConge = new DaoJourDeCongeImpl();
        PersonnesEntity pers = new PersonnesEntity();
        pers = (PersonnesEntity) request.getSession().getAttribute( ATT_SESSION_USER );
        int idPersonne = pers.getIdPersonne();
        try {
            request.setAttribute( "mesdemandes", daoJourDeConge.listerDemandeEmployer( idPersonne ) );
        } catch ( DaoException e ) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
