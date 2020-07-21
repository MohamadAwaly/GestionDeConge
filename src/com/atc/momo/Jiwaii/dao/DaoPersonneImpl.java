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
    private static final String                  PARAM_EMAIL           = "email";

    @Override public void ajouter( PersonnesEntity personne ) throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( personne );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" + e.getMessage() );
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

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
        return personnesEntities;
    }

    @Override public PersonnesEntity userFind( String email, String motDePasse ) throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<PersonnesEntity> personnesEntities = new ArrayList<>();
        PersonnesEntity personne = null;
       //try {
       //    entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
       //    entityManager = entityManagerFactory.createEntityManager();
       //    Query requete = entityManager.createQuery(
       //            "select p.email from PersonnesEntity p where p.email = :email and p.motDePasse = :motDePasse" )
       //    requete.setParameter( PARAM_EMAIL, email);
       //    try {
       //        personne = (PersonnesEntity) requete.getSingleResult();
       //    } catch ( NoResultException e ) {
       //        return null;
       //    }

       //} catch ( Exception e ) {
       //    logger.log( Level.INFO, "Erreur" );
       //} finally {
       //    if ( entityManager != null )
       //        entityManager.close();
       //}
        return null;
    }
}
