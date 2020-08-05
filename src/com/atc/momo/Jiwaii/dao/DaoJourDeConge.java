package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnejourdecongetypedemandeEntity;

import java.util.List;

public interface DaoJourDeConge {
    public void insertDemande ( PersonnejourdecongetypedemandeEntity personnejourdecongetypedemandeEntity ) throws DaoException;
    public void insertDemandeParProcedure(Integer pPersonneId,String pDateDebut,String pDateFin) ;
    List<Object []> listerDemandeEnCours() throws DaoException;
}
