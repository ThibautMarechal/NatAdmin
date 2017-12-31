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
	public String create(Model model, @ModelAttribute AttributeForm attributeForm) {
		Attribute newAttribute = new Attribute();
		newAttribute.setKey(attributeForm.getKey());
		newAttribute.setValues(attributeForm.getValues());
		long id = attributeService.create(newAttribute);
		StringBuilder returnString = new StringBuilder("{\"status\":1,\"content\":{\"id\":" +id + ",\"key\": \"" +
				attributeForm
				.getKey() + "\",\"values\": [");
		for (int i = 0; i < attributeForm.getValues().size(); i++)
		{
			returnString.append("\"").append(attributeForm.getValues().get(i)).append("\"");
			if(i != attributeForm.getValues().size() -1){
				returnString.append(",");
			}
		}
		returnString.append("]}}");
		return returnString.toString();
	}
}
