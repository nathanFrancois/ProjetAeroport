package aeroport.controller;

import aeroport.form.InscriptionJeuForm;
import aeroport.metier.Inscription;
import aeroport.metier.Jeu;
import aeroport.service.JeuService;
import aeroport.service.UserService;
import org.springframework.stereotype.Controller;
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

        UserService userService = new UserService();
        request.setAttribute("inscriptions", userService.getCurrentUser().getInscriptions());

        return new ModelAndView("formations");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/formations/inscription")
    public ModelAndView inscription(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        JeuService jeuService = new JeuService();
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

}
