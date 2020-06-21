package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "villes", schema = "gestiondeconge", catalog = "" ) public class VillesEntity {
    private int idVille;
    private String nomVille;
    private int codePostal;
    private int fkPays;

    @Id @Column( name = "IDVille", nullable = false ) public int getIdVille() {
        return idVille;
    }

    public void setIdVille( int idVille ) {
        this.idVille = idVille;
    }

    @Basic @Column( name = "NomVille", nullable = false, length = -1 ) public String getNomVille() {
        return nomVille;
    }

    public void setNomVille( String nomVille ) {
        this.nomVille = nomVille;
    }

    @Basic @Column( name = "CodePostal", nullable = false ) public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal( int codePostal ) {
        this.codePostal = codePostal;
    }

    @Basic @Column( name = "FKPays", nullable = false ) public int getFkPays() {
        return fkPays;
    }

    public void setFkPays( int fkPays ) {
        this.fkPays = fkPays;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        VillesEntity that = (VillesEntity) o;
        return idVille == that.idVille &&
                codePostal == that.codePostal &&
                fkPays == that.fkPays &&
                Objects.equals( nomVille, that.nomVille );
    }

    @Override public int hashCode() {
        return Objects.hash( idVille, nomVille, codePostal, fkPays );
    }
}
