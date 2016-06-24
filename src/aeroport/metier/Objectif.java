package aeroport.metier;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nathan on 22/06/2016.
 */
@Entity
public class Objectif {

    @Id
    @Column(name = "NUMOBJECTIF", nullable = false)
    private int numobjectif;

    @Basic
    @Column(name = "NUMMISSION", nullable = true)
    private Integer nummission;

    @Basic
    @Column(name = "LIBOBECTIF", nullable = true, length = 25)
    private String libobectif;


    public int getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(int numobjectif) {
        this.numobjectif = numobjectif;
    }

    public Integer getNummission() {
        return nummission;
    }

    public void setNummission(Integer nummission) {
        this.nummission = nummission;
    }

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

        if (numobjectif != objectif.numobjectif) return false;
        if (nummission != null ? !nummission.equals(objectif.nummission) : objectif.nummission != null) return false;
        if (libobectif != null ? !libobectif.equals(objectif.libobectif) : objectif.libobectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numobjectif;
        result = 31 * result + (nummission != null ? nummission.hashCode() : 0);
        result = 31 * result + (libobectif != null ? libobectif.hashCode() : 0);
        return result;
    }
}
