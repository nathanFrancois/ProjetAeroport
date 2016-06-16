package aeroport.metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nathan on 16/06/2016.
 */
@Entity
public class Objectif {
    private Integer numobjectif;
    private String libobectif;

    @Id
    @Column(name = "NUMOBJECTIF")
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Basic
    @Column(name = "LIBOBECTIF")
    public String getLibobectif() {
        return libobectif;
    }

    public void setLibobectif(String libobectif) {
        this.libobectif = libobectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Objectif objectif = (Objectif) o;

        if (numobjectif != null ? !numobjectif.equals(objectif.numobjectif) : objectif.numobjectif != null)
            return false;
        if (libobectif != null ? !libobectif.equals(objectif.libobectif) : objectif.libobectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif != null ? numobjectif.hashCode() : 0;
        result = 31 * result + (libobectif != null ? libobectif.hashCode() : 0);
        return result;
    }
}
