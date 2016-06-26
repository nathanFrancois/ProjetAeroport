package aeroport.service;

import aeroport.metier.Action;
import aeroport.metier.EstAssocie;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 24/06/2016.
 */
public class ActionService {

    EntityService entityService;

    public ActionService(EntityService entityService){
        this.entityService = entityService;
    }

    public Action trouverAction(int numaction) {
        return (Action) entityService.trouver(Action.class, numaction);
    }

    public List<Action> trouverActionObjectif(int numobjectif) {

        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT a FROM EstAssocie a WHERE a.numobjectif = :numObjectif");
        query.setParameter("numObjectif", numobjectif);
        List<EstAssocie> estAssocies = (List<EstAssocie>) query.getResultList();
        List<Action> actionList = new ArrayList<Action>();
        for (EstAssocie a : estAssocies) {
            actionList.add(trouverAction(a.getNumaction()));
        }

        return actionList;
    }

    public void insererAction(Action action) {

        entityService.inserer(action);
    }

    public List<Action> trouverToutAction() {
        return (List<Action>) entityService.trouverTout("Action");
    }
}
