package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoJourDeConge;
import com.atc.momo.Jiwaii.dao.DaoJourDeCongeImpl;
import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "listeDemande" )
public class listeDemande extends HttpServlet {
    public static final  String      VUE              = "/resources/view/lstdemande.jsp";
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity = new PersonnejourdecongetypedemandeEntity();

        int idDemande = Integer.parseInt( request.getParameter( "idDemande" ) );
        String approuve = (String) request.getParameter( "Aprouve" );
        String commentaire = (String) request.getParameter( "Commentaire" );

        DaoJourDeConge daoJourDeConge = new DaoJourDeCongeImpl();
        try {
            daoJourDeConge.updateDemande( idDemande, commentaire, approuve );
        } catch ( DaoException e ) {
            e.getMessage();
        }
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        DaoJourDeConge daoJourDeConge = new DaoJourDeCongeImpl();
        try {
            request.setAttribute( "demandeEnCours", daoJourDeConge.listerDemandeEnCours() );
        } catch ( DaoException e ) {
            e.printStackTrace();
        }

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }
}
