package aeroport.form;


import aeroport.metier.Users;
import aeroport.service.EntityService;
import aeroport.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class RegisterForm {

    private static final String CHAMP_USERNAME  = "username";
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

    public Users ajouterApprenant(HttpServletRequest request) {
        String nom = getValeurChamp(request, CHAMP_NOM);
        String prenom = getValeurChamp(request, CHAMP_PRENOM);
        String username = getValeurChamp(request, CHAMP_USERNAME);
        String password = getValeurChamp(request, CHAMP_PASSWORD);

        Users apprenant = new Users();

        try {
            validationNom(nom);
        } catch (Exception e) {
            setErreur( CHAMP_NOM, e.getMessage());
        }
        apprenant.setNomusers(nom);

        try {
            validationPrenom(prenom);
        } catch (Exception e) {
            setErreur( CHAMP_PRENOM, e.getMessage());
        }
        apprenant.setPrenomusers(prenom);

        try {
            validationUsername(username);
        } catch (Exception e) {
            setErreur(CHAMP_USERNAME, e.getMessage());
        }
        apprenant.setUsername(username);

        try {
            validationPassword(password);
        } catch (Exception e) {
            setErreur(CHAMP_PASSWORD, e.getMessage());
        }
        apprenant.setPassword(password);

        if (erreurs.isEmpty()) {

            EntityService entityService = new EntityService();
            UserService userService = new UserService(entityService);
            userService.ajouterApprenants(apprenant);

            resultat = "Succès";

        } else {
            resultat = "Votre demande de compte a échoué";
        }

        return apprenant;
    }

    private void validationPassword(String password) throws Exception {
        if ( password == null || password.length() < 3 ) {
            throw new Exception( "Le mot de passe doit contenir au moins 5 caractères" );
        }
    }

    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom == null || prenom.length() < 3 ) {
            throw new Exception( "Le prenom doit contenir au moins 3 caractères." );
        }
    }

    private void validationUsername( String username) throws Exception {
        if ( username == null || username.length() < 5 ) {
            throw new Exception( "le username doit contenir au moins 5 caractères." );
        }

        EntityService entityService = new EntityService();
        UserService userService = new UserService(entityService);
        if (userService.getAllUsername().contains(username)) {
            throw new Exception( "Ce nom d'utilisateur existe déjà" );
        }
    }

    private void validationNom( String nom ) throws Exception {
        if(nom == null || nom.length() < 3 ){
            throw new Exception( "Le nom doit contenir au moins 3 caractères." );
        }
    }

    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
