package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.model.Review;
import hieuhung.spring.model.User;
import hieuhung.spring.repo.EateryRepo;
import hieuhung.spring.repo.ReviewRepo;
import hieuhung.spring.service.EateryService;
import hieuhung.spring.service.ReviewService;
import hieuhung.spring.service.impl.EateryServiceImpl;
import hieuhung.spring.service.impl.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/review")
    public String main(Model model) {
        return "detail-review"; //view
    }

    @GetMapping("/review/create")
    public String getCreate (@RequestParam("id") Integer idEatery, Model model) {
        Optional<Eatery> eateryOptional = eateryService.findEateryById(idEatery);
        eateryOptional.ifPresent(eatery -> model.addAttribute("eItem", eatery));
        Review review = new Review();
        review.setIdEatery(idEatery);
        model.addAttribute("rItem", review);
        return "createReview"; //view
    }

    @RequestMapping(value = "/review/save-review", method = RequestMethod.POST)
    public String save(Review review) {
        reviewService.saveReview(review);
        return "index";
    }
}
