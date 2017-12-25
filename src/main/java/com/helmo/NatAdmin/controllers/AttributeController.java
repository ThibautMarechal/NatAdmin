package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.forms.AttributeForm;
import com.helmo.NatAdmin.models.Attribute;
import com.helmo.NatAdmin.services.AttributeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/birds/attributes")
public class AttributeController {
	private final AttributeService attributeService;
	
	public AttributeController(AttributeService attributeService) {
		this.attributeService = attributeService;
	}
	
	@RequestMapping("")
	public String list(Model model) {
		model.addAttribute("attributes", attributeService.getAll());
		return "birds/attributes/all";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute AttributeForm attributeForm) {
		Attribute attribute = attributeService.getById(id);
		attribute.setKey(attributeForm.getKey());
		attribute.setValues(attributeForm.getValues());
		attributeService.update(attribute);
		return "{\"status\":1}";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String delete(Model model, @PathVariable("id") long id) {
		attributeService.delete(id);
		return "{\"status\":1}";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(Model model) { //TODO Gni ?
		long id = attributeService.create(new Attribute());
		return String.format(
			  "{" +
					"\"status\":1," +
					"\"content\":" +
					"{" +
					"\"id\":%d," +
					"\"key\": \"%s\"" +
					"}" +
					"}", id);
	}
}
