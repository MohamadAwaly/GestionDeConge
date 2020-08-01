package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import com.atc.momo.Jiwaii.entities.SocietesEntity;

import java.util.List;

public interface DaoSociete {
    //Permet d'ajouter une societe >> SocieteEntity
    void ajouter ( SocietesEntity societe ) throws DaoException;
    //Liste les societes présent dans la table
    List<SocietesEntity> lister() throws DaoException;

}
