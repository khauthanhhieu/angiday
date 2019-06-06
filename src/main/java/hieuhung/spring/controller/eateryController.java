package hieuhung.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class eateryController {
    @GetMapping("/eatery/create")
    public String getCreate(Model model) {
        return "createEatery"; //view
    }

    @GetMapping("/eatery/detail")
    public String getDetail(Model model) {
        return "detail-eatery";
    }
}