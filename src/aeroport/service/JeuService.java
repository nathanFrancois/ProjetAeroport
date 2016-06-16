package aeroport.service;

import aeroport.metier.Jeu;

import java.util.List;

/**
 * Created by Nathan on 26/05/2016.
 */
public class JeuService extends EntityService {

    public List<Jeu> trouverToutJeux() {
        List<Jeu> jeuxList= (List<Jeu>) trouverTout("Jeu");
        return jeuxList;
    }

}

