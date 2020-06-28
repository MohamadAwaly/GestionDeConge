package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "villes", schema = "gestiondeconge") public class VillesEntity {
    private int idVille;
    private String nomVille;
    private Integer codePosal;
    private Integer fkPays;
    private String villescol;

    @Id @Column( name = "idVille", nullable = false ) public int getIdVille() {
        return idVille;
    }

    public void setIdVille( int idVille ) {
        this.idVille = idVille;
    }

    @Basic @Column( name = "NomVille", nullable = true, length = 45 ) public String getNomVille() {
        return nomVille;
    }

    public void setNomVille( String nomVille ) {
        this.nomVille = nomVille;
    }

    @Basic @Column( name = "CodePosal", nullable = true ) public Integer getCodePosal() {
        return codePosal;
    }

    public void setCodePosal( Integer codePosal ) {
        this.codePosal = codePosal;
    }

    @Basic @Column( name = "FKPays", nullable = true ) public Integer getFkPays() {
        return fkPays;
    }

    public void setFkPays( Integer fkPays ) {
        this.fkPays = fkPays;
    }

    @Basic @Column( name = "Villescol", nullable = true, length = 45 ) public String getVillescol() {
        return villescol;
    }

    public void setVillescol( String villescol ) {
        this.villescol = villescol;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        VillesEntity that = (VillesEntity) o;
        return idVille == that.idVille &&
                Objects.equals( nomVille, that.nomVille ) &&
                Objects.equals( codePosal, that.codePosal ) &&
                Objects.equals( fkPays, that.fkPays ) &&
                Objects.equals( villescol, that.villescol );
    }

    @Override public int hashCode() {
        return Objects.hash( idVille, nomVille, codePosal, fkPays, villescol );
    }
}
