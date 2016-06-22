package aeroport.metier;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Nathan on 22/06/2016.
 */
@Entity
@IdClass(InscriptionPK.class)
public class Inscription {

    @Id
    @JoinColumn(name = "NUMJEU", referencedColumnName = "NUMJEU")
    @ManyToOne(targetEntity=Jeu.class, fetch = FetchType.EAGER)
    private Jeu jeu;


    @Id
    @JoinColumn(name = "NUMAPPRENANT", referencedColumnName = "IDUSERS")
    @ManyToOne(targetEntity=Users.class, fetch = FetchType.EAGER)
    private Users apprenant;

    @Basic
    @Column(name = "DATEINSCRIPTION", nullable = false)
    private Date dateInscription;

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Users getApprenant() {
        return apprenant;
    }

    public void setApprenant(Users apprenant) {
        this.apprenant = apprenant;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscription that = (Inscription) o;

        if (jeu != that.jeu) return false;
        return apprenant != null ? apprenant.equals(that.apprenant) : that.apprenant == null;

    }

    @Override
    public int hashCode() {
        int result = jeu.getNumjeu();
        result = 31 * result + (apprenant != null ? apprenant.hashCode() : 0);
        return result;
    }
}
