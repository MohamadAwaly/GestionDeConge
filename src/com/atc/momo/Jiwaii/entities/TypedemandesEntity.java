package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "typedemandes", schema = "gestiondeconge", catalog = "" ) public class TypedemandesEntity {
    private int idTypeDemande;
    private String libele;
    private String description;

    @Id @Column( name = "IDTypeDemande", nullable = false ) public int getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande( int idTypeDemande ) {
        this.idTypeDemande = idTypeDemande;
    }

    @Basic @Column( name = "Libele", nullable = false, length = 50 ) public String getLibele() {
        return libele;
    }

    public void setLibele( String libele ) {
        this.libele = libele;
    }

    @Basic @Column( name = "Description", nullable = false, length = 255 ) public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        TypedemandesEntity that = (TypedemandesEntity) o;
        return idTypeDemande == that.idTypeDemande &&
                Objects.equals( libele, that.libele ) &&
                Objects.equals( description, that.description );
    }

    @Override public int hashCode() {
        return Objects.hash( idTypeDemande, libele, description );
    }
}
