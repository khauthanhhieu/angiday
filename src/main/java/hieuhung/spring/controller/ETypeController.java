package hieuhung.spring.controller;

import hieuhung.spring.model.Eatery;
import hieuhung.spring.service.ETypeService;
import hieuhung.spring.service.EateryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ETypeController {
    @Autowired
    private ETypeService eTypeService;

    @Autowired
    private EateryService eateryService;

    @GetMapping("/etype")
    public String getList(@RequestParam("id") Integer etId, Model model) {
        List<Eatery> eateries = eateryService.findEateryByType(etId);
        model.addAttribute("eateries", eateries);
        model.addAttribute("etName", eTypeService.findETypeById(etId).get().getName());
        return "etype";
    }
}
