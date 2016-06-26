package aeroport.metier;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nathan on 22/06/2016.
 */
@Entity
public class Action {

    @Id
    @Column(name = "NUMACTION", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int numaction;

    @JoinColumn(name = "ACT_NUMACTION", referencedColumnName = "NUMACTION")
    @ManyToOne(targetEntity=Action.class, fetch = FetchType.EAGER)
    private Action action;

    @Basic
    @Column(name = "LIBACTION", nullable = true, length = 25)
    private String libaction;

    @Basic
    @Column(name = "SCOREMIN", nullable = true)
    private Integer scoremin;

    @OneToMany(mappedBy="action")
    private List<Action> precActions;

    public List<Action> getPrecActions() {
        return precActions;
    }

    public void setPrecActions(List<Action> precActions) {
        this.precActions = precActions;
    }

    public int getNumaction() {
        return numaction;
    }

    public void setNumaction(int numaction) {
        this.numaction = numaction;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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

        Action action1 = (Action) o;

        if (numaction != action1.numaction) return false;
        if (action != null ? !action.equals(action1.action) : action1.action != null) return false;
        if (libaction != null ? !libaction.equals(action1.libaction) : action1.libaction != null) return false;
        return scoremin != null ? scoremin.equals(action1.scoremin) : action1.scoremin == null;

    }

    @Override
    public int hashCode() {
        int result = numaction;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (libaction != null ? libaction.hashCode() : 0);
        result = 31 * result + (scoremin != null ? scoremin.hashCode() : 0);
        return result;
    }
}
