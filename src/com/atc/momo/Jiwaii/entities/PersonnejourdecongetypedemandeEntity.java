package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnejourdecongetypedemande", schema = "gestiondeconge", catalog = "" ) public class PersonnejourdecongetypedemandeEntity {
    private int idPersonneJourDeCongeTypeDemande;
    private int fkPersonne;
    private int fkJourDeConge;
    private Date dateDemande;
    private Date dateReponse;
    private String messageApprobateur;
    private int fkTypeDemande;
    private Object apprrouve;

    @Id @Column( name = "IDPersonneJourDeCongeTypeDemande", nullable = false ) public int getIdPersonneJourDeCongeTypeDemande() {
        return idPersonneJourDeCongeTypeDemande;
    }

    public void setIdPersonneJourDeCongeTypeDemande( int idPersonneJourDeCongeTypeDemande ) {
        this.idPersonneJourDeCongeTypeDemande = idPersonneJourDeCongeTypeDemande;
    }

    @Basic @Column( name = "FKPersonne", nullable = false ) public int getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( int fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "FKJourDeConge", nullable = false ) public int getFkJourDeConge() {
        return fkJourDeConge;
    }

    public void setFkJourDeConge( int fkJourDeConge ) {
        this.fkJourDeConge = fkJourDeConge;
    }

    @Basic @Column( name = "DateDemande", nullable = false ) public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande( Date dateDemande ) {
        this.dateDemande = dateDemande;
    }

    @Basic @Column( name = "DateReponse", nullable = false ) public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse( Date dateReponse ) {
        this.dateReponse = dateReponse;
    }

    @Basic @Column( name = "MessageApprobateur", nullable = false, length = 255 ) public String getMessageApprobateur() {
        return messageApprobateur;
    }

    public void setMessageApprobateur( String messageApprobateur ) {
        this.messageApprobateur = messageApprobateur;
    }

    @Basic @Column( name = "FKTypeDemande", nullable = false ) public int getFkTypeDemande() {
        return fkTypeDemande;
    }

    public void setFkTypeDemande( int fkTypeDemande ) {
        this.fkTypeDemande = fkTypeDemande;
    }

    @Basic @Column( name = "Apprrouve", nullable = true ) public Object getApprrouve() {
        return apprrouve;
    }

    public void setApprrouve( Object apprrouve ) {
        this.apprrouve = apprrouve;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        PersonnejourdecongetypedemandeEntity that = (PersonnejourdecongetypedemandeEntity) o;
        return idPersonneJourDeCongeTypeDemande == that.idPersonneJourDeCongeTypeDemande &&
                fkPersonne == that.fkPersonne &&
                fkJourDeConge == that.fkJourDeConge &&
                fkTypeDemande == that.fkTypeDemande &&
                Objects.equals( dateDemande, that.dateDemande ) &&
                Objects.equals( dateReponse, that.dateReponse ) &&
                Objects.equals( messageApprobateur, that.messageApprobateur ) &&
                Objects.equals( apprrouve, that.apprrouve );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonneJourDeCongeTypeDemande, fkPersonne, fkJourDeConge, dateDemande, dateReponse,
                messageApprobateur, fkTypeDemande, apprrouve );
    }
}
