package aeroport.controller;

import aeroport.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class FormationController extends MultiActionController {

    @RequestMapping(value = "/formations")
    public ModelAndView formations(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserService userService = new UserService();
        request.setAttribute("inscriptions", userService.getCurrentUser().getInscriptions());

        return new ModelAndView("formations");
    }

}
