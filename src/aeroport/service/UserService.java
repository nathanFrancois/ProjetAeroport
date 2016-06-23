package aeroport.service;

import aeroport.metier.UserRoles;
import aeroport.metier.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


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

    public Users trouverUsers(int id) {
        return (Users)trouver(Users.class, id);
    }

    public Users trouverUsersAvecUsername(String username) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("SELECT u FROM Users u WHERE u.username = :username");
        query.setParameter("username", username);
        Users users = (Users) query.getSingleResult();
        entityManager.close();
        entityManagerFactory.close();

        return users;
    }

    public void ajouterApprenants(Users users) {
        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUsers(users);
        users.addUserRoles(userRoles);
        users.setEnabled(new Byte("0"));
        inserer(users);
    }

    public void validerCompte(Users users) {
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        users.setEnabled(new Byte("1"));
        entityManager.merge(users);
        entityManager.flush();
        transaction.commit();
        entityManager.close();
    }

    public void supprimerApprenant(int id) {
        supprimer(Users.class, id);
    }

    public List<String> getAllUsername() {
        List<Users> usersList= (List<Users>) trouverTout("Users");
        List<String> listUsername = new ArrayList<String>();

        for (Users u : usersList) {
            listUsername.add(u.getUsername());
        }
        return listUsername;
    }

    public Users getCurrentUser() {
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        return trouverUsersAvecUsername(username);
    }

    public void updateUsers(Users users) {
        Users currentUsers = getCurrentUser();
        EntityTransaction transaction = startTransaction();
        transaction.begin();
        currentUsers.setNomusers(users.getNomusers());
        currentUsers.setPrenomusers(users.getPrenomusers());
        currentUsers.setPassword(users.getPassword());
        entityManager.merge(currentUsers);
        entityManager.flush();
        transaction.commit();
        entityManager.close();
    }
}

