package aeroport.metier;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Nathan on 22/06/2016.
 */
public class InscriptionPK implements Serializable {

    @Id
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU")
    @ManyToOne(targetEntity=Jeu.class, fetch = FetchType.EAGER)
    private Jeu jeu;

    @Id
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "IDUSERS")
    @ManyToOne(targetEntity=Users.class, fetch = FetchType.EAGER)
    private Users apprenant;


    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public Users getApprenant() {
        return apprenant;
    }

    public void setApprenant(Users apprenant) {
        this.apprenant = apprenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InscriptionPK that = (InscriptionPK) o;

        if (jeu != that.jeu) return false;
        if (apprenant != that.apprenant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = jeu.getNumjeu();
        result = 31 * result + apprenant.getIdusers();
        return result;
    }
}
