package aeroport.form;

import aeroport.metier.Action;
import aeroport.metier.EstAssocie;
import aeroport.metier.Objectif;
import aeroport.service.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 23/06/2016.
 */

public class ObjectifForm {

    private static final String CHAMP_LISTE_ACTION = "listeActions";
    private static final String CHAMP_LIBELLE = "libelle";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Objectif ajouterObjectif(HttpServletRequest request) {

        String[] listAction = request.getParameterValues(CHAMP_LISTE_ACTION);
        String libelle = getValeurChamp(request, CHAMP_LIBELLE);

        Objectif objectif = new Objectif();

        try {
            validationListeAction(listAction);
        } catch (Exception e) {
            setErreur(CHAMP_LISTE_ACTION, e.getMessage());
        }

        try {
            validationLibelle(libelle);
            objectif.setLibobectif(libelle);
        } catch (Exception e) {
            setErreur(CHAMP_LIBELLE, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            ObjectifService objectifService = new ObjectifService(new EntityService());


            objectifService.insererObjectif(objectif);
            Objectif objectif1 = objectifService.trouverObjectifLib(objectif.getLibobectif());

            for (String numAction : listAction) {
                EstAssocieService estAssocieService = new EstAssocieService(new EntityService());
                EstAssocie estAssocie = new EstAssocie();
                estAssocie.setNumaction(Integer.parseInt(numAction));
                estAssocie.setNumobjectif(objectif1.getNumobjectif());
                estAssocieService.insererEstAssocie(estAssocie);
            }

        } else {
            resultat = "Échec de l'ajout de l'objectif.";
        }

        return objectif;
    }

    private void validationListeAction(String[] listAction) throws Exception {
        ActionService actionService = new ActionService(new EntityService());
        for (String numAction : listAction) {
            Action a = actionService.trouverAction(Integer.parseInt(numAction));

            if (a == null) {
                throw new Exception("Ereur ! Une des actions est incorrecte");
            }
        }
    }

    private void validationLibelle(String libelle) throws Exception {

        if(libelle == null || libelle.length() < 5){
            throw new Exception( "Le nom doit contenir au moins 5 caractères" );
        }
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
