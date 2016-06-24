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
public class ActionService extends EntityService {

    public Action trouverAction(int numaction)
    {
        return (Action) trouver(Action.class, numaction);
    }

    public List<Action> trouverActionObjectif(int numobjectif)
    {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("SELECT a FROM EstAssocie a WHERE a.numobjectif = :numObjectif");
        query.setParameter("numObjectif", numobjectif);
        List<EstAssocie> estAssocies = (List<EstAssocie>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        List<Action> actionList = new ArrayList<Action>();
        for (EstAssocie a : estAssocies) {
            actionList.add(trouverAction(a.getNumaction()));
        }

        return actionList;
    }
}
