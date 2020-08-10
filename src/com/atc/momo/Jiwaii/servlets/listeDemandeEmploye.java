package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoJourDeConge;
import com.atc.momo.Jiwaii.dao.DaoJourDeCongeImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "listeDemandeEmploye" )
public class listeDemandeEmploye extends HttpServlet {
    public static final String VUE = "/resources/view/listeDemandeEmploye.jsp";
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        DaoJourDeConge daoJourDeConge = new DaoJourDeCongeImpl();
        try {
            daoJourDeConge.listerDemandeEmployer();
            request.setAttribute( "mesdemandes", daoJourDeConge.listerDemandeEmployer() );
        } catch ( DaoException e ) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
