package aeroport.form;

import aeroport.metier.Mission;
import aeroport.metier.Comprend;
import aeroport.metier.Jeu;
import aeroport.service.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 23/06/2016.
 */

public class JeuForm {

    private static final String CHAMP_LISTE_MISSION = "listeMissions";
    private static final String CHAMP_LIBELLE = "libelle";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Jeu ajouterJeu(HttpServletRequest request) {

        String[] listMission = request.getParameterValues(CHAMP_LISTE_MISSION);
        String libelle = getValeurChamp(request, CHAMP_LIBELLE);

        Jeu jeu = new Jeu();

        try {
            validationListeMission(listMission);
        } catch (Exception e) {
            setErreur(CHAMP_LISTE_MISSION, e.getMessage());
        }

        try {
            validationLibelle(libelle);
            jeu.setLibellejeu(libelle);
        } catch (Exception e) {
            setErreur(CHAMP_LIBELLE, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            JeuService jeuService = new JeuService(new EntityService());


            jeuService.insererJeu(jeu);
            Jeu jeu1 = jeuService.trouverJeuLib(jeu.getLibellejeu());

            for (String numMission : listMission) {
                ComprendService comprendService = new ComprendService(new EntityService());
                Comprend comprend = new Comprend();
                comprend.setNummission(Integer.parseInt(numMission));
                comprend.setNumjeu(jeu1.getNumjeu());
                comprendService.insererComprend(comprend);
            }

        } else {
            resultat = "Échec de l'ajout du jeu";
        }

        return jeu;
    }

    private void validationListeMission(String[] listMission) throws Exception {
        MissionService jeuService = new MissionService(new EntityService());
        for (String numMission : listMission) {
            Mission a = jeuService.trouverMission(Integer.parseInt(numMission));

            if (a == null) {
                throw new Exception("Ereur ! Un des jeus est incorrecte");
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
