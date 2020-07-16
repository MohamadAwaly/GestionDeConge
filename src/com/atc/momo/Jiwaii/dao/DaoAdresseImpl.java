package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.AdressesEntity;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoAdresseImpl implements DaoAdresse {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoAdresseImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";

    @Override public List<AdressesEntity> lister() throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<AdressesEntity> adresse = new ArrayList<>();
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();

            adresse = entityManager.createQuery( "select a from AdressesEntity a", AdressesEntity.class )
                    .getResultList();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
        return adresse;
    }
}
