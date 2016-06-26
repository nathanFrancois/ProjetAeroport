package aeroport.service;

import aeroport.metier.Comprend;

public class ComprendService {

    EntityService entityService;

    public ComprendService(EntityService entityService){
        this.entityService = entityService;
    }

    public void insererComprend(Comprend comprend) {
        entityService.inserer(comprend);
    }


}
