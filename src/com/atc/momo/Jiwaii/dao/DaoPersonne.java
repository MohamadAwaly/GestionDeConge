package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.JourdecongeautoriseEntity;
import com.atc.momo.Jiwaii.entities.PersonnejourdecongeautorisetypedemandeEntity;
import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public interface DaoPersonne {

    //Permet d'ajouter une personne >> PersonneEntity
    void ajouter ( PersonnesEntity personne ) throws DaoException;
    //Déffinir les jours de congées autorisée par personne
    void dayHoliday ( JourdecongeautoriseEntity holiday ) throws DaoException;
    //Liste les personnes présent dans la table
    List<PersonnesEntity> lister() throws DaoException;
    PersonnesEntity userFind(String email,String motDePasse) throws DaoException;
    public List<Object[]> listDesPersonnes();
    //Liste des jours autorisé presnte dans la table
    List<String> ListeHolidayAutorise () throws DaoException;
    //void ajouterdayOff ( PersonnejourdecongeautorisetypedemandeEntity dayOff) throws DaoException;
    void ajouterdayOff ( int idJourAutorise, String email, Date datedebut, Date datefin) throws DaoException;

}
