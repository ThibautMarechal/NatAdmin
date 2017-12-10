package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.models.Description;
import com.helmo.NatAdmin.services.AttributeService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/birds/attributes")
public class AttributeController
{
    private AttributeService attributeService;
    public AttributeController(){
        attributeService = new AttributeService();
    }
    @RequestMapping("")
    public String list(Model model){
        model.addAttribute("attributes", attributeService.getAll());
        return "birds/attributes/all";
    }

    @RequestMapping(method = RequestMethod.POST, value = "edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String edit(Model model, @PathVariable("id")long id){
        return "{\"status\":1}";
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String delete(Model model, @PathVariable("id")long id){
        return "{\"status\":1}";
    }

    @RequestMapping(method = RequestMethod.POST, value = "create", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String create(Model model){
        long id = attributeService.create(new Description());
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
