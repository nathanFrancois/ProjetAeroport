package aeroport.service;

import aeroport.metier.UserRoles;
import aeroport.metier.Users;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathan on 17/06/2016.
 */
public class UserService extends EntityService {

    public List<Users> trouverToutApprenants() {

        EntityTransaction transaction = startTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("SELECT u FROM Users u JOIN u.userRolesList ur WHERE ur.role = :role");
        query.setParameter("role", "ROLE_USER");
        List<Users> listApprenants = (List<Users>) query.getResultList();
        entityManager.close();
        entityManagerFactory.close();

        return listApprenants;
    }

    public void ajouterApprenants(Users users) {

        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUsers(users);
        users.addUserRoles(userRoles);
        users.setEnabled(new Byte("0"));
        inserer(users);
    }

    public List<String> getAllUsername() {

        List<Users> usersList= (List<Users>) trouverTout("Users");
        List<String> listUsername = new ArrayList<String>();

        for (Users u : usersList) {
            listUsername.add(u.getUsername());
        }
        return listUsername;
    }
}
