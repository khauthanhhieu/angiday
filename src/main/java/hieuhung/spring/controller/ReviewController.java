package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.model.Review;
import hieuhung.spring.model.User;
import hieuhung.spring.service.impl.EateryServiceImpl;
import hieuhung.spring.service.impl.ReviewServiceImpl;
import hieuhung.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;

    @Autowired
    private EateryServiceImpl eateryService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/review")
    public String main(Model model) {
        return "detail-review"; //view
    }

    @GetMapping("/review/create")
    public String getCreate (@RequestParam("id") Integer idEatery, Model model) {
        Review review = new Review();

        Optional<Eatery> eateryOptional = eateryService.findEateryById(idEatery);
        eateryOptional.ifPresent(eatery -> model.addAttribute("eItem", eatery));
        review.setIdEatery(idEatery);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        review.setIdUser(user.getId());

        model.addAttribute("rItem", review);
        return "createReview"; //view
    }

    @RequestMapping(value = "/review/save-review", method = RequestMethod.POST)
    public String save(Review review) {
        reviewService.saveReview(review);
        return "redirect:/eatery/detail?id=" + review.getIdEatery();
    }
}
