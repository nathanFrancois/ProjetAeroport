package aeroport.form;

import aeroport.metier.Objectif;
import aeroport.metier.Fixe;
import aeroport.metier.Mission;
import aeroport.service.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nathan on 23/06/2016.
 */

public class MissionForm {

    private static final String CHAMP_LISTE_OBJECTIF = "listeObjectifs";
    private static final String CHAMP_LIBELLE = "libelle";

    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public Mission ajouterMission(HttpServletRequest request) {

        String[] listObjectif = request.getParameterValues(CHAMP_LISTE_OBJECTIF);
        String libelle = getValeurChamp(request, CHAMP_LIBELLE);

        Mission mission = new Mission();

        try {
            validationListeObjectif(listObjectif);
        } catch (Exception e) {
            setErreur(CHAMP_LISTE_OBJECTIF, e.getMessage());
        }

        try {
            validationLibelle(libelle);
            mission.setLibmission(libelle);
        } catch (Exception e) {
            setErreur(CHAMP_LIBELLE, e.getMessage());
        }

        if (erreurs.isEmpty()) {
            MissionService missionService = new MissionService(new EntityService());


            missionService.insererMission(mission);
            Mission mission1 = missionService.trouverMissionLib(mission.getLibmission());

            for (String numObjectif : listObjectif) {
                FixeService fixeService = new FixeService(new EntityService());
                Fixe fixe = new Fixe();
                fixe.setNumobjectif(Integer.parseInt(numObjectif));
                fixe.setNummission(mission1.getNummission());
                fixeService.insererFixe(fixe);
            }

        } else {
            resultat = "Échec de l'ajout de la mission.";
        }

        return mission;
    }

    private void validationListeObjectif(String[] listObjectif) throws Exception {
        ObjectifService objectifService = new ObjectifService(new EntityService());
        for (String numObjectif : listObjectif) {
            Objectif a = objectifService.trouverObjectif(Integer.parseInt(numObjectif));

            if (a == null) {
                throw new Exception("Ereur ! Un des objectifs est incorrecte");
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
