package hieuhung.spring.controller;

import hieuhung.spring.model.User;
import hieuhung.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginInit(Model model) {
        return "login"; //view
    }

    @GetMapping("/signup")
    public String signupInit(Model model) {
        model.addAttribute("user", new User());
        return "registration"; //view
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user) {
        userService.saveUser(user);
        return "index";
    }
}
