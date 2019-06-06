package hieuhung.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class reviewController {
    @GetMapping("/review")
    public String main(Model model) {
        return "detail-review"; //view
    }

    @GetMapping("/review/create")
    public String getCreate (Model model) {
        return "createReview"; //view
    }
}
