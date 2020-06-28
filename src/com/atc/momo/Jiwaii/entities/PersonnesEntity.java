package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnes", schema = "gestiondeconge") public class PersonnesEntity {
    private int idPersonne;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String motDePasse;
    private Integer fkRole;
    private Integer fkAdresse;

    @Id @Column( name = "idPersonne", nullable = false ) public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne( int idPersonne ) {
        this.idPersonne = idPersonne;
    }

    @Basic @Column( name = "Nom", nullable = false, length = 45 ) public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    @Basic @Column( name = "Prenom", nullable = false, length = 45 ) public String getPrenom() {
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

    @Basic @Column( name = "Email", nullable = false, length = 100 ) public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Basic @Column( name = "MotDePasse", nullable = false, length = 45 ) public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    @Basic @Column( name = "FKRole", nullable = true ) public Integer getFkRole() {
        return fkRole;
    }

    public void setFkRole( Integer fkRole ) {
        this.fkRole = fkRole;
    }

    @Basic @Column( name = "FKAdresse", nullable = true ) public Integer getFkAdresse() {
        return fkAdresse;
    }

    public void setFkAdresse( Integer fkAdresse ) {
        this.fkAdresse = fkAdresse;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnesEntity that = (PersonnesEntity) o;
        return idPersonne == that.idPersonne &&
                Objects.equals( nom, that.nom ) &&
                Objects.equals( prenom, that.prenom ) &&
                Objects.equals( dateDeNaissance, that.dateDeNaissance ) &&
                Objects.equals( email, that.email ) &&
                Objects.equals( motDePasse, that.motDePasse ) &&
                Objects.equals( fkRole, that.fkRole ) &&
                Objects.equals( fkAdresse, that.fkAdresse );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonne, nom, prenom, dateDeNaissance, email, motDePasse, fkRole, fkAdresse );
    }
}
