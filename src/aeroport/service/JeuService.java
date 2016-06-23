package aeroport.service;

import aeroport.metier.Jeu;

import java.util.List;

/**
 * Created by Nathan on 23/06/2016.
 */
public class JeuService extends EntityService {

    public Jeu trouverJeu(int id) {
        return (Jeu)trouver(Jeu.class, id);
    }

    public List<Jeu> trouverToutJeu() {
        List<Jeu> jeuList= (List<Jeu>) trouverTout("Jeu");
        return jeuList;
    }

}
