package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import java.util.List;

public interface DaoPersonne {

    //Permet d'ajouter une personne >> PersonneEntity
    //void ajouter ( PersonnesEntity personne ) throws DaoException;
    //Liste les personnes présent dans la table
    List<PersonnesEntity> lister() throws DaoException;
}
