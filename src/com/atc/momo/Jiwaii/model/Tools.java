package com.atc.momo.Jiwaii.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tools {
    public static EntityManager getEntityManager(String PERSISTANCE ) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTANCE );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }
}
