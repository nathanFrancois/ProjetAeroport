package aeroport.controller;

import aeroport.form.InscriptionJeuForm;
import aeroport.metier.*;
import aeroport.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;


@Controller
public class FormationController extends MultiActionController {

    public static final String ATT_FORM = "form";
    public static final String SESSION_JEUX = "jeux";
    public static final String ATT_INSCRIPTION = "inscription";

    @RequestMapping(value = "/formations")
    public ModelAndView formations(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityService entityService = new EntityService();
        UserService userService = new UserService(entityService);
        request.setAttribute("inscriptions", userService.getCurrentUser().getInscriptions());

        return new ModelAndView("formations");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/formations/inscription")
    public ModelAndView inscription(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        EntityService entityService = new EntityService();
        JeuService jeuService = new JeuService(entityService);
        List<Jeu> jeuList = jeuService.trouverToutJeu();
        HashMap<String, Jeu> jeux = new HashMap<String, Jeu>();

        for (final Jeu p : jeuList) {
            jeux.put(Integer.toString(p.getNumjeu()), p);
        }
        session.setAttribute(SESSION_JEUX, jeux);

        return new ModelAndView("inscriptionJeu");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/formations/inscription")
    public ModelAndView inscriptionForm(HttpServletRequest request, HttpServletResponse response) {

        InscriptionJeuForm form = new InscriptionJeuForm();
        Inscription inscription = form.ajouterInscription(request);

        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_INSCRIPTION, inscription);

        if(form.getErreurs().isEmpty())
            return new ModelAndView("redirect:/formations");
        else {
            return new ModelAndView("inscriptionJeu");
        }
    }

    @RequestMapping(value = "/formations/jeu/{idJeu}")
    public ModelAndView jeu(HttpServletRequest request, HttpServletResponse response, @PathVariable("idJeu") int idJeu) throws Exception {

        EntityService entityService = new EntityService();
        MissionService missionService = new MissionService(entityService);
        ObjectifService objectifService = new ObjectifService(entityService);
        JeuService jeuService = new JeuService(entityService);
        ActionService actionService = new ActionService(entityService);

        HashMap<Mission, List<Objectif>> missions = new HashMap<Mission, List<Objectif>>();
        HashMap<Objectif, List<Action>> actions = new HashMap<Objectif, List<Action>>();

        for (Mission m : missionService.trouverMissionJeu(idJeu)) {
            List<Objectif> objectifList = objectifService.trouverObjectifsMission(m.getNummission());
            missions.put(m, objectifList);
            for (Objectif o : objectifList) {
                actions.put(o, actionService.trouverActionObjectif(o.getNumobjectif()));
            }
        }

        request.setAttribute("missions", missions);
        request.setAttribute("jeu", jeuService.trouverJeu(idJeu));
        request.setAttribute("actions", actions);

        return new ModelAndView("jeu");
    }
}
