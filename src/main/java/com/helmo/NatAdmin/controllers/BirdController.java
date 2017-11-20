package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.BirdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id")long id, Model model){
        Bird bird = birdService.getById(id);
        model.addAttribute("bird", bird);
        return "birds/view";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String updateGET(@PathVariable("id")long id, Model model){
        Bird bird = birdService.getById(id);
        model.addAttribute("bird", bird);
        return "birds/edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String updatePOST(@PathVariable("id")long id, Model model)
    {
        Bird bird = birdService.getById(id);
        //TODO update bird
        //if(valid){
        //birdService.update(bird);
        //model.addAttribute("bird", bird);
        //return "birds/view";
        //}
        return "birds/edit";
    }
}