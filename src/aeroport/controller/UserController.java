package aeroport.controller;

import aeroport.form.ProfilForm;
import aeroport.form.RegisterForm;
import aeroport.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Nathan on 19/06/2016.
 */

@Controller
public class UserController extends MultiActionController {

    public static final String ATT_FORM = "form";

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

        RegisterForm form = new RegisterForm();
        form.ajouterApprenant(request);

        request.setAttribute(ATT_FORM, form);

        if(form.getErreurs().isEmpty())
            return new ModelAndView("redirect:/login");
        else {
            return new ModelAndView("register");
        }
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("login");
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/profil")
    public ModelAndView profil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserService userService = new UserService();

        request.setAttribute("user", userService.getCurrentUser());

        return new ModelAndView("profil");
    }

    @RequestMapping(value = "/profil", method = RequestMethod.POST)
    public ModelAndView profilForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProfilForm profilForm = new ProfilForm();
        profilForm.updateUsers(request);

        request.setAttribute(ATT_FORM, profilForm);

        UserService userService = new UserService();
        request.setAttribute("user", userService.getCurrentUser());

        return new ModelAndView("/profil");
    }
}
