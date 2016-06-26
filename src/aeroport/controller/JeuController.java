package aeroport.controller;

import aeroport.form.JeuForm;
import aeroport.metier.Jeu;
import aeroport.metier.Mission;
import aeroport.service.EntityService;
import aeroport.service.JeuService;
import aeroport.service.MissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nathan on 26/06/2016.
 */
@Controller
public class JeuController extends MultiActionController {

    public static final String ATT_FORM = "form";
    public static final String SESSION_MISSIONS = "missions";

    @RequestMapping(value = "/jeu", method = RequestMethod.GET)
    public ModelAndView listeJeu(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityService entityService = new EntityService();
        JeuService jeuService = new JeuService(entityService);
        MissionService missionService = new MissionService(entityService);

        HashMap<Jeu, List<Mission>> jeux = new HashMap<Jeu, List<Mission>>();

        for (Jeu j : jeuService.trouverToutJeu()) {
            jeux.put(j, missionService.trouverMissionJeu(j.getNumjeu()));
        }

        request.setAttribute("jeux", jeux);

        return new ModelAndView("listeJeux");
    }

    @RequestMapping(value = "/jeu/ajouter", method = RequestMethod.GET)
    public ModelAndView jeu(HttpServletRequest request, HttpServletResponse response) throws Exception {

        MissionService missionService = new MissionService(new EntityService());
        HashMap<String, Mission> missions = new HashMap<String, Mission>();

        for (Mission a : missionService.trouverToutMission()) {
            missions.put(Integer.toString(a.getNummission()), a);
        }
        request.getSession().setAttribute(SESSION_MISSIONS, missions);

        return new ModelAndView("ajouterJeu");
    }

    @RequestMapping(value = "/jeu/ajouter", method = RequestMethod.POST)
    public ModelAndView jeuForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JeuForm jeuForm = new JeuForm();
        Jeu jeu = jeuForm.ajouterJeu(request);

        request.setAttribute(ATT_FORM, jeuForm);
        request.setAttribute("jeu", jeu);

        if(jeuForm.getErreurs().isEmpty()) {
            return new ModelAndView("redirect:/jeu");
        }
        else {
            return new ModelAndView("ajouterJeu");
        }
    }
}
