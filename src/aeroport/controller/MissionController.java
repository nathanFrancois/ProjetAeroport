package aeroport.controller;

import aeroport.form.MissionForm;
import aeroport.metier.Mission;
import aeroport.metier.Objectif;
import aeroport.service.EntityService;
import aeroport.service.MissionService;
import aeroport.service.ObjectifService;
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
public class MissionController extends MultiActionController {

    public static final String ATT_FORM = "form";
    public static final String SESSION_OBJECTIFS = "objectifs";

    @RequestMapping(value = "/mission", method = RequestMethod.GET)
    public ModelAndView listeMissions(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityService entityService = new EntityService();
        MissionService missionService = new MissionService(entityService);
        ObjectifService objectifService = new ObjectifService(entityService);

        HashMap<Mission, List<Objectif>> missions = new HashMap<Mission, List<Objectif>>();

        for (Mission m : missionService.trouverToutMission()) {
            missions.put(m, objectifService.trouverObjectifsMission(m.getNummission()));
        }

        request.setAttribute("missions", missions);

        return new ModelAndView("listeMissions");
    }

    @RequestMapping(value = "/mission/ajouter", method = RequestMethod.GET)
    public ModelAndView mission(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ObjectifService objectifService = new ObjectifService(new EntityService());
        HashMap<String, Objectif> objectifs = new HashMap<String, Objectif>();

        for (Objectif a : objectifService.trouverToutObjectif()) {
            objectifs.put(Integer.toString(a.getNumobjectif()), a);
        }
        request.getSession().setAttribute(SESSION_OBJECTIFS, objectifs);

        return new ModelAndView("ajouterMission");
    }

    @RequestMapping(value = "/mission/ajouter", method = RequestMethod.POST)
    public ModelAndView missionForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        MissionForm missionForm = new MissionForm();
        Mission mission = missionForm.ajouterMission(request);

        request.setAttribute(ATT_FORM, missionForm);
        request.setAttribute("mission", mission);

        if(missionForm.getErreurs().isEmpty()) {
            return new ModelAndView("redirect:/mission");
        }
        else {
            return new ModelAndView("ajouterMission");
        }
    }
}
