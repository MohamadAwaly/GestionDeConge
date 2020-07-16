package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.AdressesEntity;

import java.util.List;

public interface DaoAdresse {
    List<AdressesEntity> lister() throws DaoException;

}
