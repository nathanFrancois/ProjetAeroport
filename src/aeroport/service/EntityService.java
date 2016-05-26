package aeroport.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public abstract class EntityService {
    protected EntityManager entityManager;
    protected EntityManagerFactory entityManagerFactory;

    public EntityTransaction startTransaction(){
        entityManagerFactory = Persistence.createEntityManagerFactory("PAeroport");
        entityManager = entityManagerFactory.createEntityManager();

        return entityManager.getTransaction();
    }

    public void inserer(Object object){
        EntityTransaction transaction = startTransaction();
        if (!entityManager.contains(object)) {
            transaction.begin();
            entityManager.persist(object);
            entityManager.flush();
            transaction.commit();
        }
        entityManager.close();
    }

    public List trouverTout(String tableName){
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        String query = "SELECT x FROM ".concat(tableName).concat(" x");
        List listObject = entityManager.createQuery(query).getResultList();
        entityManager.close();
        entityManagerFactory.close();

        return listObject;
    }

    public Object trouver(Class classe, int id) {
        Object object = null;

        EntityTransaction transaction = startTransaction();
        transaction.begin();

        object = entityManager.find(classe, id);
        entityManager.close();
        entityManagerFactory.close();

        return object;
    }

    public void supprimer(Class classe, int id) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();

        Object object = entityManager.find(classe, id);
        entityManager.remove(object);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

