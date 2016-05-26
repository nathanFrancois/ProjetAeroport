package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Nathan on 26/05/2016.
 */
@Entity
@IdClass(FixePK.class)
public class Fixe {
    private Integer nummission;
    private Integer numobjectif;

    @Id
    @Column(name = "NUMMISSION")
    public Integer getNummission() {
        return nummission;
    }

    public void setNummission(Integer nummission) {
        this.nummission = nummission;
    }

    @Id
    @Column(name = "NUMOBJECTIF")
    public Integer getNumobjectif() {
        return numobjectif;
    }

    public void setNumobjectif(Integer numobjectif) {
        this.numobjectif = numobjectif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fixe fixe = (Fixe) o;

        if (nummission != null ? !nummission.equals(fixe.nummission) : fixe.nummission != null) return false;
        if (numobjectif != null ? !numobjectif.equals(fixe.numobjectif) : fixe.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission != null ? nummission.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }
}
