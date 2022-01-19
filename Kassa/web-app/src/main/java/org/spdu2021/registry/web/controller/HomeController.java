package org.spdu2021.registry.web.controller;

import org.spdu2021.registry.web.service.EventService;
import org.spdu2021.registry.web.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class HomeController {

    @Autowired
    private EventService eventService;

    @Autowired
    private SaleService saleService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("events", eventService.getAllSortByDate());
        model.addAttribute("sales", saleService.getAll());
        return "home";
    }
}
