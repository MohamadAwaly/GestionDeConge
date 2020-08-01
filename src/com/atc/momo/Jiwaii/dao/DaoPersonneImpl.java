package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.JourdecongeEntity;
import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongeautorisetypedemandeEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import com.atc.momo.Jiwaii.servlets.Personnes;
import org.apache.log4j.Level;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

public class DaoPersonneImpl implements DaoPersonne {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoPersonneImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    private static final String                  PARAM_EMAIL           = "email";

    //Lister Personne avec leur adresses et roles
    public List<Object[]> laListeDeOufs() {
        EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME );
        Query query = em.createQuery(
                "select p.nom, p.prenom,p.email, a.nomRue,a.numero,v.nomVille,r.typeRole from PersonnesEntity p"
                        + " left join AdressesEntity a ON p.fkAdresse=a.idAdresse"
                        + " left join VillesEntity v ON a.fkVille = v.idVille"
                        + " left join RolesEntity r ON r.idRole = p.fkRole" );
        List<Object[]> list = query.getResultList();

        return list;
    }

    //Liste des jour de congées autorise
    @Override public List<String> ListeHolidayAutorise() throws DaoException {
        EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME );
        List<String> holiday = new ArrayList<>();

        Query query = null;
        try {
            query = em
                    .createQuery( "select j from JourdecongeautoriseEntity j", JourdecongeautoriseEntity.class );
            holiday = query.getResultList();
            //for ( int i = 0; i < holiday.size(); i++ ) {
            //    holiday.add( query.toString());
            //}
            //
            //for ( int i = 0; i < holiday.size(); i++ ) {
            //    logger.log( Level.INFO, "Liste holiday: " + holiday.get( i ) );
            //}

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ListeHolidayAutorise" );
        } finally {
            if ( em != null )
                em.close();
        }
        return holiday;
    }

    @Override public void ajouterdayOff( int idJourAutorise, String email, Date datedebut, Date datefin ) throws DaoException {
        EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME );
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "test");
            storedprocedure.setParameter( "pEmail", email );
            storedprocedure.setParameter( "datedebut", datedebut );
            storedprocedure.setParameter( "datefin", datefin );
            storedprocedure.setParameter( "idJourAutorise", idJourAutorise );

            storedprocedure.execute();
            trans.commit();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouterdayOff" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
    }

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
            logger.log( Level.INFO, "Erreur ajouter personne" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
    }

    //Insertion des jour des congées
    @Override public void dayHoliday( JourdecongeautoriseEntity holiday ) throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( holiday );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
    }

    @Override public List<String> lister() throws DaoException {
        // EntityManagerFactory entityManagerFactory = null;
        // EntityManager entityManager = null;
        // //List<Query> personnesEntities = new ArrayList<Query>();
        // List<String> test = new ArrayList<>();
        // Query query = null;
        // try {
        //
        //     entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        //     entityManager = entityManagerFactory.createEntityManager();
        //
        //     query = (Query) entityManager
        //             .createQuery( "select p, a from PersonnesEntity p , AdressesEntity  a", PersonnesEntity.class )
        //             .getResultList();
        //     for ( int i = 0; i < test.size(); i++ ) {
        //         test.add( query.toString() );
        //     }
        //
        //     for ( int i = 0; i < test.size(); i++ ) {
        //         logger.log( Level.INFO, "Liste test: " + test.get( i ) );
        //     }
        //
        // } catch ( Exception e ) {
        //     logger.log( Level.INFO, "Erreur" );
        // } finally {
        //     if ( entityManager != null )
        //         entityManager.close();
        // }
        return null;
    }

    @Override public PersonnesEntity userFind( String email, String motDePasse ) throws DaoException {
        EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME );
        PersonnesEntity personne;
        Query query = em
                .createQuery( "select p from PersonnesEntity p where p.email=:email and p.motDePasse =:motDePasse ",
                        PersonnesEntity.class );
        query.setParameter( "email", email );
        query.setParameter( "motDePasse", motDePasse );
        personne = (PersonnesEntity) query.getSingleResult();

        return personne;
    }

    private EntityManager getEntityManager( String PERSISTANCE ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTANCE );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }

}
