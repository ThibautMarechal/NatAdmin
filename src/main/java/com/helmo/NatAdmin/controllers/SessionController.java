package com.helmo.NatAdmin.controllers;

import com.helmo.NatAdmin.services.SessionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("sessions")
public class SessionController
{
    private SessionService sessionService;

    public SessionController()
    {
        this.sessionService = new SessionService();
    }

    @RequestMapping("")
    public String getAll(Model model){
        model.addAttribute("sessions", sessionService.getAll());
        return "sessions/all";
    }

    @RequestMapping("{id}")
    public String getSingle(Model model, @PathVariable("id")long id){
        model.addAttribute("MySession", sessionService.getById(id));
        return "sessions/view";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String edit(Model model, @PathVariable("id")long id){
        return "{\"status\": 1}";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(Model model, @PathVariable("id")long id){
        return "{\"status\": 1}";
    }
}
