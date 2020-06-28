package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "jourdeconge", schema = "gestiondeconge") public class JourdecongeEntity {
    private int idJourDeconge;
    private Date dateDebut;
    private Date dateFin;

    @Id @Column( name = "idJourDeconge", nullable = false ) public int getIdJourDeconge() {
        return idJourDeconge;
    }

    public void setIdJourDeconge( int idJourDeconge ) {
        this.idJourDeconge = idJourDeconge;
    }

    @Basic @Column( name = "DateDebut", nullable = false ) public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut( Date dateDebut ) {
        this.dateDebut = dateDebut;
    }

    @Basic @Column( name = "DateFin", nullable = false ) public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin( Date dateFin ) {
        this.dateFin = dateFin;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        JourdecongeEntity that = (JourdecongeEntity) o;
        return idJourDeconge == that.idJourDeconge &&
                Objects.equals( dateDebut, that.dateDebut ) &&
                Objects.equals( dateFin, that.dateFin );
    }

    @Override public int hashCode() {
        return Objects.hash( idJourDeconge, dateDebut, dateFin );
    }
}
