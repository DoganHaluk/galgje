package be.vdab.galgje.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("categorie")
class CategorieController {
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    @GetMapping("alfabet")
    public ModelAndView alfabet() {
        return new ModelAndView("sausAlfabet", "alfabet", alfabet);
    }
}
