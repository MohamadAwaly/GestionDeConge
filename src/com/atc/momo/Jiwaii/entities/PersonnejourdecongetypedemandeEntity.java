package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity @Table( name = "personnejourdecongetypedemande", schema = "gestiondeconge" )
public class PersonnejourdecongetypedemandeEntity {

    public enum EnumApprouver {
        Rien,
        En_Cours,
        Accepte ,
        Refuse
    }

    private int           idPersonneJourDeCongeTypeDemande;
    private Integer       fkPersonne;
    private Date          dateDemande;
    private Date          dateReponse;
    private String        messageApprobateur;
    private Integer       fkTypeDemande;
    private EnumApprouver aprouver;
    private Date          datedebut;
    private Date          datefin;

    @Id @Column( name = "idPersonneJourDeCongeTypeDemande", nullable = false )
    public int getIdPersonneJourDeCongeTypeDemande() {
        return idPersonneJourDeCongeTypeDemande;
    }

    public void setIdPersonneJourDeCongeTypeDemande( int idPersonneJourDeCongeTypeDemande ) {
        this.idPersonneJourDeCongeTypeDemande = idPersonneJourDeCongeTypeDemande;
    }

    @Basic @Column( name = "FKPersonne", nullable = true ) public Integer getFkPersonne() {
        return fkPersonne;
    }

    public void setFkPersonne( Integer fkPersonne ) {
        this.fkPersonne = fkPersonne;
    }

    @Basic @Column( name = "DateDemande", nullable = true ) public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande( Date dateDemande ) {
        this.dateDemande = dateDemande;
    }

    @Basic @Column( name = "DateReponse", nullable = true ) public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse( Date dateReponse ) {
        this.dateReponse = dateReponse;
    }

    @Basic @Column( name = "MessageApprobateur", nullable = true, length = 255 ) public String getMessageApprobateur() {
        return messageApprobateur;
    }

    public void setMessageApprobateur( String messageApprobateur ) {
        this.messageApprobateur = messageApprobateur;
    }

    @Basic @Column( name = "FKTypeDemande", nullable = true ) public Integer getFkTypeDemande() {
        return fkTypeDemande;
    }

    public void setFkTypeDemande( Integer fkTypeDemande ) {
        this.fkTypeDemande = fkTypeDemande;
    }

    @Basic @Column( name = "Aprouver", nullable = true ) public EnumApprouver getAprouver() {
        return aprouver;
    }

    public void setAprouver( EnumApprouver aprouver ) {
        this.aprouver = aprouver;
    }

    @Basic @Column( name = "Datedebut", nullable = false ) public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut( Date datedebut ) {
        this.datedebut = datedebut;
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
        PersonnejourdecongetypedemandeEntity that = (PersonnejourdecongetypedemandeEntity) o;
        return idPersonneJourDeCongeTypeDemande == that.idPersonneJourDeCongeTypeDemande &&
                Objects.equals( fkPersonne, that.fkPersonne ) &&
                Objects.equals( dateDemande, that.dateDemande ) &&
                Objects.equals( dateReponse, that.dateReponse ) &&
                Objects.equals( messageApprobateur, that.messageApprobateur ) &&
                Objects.equals( fkTypeDemande, that.fkTypeDemande ) &&
                Objects.equals( aprouver, that.aprouver ) &&
                Objects.equals( datedebut, that.datedebut ) &&
                Objects.equals( datefin, that.datefin );
    }

    @Override public int hashCode() {
        return Objects.hash( idPersonneJourDeCongeTypeDemande, fkPersonne, dateDemande, dateReponse,
                messageApprobateur, fkTypeDemande, aprouver, datedebut, datefin );
    }
}
