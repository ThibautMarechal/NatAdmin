package com.helmo.NatAdmin.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	@Secured("ROLE_USER")
	public String index() {
		return "index";
	}
}
