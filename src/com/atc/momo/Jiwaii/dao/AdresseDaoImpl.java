package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.AdressesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sun.applet.resources.MsgAppletViewer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implemente la liste déroulante pour choisir une adresse pour les personnes
 */
public class AdresseDaoImpl implements AdresseDao {

    private      DaoFactory daoFactory;
    final static Logger     logger = Logger.getLogger( AdresseDaoImpl.class );

    //permet d'avoir acces a l'objet connecte
    AdresseDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override public List<AdressesEntity> lister() {
        List<AdressesEntity> adressesEntities = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        logger.log( Level.INFO, "avant le try" );
        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery( "SELECT idAdresse,NomRue, Numero FROM adresses" );
            logger.log( Level.INFO, "avant le while" );
            while ( resultat.next() ) {
                logger.log( Level.INFO, "test");
                int idAdresse = resultat.getInt( "idAdresse" );
                String nomRue = resultat.getString( "NomRue" );
                int numero = resultat.getInt( "Numero" );
                logger.log( Level.INFO, idAdresse + " " + nomRue );

                AdressesEntity adresse = new AdressesEntity();
                adresse.setIdAdresse( idAdresse );
                adresse.setNomRue( nomRue );
                adresse.setNumero( numero );
                adressesEntities.add( adresse );
            }

        } catch ( SQLException e ) {

        }
        return adressesEntities;
    }
}
