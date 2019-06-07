package hieuhung.spring.controller;

import hieuhung.spring.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String loginInit(Model model) {
        return "login"; //view
    }

    @GetMapping("/signup")
    public String signupInit(Model model) {
        return "registration"; //view
    }
}
