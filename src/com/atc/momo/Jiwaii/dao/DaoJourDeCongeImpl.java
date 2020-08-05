package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;
import model.Tools;
import org.apache.log4j.Level;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DaoJourDeCongeImpl implements DaoJourDeConge {
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoJourDeCongeImpl.class );

    @Override public void insertDemande( PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity )
            throws DaoException {
        EntityManager entityManager = null;
        try {
            entityManager = Tools.getEntityManager(PERSISTENCE_UNIT_NAME);
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();
            entityManager.persist( personnejourdecongetypedemandeEntity );
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur ajouter Demande Congé" + e.getMessage() );
        } finally {
            if ( entityManager != null )
                entityManager.close();
        }

    }

    @Override
    public void insertDemandeParProcedure(Integer pPersonneId,String pDateDebut,String pDateFin) {
        EntityManager em = Tools.getEntityManager( PERSISTENCE_UNIT_NAME );
        try {
            EntityTransaction trans = em.getTransaction();
            trans.begin();
            StoredProcedureQuery storedprocedure = em.createStoredProcedureQuery( "InsererUneDemande");
            //parametres SQL : pPersonneId INT,pDateDebut Nvarchar(10),pDateFin Nvarchar(10)
            storedprocedure.registerStoredProcedureParameter("pPersonneId",Integer.class,ParameterMode.IN);
            storedprocedure.registerStoredProcedureParameter("pDateDebut", Date.class,ParameterMode.IN);
            storedprocedure.registerStoredProcedureParameter("pDateFin",Date.class,ParameterMode.IN);

            storedprocedure.setParameter("pPersonneId",pPersonneId);
            storedprocedure.setParameter("pDateDebut",pDateDebut);
            storedprocedure.setParameter("pDateFin",pDateFin);

            storedprocedure.execute();
            trans.commit();
        } catch ( Exception e ) {
            logger.log( Level.INFO, "Erreur dans la Demande" + e.getMessage() );
        } finally {
            if ( em != null )
                em.close();
        }
    }

    @Override public List<Object []> listerDemandeEnCours() throws DaoException {

        EntityManager em = Tools.getEntityManager(  PERSISTENCE_UNIT_NAME);
        Query query = em.createQuery("select p.idPersonne, p.nom,pjc.dateDemande , pjc.datedebut,pjc.datefin ,pjc.aprouver from PersonnejourdecongetypedemandeEntity pjc "
                        + "join PersonnesEntity p ON p.idPersonne = pjc.fkPersonne"
                        + " where pjc.aprouver = com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity.EnumApprouver.En_Cours " );
        List<Object[]> lst_demande = query.getResultList();
        return lst_demande;
    }
}
