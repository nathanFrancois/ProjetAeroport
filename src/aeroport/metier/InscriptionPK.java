package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Nathan on 22/06/2016.
 */
public class InscriptionPK implements Serializable {
    private int numjeu;
    private int numapprenant;

    @Column(name = "NUMJEU", nullable = false)
    @Id
    public int getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(int numjeu) {
        this.numjeu = numjeu;
    }

    @Column(name = "NUMAPPRENANT", nullable = false)
    @Id
    public int getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(int numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionPK that = (InscriptionPK) o;

        if (numjeu != that.numjeu) return false;
        if (numapprenant != that.numapprenant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu;
        result = 31 * result + numapprenant;
        return result;
    }
}
