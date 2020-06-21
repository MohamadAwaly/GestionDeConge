package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "pays", schema = "gestiondeconge", catalog = "" ) public class PaysEntity {
    private int idPays;
    private String nomPays;

    @Id @Column( name = "IDPays", nullable = false ) public int getIdPays() {
        return idPays;
    }

    public void setIdPays( int idPays ) {
        this.idPays = idPays;
    }

    @Basic @Column( name = "NomPays", nullable = false, length = -1 ) public String getNomPays() {
        return nomPays;
    }

    public void setNomPays( String nomPays ) {
        this.nomPays = nomPays;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PaysEntity that = (PaysEntity) o;
        return idPays == that.idPays &&
                Objects.equals( nomPays, that.nomPays );
    }

    @Override public int hashCode() {
        return Objects.hash( idPays, nomPays );
    }
}
