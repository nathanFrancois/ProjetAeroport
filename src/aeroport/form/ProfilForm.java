package aeroport.form;


import aeroport.metier.Users;
import aeroport.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ProfilForm {

    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_PRENOM   = "prenom";
    private static final String CHAMP_PASSWORD   = "password";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void updateUsers(HttpServletRequest request) {
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String password = getValeurChamp(request, CHAMP_PASSWORD);

        Users users = new Users();

        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur(CHAMP_NOM, e.getMessage());
        }
        users.setNomusers(nom);

        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            setErreur(CHAMP_PRENOM, e.getMessage());
        }
        users.setPrenomusers(prenom);

        try {
            validationPassword(password);
        } catch (Exception e) {
            setErreur(CHAMP_PASSWORD, e.getMessage());
        }
        users.setPassword(password);

        if (erreurs.isEmpty()) {
            UserService userService = new UserService();
            userService.updateUsers(users);
            resultat = "Succès";
        } else {
            resultat = "Votre de demande de compte a échoué";
        }
    }

    private void validationPassword(String password) throws Exception {
        if ( password == null || password.length() < 3 ) {
            throw new Exception( "Le mot de passe doit contenir au moin 5 caractères" );
        }
    }

    private void validationPrenom(String prenom) throws Exception {
        if ( prenom == null || prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
        }
    }

    private void validationNom(String nom) throws Exception {
        if(nom == null || nom.length() < 3){
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
