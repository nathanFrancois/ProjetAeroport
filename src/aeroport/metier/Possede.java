package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * Created by Nathan on 26/05/2016.
 */
@Entity
@IdClass(PossedePK.class)
public class Possede {
    private Integer numaction;
    private Integer numregle;

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Id
    @Column(name = "NUMREGLE")
    public Integer getNumregle() {
        return numregle;
    }

    public void setNumregle(Integer numregle) {
        this.numregle = numregle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Possede possede = (Possede) o;

        if (numaction != null ? !numaction.equals(possede.numaction) : possede.numaction != null) return false;
        if (numregle != null ? !numregle.equals(possede.numregle) : possede.numregle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (numregle != null ? numregle.hashCode() : 0);
        return result;
    }
}
