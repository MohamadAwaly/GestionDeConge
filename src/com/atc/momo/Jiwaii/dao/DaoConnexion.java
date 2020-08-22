package com.atc.momo.Jiwaii.dao;

import org.apache.log4j.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoConnexion {
    final static         org.apache.log4j.Logger logger                = org.apache.log4j.Logger
            .getLogger( DaoConnexion.class );
    private static final String                  PERSISTENCE_UNIT_NAME = "gestiondeconge";

    EntityManagerFactory factory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );

    public EntityManager getEntityManager() {
        logger.log( Level.INFO,"Connexion EntityManagerFactory" );
        return factory.createEntityManager();
    }


   //private static final String PERSISTENCE_UNIT_NAME = "Employee";
   //private static EntityManagerFactory factory =
   //        Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

   //public void create(MyEntiy person){
   //    EntityManager em = factory.createEntityManager();
   //    em.getTransaction().begin();
   //    // do what ever you need
   //    em.getTransaction().commit();
   //    em.close();
   // }

}
