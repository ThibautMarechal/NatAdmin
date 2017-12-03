package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.BirdForm;
import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.services.BirdService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("birds")
public class BirdController {
	private final BirdService birdService;
	
	public BirdController(BirdService birdService) {
		this.birdService = birdService;
	}
	
	@RequestMapping("")
	public String list(Model model) {
		List<Bird> birds = birdService.getAll();
		model.addAttribute("birds", birds);
		return "birds/all";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
//    @GetMapping("/{id}") //Another way to do it
	public String view(@PathVariable("id") long id, Model model) {
		Bird bird = birdService.getById(id);
		model.addAttribute("bird", bird);
		return "birds/view";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String updateGET(@PathVariable("id") long id, Model model) {
		Bird bird = birdService.getById(id);
		model.addAttribute("bird", bird);
		return "birds/edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String updatePOST(@PathVariable("id") long id, Model model, @ModelAttribute BirdForm birdForm) {
		Bird bird = birdService.getById(id);
	    /*
        TODO update bird
        if(//valid){
            birdService.update(bird);
            model.addAttribute("bird", RBird);
            return "birds/view";
        }
        */
		return "birds/edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String delete(@PathVariable("id") long id, Model model) {
		birdService.delete(id);
		return "{\"status\" : 1}";
	}
}
