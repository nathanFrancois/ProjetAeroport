package aeroport.service;

import aeroport.metier.Obtient;
import aeroport.metier.Users;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Nathan on 25/06/2016.
 */
public class ObtientService extends EntityService {

    public List<Obtient> trouverObtientUser(int idUser){
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("SELECT o FROM Obtient o WHERE o.idusers = :idUser");
        query.setParameter("idUser", idUser);
        List<Obtient> obtientList = (List<Obtient>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        return obtientList;
    }
}
