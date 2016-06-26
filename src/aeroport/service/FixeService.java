package aeroport.service;

import aeroport.metier.Fixe;

public class FixeService {

    EntityService entityService;

    public FixeService(EntityService entityService){
        this.entityService = entityService;
    }

    public void insererFixe(Fixe fixe) {
        entityService.inserer(fixe);
    }


}
