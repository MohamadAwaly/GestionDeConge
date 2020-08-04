package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DaoJourDeCongeImpl implements DaoJourDeConge {
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoJourDeCongeImpl.class );

    @Override public void insertDemande( PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity )
            throws DaoException {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( personnejourdecongetypedemandeEntity );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouter personne" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }

    }
}
