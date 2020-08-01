package com.atc.momo.Jiwaii.servlets;

import com.atc.momo.Jiwaii.dao.DaoException;
import com.atc.momo.Jiwaii.dao.DaoSociete;
import com.atc.momo.Jiwaii.dao.DaoSocietesImpl;
import com.atc.momo.Jiwaii.entities.SocietesEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( name = "nouvellesociete" )
public class nouvellesociete extends HttpServlet {
    public static final String     VUE     = "/resources/view/nouvelleSociete.jsp";
    private             DaoSociete societe = new DaoSocietesImpl();

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        SocietesEntity societesEntity = new SocietesEntity();

        societesEntity.setNom( request.getParameter( "nom" ) );
        societesEntity.setTel( request.getParameter( "tel" ) );
        societesEntity.setNtva( Integer.parseInt( request.getParameter( "ntva" ) ) );
        societesEntity.setEmail( request.getParameter( "email" ) );

        try {
            societe.ajouter( societesEntity );
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
