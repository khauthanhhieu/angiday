package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName() + " - " + auth.getAuthorities());

        return "index"; //view
    }
}
