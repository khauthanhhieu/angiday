package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.model.Review;
import hieuhung.spring.model.User;
import hieuhung.spring.service.ETypeService;
import hieuhung.spring.service.EateryService;
import hieuhung.spring.service.ReviewService;
import hieuhung.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class EateryController {
    @Autowired private EateryService eateryService;

    @Autowired private UserService userService;

    @Autowired private ETypeService eTypeService;

    @Autowired private ReviewService reviewService;

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

        List<Review> reviews = new ArrayList<>();
        reviews = reviewService.getReviewByEateryId(eateryId);

        List<User> users = new ArrayList<>();
        users = userService.getUserReviews(reviews);

        List<String> images = new ArrayList<>();
        images = eateryService.getImages(eateryId);

        model.addAttribute("eatery", eatery);
        model.addAttribute("imageList", images);
        model.addAttribute("reviews", reviews);
        model.addAttribute("users", users);
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