package aeroport.controller;

import aeroport.form.ActionForm;
import aeroport.metier.Action;
import aeroport.service.ActionService;
import aeroport.service.EntityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@Controller
public class AdminController extends MultiActionController {

    public static final String ATT_FORM = "form";
    public static final String SESSION_ACTIONS = "actions";

    @RequestMapping(value = "/action", method = RequestMethod.GET)
    public ModelAndView listeAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionService actionService = new ActionService(new EntityService());
        request.setAttribute("actions", actionService.trouverToutAction());
        return new ModelAndView("listeAction");
    }

    @RequestMapping(value = "/action/ajouter", method = RequestMethod.GET)
    public ModelAndView action(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionService actionService = new ActionService(new EntityService());
        HashMap<String, Action> actions = new HashMap<String, Action>();

        for (final Action a : actionService.trouverToutAction()) {
            actions.put(Integer.toString(a.getNumaction()), a);
        }
        request.getSession().setAttribute(SESSION_ACTIONS, actions);

        return new ModelAndView("ajouterAction");
    }

    @RequestMapping(value = "/action/ajouter", method = RequestMethod.POST)
    public ModelAndView actionForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionForm actionForm = new ActionForm();
        Action action = actionForm.ajouterAction(request);

        request.setAttribute(ATT_FORM, actionForm);
        request.setAttribute("actionApp", action);

        if(actionForm.getErreurs().isEmpty()) {
            return new ModelAndView("redirect:/action");
        }
        else {
            return new ModelAndView("ajouterAction");
        }
    }
}
