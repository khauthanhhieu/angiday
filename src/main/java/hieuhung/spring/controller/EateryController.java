package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EateryController {
    @Autowired private EateryService eateryService;

    @GetMapping("/eatery/create")
    public String getCreate(Model model) {
        return "createEatery"; //view
    }

    @GetMapping("/eatery/detail")
    public String getDetail(Model model) {
        return "detail-eatery";
    }
}