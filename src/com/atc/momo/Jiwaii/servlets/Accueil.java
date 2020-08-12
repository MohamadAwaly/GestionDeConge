package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoJourDeConge;
import com.atc.momo.Jiwaii.dao.DaoJourDeCongeImpl;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import model.CalendarTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet( name = "Accueil" )
public class Accueil extends HttpServlet {
    public static final String         VUE              = "/resources/view/accueil.jsp";
    public static final String         ATT_SESSION_USER = "sessionUtilisateur";
    private             DaoJourDeConge daoJourDeConge   = new DaoJourDeCongeImpl();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        PersonnesEntity pers = new PersonnesEntity();
        pers = (PersonnesEntity) request.getSession().getAttribute( ATT_SESSION_USER );
        int idPersonne = pers.getIdPersonne();

        try {
            request.setAttribute( "jourdecongerestant", daoJourDeConge.CountDateToDate( idPersonne ));
        } catch ( DaoException | ParseException e ) {
            e.getMessage();
        }

        request.setAttribute( "calendar", CalendarTools.getAWeek() );
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
