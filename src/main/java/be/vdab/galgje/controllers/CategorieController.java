package be.vdab.galgje.controllers;

import be.vdab.galgje.services.CategorieService;
import be.vdab.galgje.sessions.RaadHetWoord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("categorie")
class CategorieController {
    private final char[] alfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final CategorieService categorieService;
    private final RaadHetWoord raadHetWoord;

    public CategorieController(CategorieService categorieService, RaadHetWoord raadHetWoord) {
        this.categorieService = categorieService;
        this.raadHetWoord = raadHetWoord;
    }

    private String randomWoord(long id) {
        var woorden= categorieService.findById(id).get().getWoorden();
        return woorden.get(ThreadLocalRandom.current().nextInt(woorden.size())).getWoord();
    }

    @PostMapping("{id}/nieuwspel")
    public String radenNieuwSpel(@PathVariable long id) {
        raadHetWoord.reset(randomWoord(id));
        return "redirect:/categorie/{id}";
    }

    @GetMapping("{id}")
    public ModelAndView categoryNaam(@PathVariable long id){
        var modelAndView = new ModelAndView("woordraden", "alfabet", alfabet).addObject(raadHetWoord);
        categorieService.findById(id).ifPresent(categorie -> modelAndView.addObject(categorie));
        return modelAndView;
    }

    @PostMapping("{id}/{letter}")
    public ModelAndView raden(@PathVariable long id, @PathVariable char letter){
        raadHetWoord.gok(letter);
        raadHetWoord.voegLetterToe(letter);
        var modelAndView = new ModelAndView("woordraden");
        categorieService.findById(id).ifPresent(categorie -> modelAndView.addObject(categorie));
        return new ModelAndView("redirect:/categorie/{id}");
    }
}
