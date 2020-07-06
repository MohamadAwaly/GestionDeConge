package com.atc.momo.Jiwaii.beans;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJDBC {

    /* La liste qui contiendra tous les resultats de nos essais */
    private      List<String> messages = new ArrayList<>();
    final static Logger       logger2  = Logger.getLogger( TestJDBC.class );

    public List<String> executerTests( HttpServletRequest request ) {
        /* Chargement du driver JDBC pour MySQL */
        try {
            messages.add( "Chargement du driver..." );
            Class.forName( "com.mysql.jdbc.Driver" );
            messages.add( "Driver chargé !" );
        } catch ( ClassNotFoundException e ) {
            messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
                    + e.getMessage() );
        }

        /* Connexion à la base de données */
        String url = "jdbc:mysql://localhost:3306/gestiondeconge";
        String user = "root";
        String motDePasse = "12345678";
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;
        try {
            messages.add( "Connexion à la base de données..." );
            connexion = DriverManager.getConnection( url, user, motDePasse );
            messages.add( "Connexion réussie !" );

            /* Création de l'objet gérant les requêtes */
            statement = connexion.createStatement();
            messages.add( "Objet requête créé !" );

            /* Exécution d'une requête de lecture */
            resultat = statement.executeQuery( "SELECT idPersonne, nom,email , motDePasse, dateDeNaissance FROM personnes;" );
            messages.add( "Requête \"SELECT idPersonne, email, motDePAsse FROM Personne;\" effectuée !" );

            try {
                logger2.log( Level.INFO, "resultat" );
                logger2.log( Level.INFO, "avant le while" );
            } catch ( Exception e ) {
                logger2.fatal( "Une exceptin est survenue " + e.getMessage() );
            }

            /* Récupération des données du résultat de la requête de lecture */
            while ( resultat.next() ) {
                int idUtilisateur = resultat.getInt( "idPersonne" );
                String emailUtilisateur = resultat.getString( "email" );
                String motDePasseUtilisateur = resultat.getString( "motDePasse" );
                String nomUtilisateur = resultat.getString( "nom" );
                String dateNaissanceUtilisateur = resultat.getString( "dateDeNaissance" );

                /* Formatage des données pour affichage dans la JSP finale. */
                messages.add(
                        "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
                                + ", motdepasse = "
                                + motDePasseUtilisateur + ", nom = " + nomUtilisateur + ", Date de naissance " + dateNaissanceUtilisateur +  "." );
                logger2.log( Level.INFO, idUtilisateur );
                logger2.log( Level.INFO, emailUtilisateur );
                logger2.log( Level.INFO, motDePasseUtilisateur );
            }

        } catch ( SQLException e ) {
            messages.add( "Erreur lors de la connexion : <br/>"
                    + e.getMessage() );
        } finally {
            messages.add( "Fermeture de l'objet ResultSet." );
            if ( resultat != null ) {
                try {
                    resultat.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Statement." );
            if ( statement != null ) {
                try {
                    statement.close();
                } catch ( SQLException ignore ) {
                }
            }
            messages.add( "Fermeture de l'objet Connection." );
            if ( connexion != null ) {
                try {
                    connexion.close();
                } catch ( SQLException ignore ) {
                }
            }
        }
        return messages;
    }
}