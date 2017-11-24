package com.helmo.NatAdmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("birds/descriptions")
public class DescriptionController
{
    @RequestMapping("")
    public String list(Model model){
        return "birds/descriptions/all";
    }
    @RequestMapping("edit/{id}")
    public String editGet(Model model, @PathVariable("id") long id){
        return "birds/description/edit";
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String editPost(Model model, @PathVariable("id") long id /*,@ModelAttribute //TODO Attribute form*/){
        return "birds/description/edit";
    }
}
