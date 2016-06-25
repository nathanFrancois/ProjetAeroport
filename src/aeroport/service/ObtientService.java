package aeroport.service;

import aeroport.metier.Obtient;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nathan on 25/06/2016.
 */
public class ObtientService {

    private EntityService entityService;

    public ObtientService(EntityService entityService){
        this.entityService = entityService;
    }

    public List<Obtient> trouverObtientUser(int idUser){

        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT o FROM Obtient o WHERE o.idusers = :idUser");
        query.setParameter("idUser", idUser);
        List<Obtient> obtientList = (List<Obtient>) query.getResultList();

        return obtientList;
    }
}
