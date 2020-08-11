package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;

import java.util.Date;
import java.util.List;

public interface DaoJourDeConge {
    public void insertDemande ( PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity ) throws DaoException;
    public void insertDemandeParProcedure(Integer pPersonneId,String pDateDebut,String pDateFin) ;
    List<Object []> listerDemandeEnCours() throws DaoException;
    public void updateDemande (int idDemande, String commentaire, String aprouve) throws DaoException;
    List<Object []> listerDemandeEmployer (int idPersonne) throws DaoException;
    List<Object []> JourRestant (int idPersonne) throws DaoException;
    public List<Object[]> CountDateToDate( int idPersonne) throws DaoException;
}
