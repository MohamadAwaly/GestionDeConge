package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "typedemande", schema = "gestiondeconge") public class TypedemandeEntity {
    private int idTypeDemande;
    private String libele;
    private String description;

    @Id @Column( name = "idTypeDemande", nullable = false ) public int getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande( int idTypeDemande ) {
        this.idTypeDemande = idTypeDemande;
    }

    @Basic @Column( name = "Libele", nullable = true, length = 45 ) public String getLibele() {
        return libele;
    }

    public void setLibele( String libele ) {
        this.libele = libele;
    }

    @Basic @Column( name = "Description", nullable = true, length = 255 ) public String getDescription() {
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
        TypedemandeEntity that = (TypedemandeEntity) o;
        return idTypeDemande == that.idTypeDemande &&
                Objects.equals( libele, that.libele ) &&
                Objects.equals( description, that.description );
    }

    @Override public int hashCode() {
        return Objects.hash( idTypeDemande, libele, description );
    }
}
