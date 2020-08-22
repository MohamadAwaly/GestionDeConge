package com.atc.momo.Jiwaii.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Une class qui permet d'initialiser le DAO
 * Permet de faire la connexion avec la DB
 */
public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Méthode qui charge le driver JDBC
     * se connecte a la base de données
     *
     * @return
     */
    public static DaoFactory getInstance() {
        try {
            Class.forName( "com.mysql.jdbc.Driver" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }
        DaoFactory instance = new DaoFactory(
                "jdbc:mysql://localhost:3306/gestiondeconge", "root", "12345678"
        );
        return instance;
    }

    /**
     * Méthode qui permet a tout moment de recupere la connexion a la base de données
     * quand on l'utilisera dans l'implementation
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection( url, username, password );
        connection.setAutoCommit( false );
        return connection;

    }


}
