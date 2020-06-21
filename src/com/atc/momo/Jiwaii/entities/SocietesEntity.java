package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "societes", schema = "gestiondeconge", catalog = "" ) public class SocietesEntity {
    private int idSociete;
    private String nom;
    private int tel;
    private int nTva;
    private String email;

    @Id @Column( name = "IDSociete", nullable = false ) public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete( int idSociete ) {
        this.idSociete = idSociete;
    }

    @Basic @Column( name = "Nom", nullable = false, length = 50 ) public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    @Basic @Column( name = "Tel", nullable = false ) public int getTel() {
        return tel;
    }

    public void setTel( int tel ) {
        this.tel = tel;
    }

    @Basic @Column( name = "NTva", nullable = false ) public int getnTva() {
        return nTva;
    }

    public void setnTva( int nTva ) {
        this.nTva = nTva;
    }

    @Basic @Column( name = "Email", nullable = false, length = 255 ) public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        SocietesEntity that = (SocietesEntity) o;
        return idSociete == that.idSociete &&
                tel == that.tel &&
                nTva == that.nTva &&
                Objects.equals( nom, that.nom ) &&
                Objects.equals( email, that.email );
    }

    @Override public int hashCode() {
        return Objects.hash( idSociete, nom, tel, nTva, email );
    }
}
