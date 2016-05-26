package aeroport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aeroport.service.JeuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class IndexController extends MultiActionController {


    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/formations")
    public ModelAndView formations(HttpServletRequest request, HttpServletResponse response) throws Exception {

        JeuService jeuService = new JeuService();
        request.setAttribute("jeux", jeuService.trouverToutJeux());
        return new ModelAndView("formations");
    }

    @RequestMapping(value = "/parcours")
    public ModelAndView parcours(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("parcours");
    }
}
