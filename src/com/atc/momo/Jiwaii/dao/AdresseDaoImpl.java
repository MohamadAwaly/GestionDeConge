package com.atc.momo.Jiwaii.dao;

import org.apache.log4j.Logger;
import sun.applet.resources.MsgAppletViewer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;
/**
 * Implemente la liste déroulante pour choisir une adresse pour les personnes
 */
public class AdresseDaoImpl implements AdresseDao {

    private      DaoFactory daoFactory;
    final static Logger     logger = Logger.getLogger( AdresseDaoImpl.class );

    //permet d'avoir acces a l'objet connecte
    AdresseDaoImpl (DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override public Map<String, Integer> mapAdresse() {
        Map<String,Integer> map = new Map<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = daoFactory.getConnection();
        }
        return null;
    }

}
