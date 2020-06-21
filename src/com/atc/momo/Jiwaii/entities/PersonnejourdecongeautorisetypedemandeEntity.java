package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnejourdecongeautorisetypedemande", schema = "gestiondeconge", catalog = "" ) public class PersonnejourdecongeautorisetypedemandeEntity {
    private int idPersonneJourDeCongeAutoriseTypeDemande;
    private int fkPersonne;
    private int fkJourCongeAutorise;
    private Date dateDebut;
    private Date dateFin;
    private int fkTypeDemandes;

    @Id @Column( name = "IDPersonneJourDeCongeAutoriseTypeDemande", nullable = false ) public int getIdPersonneJourDeCongeAutoriseTypeDemande() {
        return idPersonneJourDeCongeAutoriseTypeDemande;
    }

    public void setIdPersonneJourDeCongeAutoriseTypeDemande( int idPersonneJourDeCongeAutoriseTypeDemande ) {
        this.idPersonneJourDeCongeAutoriseTypeDemande = idPersonneJourDeCongeAutoriseTypeDemande;
    }

    @Basic @Column( name = "FKPersonne", nullable = false ) public int getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( int fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "FKJourCongeAutorise", nullable = false ) public int getFkJourCongeAutorise() {
        return fkJourCongeAutorise;
    }

    public void setFkJourCongeAutorise( int fkJourCongeAutorise ) {
        this.fkJourCongeAutorise = fkJourCongeAutorise;
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

    @Basic @Column( name = "FKTypeDemandes", nullable = false ) public int getFkTypeDemandes() {
        return fkTypeDemandes;
    }

    public void setFkTypeDemandes( int fkTypeDemandes ) {
        this.fkTypeDemandes = fkTypeDemandes;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnejourdecongeautorisetypedemandeEntity that = (PersonnejourdecongeautorisetypedemandeEntity) o;
        return idPersonneJourDeCongeAutoriseTypeDemande == that.idPersonneJourDeCongeAutoriseTypeDemande &&
                fkPersonne == that.fkPersonne &&
                fkJourCongeAutorise == that.fkJourCongeAutorise &&
                fkTypeDemandes == that.fkTypeDemandes &&
                Objects.equals( dateDebut, that.dateDebut ) &&
                Objects.equals( dateFin, that.dateFin );
    }

    @Override public int hashCode() {
        return Objects
                .hash( idPersonneJourDeCongeAutoriseTypeDemande, fkPersonne, fkJourCongeAutorise, dateDebut, dateFin,
                        fkTypeDemandes );
    }
}
