package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Nathan on 22/06/2016.
 */
public class ObtientPK implements Serializable {
    private int idusers;
    private Date datejour;
    private int numaction;

    @Column(name = "IDUSERS", nullable = false)
    @Id
    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    @Column(name = "DATEJOUR", nullable = false)
    @Id
    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Column(name = "NUMACTION", nullable = false)
    @Id
    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObtientPK obtientPK = (ObtientPK) o;

        if (idusers != obtientPK.idusers) return false;
        if (numaction != obtientPK.numaction) return false;
        if (datejour != null ? !datejour.equals(obtientPK.datejour) : obtientPK.datejour != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusers;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        result = 31 * result + numaction;
        return result;
    }
}
