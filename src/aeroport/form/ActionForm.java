package aeroport.form;

import aeroport.metier.Action;
import aeroport.service.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 23/06/2016.
 */

public class ActionForm {

    private static final String CHAMP_LISTE_ACTION = "listeActions";
    private static final String CHAMP_LIBELLE = "libelle";
    private static final String CHAMP_SCORE = "score";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Action ajouterAction(HttpServletRequest request) {

        String numActionPrec = getValeurChamp(request, CHAMP_LISTE_ACTION);
        String libelle = getValeurChamp(request, CHAMP_LIBELLE);
        String score = getValeurChamp(request, CHAMP_SCORE);

        Action action = new Action();

        try {
            if(numActionPrec != null){
                Action actionSucc = validationAction(numActionPrec);
                action.setAction(actionSucc);
            }
        } catch (Exception e) {
            setErreur(CHAMP_LISTE_ACTION, e.getMessage());
        }

        try {
            validationLibelle(libelle);
            action.setLibaction(libelle);
        } catch (Exception e) {
            setErreur(CHAMP_LIBELLE, e.getMessage());
        }

        try {
            validationScore(score);
            action.setScoremin(Integer.parseInt(score));
        } catch (Exception e) {
            setErreur(CHAMP_SCORE, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            EntityService entityService = new EntityService();
            ActionService actionService = new ActionService(entityService);

            actionService.insererAction(action);

        } else {
            resultat = "Échec de l'ajout de l'action.";
        }

        return action;
    }

    private void validationScore(String score) throws Exception {

        try {
            Integer.parseInt(score);
        } catch (Exception e){
            throw new Exception("Ce n'est pas un nombre");
        }

        int a = Integer.parseInt(score);
        if(a < 0)
            throw new Exception("Veuillez entrez un nombre positif");

    }

    private void validationLibelle(String libelle) throws Exception {

        if(libelle == null || libelle.length() < 5){
            throw new Exception( "Le nom doit contenir au moins 5 caractères" );
        }
    }

    private Action validationAction(String numActionPrec) throws Exception {

        EntityService entiyService = new EntityService();
        ActionService actionSevice = new ActionService(entiyService);

        Action action = actionSevice.trouverAction(Integer.parseInt(numActionPrec));

        if(action == null){
            throw new Exception( "Cette action n'éxiste pas" );
        }

        return action;
    }

    private void setErreur( String champ, String message ) {
        erreurs.put(champ, message);
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
}
