package aeroport.service;

import aeroport.metier.Jeu;

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

}
