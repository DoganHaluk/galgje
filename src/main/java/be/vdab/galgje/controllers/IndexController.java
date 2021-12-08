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
@RequestMapping("/")
class IndexController {
    private final CategorieService categorieService;
    private final RaadHetWoord raadHetWoord;

    IndexController(CategorieService categorieService, RaadHetWoord raadHetWoord) {
        this.categorieService = categorieService;
        this.raadHetWoord = raadHetWoord;
    }

    @GetMapping
    public ModelAndView categorieen(){
        return new ModelAndView("index", "categorieen", categorieService.findAll());
    }

    private String randomWoord(long id) {
        var woorden = categorieService.findById(id).get().getWoorden();
        return woorden.get(ThreadLocalRandom.current().nextInt(woorden.size())).getWoord();
    }

    @PostMapping("categorie/{id}/nieuwspel")
    public String radenNieuwSpel(@PathVariable long id) {
        raadHetWoord.reset(randomWoord(id));
        return "redirect:/categorie";
    }
}
