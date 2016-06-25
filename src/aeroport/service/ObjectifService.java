package aeroport.service;

import aeroport.metier.Fixe;
import aeroport.metier.Objectif;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 24/06/2016.
 */
public class ObjectifService {

    private EntityService entityService;

    public ObjectifService(EntityService entityService){
        this.entityService = entityService;
    }

    public Objectif trouverObjectif(int numObjectif) {

        return (Objectif) entityService.trouver(Objectif.class, numObjectif);
    }

    public List<Objectif> trouverObjectifsMission(int numMission) {

        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT f FROM Fixe f WHERE f.nummission = :numMission");
        query.setParameter("numMission", numMission);
        List<Fixe> fixeList = (List<Fixe>) query.getResultList();

        List<Objectif> objectifList = new ArrayList<Objectif>();
        for (Fixe f : fixeList) {
            objectifList.add(trouverObjectif(f.getNumobjectif()));
        }

        return objectifList;
    }
}
