package aeroport.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EntityService {
    protected EntityManager entityManager;
    protected EntityManagerFactory entityManagerFactory;

    public EntityTransaction startTransaction(){

        if(entityManagerFactory == null)
        {
            entityManagerFactory = Persistence.createEntityManagerFactory("PAeroport");
            if(entityManager == null)
            {
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
            }
        }

        return entityManager.getTransaction();
    }

    public void inserer(Object object){

        EntityTransaction transaction = startTransaction();
        if (!entityManager.contains(object)) {
            entityManager.persist(object);
            entityManager.flush();
            transaction.commit();
        }
    }

    public List trouverTout(String tableName){

        EntityTransaction transaction = startTransaction();
        String query = "SELECT x FROM ".concat(tableName).concat(" x");
        List listObject = entityManager.createQuery(query).getResultList();

        return listObject;
    }

    public Object trouver(Class classe, int id) {
        Object object = null;
        startTransaction();
        object = entityManager.find(classe, id);

        return object;
    }

    public void supprimer(Class classe, int id) {

        Object object = entityManager.find(classe, id);
        entityManager.remove(object);
        entityManager.getTransaction().commit();
    }
}

