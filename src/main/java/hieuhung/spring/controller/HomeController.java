package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    EateryService eateryService;

    @GetMapping("/")
    public String main(Model model) {

        List<Eatery> eateryList = eateryService.getAllEatery();

        model.addAttribute("eateryList", eateryList);

        return "index"; //view
    }
}
