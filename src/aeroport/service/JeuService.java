package aeroport.service;

import aeroport.metier.Jeu;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nathan on 23/06/2016.
 */
public class JeuService {

    private EntityService entityService;

    public JeuService(EntityService entityService){
        this.entityService = entityService;
    }

    public Jeu trouverJeu(int id) {
        return (Jeu) entityService.trouver(Jeu.class, id);
    }

    public List<Jeu> trouverToutJeu() {
        List<Jeu> jeuList= (List<Jeu>) entityService.trouverTout("Jeu");
        return jeuList;
    }

    public void insererJeu(Jeu jeu) {
        entityService.inserer(jeu);
    }

    public Jeu trouverJeuLib(String libellejeu) {
        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT j FROM Jeu j WHERE j.libellejeu = :libelleJeu");
        query.setParameter("libelleJeu", libellejeu);

        return (Jeu) query.getSingleResult();
    }
}
