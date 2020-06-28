package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "adresses", schema = "gestiondeconge" ) public class AdressesEntity {
    private int idAdresse;
    private String nomRue;
    private Integer numero;
    private Integer fkVille;

    @Id @Column( name = "idAdresse", nullable = false ) public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse( int idAdresse ) {
        this.idAdresse = idAdresse;
    }

    @Basic @Column( name = "NomRue", nullable = true, length = 45 ) public String getNomRue() {
        return nomRue;
    }

    public void setNomRue( String nomRue ) {
        this.nomRue = nomRue;
    }

    @Basic @Column( name = "Numero", nullable = true ) public Integer getNumero() {
        return numero;
    }

    public void setNumero( Integer numero ) {
        this.numero = numero;
    }

    @Basic @Column( name = "FKVille", nullable = true ) public Integer getFkVille() {
        return fkVille;
    }

    public void setFkVille( Integer fkVille ) {
        this.fkVille = fkVille;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        AdressesEntity that = (AdressesEntity) o;
        return idAdresse == that.idAdresse &&
                Objects.equals( nomRue, that.nomRue ) &&
                Objects.equals( numero, that.numero ) &&
                Objects.equals( fkVille, that.fkVille );
    }

    @Override public int hashCode() {
        return Objects.hash( idAdresse, nomRue, numero, fkVille );
    }
}
