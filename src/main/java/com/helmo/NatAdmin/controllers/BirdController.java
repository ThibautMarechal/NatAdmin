package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.BirdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("birds")
public class BirdController {
    private BirdService birdService;

    public BirdController() {
        this.birdService = new BirdService();
    }

    @RequestMapping("")
    public String list(Model model){
        List<Bird> birds = birdService.getAll();
        model.addAttribute("birds", birds);
        return "birds/all";
    }
}
