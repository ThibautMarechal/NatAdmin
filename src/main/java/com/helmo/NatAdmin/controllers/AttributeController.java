package com.helmo.NatAdmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/birds/attributes")
public class AttributeController
{
    @RequestMapping("")
    public String list(Model model){
        return "birds/attributes/all";
    }

//    @RequestMapping(method = RequestMethod.POST, value = "edit/{id}")
}
