package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Nathan on 22/06/2016.
 */
public class ComprendPK implements Serializable {
    private int numjeu;
    private int nummission;

    @Column(name = "NUMJEU", nullable = false)
    @Id
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Column(name = "NUMMISSION", nullable = false)
    @Id
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComprendPK that = (ComprendPK) o;

        if (numjeu != that.numjeu) return false;
        if (nummission != that.nummission) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + nummission;
        return result;
    }
}
