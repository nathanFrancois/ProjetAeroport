package aeroport.service;

import aeroport.metier.Inscription;

/**
 * Created by Nathan on 23/06/2016.
 */
public class InscriptionService extends EntityService {

    public void insererInscription(Inscription inscription) throws Exception {
            inserer(inscription);
    }
}
