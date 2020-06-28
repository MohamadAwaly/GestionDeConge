package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "societes", schema = "gestiondeconge" ) public class SocietesEntity {
    private int idSociete;
    private String nom;
    private String tel;
    private Integer ntva;
    private String email;
    private Integer fkAdresse;

    @Id @Column( name = "idSociete", nullable = false ) public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete( int idSociete ) {
        this.idSociete = idSociete;
    }

    @Basic @Column( name = "Nom", nullable = false, length = 45 ) public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    @Basic @Column( name = "Tel", nullable = true, length = 45 ) public String getTel() {
        return tel;
    }

    public void setTel( String tel ) {
        this.tel = tel;
    }

    @Basic @Column( name = "NTVA", nullable = true ) public Integer getNtva() {
        return ntva;
    }

    public void setNtva( Integer ntva ) {
        this.ntva = ntva;
    }

    @Basic @Column( name = "Email", nullable = true, length = 100 ) public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
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
        SocietesEntity that = (SocietesEntity) o;
        return idSociete == that.idSociete &&
                Objects.equals( nom, that.nom ) &&
                Objects.equals( tel, that.tel ) &&
                Objects.equals( ntva, that.ntva ) &&
                Objects.equals( email, that.email ) &&
                Objects.equals( fkAdresse, that.fkAdresse );
    }

    @Override public int hashCode() {
        return Objects.hash( idSociete, nom, tel, ntva, email, fkAdresse );
    }
}
