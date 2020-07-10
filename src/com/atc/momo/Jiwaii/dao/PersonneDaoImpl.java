package com.atc.momo.Jiwaii.dao;
/**
 * Ici on retrouve les requête SQL
 */

import com.atc.momo.Jiwaii.entities.EntityException;
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

    @Override public void ajouter( PersonnesEntity personnesEntity ) throws DaoException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        logger.log( Level.INFO, "Avant le blog Try" );
        try {
            connection = daoFactory.getConnection();
            preparedStatement = connection.prepareStatement
                    ( "INSERT INTO personnes(Nom, Prenom, DateDeNaissance, Email,MotDePasse,FKRole, FKAdresse) VALUES (?,?,?,?,?,?,?);" );
            //PersonnesEntity personne = new PersonnesEntity();
            preparedStatement.setString( 1, personnesEntity.getNom() );
            preparedStatement.setString( 2, personnesEntity.getPrenom() );
            preparedStatement.setDate( 3, personnesEntity.getDateDeNaissance() );
            preparedStatement.setString( 4, personnesEntity.getEmail() );
            preparedStatement.setString( 5, personnesEntity.getMotDePasse() );
            preparedStatement.setInt( 6, personnesEntity.getFkRole() );
            preparedStatement.setInt( 7, personnesEntity.getFkAdresse() );

            preparedStatement.executeUpdate();
            logger.log( Level.INFO, "Requête d'ajout execute avec succes" );
            connection.commit();
        } catch ( SQLException e ) {
            try {
                if (connection != null){
                    connection.rollback();
                }
            } catch ( SQLException e2 ){
            }
            throw new DaoException( "Impossible de communiquer avec la base de données" );
        }
        finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch ( SQLException e ){
                throw new DaoException( "Impossible de communiquer avec la base de donées" );
            }
        }
    }

    @Override public List<PersonnesEntity> lister() throws DaoException {
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
            throw new DaoException( "Impossible de communiquer avec la base de donées" );
        } catch ( EntityException e ){
            throw new DaoException( "Les données de la base sont invalides" );
        }
        finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch ( SQLException e ){
                throw new DaoException( "Impossible de communiquer avec la base de donées" );
            }
        }

        return personnesEntities;
    }
}
