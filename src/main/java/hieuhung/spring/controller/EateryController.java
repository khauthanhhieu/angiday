package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class EateryController {
    @Autowired private EateryService eateryService;

    @GetMapping("/eatery/create")
    public String getCreate(Model model) {
        model.addAttribute("eatery", new Eatery());
        return "createEatery"; //view
    }

    @RequestMapping(value = "/eatery/saveEatery", method = RequestMethod.POST)
    public String save(Eatery eatery) {
        eateryService.saveEatery(eatery);
        return "index";
    }

    @GetMapping("/eatery/detail")
    public String getDetail(@RequestParam("id") Integer eateryId, Model model) {
        Optional<Eatery> checkedEatery = eateryService.findEateryById(eateryId);
        Eatery eatery = checkedEatery.get();
        model.addAttribute("eatery", eatery);
        return "detail-eatery";
    }
}