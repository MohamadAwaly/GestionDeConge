package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "jourdecongeautorise", schema = "gestiondeconge", catalog = "" ) public class JourdecongeautoriseEntity {
    private int idJourCongeAutorise;
    private int nbrJourAutorise;

    @Id @Column( name = "IDJourCongeAutorise", nullable = false ) public int getIdJourCongeAutorise() {
        return idJourCongeAutorise;
    }

    public void setIdJourCongeAutorise( int idJourCongeAutorise ) {
        this.idJourCongeAutorise = idJourCongeAutorise;
    }

    @Basic @Column( name = "NbrJourAutorise", nullable = false ) public int getNbrJourAutorise() {
        return nbrJourAutorise;
    }

    public void setNbrJourAutorise( int nbrJourAutorise ) {
        this.nbrJourAutorise = nbrJourAutorise;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        JourdecongeautoriseEntity that = (JourdecongeautoriseEntity) o;
        return idJourCongeAutorise == that.idJourCongeAutorise &&
                nbrJourAutorise == that.nbrJourAutorise;
    }

    @Override public int hashCode() {
        return Objects.hash( idJourCongeAutorise, nbrJourAutorise );
    }
}
