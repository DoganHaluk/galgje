package be.vdab.galgje.controllers;

import be.vdab.galgje.services.CategorieService;
import be.vdab.galgje.sessions.RaadHetWoord;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("categorie")
class CategorieController {
    private final char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final CategorieService categorieService;
    private final RaadHetWoord raadHetWoord;

    CategorieController(CategorieService categorieService, RaadHetWoord raadHetWoord) {
        this.categorieService = categorieService;
        this.raadHetWoord = raadHetWoord;
    }

    private String randomWoord(long id) {
        //var categorie=categorieService.findById(id);
        var woorden= categorieService.findWoordenByCategorie(id);
        return woorden.get(ThreadLocalRandom.current().nextInt(woorden.size())).getWoord();
    }

    @PostMapping("{id}/nieuwspel")
    public String radenNieuwSpel(@PathVariable long id) {
        raadHetWoord.reset(randomWoord(id));
        return "redirect:/categorie/{id}";
    }

    @GetMapping("{id}")
    public ModelAndView categoryNaam(@PathVariable long id){
        var modelAndView = new ModelAndView("woordraden", "alfabet", alfabet);
        categorieService.findById(id).ifPresent(categorie -> modelAndView.addObject(categorie));
        return modelAndView;
    }

    @PostMapping("{id}/{letter}")
    public ModelAndView raden(@PathVariable char letter, Errors errors){
        if(errors.hasErrors()){
            return new ModelAndView("woordraden").addObject(raadHetWoord);
        }
        raadHetWoord.gok(letter);
        raadHetWoord.voegLetterToe(letter);
        return new ModelAndView("redirect:/categorie/{id}");
    }
}
