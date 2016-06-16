package aeroport.metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nathan on 16/06/2016.
 */
@Entity
public class Action {
    private Integer numaction;
    private Integer actNumaction;
    private String libaction;
    private Integer scoremin;

    @Id
    @Column(name = "NUMACTION")
    public Integer getNumaction() {
        return numaction;
    }

    public void setNumaction(Integer numaction) {
        this.numaction = numaction;
    }

    @Basic
    @Column(name = "ACT_NUMACTION")
    public Integer getActNumaction() {
        return actNumaction;
    }

    public void setActNumaction(Integer actNumaction) {
        this.actNumaction = actNumaction;
    }

    @Basic
    @Column(name = "LIBACTION")
    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

    @Basic
    @Column(name = "SCOREMIN")
    public Integer getScoremin() {
        return scoremin;
    }

    public void setScoremin(Integer scoremin) {
        this.scoremin = scoremin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (numaction != null ? !numaction.equals(action.numaction) : action.numaction != null) return false;
        if (actNumaction != null ? !actNumaction.equals(action.actNumaction) : action.actNumaction != null)
            return false;
        if (libaction != null ? !libaction.equals(action.libaction) : action.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(action.scoremin) : action.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction != null ? numaction.hashCode() : 0;
        result = 31 * result + (actNumaction != null ? actNumaction.hashCode() : 0);
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }
}
