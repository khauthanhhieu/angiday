package hieuhung.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/login")
    public String loginInit(Model model) {
        return "login"; //view
    }

    @GetMapping("/signup")
    public String signupInit(Model model) {
        return "registration"; //view
    }
}
