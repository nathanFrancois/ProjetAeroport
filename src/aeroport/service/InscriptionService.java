package aeroport.service;

import aeroport.metier.Inscription;

/**
 * Created by Nathan on 23/06/2016.
 */
public class InscriptionService {

    public EntityService entityService;

    public InscriptionService (EntityService entityService){
        this.entityService = entityService;
    }

    public void insererInscription(Inscription inscription) throws Exception {
        entityService.inserer(inscription);
    }
}
