package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.BirdForm;
import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.BirdService;
import com.helmo.NatAdmin.services.AttributeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("birds")
public class    BirdController {
    private BirdService birdService;
    private AttributeService attributeService;

    public BirdController() {
        this.birdService = new BirdService();
        attributeService = new AttributeService();
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
        model.addAttribute("attributes", attributeService.getAll());
        return "birds/view";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable("id")long id, Model model, @ModelAttribute BirdForm birdForm)
    {
        Bird bird = birdService.getById(id);
        /*
        TODO update bird
        if(//valid){
            birdService.update(bird);
            model.addAttribute("bird", bird);
            return "birds/view";
        }
        */
        return "birds/edit";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(@PathVariable("id")long id, Model model){
        birdService.delete(id);
        return "{\"status\" : 1}";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@ModelAttribute BirdForm birdForm){
        Bird newBird = new Bird();
        newBird.setDescription(birdForm.getDescription());
        newBird.setName(birdForm.getName());
        long id = birdService.create(newBird);
        return String.format(
            "{" +
                "\"status\":1," +
                "\"content\":" +
                "{" +
                    "\"id\":%d," +
                    "\"name\": \"%s\"," +
                    "\"description\": \"%s\"," +
                "}" +
            "}", id, newBird.getName(), newBird.getDescription());
    }
    @GetMapping("test")
    public String test(){
        return "birds/test";
    }
}
