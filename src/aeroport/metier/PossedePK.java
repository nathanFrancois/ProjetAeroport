package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Nathan on 22/06/2016.
 */
public class PossedePK implements Serializable {
    private int numaction;
    private int numregle;

    @Column(name = "NUMACTION", nullable = false)
    @Id
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Column(name = "NUMREGLE", nullable = false)
    @Id
    public int getNumregle() {
        return numregle;
    }

    public void setNumregle(int numregle) {
        this.numregle = numregle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PossedePK possedePK = (PossedePK) o;

        if (numaction != possedePK.numaction) return false;
        if (numregle != possedePK.numregle) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + numregle;
        return result;
    }
}
