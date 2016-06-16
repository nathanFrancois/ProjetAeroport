package aeroport.metier;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Nathan on 16/06/2016.
 */
public class ObtientPK implements Serializable {
    private String username;
    private Date datejour;
    private Integer numaction;

    @Column(name = "USERNAME")
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "DATEJOUR")
    @Id
    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Column(name = "NUMACTION")
    @Id
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

        ObtientPK obtientPK = (ObtientPK) o;

        if (username != null ? !username.equals(obtientPK.username) : obtientPK.username != null) return false;
        if (datejour != null ? !datejour.equals(obtientPK.datejour) : obtientPK.datejour != null) return false;
        if (numaction != null ? !numaction.equals(obtientPK.numaction) : obtientPK.numaction != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        result = 31 * result + (numaction != null ? numaction.hashCode() : 0);
        return result;
    }
}
