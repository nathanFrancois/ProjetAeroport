package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Nathan on 26/05/2016.
 */
@Entity
@IdClass(AppartientPK.class)
public class Appartient {
    private Integer numjeu;
    private Integer numaction;

    @Id
    @Column(name = "NUMJEU")
    public Integer getNumjeu() {
        return numjeu;
    }

    public void setNumjeu(Integer numjeu) {
        this.numjeu = numjeu;
    }

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appartient that = (Appartient) o;

        if (numjeu != null ? !numjeu.equals(that.numjeu) : that.numjeu != null) return false;
        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numjeu != null ? numjeu.hashCode() : 0;
        result = 31 * result + (numaction != null ? numaction.hashCode() : 0);
        return result;
    }
}
