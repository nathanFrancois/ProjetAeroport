package aeroport.service;

import aeroport.metier.Comprend;
import aeroport.metier.Jeu;
import aeroport.metier.Mission;
import aeroport.metier.Users;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 24/06/2016.
 */
public class MissionService extends EntityService {


    public Mission trouverMission(int nummission)
    {
        return (Mission) trouver(Mission.class, nummission);
    }

    public List<Mission> trouverMissionJeu(int numJeu)
    {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("SELECT c FROM Comprend c WHERE c.numjeu = :numjeu");
        query.setParameter("numjeu", numJeu);
        List<Comprend> comprendList = (List<Comprend>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        List<Mission> missionList = new ArrayList<Mission>();
        for (Comprend c : comprendList) {
            missionList.add(trouverMission(c.getNummission()));
        }

        return missionList;
    }
}
