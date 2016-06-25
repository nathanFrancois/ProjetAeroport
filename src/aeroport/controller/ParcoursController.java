package aeroport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aeroport.metier.Action;
import aeroport.metier.Obtient;
import aeroport.metier.Users;
import aeroport.service.ActionService;
import aeroport.service.EntityService;
import aeroport.service.ObtientService;
import aeroport.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import java.util.HashMap;
import java.util.List;

@Controller
public class ParcoursController extends MultiActionController {

    @RequestMapping(value = "/parcours")
    public ModelAndView parcours(HttpServletRequest request, HttpServletResponse response) throws Exception {

        EntityService entityService = new EntityService();
        ActionService actionService = new ActionService(entityService);
        UserService userService = new UserService(entityService);
        Users userCourant = userService.getCurrentUser();

        ObtientService obtientService = new ObtientService(entityService);
        List<Obtient> obtientList = obtientService.trouverObtientUser(userCourant.getIdusers());

        HashMap<Obtient, Action> obtients = new HashMap<Obtient, Action>();

        for (Obtient o : obtientList) {
            obtients.put(o, actionService.trouverAction(o.getNumaction()));
        }

        request.setAttribute("obtients", obtients);

        return new ModelAndView("parcours");
    }
}
