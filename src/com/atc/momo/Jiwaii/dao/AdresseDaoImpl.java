package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.AdressesEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sun.applet.resources.MsgAppletViewer;

import java.sql.*;
import java.util.HashMap;
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

    @Override public Map<Integer, String> mapAdresse() {
        Map<Integer, String> map = new HashMap<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery( "SELECT * FROM adresses" );

            while ( resultat.next() ) {
                int idAdresse = resultat.getInt( "idAdresse" );
                String nomRue = resultat.getString( "NomRue" );
                logger.log( Level.INFO, idAdresse + " " + nomRue );
                map.put( idAdresse, nomRue );

            }

        } catch ( SQLException e ) {

        }

        return map;
    }

}
