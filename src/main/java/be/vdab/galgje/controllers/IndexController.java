package be.vdab.galgje.controllers;

import be.vdab.galgje.services.CategorieService;
import be.vdab.galgje.sessions.RaadHetWoord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
    private final CategorieService categorieService;

    IndexController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public ModelAndView categorieen(){
        return new ModelAndView("index", "categorieen", categorieService.findAll());
    }
}
