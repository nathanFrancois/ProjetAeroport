package aeroport.controller;

import aeroport.metier.Users;
import aeroport.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class ApprenantController extends MultiActionController {

    @RequestMapping(value = "/apprenants")
    public ModelAndView apprenants(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UserService userService = new UserService();
        request.setAttribute("apprenants", userService.trouverToutApprenants());

        return new ModelAndView("listeApprenants");
    }

    @RequestMapping(value = "/apprenants/enabled/{username}")
    public ModelAndView enabledApprenant(HttpServletRequest request, HttpServletResponse response, @PathVariable("username") String username) throws Exception {

        UserService userService = new UserService();
        Users users = userService.trouverUsers(username);
        userService.validerCompte(users);

        return new ModelAndView("redirect:/apprenants");
    }
}
