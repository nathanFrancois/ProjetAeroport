package aeroport.metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Nathan on 26/05/2016.
 */
@Entity
@IdClass(ObtientPK.class)
public class Obtient {
    private Integer numapprenant;
    private Date datejour;
    private Integer numaction;
    private Integer valeurdebut;
    private Integer valeurfin;

    @Id
    @Column(name = "NUMAPPRENANT")
    public Integer getNumapprenant() {
        return numapprenant;
    }

    public void setNumapprenant(Integer numapprenant) {
        this.numapprenant = numapprenant;
    }

    @Id
    @Column(name = "DATEJOUR")
    public Date getDatejour() {
        return datejour;
    }

    public void setDatejour(Date datejour) {
        this.datejour = datejour;
    }

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "VALEURDEBUT")
    public Integer getValeurdebut() {
        return valeurdebut;
    }

    public void setValeurdebut(Integer valeurdebut) {
        this.valeurdebut = valeurdebut;
    }

    @Basic
    @Column(name = "VALEURFIN")
    public Integer getValeurfin() {
        return valeurfin;
    }

    public void setValeurfin(Integer valeurfin) {
        this.valeurfin = valeurfin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Obtient obtient = (Obtient) o;

        if (numapprenant != null ? !numapprenant.equals(obtient.numapprenant) : obtient.numapprenant != null)
            return false;
        if (datejour != null ? !datejour.equals(obtient.datejour) : obtient.datejour != null) return false;
        if (numaction != null ? !numaction.equals(obtient.numaction) : obtient.numaction != null) return false;
        if (valeurdebut != null ? !valeurdebut.equals(obtient.valeurdebut) : obtient.valeurdebut != null) return false;
        if (valeurfin != null ? !valeurfin.equals(obtient.valeurfin) : obtient.valeurfin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numapprenant != null ? numapprenant.hashCode() : 0;
        result = 31 * result + (datejour != null ? datejour.hashCode() : 0);
        result = 31 * result + (numaction != null ? numaction.hashCode() : 0);
        result = 31 * result + (valeurdebut != null ? valeurdebut.hashCode() : 0);
        result = 31 * result + (valeurfin != null ? valeurfin.hashCode() : 0);
        return result;
    }
}
