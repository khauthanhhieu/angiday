package hieuhung.spring.controller;

import hieuhung.spring.model.User;
import hieuhung.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public String loginInit(Model model) {
        model.addAttribute("error", "");
        model.addAttribute("user", new User());
        return "login"; //view
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(User user, Model model) {
        User users = userService.getAllUser().stream()
                .filter(_user -> user.getUsername().equals(_user.getUsername())
                        && user.getPassword().equals(_user.getPassword()))
                .findAny()
                .orElse(null);
        if (users == null) {
            String error = "Username hoặc Password không đúng, vui lòng thử lại";
            model.addAttribute("error", error);
            model.addAttribute("user", new User());
            return "login";
        }
        return loginInit(model);
    }

    @GetMapping("/signup")
    public String signupInit(Model model) {
        model.addAttribute("user", new User());
        return "registration"; //view
    }

    @RequestMapping(value = "save-user", method = RequestMethod.POST)
    public String save(User user) {
        userService.saveUser(user);
        return "index";
    }
}
