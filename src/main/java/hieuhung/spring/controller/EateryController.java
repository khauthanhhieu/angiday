package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.model.User;
import hieuhung.spring.service.impl.ETypeServiceImpl;
import hieuhung.spring.service.impl.EateryServiceImpl;
import hieuhung.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class EateryController {
    @Autowired
    private EateryServiceImpl eateryService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ETypeServiceImpl eTypeService;


    @GetMapping("/eatery/create")
    public String getCreate(Model model) {
        Eatery eatery = new Eatery();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        eatery.setId_user(user.getId());
        model.addAttribute("eatery", eatery);

        model.addAttribute("etypes", eTypeService.getAllEType());

        return "createEatery"; //view
    }

    @RequestMapping(value = "/eatery/saveEatery", method = RequestMethod.POST)
    public String save(Eatery eatery) {
        eateryService.saveEatery(eatery);
        return "redirect:/";
    }

    @GetMapping("/eatery/detail")
    public String getDetail(@RequestParam("id") Integer eateryId, Model model) {
        Optional<Eatery> checkedEatery = eateryService.findEateryById(eateryId);
        Eatery eatery = checkedEatery.get();
        model.addAttribute("eatery", eatery);
        return "detail-eatery";
    }

    @GetMapping("/eatery/search")
    public String getSearch(@RequestParam("name") String name, @RequestParam("addr") String addr, Model model) {
        List<Eatery> eateries = eateryService.getAllEatery();
        List<Eatery> results = eateries
                .stream()
                .filter(eatery -> {
                    String eName = eatery.getName().toLowerCase(new Locale("vi", "VN"));
                    String keyName = name.toLowerCase(new Locale("vi", "VN"));
                    return eName.contains(keyName);
                })
                .collect(Collectors.toList());
        model.addAttribute("eateries", results);
        model.addAttribute("etypes", eTypeService.getAllEType());
        return "listing";
    }
}