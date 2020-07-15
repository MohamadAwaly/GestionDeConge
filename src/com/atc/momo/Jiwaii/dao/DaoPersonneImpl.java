package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonneImpl implements DaoPersonne {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoPersonneImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";

    @Override public void ajouter( PersonnesEntity personne ) throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            PersonnesEntity newUser = new PersonnesEntity();
            entityManager.persist( newUser );


        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
    }

    @Override public List<PersonnesEntity> lister() throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<PersonnesEntity> personnesEntities = new ArrayList<PersonnesEntity>();
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();

            personnesEntities = entityManager
                    .createQuery( "select p from PersonnesEntity p", PersonnesEntity.class ).getResultList();

            for ( PersonnesEntity str : personnesEntities ) {
                logger.log( Level.INFO, "restul: " + str );
            }

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }

        return personnesEntities;
    }
}
