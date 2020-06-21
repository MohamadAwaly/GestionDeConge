package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "jourdeconge", schema = "gestiondeconge", catalog = "" ) public class JourdecongeEntity {
    private int idJourDeConge;
    private Date dateDebut;
    private Date dateFin;

    @Id @Column( name = "IDJourDeConge", nullable = false ) public int getIdJourDeConge() {
        return idJourDeConge;
    }

    public void setIdJourDeConge( int idJourDeConge ) {
        this.idJourDeConge = idJourDeConge;
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
        return idJourDeConge == that.idJourDeConge &&
                Objects.equals( dateDebut, that.dateDebut ) &&
                Objects.equals( dateFin, that.dateFin );
    }

    @Override public int hashCode() {
        return Objects.hash( idJourDeConge, dateDebut, dateFin );
    }
}
