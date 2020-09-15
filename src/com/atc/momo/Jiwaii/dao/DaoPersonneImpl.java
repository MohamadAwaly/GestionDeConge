package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongeautorisetypedemandeEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import org.apache.log4j.Level;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoPersonneImpl implements DaoPersonne {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoPersonneImpl.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    private static final String                  PARAM_EMAIL           = "email";

    //Lister Personne avec leur adresses et roles
    public List<Object[]> listDesPersonnes() {
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

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ListeHolidayAutorise" );
        } finally {
            if ( em != null )
                em.close();
        }
        return holiday;
    }

    @Override public void ajouterdayOff( int idJourAutorise, String email, Date datedebut, Date datefin )
            throws DaoException {
        EntityManager em = getEntityManager( PERSISTENCE_UNIT_NAME );
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "NewDroitForUserWithId" );
            storedprocedure.registerStoredProcedureParameter( "pEmail", String.class, ParameterMode.IN );
            storedprocedure.registerStoredProcedureParameter( "pDateDebut", Date.class, ParameterMode.IN );
            storedprocedure.registerStoredProcedureParameter( "pDateFin", Date.class, ParameterMode.IN );
            storedprocedure.registerStoredProcedureParameter( "pIdJourAutorise", Integer.class, ParameterMode.IN );
            storedprocedure.setParameter( "pEmail", email );
            storedprocedure.setParameter( "pDateDebut", datedebut );
            storedprocedure.setParameter( "pDateFin", datefin );
            storedprocedure.setParameter( "pIdJourAutorise", idJourAutorise );
            storedprocedure.execute();
            trans.commit();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouterdayOff" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
    }

    @Override public void ajouter( PersonnesEntity personne, int idJourAutorise, String email, Date datedebut,
            Date datefin ) throws DaoException {

        PersonnejourdecongeautorisetypedemandeEntity persJrCongAut = new PersonnejourdecongeautorisetypedemandeEntity();
        //persJrCongAut.setFkPersonne( 65 );
        persJrCongAut.setFkJourCongeAutorise( idJourAutorise );
        persJrCongAut.setDateDebut( (java.sql.Date) datedebut );
        persJrCongAut.setDateFin( (java.sql.Date) datefin );
        persJrCongAut.setFkTypeDemandes( 1 );

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
        entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction trans = entityManager.getTransaction();
        try {

            trans.begin();
            entityManager.persist( personne );
            entityManager.persist( persJrCongAut );
            PersonnesEntity test = entityManager.merge( personne );
            entityManager.flush();
            //persJrCongAut.setFkPersonne( personne );
            logger.log( Level.INFO, "id personne+++++++++++++++++++" + test.getIdPersonne() );
            logger.log( Level.INFO, "id personne+++++++++++++++++++" + test.getNom() );

            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouter personne" + e.getMessage() );
        } finally {
            if(trans.isActive()){
                trans.rollback();
            }
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

    @Override public List<PersonnesEntity> lister() throws DaoException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        List<PersonnesEntity> personnesEntities = new ArrayList<>();

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
            entityManager = entityManagerFactory.createEntityManager();

            personnesEntities = entityManager
                    .createQuery( "select p from PersonnesEntity p ", PersonnesEntity.class )
                    .getResultList();

        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur" );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }
        return personnesEntities;
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
