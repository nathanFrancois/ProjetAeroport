package aeroport.service;

import aeroport.metier.*;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 24/06/2016.
 */
public class MissionService {

    private EntityService entityService;

    public MissionService(EntityService entityService){
        this.entityService = entityService;
    }

    public Mission trouverMission(int nummission)
    {
        return (Mission) entityService.trouver(Mission.class, nummission);
    }

    public List<Mission> trouverMissionJeu(int numJeu) {

        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT c FROM Comprend c WHERE c.numjeu = :numjeu");
        query.setParameter("numjeu", numJeu);
        List<Comprend> comprendList = (List<Comprend>) query.getResultList();

        List<Mission> missionList = new ArrayList<Mission>();
        for (Comprend c : comprendList) {
            missionList.add(trouverMission(c.getNummission()));
        }

        return missionList;
    }

    public List<Mission> trouverToutMission() {

        return (List<Mission> ) entityService.trouverTout("Mission");
    }

    public void insererMission(Mission mission){
        entityService.inserer(mission);
    }

    public Mission trouverMissionLib(String libMission) {
        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT m FROM Mission m WHERE m.libmission = :libmission");
        query.setParameter("libmission", libMission);

        return (Mission) query.getSingleResult();
    }
}
