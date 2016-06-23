package aeroport.form;

import aeroport.metier.Inscription;
import aeroport.metier.Jeu;
import aeroport.metier.Users;
import aeroport.service.InscriptionService;
import aeroport.service.JeuService;
import aeroport.service.UserService;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 23/06/2016.
 */
public class InscriptionJeuForm {

    private static final String CHAMP_LISTE_JEUX = "listeJeux";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public Inscription ajouterInscription(HttpServletRequest request) {

        Inscription inscription = new Inscription();

        UserService userService = new UserService();
        Users users = userService.getCurrentUser();
        inscription.setApprenant(users);

        String idJeu = getValeurChamp(request, CHAMP_LISTE_JEUX);
        try {
            Jeu jeu = validationJeu(idJeu);
            inscription.setJeu(jeu);
        } catch (Exception e) {
            setErreur(CHAMP_LISTE_JEUX, e.getMessage());
        }

        Date dateDuJour = new java.util.Date();
        java.sql.Date sqlDateDuJour = new java.sql.Date(dateDuJour.getTime());
        inscription.setDateInscription(sqlDateDuJour);

        if (erreurs.isEmpty()) {
            InscriptionService inscriptionService = new InscriptionService();

            try {
                inscriptionService.insererInscription(inscription);
                resultat = "Succès de l'inscription.";
            } catch (Exception e) {
                resultat = "Vous êtes déjà inscrit à cette formation";
                setErreur("resultat", "Vous êtes déjà inscrit à cette formation");
            }

        } else {
            resultat = "Échec de l'inscription.";
        }

        return inscription;
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

    private Jeu validationJeu(String idJeu) throws Exception {
        if(idJeu == null)
            throw new Exception( "Entrez un jeu");

        int id = Integer.parseInt(idJeu);
        JeuService jeuService = new JeuService();
        Jeu jeu = jeuService.trouverJeu(id);

        if(jeu == null)
            throw new Exception( "Entrez un proprietaire valide");

        return jeu;
    }
}
