package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.SessionForm;
import com.helmo.NatAdmin.models.User;
import com.helmo.NatAdmin.services.SessionService;
import com.helmo.NatAdmin.tools.SystemProvider;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sessions")
public class SessionController {
	private final SessionService sessionService;
	
	private final Environment env;
	private User system;
	
	public SessionController(SessionService sessionService, Environment env) {
		this.sessionService = sessionService;
		this.env = env;
		system = SystemProvider.getSystem();
		
	}
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute("sessions", sessionService.getAll(system));
		return "sessions/all";
	}
	
	@RequestMapping("{id}")
	public String getSingle(Model model, @PathVariable("id") long id) {
		model.addAttribute("MySession", sessionService.getById(id, system));
		return "sessions/view";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute SessionForm sessionForm) {
		return "{\"status\": 1}";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delete(Model model, @PathVariable("id") long id) {
		sessionService.delete(id, system);
		return "{\"status\": 1}";
	}
}
