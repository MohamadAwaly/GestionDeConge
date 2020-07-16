package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import com.atc.momo.Jiwaii.entities.RolesEntity;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoRolesImpl implements DaoRole {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoRolesImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";

    @Override public List<RolesEntity> lister() throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<RolesEntity> role = new ArrayList<>();
        try {
            logger.log( Level.INFO,"Dans le try ");
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            logger.log( Level.INFO,"apres entity" );
            role = entityManager.createQuery( "select r from RolesEntity r", RolesEntity.class ).getResultList();
            logger.log( Level.INFO,"requete" );
            for ( RolesEntity str : role ) {
                logger.log( Level.INFO, "restul requete role: " + str.getTypeRole() );
            }

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
        return role;
    }
}
