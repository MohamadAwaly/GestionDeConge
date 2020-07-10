package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;

import java.util.List;

/**
 * Une interface qui permet de deffinir les méthodes sans les implémenters
 */
public interface PersonneDao {
    //Permet d'ajouter une personne >> PersonneEntity
    void ajouter ( PersonnesEntity personne ) throws DaoException;
    //Liste les personnes présent dans la table
    List<PersonnesEntity> lister() throws DaoException;
}
