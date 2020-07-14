package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "jourdecongeautorise", schema = "gestiondeconge" )
public class JourdecongeautoriseEntity {
    private int idJourDeCongeAutorise;
    private Integer nbrJourAutorise;

    @Id @Column( name = "idJourDeCongeAutorise", nullable = false ) public int getIdJourDeCongeAutorise() {
        return idJourDeCongeAutorise;
    }

    public void setIdJourDeCongeAutorise( int idJourDeCongeAutorise ) {
        this.idJourDeCongeAutorise = idJourDeCongeAutorise;
    }

    @Basic @Column( name = "NbrJourAutorise", nullable = true ) public Integer getNbrJourAutorise() {
        return nbrJourAutorise;
    }

    public void setNbrJourAutorise( Integer nbrJourAutorise ) {
        this.nbrJourAutorise = nbrJourAutorise;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        JourdecongeautoriseEntity that = (JourdecongeautoriseEntity) o;
        return idJourDeCongeAutorise == that.idJourDeCongeAutorise &&
                Objects.equals( nbrJourAutorise, that.nbrJourAutorise );
    }

    @Override public int hashCode() {
        return Objects.hash( idJourDeCongeAutorise, nbrJourAutorise );
    }
}
