package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.BirdForm;
import com.helmo.NatAdmin.models.Bird;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.BirdService;
import com.helmo.NatAdmin.tools.SystemProvider;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("birds")
public class BirdController {
	private final BirdService birdService;
	
	private final Environment env;
	private final PasswordEncoder passEnc;
	private User system;
	
	public BirdController(BirdService birdService, Environment env, PasswordEncoder passEnc) {
		this.birdService = birdService;
		this.env = env;
		this.passEnc = passEnc;
		system = SystemProvider.getSystem();
		
	}
	
	@RequestMapping("")
	public String list(Model model) {
		List<Bird> birds = birdService.getAll(system);
		model.addAttribute("birds", birds);
		return "birds/all";
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
//    @GetMapping("/{id}") //Another way to do it
	public String view(@PathVariable("id") long id, Model model) {
		Bird bird = birdService.getById(id, system);
		model.addAttribute("bird", bird);
		return "birds/view";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String updateGET(@PathVariable("id") long id, Model model) {
		Bird bird = birdService.getById(id, system);
		model.addAttribute("bird", bird);
		return "birds/edit";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
	public String updatePOST(@PathVariable("id") long id, Model model, @ModelAttribute BirdForm birdForm) {
		Bird bird = birdService.getById(id, system);
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
    public String delete(@PathVariable("id")long id, Model model){
        birdService.delete(id, system);
        return "{\"status\" : 1}";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(@ModelAttribute BirdForm birdForm){
        Bird newBird = new Bird();
        newBird.setDescription(birdForm.getDescription());
        newBird.setName(birdForm.getName());
        long id = birdService.create(newBird, system);
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
}
