package aeroport.metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nathan on 22/06/2016.
 */
@Entity
public class Mission {
    private int nummission;
    private String libmission;

    @Id
    @Column(name = "NUMMISSION", nullable = false)
    public int getNummission() {
        return nummission;
    }

    public void setNummission(int nummission) {
        this.nummission = nummission;
    }

    @Basic
    @Column(name = "LIBMISSION", nullable = true, length = 25)
    public String getLibmission() {
        return libmission;
    }

    public void setLibmission(String libmission) {
        this.libmission = libmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mission mission = (Mission) o;

        if (nummission != mission.nummission) return false;
        if (libmission != null ? !libmission.equals(mission.libmission) : mission.libmission != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nummission;
        result = 31 * result + (libmission != null ? libmission.hashCode() : 0);
        return result;
    }
}
