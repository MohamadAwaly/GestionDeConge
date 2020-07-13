package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.AdressesEntity;

import java.util.List;
import java.util.Map;

public interface AdresseDao {
    List<AdressesEntity> lister() throws DaoException;

}
