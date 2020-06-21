package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnessocietes", schema = "gestiondeconge", catalog = "" ) public class PersonnessocietesEntity {
    private int idPersonnesSocietes;
    private int fkSociete;
    private int fkPersonne;
    private Date dateInscription;
    private Date datefin;

    @Id @Column( name = "IDPersonnesSocietes", nullable = false ) public int getIdPersonnesSocietes() {
        return idPersonnesSocietes;
    }

    public void setIdPersonnesSocietes( int idPersonnesSocietes ) {
        this.idPersonnesSocietes = idPersonnesSocietes;
    }

    @Basic @Column( name = "FkSociete", nullable = false ) public int getFkSociete() {
        return fkSociete;
    }

    public void setFkSociete( int fkSociete ) {
        this.fkSociete = fkSociete;
    }

    @Basic @Column( name = "FkPersonne", nullable = false ) public int getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( int fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "DateInscription", nullable = false ) public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription( Date dateInscription ) {
        this.dateInscription = dateInscription;
    }

    @Basic @Column( name = "Datefin", nullable = false ) public Date getDatefin() {
        return datefin;
    }

    public void setDatefin( Date datefin ) {
        this.datefin = datefin;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnessocietesEntity that = (PersonnessocietesEntity) o;
        return idPersonnesSocietes == that.idPersonnesSocietes &&
                fkSociete == that.fkSociete &&
                fkPersonne == that.fkPersonne &&
                Objects.equals( dateInscription, that.dateInscription ) &&
                Objects.equals( datefin, that.datefin );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonnesSocietes, fkSociete, fkPersonne, dateInscription, datefin );
    }
}
