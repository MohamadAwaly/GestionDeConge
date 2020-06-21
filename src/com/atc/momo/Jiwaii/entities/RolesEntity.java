package com.atc.momo.Jiwaii.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity @Table( name = "roles", schema = "gestiondeconge", catalog = "" ) public class RolesEntity {
    private int idRole;
    private String typeRole;

    @Id @Column( name = "IDRole", nullable = false ) public int getIdRole() {
        return idRole;
    }

    public void setIdRole( int idRole ) {
        this.idRole = idRole;
    }

    @Basic @Column( name = "TypeRole", nullable = false, length = 50 ) public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole( String typeRole ) {
        this.typeRole = typeRole;
    }

    @Override public boolean equals( Object o ) {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        RolesEntity that = (RolesEntity) o;
        return idRole == that.idRole &&
                Objects.equals( typeRole, that.typeRole );
    }

    @Override public int hashCode() {
        return Objects.hash( idRole, typeRole );
    }
}
