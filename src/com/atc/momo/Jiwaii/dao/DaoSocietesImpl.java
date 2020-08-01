package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.SocietesEntity;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class DaoSocietesImpl implements DaoSociete {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoSocietesImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";

    @Override public void ajouter( SocietesEntity societe ) throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( societe );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }

    }

    @Override public List<SocietesEntity> lister() throws DaoException {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<SocietesEntity> societesEntities = new ArrayList<SocietesEntity>();
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            societesEntities = entityManager.createQuery( "select s from SocietesEntity s" ).getResultList();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
        return societesEntities;

    }

    @Override public boolean SocieteExiste() throws DaoException {
        if (lister().isEmpty() || lister() == null || lister().size() == 0){
            return false;
        }
        else{
            return true;
        }
    }

}
