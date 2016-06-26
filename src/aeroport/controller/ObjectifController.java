package aeroport.controller;

import aeroport.form.ObjectifForm;
import aeroport.metier.Action;
import aeroport.metier.Objectif;
import aeroport.service.ActionService;
import aeroport.service.EntityService;
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


@Controller
public class ObjectifController extends MultiActionController {

    public static final String ATT_FORM = "form";
    public static final String SESSION_ACTIONS = "actions";

    @RequestMapping(value = "/objectif", method = RequestMethod.GET)
    public ModelAndView listeObjectifs(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityService entityService = new EntityService();
        ObjectifService objectifService = new ObjectifService(entityService);
        ActionService actionService = new ActionService(entityService);

        HashMap<Objectif, List<Action>> objectifs = new HashMap<Objectif, List<Action>>();

        for (Objectif o : objectifService.trouverToutObjectif()) {
            objectifs.put(o, actionService.trouverActionObjectif(o.getNumobjectif()));
        }

        request.setAttribute("objectifs", objectifs);

        return new ModelAndView("listeObjectifs");
    }

    @RequestMapping(value = "/objectif/ajouter", method = RequestMethod.GET)
    public ModelAndView objectif(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionService actionService = new ActionService(new EntityService());
        HashMap<String, Action> actions = new HashMap<String, Action>();

        for (final Action a : actionService.trouverToutAction()) {
            actions.put(Integer.toString(a.getNumaction()), a);
        }
        request.getSession().setAttribute(SESSION_ACTIONS, actions);

        return new ModelAndView("ajouterObjectif");
    }

    @RequestMapping(value = "/objectif/ajouter", method = RequestMethod.POST)
    public ModelAndView objectifForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ObjectifForm objectifForm = new ObjectifForm();
        Objectif objectif = objectifForm.ajouterObjectif(request);

        request.setAttribute(ATT_FORM, objectifForm);
        request.setAttribute("objectif", objectif);

        if(objectifForm.getErreurs().isEmpty()) {
            return new ModelAndView("redirect:/objectif");
        }
        else {
            return new ModelAndView("ajouterObjectif");
        }
    }
}
