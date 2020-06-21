package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnes", schema = "gestiondeconge" ) public class PersonnesEntity {
    private int idPersonne;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String motDePasse;
    private int fkRole;
    private int fkAdresse;

    @Id @Column( name = "IDPersonne", nullable = false ) public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne( int idPersonne ) {
        this.idPersonne = idPersonne;
    }

    @Basic @Column( name = "Nom", nullable = false, length = 50 ) public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    @Basic @Column( name = "Prenom", nullable = false, length = 60 ) public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    @Basic @Column( name = "DateDeNaissance", nullable = false ) public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance( Date dateDeNaissance ) {
        this.dateDeNaissance = dateDeNaissance;
    }

    @Basic @Column( name = "Email", nullable = false, length = 255 ) public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Basic @Column( name = "MotDePasse", nullable = false, length = 8 ) public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    @Basic @Column( name = "FKRole", nullable = false ) public int getFkRole() {
        return fkRole;
    }

    public void setFkRole( int fkRole ) {
        this.fkRole = fkRole;
    }

    @Basic @Column( name = "FkAdresse", nullable = false ) public int getFkAdresse() {
        return fkAdresse;
    }

    public void setFkAdresse( int fkAdresse ) {
        this.fkAdresse = fkAdresse;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnesEntity that = (PersonnesEntity) o;
        return idPersonne == that.idPersonne &&
                fkRole == that.fkRole &&
                fkAdresse == that.fkAdresse &&
                Objects.equals( nom, that.nom ) &&
                Objects.equals( prenom, that.prenom ) &&
                Objects.equals( dateDeNaissance, that.dateDeNaissance ) &&
                Objects.equals( email, that.email ) &&
                Objects.equals( motDePasse, that.motDePasse );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonne, nom, prenom, dateDeNaissance, email, motDePasse, fkRole, fkAdresse );
    }
}
