package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnejourdecongeautorisetypedemande", schema = "gestiondeconge")
public class PersonnejourdecongeautorisetypedemandeEntity {
    private int idPersonneJourDeCongeAutoriseTypeDemande;
    private Integer fkPersonne;
    private Integer fkJourCongeAutorise;
    private Date dateDebut;
    private Date dateFin;
    private Integer fkTypeDemandes;

    @Id @Column( name = "idPersonneJourDeCongeAutoriseTypeDemande", nullable = false ) public int getIdPersonneJourDeCongeAutoriseTypeDemande() {
        return idPersonneJourDeCongeAutoriseTypeDemande;
    }

    public void setIdPersonneJourDeCongeAutoriseTypeDemande( int idPersonneJourDeCongeAutoriseTypeDemande ) {
        this.idPersonneJourDeCongeAutoriseTypeDemande = idPersonneJourDeCongeAutoriseTypeDemande;
    }

    @Basic @Column( name = "FKPersonne", nullable = true ) public Integer getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( Integer fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "FKJourCongeAutorise", nullable = true ) public Integer getFkJourCongeAutorise() {
        return fkJourCongeAutorise;
    }

    public void setFkJourCongeAutorise( Integer fkJourCongeAutorise ) {
        this.fkJourCongeAutorise = fkJourCongeAutorise;
    }

    @Basic @Column( name = "DateDebut", nullable = false ) public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut( Date dateDebut ) {
        this.dateDebut = dateDebut;
    }

    @Basic @Column( name = "DateFin", nullable = true ) public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin( Date dateFin ) {
        this.dateFin = dateFin;
    }

    @Basic @Column( name = "FKTypeDemandes", nullable = true ) public Integer getFkTypeDemandes() {
        return fkTypeDemandes;
    }

    public void setFkTypeDemandes( Integer fkTypeDemandes ) {
        this.fkTypeDemandes = fkTypeDemandes;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnejourdecongeautorisetypedemandeEntity that = (PersonnejourdecongeautorisetypedemandeEntity) o;
        return idPersonneJourDeCongeAutoriseTypeDemande == that.idPersonneJourDeCongeAutoriseTypeDemande &&
                Objects.equals( fkPersonne, that.fkPersonne ) &&
                Objects.equals( fkJourCongeAutorise, that.fkJourCongeAutorise ) &&
                Objects.equals( dateDebut, that.dateDebut ) &&
                Objects.equals( dateFin, that.dateFin ) &&
                Objects.equals( fkTypeDemandes, that.fkTypeDemandes );
    }

    @Override public int hashCode() {
        return Objects
                .hash( idPersonneJourDeCongeAutoriseTypeDemande, fkPersonne, fkJourCongeAutorise, dateDebut, dateFin,
                        fkTypeDemandes );
    }
}
