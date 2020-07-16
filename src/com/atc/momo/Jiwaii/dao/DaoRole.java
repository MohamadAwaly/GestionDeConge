package com.atc.momo.Jiwaii.dao;

import com.atc.momo.Jiwaii.entities.RolesEntity;

import java.util.List;

public interface DaoRole {
    List<RolesEntity> lister() throws DaoException;
}
