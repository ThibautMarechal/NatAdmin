package com.helmo.NatAdmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("birds/descriptions")
public class DescriptionController
{
    @RequestMapping("")
    public String list(Model model){
        return "birds/descriptions/all";
    }
}
