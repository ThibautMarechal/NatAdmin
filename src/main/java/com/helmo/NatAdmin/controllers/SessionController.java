package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.SessionForm;
import com.helmo.NatAdmin.models.Session;
import com.helmo.NatAdmin.services.SessionService;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sessions")
public class SessionController {
	private final SessionService sessionService;
	
	private final Environment env;
	
	public SessionController(SessionService sessionService, Environment env) {
		this.sessionService = sessionService;
		this.env = env;
		
	}
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("sessions", sessionService.getAll());
		return "sessions/all";
	}
	
	@RequestMapping("{id}")
	public String getSingle(Model model, @PathVariable("id") long id) {
		model.addAttribute("mySession", sessionService.getById(id));
		return "sessions/view";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute SessionForm sessionForm) {
		Session ses = sessionService.getById(id);
		ses.setName(sessionForm.getName());
		sessionService.update(ses);
		return "{\"status\": 1}";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(Model model, @PathVariable("id") long id) {
		sessionService.delete(id);
		return "{\"status\": 1}";
	}
}
