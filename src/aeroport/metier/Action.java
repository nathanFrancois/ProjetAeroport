package aeroport.metier;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nathan on 22/06/2016.
 */
@Entity
public class Action {

    @Id
    @Column(name = "NUMACTION", nullable = false)
    private int numaction;

    @Basic
    @Column(name = "ACT_NUMACTION", nullable = true)
    private Integer actNumaction;

    @Basic
    @Column(name = "LIBACTION", nullable = true, length = 25)
    private String libaction;

    @Basic
    @Column(name = "SCOREMIN", nullable = true)
    private Integer scoremin;


    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    public Integer getActNumaction() {
        return actNumaction;
    }

    public void setActNumaction(Integer actNumaction) {
        this.actNumaction = actNumaction;
    }

    public String getLibaction() {
        return libaction;
    }

    public void setLibaction(String libaction) {
        this.libaction = libaction;
    }

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

        if (numaction != action.numaction) return false;
        if (actNumaction != null ? !actNumaction.equals(action.actNumaction) : action.actNumaction != null)
            return false;
        if (libaction != null ? !libaction.equals(action.libaction) : action.libaction != null) return false;
        if (scoremin != null ? !scoremin.equals(action.scoremin) : action.scoremin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + (actNumaction != null ? actNumaction.hashCode() : 0);
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }
}
