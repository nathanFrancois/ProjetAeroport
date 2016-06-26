package aeroport.service;

import aeroport.metier.EstAssocie;

/**
 * Created by Nathan on 24/06/2016.
 */
public class EstAssocieService {

    EntityService entityService;

    public EstAssocieService(EntityService entityService){
        this.entityService = entityService;
    }

    public void insererEstAssocie(EstAssocie estAssocie) {
        entityService.inserer(estAssocie);
    }


}
