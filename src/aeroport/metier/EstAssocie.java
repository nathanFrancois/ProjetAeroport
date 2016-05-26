package aeroport.metier;

import javax.persistence.*;

/**
 * Created by Nathan on 26/05/2016.
 */
@Entity
@Table(name = "EST_ASSOCIE", schema = "baseaeroport", catalog = "")
@IdClass(EstAssociePK.class)
public class EstAssocie {
    private Integer numaction;
    private Integer numobjectif;

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
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

        EstAssocie that = (EstAssocie) o;

        if (numaction != null ? !numaction.equals(that.numaction) : that.numaction != null) return false;
        if (numobjectif != null ? !numobjectif.equals(that.numobjectif) : that.numobjectif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (numobjectif != null ? numobjectif.hashCode() : 0);
        return result;
    }
}
