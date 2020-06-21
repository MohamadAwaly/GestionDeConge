package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "adresses", schema = "gestiondeconge", catalog = "" ) public class AdressesEntity {
    private int    idAdresse;
    private String nomRue;
    private int    numero;
    private int    fkVille;

    @Id @Column( name = "IDAdresse", nullable = false ) public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse( int idAdresse ) {
        this.idAdresse = idAdresse;
    }

    @Basic @Column( name = "NomRue", nullable = false, length = -1 ) public String getNomRue() {
        return nomRue;
    }

    public void setNomRue( String nomRue ) {
        this.nomRue = nomRue;
    }

    @Basic @Column( name = "Numero", nullable = false ) public int getNumero() {
        return numero;
    }

    public void setNumero( int numero ) {
        this.numero = numero;
    }

    @Basic @Column( name = "FKVille", nullable = false ) public int getFkVille() {
        return fkVille;
    }

    public void setFkVille( int fkVille ) {
        this.fkVille = fkVille;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        AdressesEntity that = (AdressesEntity) o;
        return idAdresse == that.idAdresse &&
                numero == that.numero &&
                fkVille == that.fkVille &&
                Objects.equals( nomRue, that.nomRue );
    }

    @Override public int hashCode() {
        return Objects.hash( idAdresse, nomRue, numero, fkVille );
    }
}
