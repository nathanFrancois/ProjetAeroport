package aeroport.service;

import aeroport.metier.UserRoles;
import aeroport.metier.Users;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class UserService {

    private EntityService entityService;

    public UserService(EntityService entityService){
        this.entityService = entityService;
    }

    public List<Users> trouverToutApprenants() {

        EntityTransaction transaction = entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT u FROM Users u JOIN u.userRolesList ur WHERE ur.role = :role");
        query.setParameter("role", "ROLE_USER");
        List<Users> listApprenants = (List<Users>) query.getResultList();

        return listApprenants;
    }

    public Users trouverUsers(int id) {
        return (Users)entityService.trouver(Users.class, id);
    }

    public Users trouverUsersAvecUsername(String username) {

        entityService.startTransaction();
        Query query = entityService.entityManager.createQuery("SELECT u FROM Users u WHERE u.username = :username");
        query.setParameter("username", username);
        Users users = (Users) query.getSingleResult();

        return users;
    }

    public void ajouterApprenants(Users users) {

        UserRoles userRoles = new UserRoles();
        userRoles.setRole("ROLE_USER");
        userRoles.setUsers(users);
        users.addUserRoles(userRoles);
        users.setEnabled(new Byte("0"));
        entityService.inserer(users);
    }

    public void validerCompte(Users users) {
        EntityTransaction transaction = entityService.startTransaction();
        users.setEnabled(new Byte("1"));
        entityService.entityManager.merge(users);
        entityService.entityManager.flush();
        transaction.commit();
    }

    public void supprimerApprenant(int id) {
        entityService.supprimer(Users.class, id);
    }

    public List<String> getAllUsername() {
        List<Users> usersList= (List<Users>) entityService.trouverTout("Users");
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
        EntityTransaction transaction = entityService.startTransaction();
        currentUsers.setNomusers(users.getNomusers());
        currentUsers.setPrenomusers(users.getPrenomusers());
        currentUsers.setPassword(users.getPassword());
        entityService.entityManager.merge(currentUsers);
        entityService.entityManager.flush();
        transaction.commit();
    }
}

