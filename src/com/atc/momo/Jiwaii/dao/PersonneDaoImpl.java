package com.atc.momo.Jiwaii.dao;
/**
 * Ici on retrouve les requête SQL
 */

import com.atc.momo.Jiwaii.entities.PersonnesEntity;
import com.atc.momo.Jiwaii.servlets.Test;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class PersonneDaoImpl implements PersonneDao {
    private      DaoFactory daoFactory;
    final static Logger     logger = Logger.getLogger( PersonneDaoImpl.class );

    // permet d'avoir acces a l'objet connecte
    PersonneDaoImpl( DaoFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    @Override public void ajouter( PersonnesEntity personnesEntity ) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Date dateDenaissance = new Date( System.currentTimeMillis() );
        logger.log( Level.INFO, "Avant le blog Try" );
        try {
            logger.log( Level.INFO, "Dans le blog Try avant la connexion" );
            connection = daoFactory.getConnection();
            logger.log( Level.INFO, "Dans le blog Try apres la connexion" );
            preparedStatement = connection.prepareStatement
                    ( "INSERT INTO personnes(Nom, prenom, DateDeNaissance, email,MotDePasse) VALUES (?,?,?,?,?);" );
            //PersonnesEntity personne = new PersonnesEntity();
            logger.log( Level.INFO, "Dans le blog Try apres la preparedStatement" );
            preparedStatement.setString( 1, personnesEntity.getNom() );
            preparedStatement.setString( 2, personnesEntity.getPrenom() );
            preparedStatement.setDate( 3, personnesEntity.getDateDeNaissance());
            preparedStatement.setString( 4, personnesEntity.getEmail() );
            preparedStatement.setString( 5, personnesEntity.getMotDePasse() );
            //preparedStatement.setInt( 6, personnesEntity.getFkRole() );
            //preparedStatement.setInt( 7, personnesEntity.getFkAdresse() );

            logger.log( Level.INFO, "Dans le blog Try apres les gets" );
            logger.log( Level.INFO, "Class PersonneDaoImpl" );
            logger.log( Level.INFO, "Nom: " + personnesEntity.getNom() );
            logger.log( Level.INFO, "Prenom: " + personnesEntity.getPrenom() );
            logger.log( Level.INFO, "Date de naissance: " + personnesEntity.getDateDeNaissance() );
            logger.log( Level.INFO, "Email: " + personnesEntity.getEmail() );
            logger.log( Level.INFO, "Mot de passe: " + personnesEntity.getMotDePasse() );
            logger.log( Level.INFO, "Role: " + personnesEntity.getFkRole() );
            logger.log( Level.INFO, " Adresse: " + personnesEntity.getFkAdresse() );

            preparedStatement.executeUpdate();
            logger.log( Level.INFO, "Requête d'ajout execute avec succes" );

        } catch ( SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override public List<PersonnesEntity> lister() {
        List<PersonnesEntity> personnesEntities = new ArrayList<PersonnesEntity>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connection = daoFactory.getConnection();
            statement = connection.createStatement();
            resultat = statement.executeQuery( "SELECT nom, prenom,dateDeNaissance, email, motDePasse FROM personnes" );

            while ( resultat.next() ) {
                String nom = resultat.getString( "Nom" );
                String prenom = resultat.getString( "Prenom" );
                Date dateDeNaissance = resultat.getDate( "DateDeNaissance" );
                String email = resultat.getString( "Email" );
                String motdePAsse = resultat.getString( "MotDePasse" );

                PersonnesEntity personnesEntity = new PersonnesEntity();
                personnesEntity.setNom( nom );
                personnesEntity.setPrenom( prenom );
                personnesEntity.setDateDeNaissance( dateDeNaissance );
                personnesEntity.setEmail( email );
                personnesEntity.setMotDePasse( motdePAsse );

                personnesEntities.add( personnesEntity );
            }

        } catch ( SQLException e ) {
            e.printStackTrace();
        }

        return personnesEntities;
    }
}
