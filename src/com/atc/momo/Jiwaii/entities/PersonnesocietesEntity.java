package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnesocietes", schema = "gestiondeconge") public class PersonnesocietesEntity {
    private int idPersonneSocietes;
    private Integer fkSociete;
    private Integer fkPersonne;
    private Date dateInscription;
    private Date dateFin;

    @Id @Column( name = "idPersonneSocietes", nullable = false ) public int getIdPersonneSocietes() {
        return idPersonneSocietes;
    }

    public void setIdPersonneSocietes( int idPersonneSocietes ) {
        this.idPersonneSocietes = idPersonneSocietes;
    }

    @Basic @Column( name = "FKSociete", nullable = true ) public Integer getFkSociete() {
        return fkSociete;
    }

    public void setFkSociete( Integer fkSociete ) {
        this.fkSociete = fkSociete;
    }

    @Basic @Column( name = "FKPersonne", nullable = true ) public Integer getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( Integer fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "DateInscription", nullable = false ) public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription( Date dateInscription ) {
        this.dateInscription = dateInscription;
    }

    @Basic @Column( name = "DateFin", nullable = true ) public Date getDateFin() {
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
        PersonnesocietesEntity that = (PersonnesocietesEntity) o;
        return idPersonneSocietes == that.idPersonneSocietes &&
                Objects.equals( fkSociete, that.fkSociete ) &&
                Objects.equals( fkPersonne, that.fkPersonne ) &&
                Objects.equals( dateInscription, that.dateInscription ) &&
                Objects.equals( dateFin, that.dateFin );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonneSocietes, fkSociete, fkPersonne, dateInscription, dateFin );
    }
}
