package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.Observationform;
import com.helmo.NatAdmin.services.ObservationService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ObservationController {
	
	private final ObservationService obsSrv;
	
	public ObservationController(ObservationService obsSrv) {
		this.obsSrv = obsSrv;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute Observationform observationform) {
		
		return "{\"status\" : 1}";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "delete/{id}")
	public String delete(Model model, @PathVariable("id") long id) {
		
		obsSrv.delete(id);
		return "{\"status\" : 1}";
	}
}
