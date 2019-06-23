package hieuhung.spring.controller;

import hieuhung.spring.model.Review;
import hieuhung.spring.model.User;
import hieuhung.spring.service.EateryService;
import hieuhung.spring.service.ReviewService;
import hieuhung.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private EateryService eateryService;

    @GetMapping("/user/reviews")
    public String getReviews(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        List<Review> reviews = reviewService.getReviewByUserId(user.getId());
        if (reviews != null && reviews.size() > 0)
            model.addAttribute("reviews", reviews);
        model.addAttribute("eateries", eateryService.getAllEatery());
        return "reviews";
    }
}